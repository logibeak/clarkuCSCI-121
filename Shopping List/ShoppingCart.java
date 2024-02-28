import java.util.ArrayList;

public class ShoppingCart {
    public static ArrayList<ItemOrder> list = new ArrayList<ItemOrder>();
    public void addItemOrder(ItemOrder order){
        list.add(order);
    }

    public ItemOrder getItemOrder(int index){
        return list.get(index);
    }

//    public String toString() {
//        StringBuilder string = new StringBuilder();
//        for (ItemOrder itemOrder : list) {
//            string.append(itemOrder.getItemType().getName())
//                    .append(" of quantity ").
//                    append(itemOrder.getQuantity()).
//                    append("\n");
//        }
//        return string.toString();
//    }
}
