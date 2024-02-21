import javax.swing.JOptionPane;
public class Party {
    private short guests;
    public void setGuests(short nGuests){guests = nGuests;}
    public short getGuests(){return guests;}
    public void displayInvitation(){
        JOptionPane.showMessageDialog(null,"Please come to my party!");
//        System.out.println("Please come to my party!");
    }
}