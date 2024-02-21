import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Arrays;

public class PizzaDemo extends JFrame implements KeyListener, ActionListener {
    private String[] toppings;
    private short toppingsCount;

    public String[] getToppings() {
        return toppings;
    }

    public void setToppings(String[] toppings) {
        this.toppings = toppings;
    }
    public void addTopping(String topping){
        String[] current = getToppings();
        String[] newToppings = new String[current.length+1];
        System.arraycopy(current, 0, newToppings, 0, current.length);
        newToppings[current.length] = topping;
        setToppings(newToppings);
        orderModel.addElement(topping);
    }

    final int width = 300;
    final int height = 500;
    JLabel windowHeading = new JLabel("Pizza Arrays Application", SwingConstants.CENTER);
    static JLabel question = new JLabel("Please enter any toppings you would like to add", SwingConstants.CENTER);
    static JLabel questionL2 = new JLabel("in the small box below. enter \"QUIT\" when done", SwingConstants.CENTER);
    static JLabel scrollLabel = new JLabel("Toppings Added:");
    JTextField response = new JTextField(10);
    JButton enterButton = new JButton(">");
    public JList<String> order = new JList<>(getToppings());
    public static DefaultListModel<String> orderModel = new DefaultListModel<>();
    JScrollPane orderScroll = new JScrollPane(order);
    public double price = 12.0;
    public double deliveryFee=0;
    public JLabel cost = new JLabel("Total Cost: $"+price);
    public JButton clear = new JButton("Clear toppings");

    public JPanel innerFlow = new JPanel(new FlowLayout());
    public JPanel midFlow = new JPanel(new GridLayout(1,1));
    public JPanel outerFlow = new JPanel(new FlowLayout());
    PizzaDemo(String[] toppingsArr, short toppingsCountIn){
        setLayout(new GridLayout(3,1));
        toppings = toppingsArr;
        toppingsCount = toppingsCountIn;
        setSize(width,height);
        this.setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        Font bold = new Font( "Arial", Font.BOLD, 19);
        windowHeading.setFont(bold);
        order.setModel(orderModel);
        Font bigText = new Font( "Arial", Font.PLAIN,25);

        innerFlow.add(windowHeading);
        innerFlow.add(question);
        innerFlow.add(questionL2);
        innerFlow.add(scrollLabel);
        scrollLabel.setFont(bigText);
        add(innerFlow);
        midFlow.add(orderScroll);
        add(midFlow);
        outerFlow.add(response);
        response.setToolTipText("name of topping");

        outerFlow.add(enterButton);
        enterButton.setToolTipText("Enter topping into list");

        outerFlow.add(clear);
        clear.setToolTipText("Clears the previously entered toppings");

        outerFlow.add(cost);
        cost.setFont(bigText);
        add(outerFlow);

        response.addKeyListener(this);
        enterButton.addActionListener(this);
        clear.addActionListener(this);

        setVisible(true);
    }
    public void processDeliveryMethod(){
        if (price > 18){
            deliveryFee=3;
        } else {
            deliveryFee=5;
        }
        //Creativity!
        int method = JOptionPane.showConfirmDialog(this,"Is this for delivery?\n(Adds $"+
                deliveryFee+" Fee)", "Delivery Method", JOptionPane.YES_NO_OPTION);

        if (method == 0) {
            String address = JOptionPane.showInputDialog(this, "Please enter the address for delivery:");
            if (address==null){address="None";}

            //Create DeliveryPizza object with constructor
            DeliveryPizza pizza = new DeliveryPizza(toppings, toppingsCount, address);
            pizza.setPizzaPrice(price);
            pizza.setDeliveryFee(deliveryFee);
            JOptionPane.showMessageDialog(this, "DeliveryPizza object:\n" +
                    "toppings: "+ Arrays.toString(pizza.getToppings())+"\n"+
                    "toppingCount: "+pizza.getToppingCount()+"\n"+
                    "price: "+pizza.getPizzaPrice()+"\n"+
                    "deliveryFee: "+pizza.getDeliveryFee()+"\n"+
                    "deliveryAddress: "+pizza.getDeliveryAddress());
        } else if (method == 1) {
            //Create Pizza object with constructor
            Pizza pizza = new Pizza(toppings, toppingsCount);
            pizza.setPizzaPrice(price);
            JOptionPane.showMessageDialog(this, "Pizza object:\n" +
                    "toppings: "+ Arrays.toString(pizza.getToppings())+"\n"+
                    "toppingCount: "+pizza.getToppingCount()+"\n"+
                    "price: "+pizza.getPizzaPrice());
        }
    }
    public void processEntry(){
        toppingsCount = (short) orderModel.toArray().length;
        if (response.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Nothing topping?",
                    "Error", JOptionPane.QUESTION_MESSAGE);
        }else
            if (response.getText().equals("QUIT")) {
                processDeliveryMethod();
            }
            else if(toppingsCount != 10){
            addTopping(response.getText());
            response.setText("");
            price = 12+2.0*toppingsCount;
            cost.setText("Total Cost: $" + (price));
            }
            else {
                JOptionPane.showMessageDialog(this, "Too many toppings!",
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
    }

    public void clearToppings(){
        orderModel = new DefaultListModel<>();
        order.setModel(orderModel);
        //reset variables
        price=12;
        toppingsCount=0;
        toppings = new String[0];
    }
    //creativity!
    @Override
    public void keyPressed(KeyEvent e){
        if (e.getKeyCode() == KeyEvent.VK_ENTER){
            processEntry();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    public static void main(String[] args){
        String[] toppings = new String[0];
        PizzaDemo window = new PizzaDemo(toppings, (short) 0);
        window.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == enterButton) {
            processEntry();
        } else if (e.getSource() == clear){
            clearToppings();
        }
    }
}
