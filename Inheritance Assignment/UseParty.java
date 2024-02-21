import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;
import javax.swing.*;
public class UseParty {
    public static class GuiParty extends JFrame implements ActionListener {
        final int width = 300;
        final int height = 150;
        JLabel windowHeading = new JLabel("Party Classes Assignment", SwingConstants.CENTER);
        JLabel question = new JLabel("Please enter the number of guests for the party:");
        JTextField response = new JTextField(5);
        JButton proceed = new JButton(">");
        Party partyObject = new Party();
        public GuiParty(){
            setSize(width,height);
            this.setResizable(false);
            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            setLayout(new FlowLayout());
            Font bold = new Font( "Arial", Font.BOLD, 19);
            windowHeading.setFont(bold);

            add(windowHeading);
            add(question);
            add(response);
            add(proceed);
            proceed.addActionListener(this);
            setVisible(true);
        }
        @Override
        public void actionPerformed(ActionEvent e){
            if (e.getSource()==proceed){
                short numGuests = Short.parseShort(response.getText());
                JOptionPane.showMessageDialog(this, "The party has " + numGuests + " Guests" );
                partyObject.setGuests(numGuests);

                proceed.setVisible(false);
                partyObject.displayInvitation();
//                JOptionPane.showMessageDialog(this, "Please come to my party!" );
                dispose();
            }
        }
    }

    public static void main(String[] args) {
        GuiParty p = new GuiParty();
        p.setVisible(true);

        /*leftovers from console version
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of guests for the party:");
        p.setGuests(sc.nextShort());
        System.out.println("The party has " +p.getGuests() + " Guests");
        p.displayInvitation();*/
    }
}