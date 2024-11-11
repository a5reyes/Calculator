import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;



public class Listener implements ActionListener {

    public void actionPerformed (ActionEvent e){
        JButton jBut = (JButton) e.getSource(); //to get button object which is clicked
        System.out.println(jBut.getText()); //to print text of button
    }
}
