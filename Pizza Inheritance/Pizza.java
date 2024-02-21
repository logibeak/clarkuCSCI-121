public class Pizza {
    private double pizzaPrice = 14;
    private short toppingCount;
    private String[] toppings = new String[10];
    public void setToppings(String[] toppings) {
        this.toppings = toppings;
    }
    public String[] getToppings() {
        return toppings;
    }
    public void setPizzaPrice(double pizzaPrice) {
        this.pizzaPrice = pizzaPrice;
    }
    public double getPizzaPrice() {
        return pizzaPrice;
    }
    public short getToppingCount() {
        return toppingCount;
    }
    public void setToppingCount(short toppingCount){
        this.toppingCount = toppingCount;
    }
    Pizza(){
        setToppings(new String[0]);
        setToppingCount((short) 0);
    }
    Pizza(String[] topping, short toppingCount){
        assert(topping.length <= 10);
        setToppings(topping);
        setToppingCount(toppingCount);
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        /*IntelliJ enhanced loop?*/
        for (String topping : this.toppings) {
            output.append(topping).append(", ");
        }
        output.append("Pizza ($").append(this.pizzaPrice).append(")");
        return output.toString();
    }

    public static void main(String[] args){
        String[] toppingsTest = {"test1", "test2"};
        Pizza pizzaTest = new Pizza(toppingsTest, (short) 0);
        System.out.println(pizzaTest);
    }
}
