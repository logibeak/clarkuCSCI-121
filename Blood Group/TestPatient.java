import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TestPatient extends JFrame implements ActionListener {
    JLabel title = new JLabel("TestPatient.java");
    Font bold = new Font("Arial", Font.BOLD, 20);
    JLabel question = new JLabel();
    JTextField input = new JTextField(8);
    JButton next = new JButton(">");
    JButton next2 = new JButton(">");
    JButton next3 = new JButton(">");
    JButton next4 = new JButton(">");
    JButton next5 = new JButton(">");
    static String bloodType;
    public static int id;
    public static int age;
    public static int secondID;
    public static int secondAGE;
    public static BloodData userInput;
    TestPatient(){
        setLayout(new FlowLayout());
        setSize(300, 200);
        add(title);
        title.setFont(bold);
        add(question);
        add(input);
        add(next);
        add(next2);
        add(next3);
        add(next4);
        add(next5);

        next2.setVisible(false);
        next3.setVisible(false);
        next4.setVisible(false);
        next5.setVisible(false);

        next.addActionListener(this);
        next2.addActionListener(this);
        next3.addActionListener(this);
        next4.addActionListener(this);
        next5.addActionListener(this);
        question.setText("Please enter the patient ID:");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == next) {
            next.setVisible(false);
            next2.setVisible(true);
            id = Integer.parseInt(input.getText());

            input.setText("");
            question.setText("Please enter the patient's age:");
        } else if (e.getSource() == next2) {
            age = Integer.parseInt(input.getText());
            next2.setVisible(false);
            next3.setVisible(true);
            question.setText("Please enter the patient's blood type:");
            input.setText("");

        } else if (e.getSource() == next3) {
            String text = input.getText();
            input.setText("");
            if ((text.contains("+")||text.contains("-"))&&(text.length()<=3)) {
                String bloodGroup = text.replace("+", "p").replace("-", "n");

                userInput = BloodData.stringToBloodData(bloodGroup);
            }

            question.setText("New Patient: please enter ID:");
            next3.setVisible(false);
            next4.setVisible(true);

        } else if (e.getSource() == next4) {
            next4.setVisible(false);
            next5.setVisible(true);
            secondID = Integer.parseInt(input.getText());
            input.setText("");
            question.setText("New Patient: please enter Age:");
        } else if (e.getSource()==next5){
            secondAGE = Integer.parseInt(input.getText());
            input.setText("");

            Patient defaultData = new Patient();
            Patient userPatient = new Patient(id,age,userInput);
            Patient halfDefault = new Patient(secondID,secondAGE,new BloodData(BloodData.Blood.Op));

            if (userInput == null){
                JOptionPane.showMessageDialog(this,"Invalid Input!");
            } else{
                JOptionPane.showMessageDialog(this, "defaultData Object: Type "+defaultData.getBloodData().getBloodType()
                        +defaultData.getBloodData().getRhFactor() + " ID=" + defaultData.getId() + " AGE=" + defaultData.getAge());
                JOptionPane.showMessageDialog(this, "userPatient Object: Type "+userPatient.getBloodData().getBloodType()
                        +userPatient.getBloodData().getRhFactor() + " ID=" + userPatient.getId() + " AGE=" + userPatient.getAge());
                JOptionPane.showMessageDialog(this, "halfDefault Object: Type "+halfDefault.getBloodData().getBloodType()
                        +halfDefault.getBloodData().getRhFactor() + " ID=" + halfDefault.getId() + " AGE=" + halfDefault.getAge());
            }
            dispose();
        }

    }

    public static void main(String[] args){
        TestPatient window = new TestPatient();
        window.setVisible(true);
    }
}

