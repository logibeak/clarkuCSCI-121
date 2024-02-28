public class ItemOrder {
    private Item itemType;
    private int quantity;
    private int bulkDiscountThreshold;
    private double bulkDiscountModifier;
    private static double orderTotal;
    public double getOrderTotal() {
        return orderTotal;
    }
    public void setOrderTotal(double orderTotalz){
        orderTotal = orderTotalz;
    }

    public void setItemType(Item itemType) {
        this.itemType = itemType;
    }

    public Item getItemType() {
        return itemType;
    }

    public void setBulkDiscountThreshold(int bulkDiscountThreshold) {
        this.bulkDiscountThreshold = bulkDiscountThreshold;
    }

    public int getBulkDiscountThreshold() {
        return bulkDiscountThreshold;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
        setOrderTotal(getBulkDiscountThreshold()*getItemType().getPrice()+getItemType().getPrice()*getBulkDiscountModifier()*quantity-getBulkDiscountThreshold());
        System.out.println("itemOrder set with order total:");
        System.out.println(getOrderTotal());
    }
    public int getQuantity() {
        return quantity;
    }
    public void setBulkDiscountModifier(double bulkDiscountModifier) {
        this.bulkDiscountModifier = bulkDiscountModifier;
    }
    public double getBulkDiscountModifier() {
        return bulkDiscountModifier;
    }

    //Different constructors!
    ItemOrder(Item item, int quantity){
        setItemType(item);
        setQuantity(quantity);
        setBulkDiscountThreshold(0);
        setBulkDiscountModifier(0);
        if (getQuantity() > getBulkDiscountThreshold()) {
            setOrderTotal(Math.round((getBulkDiscountThreshold() * item.getPrice()) +
                    ((item.getPrice() * (1-(getBulkDiscountModifier())) * (getQuantity() - getBulkDiscountThreshold())))));
        } else {
            setOrderTotal(item.getPrice()*getQuantity());
        }

//        System.out.println("new ItemOrder object with OrderTotal: "+getOrderTotal()+" quantity: "+getQuantity()+" bulkDiscountThreshold: "+getBulkDiscountThreshold());
    }
    ItemOrder(Item item, int quantity, int discountThreshold, double discountModifier){
        setItemType(item);
        setQuantity(quantity);
        setBulkDiscountThreshold(discountThreshold);
        setBulkDiscountModifier(discountModifier/100);
        if (getQuantity() > getBulkDiscountThreshold()) {
            setOrderTotal(Math.round((getBulkDiscountThreshold() * item.getPrice()) +
                    ((item.getPrice() * (1-(getBulkDiscountModifier())) * (getQuantity() - getBulkDiscountThreshold())))));
        } else {
            setOrderTotal(item.getPrice()*getQuantity());
        }

//        System.out.println("new ItemOrder object with OrderTotal: "+getOrderTotal()+" quantity: "+getQuantity()+" bulkDiscountThreshold: "+getBulkDiscountThreshold());
    }

}
