import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TestPatient extends JFrame implements ActionListener {
    //create GUI elements
    JLabel title = new JLabel("TestPatient.java");
    Font bold = new Font("Arial", Font.BOLD, 20);
    JLabel question = new JLabel();
    JTextField input = new JTextField(8);
    JButton next = new JButton(">");
    JButton next2 = new JButton(">");
    JButton next3 = new JButton(">");
    JButton next4 = new JButton(">");
    JButton next5 = new JButton(">");
    public static int id;
    public static int age;
    public static int secondID;
    public static int secondAGE;
    public static BloodData userInput;

    //GUI Constructor
    TestPatient(){
        setLayout(new FlowLayout());
        setSize(300, 200);
        add(title);
        title.setFont(bold);
        add(question);
        add(input);
        add(next);

        //multiple next buttons adds easier coding for multiple windows
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
            //set to question 2
            try{id = Integer.parseInt(input.getText());
                next.setVisible(false);
                next2.setVisible(true);
                input.setText("");
                question.setText("Please enter the patient's age:");}
            catch(Exception exc) {invalidMsgNotifier();}


        } else if (e.getSource() == next2) {
            //set to question 3
            try{age = Integer.parseInt(input.getText());
                next2.setVisible(false);
                next3.setVisible(true);
                question.setText("Please enter the patient's blood type:");
                input.setText("");}
            catch(Exception exc) {invalidMsgNotifier();}

        } else if (e.getSource() == next3) {
            //set to question 4
            try{String text = input.getText();
                input.setText("");

                String bloodGroup = text.replace("+", "p").replace("-", "n");

                userInput = BloodData.stringToBloodData(bloodGroup);
                if (userInput==null){throw new Exception();}


                question.setText("New Patient: please enter ID:");
                next3.setVisible(false);
                next4.setVisible(true);}
            catch(Exception exp){invalidMsgNotifier();}

        } else if (e.getSource() == next4) {
            //set to question 5
            try{next4.setVisible(false);
                next5.setVisible(true);
                secondID = Integer.parseInt(input.getText());
                input.setText("");
                question.setText("New Patient: please enter Age:");}
            catch(Exception exp){invalidMsgNotifier();}

        } else if (e.getSource()==next5){
            //parse all entered data
            try{secondAGE = Integer.parseInt(input.getText());
                input.setText("");

                //create the three Patient objects based
                Patient defaultData = new Patient();
                Patient userPatient = new Patient(id,age,userInput);
                Patient halfDefault = new Patient(secondID,secondAGE,new BloodData(BloodData.Blood.OPOSITIVE));

                //final error checking + descriptors
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
                //close program
                dispose();}
            catch(Exception exp){invalidMsgNotifier();}

        }

    }

    //bad input error as a function to simplify the blocks above
    public void invalidMsgNotifier(){
        JOptionPane.showMessageDialog(null, "Invalid input! Please re-enter."
        ,"Error", JOptionPane.ERROR_MESSAGE);
    }

    //create initial window
    public static void main(String[] args){
        TestPatient window = new TestPatient();
        window.setVisible(true);
    }
}

