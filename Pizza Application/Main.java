import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class Main {
    //Main window containing the Order screen
    public static class mainWindow extends JFrame implements ActionListener {
        //Initialize variables for main order screen
        //Public static on those being modified by other subclass
        JLabel heading = new JLabel("BigY Pizza", SwingConstants.CENTER);
        public static JLabel total = new JLabel("Total: $0.00");
        Font bold = new Font( "Arial", Font.BOLD, 29);
        Font buttonBold = new Font( "Arial", Font.BOLD, 21);
        JButton createPizza = new JButton("Add Pizza");
        JButton orderButton = new JButton("Place Order");
        JButton clearButton = new JButton("Clear Order");
        public static ArrayList<String> orderData = new ArrayList<>();
        public JList<String> order = new JList<>(orderData.toArray(new String[10]));
        public static DefaultListModel<String> orderModel = new DefaultListModel<>();
        JScrollPane orderScroll = new JScrollPane(order);
        public mainWindow() {
            setSize(750,400);
            setLayout(new GridLayout(2,3));
            this.setResizable(false);

            //Add elements
            add(heading);
            heading.setFont(bold);

            //I would consider the Order List to be the most creative element of the project
            add(orderScroll);
            order.setModel(orderModel);

            //Add elements to the main window
            add(total);
            add(createPizza);
            add(orderButton);
            add(clearButton);

            //Change button fonts to bold
            total.setFont(buttonBold);
            createPizza.setFont(buttonBold);
            orderButton.setFont(buttonBold);
            clearButton.setFont(buttonBold);

            //Action Listeners
            createPizza.addActionListener(this);
            orderButton.addActionListener(this);
            clearButton.addActionListener(this);

            setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        }

        public static void addToOrder(String item) {
            orderModel.addElement(item); //adds to JList order
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == createPizza) {
                //create pizza creator window
                pizzaWindow bWindow = new pizzaWindow();
                bWindow.setVisible(true);
            } else if (e.getSource() == clearButton) {
                //clear out JList and reset total
                orderModel = new DefaultListModel<>();
                order.setModel(orderModel);
                total.setText("Total: $0.00");
            } else if (e.getSource() == orderButton) {
                //Place order
                if (!orderModel.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Order placed!", "Result", JOptionPane.INFORMATION_MESSAGE);
                    this.dispose();
                } else {
                    JOptionPane.showMessageDialog(this, "Please add items to your order.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }

        }
    }

    //Sub-window for creating an individual pizza
    public static class pizzaWindow extends JFrame implements ActionListener, ItemListener {
        //Initialize variables
        final int width = 260;
        final int height = 250;
        JLabel builderHeading = new JLabel("Pizza Builder", SwingConstants.CENTER);
        JLabel builderTotal = new JLabel("Total: $0.00");
        public static double itemPrice = 0.00; //public static so Action and Item listeners can access
        String[] builderSizes = {"Small", "Medium", "Large", "Super"};
        HashMap<String, Double> builderToppingPrices = new HashMap<>(){
            {
                put("Small", 5.00);
                put("Medium", 10.00);
                put("Large", 15.00);
                put("Super", 20.00);
            }};


        JLabel builderPrompt = new JLabel("Which size would you like to order?");
        JComboBox<String> builderSizeBox = new JComboBox<>(builderSizes);
        JButton builderNextFrame = new JButton("Next");

        //Checkboxes for each topping

        JCheckBox pepperoni = new JCheckBox("Pepperoni");
        JCheckBox pineapple = new JCheckBox("Pineapple");
        JCheckBox bacon = new JCheckBox("Bacon");
        JCheckBox mushrooms = new JCheckBox("Mushrooms");
        JCheckBox extraCheese = new JCheckBox("Extra Cheese");
        HashMap<Integer, JCheckBox> toppingBoxes = new HashMap<>();
        JButton addToOrder = new JButton("Add to Order");



        public pizzaWindow() {
            setSize(width,height);
            this.setResizable(false);
            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            setLayout(new FlowLayout());
            Font bold = new Font( "Arial", Font.BOLD, 29);
            builderHeading.setFont(bold);

            //Add elements to frame
            add(builderHeading);
            add(builderPrompt);
            add(builderSizeBox);
            add(builderNextFrame);
            add(builderTotal);
            //Action Listeners
            builderNextFrame.addActionListener(this);
            builderSizeBox.addActionListener(this);
            addToOrder.addActionListener(this);
            //Item Listeners
            pepperoni.addItemListener(this);
            pineapple.addItemListener(this);
            bacon.addItemListener(this);
            mushrooms.addItemListener(this);
            extraCheese.addItemListener(this);

            setVisible(true);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == builderNextFrame) {
                //Change from size options to toppings
                //Grab selected size and add correct price to the total
                String selectedSize = Objects.requireNonNull(builderSizeBox.getSelectedItem()).toString();
                builderSizeBox.setVisible(false);
                Double pizzaCost = builderToppingPrices.get(selectedSize);
                itemPrice = builderToppingPrices.get(selectedSize);
                builderTotal.setText("Cost of Pizza: $" + pizzaCost);
                //proceed to stage 2 (toppings)
                builderNextFrame.setVisible(false);
                builderPrompt.setText("Select the toppings you would like:");

                toppingBoxes.put(1, pepperoni);
                toppingBoxes.put(2, pineapple);
                toppingBoxes.put(3, bacon);
                toppingBoxes.put(4, mushrooms);


                for (int i = 1; i<=toppingBoxes.size(); i++) {
                    add(toppingBoxes.get(i)); // add checkboxes for toppings
                }

                add(extraCheese); // manual add to avoid checking the extra charge
                add(addToOrder);
            }
            if (e.getSource()==addToOrder) {
                //Limit toppings to 3
                if (totalToppings > 3) {
                    JOptionPane.showMessageDialog(null, "Too many toppings! (max: 3, not including" +
                                    " Extra Cheese)",
                            "Error", JOptionPane.ERROR_MESSAGE);
                }
                else {
                    // Parse pizza data, add correct info to list
                    boolean hasPepperoni = pepperoni.isSelected();
                    boolean hasMushrooms = mushrooms.isSelected();
                    boolean hasPineapple = pineapple.isSelected();
                    boolean hasBacon = bacon.isSelected();
                    boolean hasXCheese = extraCheese.isSelected();

                    //Create string for order list
                    String orderItem = "";
                    String selectedSize = Objects.requireNonNull(builderSizeBox.getSelectedItem()).toString();
                    orderItem+=selectedSize+" ";

                    //process toppings
                    if (hasPepperoni) {orderItem+="Pepperoni ";}
                    if (hasMushrooms) {orderItem+="Mushroom ";}
                    if (hasPineapple) {orderItem+="Pineapple ";}
                    if (hasBacon) {orderItem+="Bacon ";}
                    if (hasXCheese) {orderItem+="Pizza (Extra Cheese) ($" + itemPrice + ')';}
                    else {
                        orderItem+="Pizza ($" + itemPrice + ')';
                    }

                    mainWindow.addToOrder(orderItem);

                    //Update total
                    double currentTotal = Double.parseDouble(
                            mainWindow.total.getText().replaceAll("[^0-9.]","")
                            //this regex expression removes all characters unrelated to
                            //the price from the string for parsing
                    );
                    currentTotal += Double.parseDouble(
                            builderTotal.getText().replaceAll("[^0-9.]","")
                    );
                    mainWindow.total.setText("Total: $"+currentTotal);

                    //Deactivate window
                    builderNextFrame.setVisible(false);
                    //remove Action Listeners
                    builderNextFrame.setVisible(false);
                    builderSizeBox.setVisible(false);
                    addToOrder.setVisible(false);
                    //remove Item Listeners
                    pepperoni.setVisible(false);
                    pineapple.setVisible(false);
                    bacon.setVisible(false);
                    mushrooms.setVisible(false);
                    dispose(); // destroy window
                }
            }
        }

        public double hold = 0.0;
        public int totalToppings = 0;
        @Override
        public void itemStateChanged(ItemEvent e) {
            //Count toppings checked
            totalToppings=0;
            for (int i=1; i<=toppingBoxes.size(); i++) {
                if (toppingBoxes.get(i).isSelected()) {
                    totalToppings += 1;
                }
            }

            double currentTotal = Double.parseDouble(builderTotal.getText().replaceAll("[^0-9.]", ""));

            //the hold variable handles if toppings are checked but then
            //deselected
            if (hold!=0) {
                currentTotal -= hold;
                hold = 0.0;
            }

            if (totalToppings==1){hold=0.50;}
            else if (totalToppings==2){hold=1.00;}
            else if (totalToppings>=3){hold=1.25;}
            // greater than to prevent price errors. checking will be done with add button

            currentTotal += hold; // add toppings price to the current item total
            itemPrice = currentTotal;
            builderTotal.setText("Cost of Pizza: $" + currentTotal);
        }
    }

    public static void main(String[] args) {
        mainWindow window = new mainWindow();
        window.setVisible(true);
    }
}