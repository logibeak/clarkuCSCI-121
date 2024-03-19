import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class TestBloodData extends JFrame implements ActionListener {
    JLabel title = new JLabel("TestBloodData.java");
    JLabel question = new JLabel();
    JTextField input = new JTextField(8);
    JButton next = new JButton(">");
    static String bloodType;
    TestBloodData(){
        setLayout(new FlowLayout());
        setSize(200, 200);
        add(title);
        add(question);
        add(input);
        add(next);

        next.addActionListener(this);
        question.setText("Please enter a blood type:");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == next) {
            String text = input.getText();
            if ((text.contains("+")||text.contains("-"))&&(text.length()<=3)) {
                String bloodGroup = text.replace("+","p").replace("-","n");

                BloodData userInput = BloodData.stringToBloodData(bloodGroup);

                BloodData defaultData = new BloodData();

                if (userInput == null){
                    JOptionPane.showMessageDialog(this,"Invalid Input!");
                } else{
                    JOptionPane.showMessageDialog(this, "userInput Object: Type "+userInput.getBloodType()+userInput.getRhFactor());
                    JOptionPane.showMessageDialog(this, "defaultData Object: Type "+defaultData.getBloodType()+defaultData.getRhFactor());
                    dispose();
                }
            }
        }
    }

    public static void main(String[] args){
        TestBloodData window = new TestBloodData();
        window.setVisible(true);
    }
}

