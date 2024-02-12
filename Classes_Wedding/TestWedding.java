import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.Scanner;
import javax.swing.*;
public class TestWedding {
    public static class GuiWindow extends JFrame implements ActionListener {
        final int width = 300;
        final int height = 150;
        JLabel windowHeading = new JLabel("Wedding Classes Assignment", SwingConstants.CENTER);
        static JLabel question = new JLabel("Please enter in the first name of the Bride");
        JTextField response = new JTextField(10);
        JButton person1First = new JButton(">");
        JButton person1Last = new JButton(">");
        JButton person2First = new JButton(">");
        JButton person2Last = new JButton(">");
        JButton dateB = new JButton(">");
        JButton locationB = new JButton(">");
        static String bName, bLName, gName, gLName;
        static Person bride, groom;
        static Couple couple;
        static LocalDate date;
        public GuiWindow(){
            setSize(width,height);
            this.setResizable(false);
            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            setLayout(new FlowLayout());
            Font bold = new Font( "Arial", Font.BOLD, 19);
            windowHeading.setFont(bold);

            add(windowHeading);
            add(question);
            add(response);

            add(person1First);
            add(person1Last);
            add(person2First);
            add(person2Last);
            add(dateB);
            add(locationB);

            person1Last.setVisible(false);
            person2First.setVisible(false);
            person2Last.setVisible(false);
            dateB.setVisible(false);
            locationB.setVisible(false);

            person1First.addActionListener(this);
            person1Last.addActionListener(this);
            person2First.addActionListener(this);
            person2Last.addActionListener(this);
            dateB.addActionListener(this);
            locationB.addActionListener(this);
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == person1First) {
                bName = response.getText();
                response.setText("");
                person1First.setVisible(false);
                person1Last.setVisible(true);
                question.setText("Please enter in the last name of the Bride:");
            }
            if (e.getSource() == person1Last){
                bLName = response.getText();
                bride = new Person(bName, bLName);
                response.setText("");
                person1Last.setVisible(false);
                person2First.setVisible(true);
                question.setText("Please enter in the first name of the Groom:");
            }
            if (e.getSource() == person2First){
                gName = response.getText();
                response.setText("");
                person2First.setVisible(false);
                person2Last.setVisible(true);
                question.setText("Please enter in the last name of the Groom:");
            }
            if (e.getSource() == person2Last){
                gLName = response.getText();
                groom = new Person(gName, gLName);
                couple = new Couple(bride, groom);
                response.setText("");
                person2Last.setVisible(false);
                dateB.setVisible(true);
                question.setText("Please enter the wedding date (YEAR-day-Month):");
            }
            if (e.getSource() == dateB){
                date = LocalDate.parse(response.getText());
                response.setText("");
                dateB.setVisible(false);
                locationB.setVisible(true);
                question.setText("Please enter in the location of the wedding:");
            }
            if (e.getSource() == locationB){
                String location = response.getText();
                Wedding wedding = new Wedding(couple, date, location);
                JOptionPane.showMessageDialog(this, "Couple: " + wedding.getCouple()
                + "\nDate: " + wedding.getDate() + "\nLocation: " + wedding.getLocation() +"\nCongratulations!");
                dispose();
            }
        }
    }


    public static void main(String[] args){
        GuiWindow gui = new GuiWindow();
        gui.setVisible(true);
    }
}
