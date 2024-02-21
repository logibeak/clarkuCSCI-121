import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import javax.swing.*;
public class UseDinnerParty {
    public static class GuiParty extends JFrame implements ActionListener {
        final int width = 300;
        final int height = 150;
        JLabel windowHeading = new JLabel("Dinner Party Classes", SwingConstants.CENTER);
        JLabel question = new JLabel("Please enter the number of guests for the party:");
        JTextField response = new JTextField(5);
        JButton proceed = new JButton(">");
        JButton proceed2 = new JButton(">");
        DinnerParty dinnerPartyObject = new DinnerParty();
        static int menuChoice = 0;
        HashMap<Integer, String> menu = new HashMap<>() {{
            put(1, "Chicken");
            put(2, "Veggies");
        }};

        public GuiParty() {
            setSize(width, height);
            this.setResizable(false);
            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            setLayout(new FlowLayout());
            Font bold = new Font("Arial", Font.BOLD, 19);
            windowHeading.setFont(bold);
            add(windowHeading);
            add(question);
            add(response);
            add(proceed);
            add(proceed2);
            proceed2.setVisible(false);
            proceed.addActionListener(this);
            proceed2.addActionListener(this);
            setVisible(true);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == proceed) {
                short numGuests = Short.parseShort(response.getText());
                JOptionPane.showMessageDialog(this, "The party has " + numGuests + " Guests");
                dinnerPartyObject.setGuests(numGuests);

                proceed.setVisible(false);
                proceed2.setVisible(true);

                question.setText("Enter menu choice: 1 for Chicken 2 for Veggies");
                response.setText("");
            } else if (e.getSource() == proceed2) {
                menuChoice = Integer.parseInt(response.getText());
                if (menuChoice != 1 && menuChoice != 2) {
                    /* bounds checking, can be seen as the creative part as the
                 directions say not to do it for simplicity*/
                    JOptionPane.showMessageDialog(this, "Please enter one of the two options!", "Error!", JOptionPane.ERROR_MESSAGE);
                } else {
                    dinnerPartyObject.setDinnerChoice(menuChoice);
                    JOptionPane.showMessageDialog(this, menu.get(menuChoice) + " has been selected as the meal.", "Choice", JOptionPane.INFORMATION_MESSAGE);
                }
                dinnerPartyObject.displayInvitation();
                dispose();
            }
        }
    }

    public static void main(String[] args) {
        GuiParty p = new GuiParty();
        p.setVisible(true);
    }
}

/*old console version

    public class UseDinnerParty extends UseParty {
    public static void main(String[] args) {
        DinnerParty dp = new DinnerParty();
        Scanner sc = new Scanner(System.in);
        //party
        System.out.println("Enter the number of guests for the party:");
        dp.setGuests(sc.nextShort());
        System.out.println("The party has " +dp.getGuests() + " Guests");
        dp.displayInvitation();

        //dinner party
        System.out.println("Set the number of guests for the Dinner Party:");
        dp.setGuests(sc.nextShort());
        System.out.println("Enter the menu option: 1 for Chicken 2 for Veggies");
        dp.setDinnerChoice(sc.nextInt());
        System.out.println("The dinner party has " +dp.getGuests() + " guests");
        System.out.println("Menu option " + dp.getDinnerChoice() + " will be served");
        dp.displayInvitation();
    }
}
}*/
