public class DeliveryPizza extends Pizza {
    private double deliveryFee;
    private String deliveryAddress;

    public void setDeliveryFee(double deliveryFee) {
        this.deliveryFee = deliveryFee;
    }

    public double getDeliveryFee() {
        return deliveryFee;
    }

    public void setDeliveryAddress(String address){
        this.deliveryAddress=address;
    }

    public String getDeliveryAddress(){
        return deliveryAddress;
    }

    DeliveryPizza(String[] topping, short toppingCount, String address){
        assert(topping.length <= 10);
        setToppings(topping);
        setToppingCount(toppingCount);
        setDeliveryAddress(address);
    }

}
