import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ShoppingDemo extends JFrame implements ActionListener {
    int width = 300;
    int height = 300;
    JLabel windowHeading = new JLabel("Shopping Class Demo", SwingConstants.CENTER);
    JList<String> order = new JList<>();
    public static DefaultListModel<String> orderModel = new DefaultListModel<>();
    JScrollPane orderScroll = new JScrollPane(order);
    JPanel top = new JPanel(new FlowLayout());
    JPanel bottom = new JPanel(new FlowLayout());
    JTextField itemType = new JTextField(10);
    JLabel comma = new JLabel(", #");
    JLabel comma2 = new JLabel(", $");
    JLabel comma3 = new JLabel("            %");
    JLabel comma4 = new JLabel(", #%");
    JTextField itemQuantity = new JTextField(4);
    JTextField itemPrice = new JTextField(4);
    JTextField itemBulkModifier = new JTextField(4);
    JTextField itemBulkDCount = new JTextField(4);
    JButton okButton = new JButton("OK");
    JLabel tooltip = new JLabel("Please hover over the inputs to see tooltips");
    JLabel total = new JLabel("Cart Total: $0.00");
    ShoppingCart cart = new ShoppingCart();
    static int index=0;
    ShoppingDemo(){
        setLayout(new GridLayout(3,1));
        setSize(width,height);
        this.setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        Font bold = new Font( "Arial", Font.BOLD, 19);
        windowHeading.setFont(bold);
        order.setModel(orderModel);

        add(top);
        top.add(windowHeading);
        top.add(tooltip);
        top.add(total);

        add(orderScroll);
        add(bottom);
        bottom.add(itemType);
        itemType.setToolTipText("Item Type / Item Name");

        bottom.add(comma);
        bottom.add(itemQuantity);
        bottom.add(comma2);


        bottom.add(itemPrice);
        bottom.add(comma3);
        bottom.add(itemBulkModifier);
        bottom.add(comma4);
        bottom.add(itemBulkDCount);
        bottom.add(okButton);

        itemQuantity.setToolTipText("Item Quantity");
        itemPrice.setToolTipText("Price per Item");
        itemBulkModifier.setToolTipText("Bulk Discount Modifier (e.g. 20 represents 20 percent off per item over " +
                "threshold) default: 100");
        itemBulkDCount.setToolTipText("# of items before the discount applies; default: 0");

        okButton.addActionListener(this);
    }
    public void addToShoppingList(){
        orderModel.addElement(
                cart.getItemOrder(index).getItemType().getName() +
                " of quantity " + cart.getItemOrder(index).getQuantity() +
                " ($"+ cart.getItemOrder(index).getOrderTotal() +")");
        index++;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==okButton){
            try {
                if(itemBulkDCount.getText().isEmpty() && itemBulkModifier.getText().isEmpty()){
                    cart.addItemOrder(new ItemOrder(
                            new Item(itemType.getText(),
                                    Double.parseDouble(itemPrice.getText())),
                            Integer.parseInt(itemQuantity.getText())));
                } else {
                    cart.addItemOrder(new ItemOrder(
                            new Item(itemType.getText(),
                                    Double.parseDouble(itemPrice.getText())),
                            Integer.parseInt(itemQuantity.getText()),
                            Integer.parseInt(itemBulkDCount.getText()),
                            Double.parseDouble(itemBulkModifier.getText())
                    ));
                }
                addToShoppingList();
            } catch (Exception x) {
                JOptionPane.showMessageDialog(null, "Invalid input.\nPlease double check your " +
                        "formatting!", "error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public static void main (String[] args){
        ShoppingDemo window = new ShoppingDemo();
        window.setVisible(true);
    }
}
