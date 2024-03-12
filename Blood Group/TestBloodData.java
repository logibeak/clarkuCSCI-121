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
                System.out.println(bloodGroup);
                BloodData userInput = switch (bloodGroup) {
                    case "Ap" -> new BloodData(BloodData.Blood.Ap);
                    case "An" -> new BloodData(BloodData.Blood.An);
                    case "Bp" -> new BloodData(BloodData.Blood.Bp);
                    case "Bn" -> new BloodData(BloodData.Blood.Bn);
                    case "Op" -> new BloodData(BloodData.Blood.Op);
                    case "On" -> new BloodData(BloodData.Blood.On);
                    case "ABn" -> new BloodData(BloodData.Blood.ABn);
                    case "ABp" -> new BloodData(BloodData.Blood.ABp);
                    default -> null;
                };
                BloodData defaultData = new BloodData();
                if (userInput == null){
                    JOptionPane.showMessageDialog(this,"Invalid Input!");
                } else{
                    JOptionPane.showMessageDialog(this, "userInput Object: Type "+userInput.getBloodType()+userInput.getRhFactor());
                    JOptionPane.showMessageDialog(this, "defaultData Object: Type "+defaultData.getBloodType()+defaultData.getRhFactor());
                }
            }
        }
    }

    public static void main(String[] args){
        TestBloodData window = new TestBloodData();
        window.setVisible(true);
    }
}

