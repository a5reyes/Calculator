import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.GridLayout;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Font;


public class Main {
    public static void main(String[] args) throws Exception {
        JTextField textPart = new JTextField();
        calc cal = new calc(textPart);
        JButton one= new JButton("1");
        one.addActionListener(cal);
        JFrame mainWindow = new JFrame();
        mainWindow.setTitle("COMP152 Calculator");
        mainWindow.setSize(300,370); // wxh

        mainWindow.setLocationRelativeTo(null); // sets creation to screen center
        mainWindow.setResizable(false); // makes a non resizable window
        mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // exits code on window close
        mainWindow.setLayout(null);
        
        textPart.setBounds(8,10,270,70); //x:8, y:10, w:270, h:70
        textPart.setBackground(Color.white); //to see text part
        mainWindow.add(textPart);
        textPart.setText("0");
        textPart.setHorizontalAlignment(SwingConstants.RIGHT); // set font alignment to right
        Font font = new Font("SansSerif", Font.BOLD, 40); // create a usable font to apply to textPart
        textPart.setFont(font); // set font
        JPanel buttonPart = new JPanel();
        GridLayout gl = new GridLayout(0,4);
        buttonPart.setLayout(gl);
        buttonPart.setBounds(8,90,270,235);
        buttonPart.setBackground(Color.white); //to see the button part
        mainWindow.add(buttonPart);
        buttonPart.repaint();
        JButton C = new JButton("C");
        buttonPart.add(C);
        C.addActionListener(cal);
        mainWindow.add(buttonPart); //already have it
        JButton D = new JButton("/");
        buttonPart.add(D);
        D.addActionListener(cal);
        mainWindow.add(buttonPart); //already have it
        JButton M = new JButton("*");
        buttonPart.add(M);
        M.addActionListener(cal);
        mainWindow.add(buttonPart); //already have it
        JButton E = new JButton("=");
        buttonPart.add(E);
        E.addActionListener(cal);
        mainWindow.add(buttonPart); //already have it
        JButton Sev = new JButton("7");
        buttonPart.add(Sev);
        Sev.addActionListener(cal);
        mainWindow.add(buttonPart); //already have it
        JButton Eig = new JButton("8");
        buttonPart.add(Eig);
        Eig.addActionListener(cal);
        mainWindow.add(buttonPart); //already have it
        JButton Nin = new JButton("9");
        buttonPart.add(Nin);
        Nin.addActionListener(cal);
        mainWindow.add(buttonPart); //already have it
        JButton A = new JButton("+");
        buttonPart.add(A);
        A.addActionListener(cal);
        mainWindow.add(buttonPart); //already have it
        JButton Fou = new JButton("4");
        buttonPart.add(Fou);
        Fou.addActionListener(cal);
        mainWindow.add(buttonPart); //already have it
        JButton Fiv = new JButton("5");
        buttonPart.add(Fiv);
        Fiv.addActionListener(cal);
        mainWindow.add(buttonPart); //already have it
        JButton Six = new JButton("6");
        buttonPart.add(Six);
        Six.addActionListener(cal);
        mainWindow.add(buttonPart); //already have it
        JButton S = new JButton("-");
        buttonPart.add(S);
        S.addActionListener(cal);
        mainWindow.add(buttonPart); //already have it
        JButton One = new JButton("1");
        buttonPart.add(One);
        One.addActionListener(cal);
        mainWindow.add(buttonPart); //already have it
        JButton Two = new JButton("2");
        buttonPart.add(Two);
        Two.addActionListener(cal);
        mainWindow.add(buttonPart); //already have it
        JButton Thr = new JButton("3");
        buttonPart.add(Thr);
        Thr.addActionListener(cal);
        mainWindow.add(buttonPart); //already have it
        JButton Zer = new JButton("0");
        buttonPart.add(Zer);
        Zer.addActionListener(cal);
        mainWindow.add(buttonPart); //already have it
        mainWindow.setVisible(true);
        mainWindow.setVisible(true);
    }
}