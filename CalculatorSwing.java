import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CalculatorSwing extends JFrame implements ActionListener {

    JTextField t1;
    JButton b0, b1, b2, b3, b4, b5, b6, b7, b8, b9;
    JButton bAdd, bSub, bMul, bDiv, bEq, bClr;

    double num1 = 0, num2 = 0, result = 0;
    char operator;

    CalculatorSwing() {

        setTitle("Calculator");
        setSize(300, 400);
        setLayout(null);

        t1 = new JTextField();
        t1.setBounds(20, 20, 250, 40);
        t1.setEditable(false);
        add(t1);

        // Number buttons
        b1 = new JButton("1"); b2 = new JButton("2"); b3 = new JButton("3");
        b4 = new JButton("4"); b5 = new JButton("5"); b6 = new JButton("6");
        b7 = new JButton("7"); b8 = new JButton("8"); b9 = new JButton("9");
        b0 = new JButton("0");

        // Operator buttons
        bAdd = new JButton("+");
        bSub = new JButton("-");
        bMul = new JButton("*");
        bDiv = new JButton("/");
        bEq  = new JButton("=");
        bClr = new JButton("C");

        // Set bounds
        b1.setBounds(20, 80, 50, 40);
        b2.setBounds(80, 80, 50, 40);
        b3.setBounds(140, 80, 50, 40);

        b4.setBounds(20, 130, 50, 40);
        b5.setBounds(80, 130, 50, 40);
        b6.setBounds(140, 130, 50, 40);

        b7.setBounds(20, 180, 50, 40);
        b8.setBounds(80, 180, 50, 40);
        b9.setBounds(140, 180, 50, 40);

        b0.setBounds(80, 230, 50, 40);

        bAdd.setBounds(200, 80, 50, 40);
        bSub.setBounds(200, 130, 50, 40);
        bMul.setBounds(200, 180, 50, 40);
        bDiv.setBounds(200, 230, 50, 40);

        bEq.setBounds(20, 230, 50, 40);
        bClr.setBounds(140, 230, 50, 40);

        // Add buttons
        add(b1); add(b2); add(b3); add(b4); add(b5); add(b6);
        add(b7); add(b8); add(b9); add(b0);
        add(bAdd); add(bSub); add(bMul); add(bDiv);
        add(bEq); add(bClr);

        // Add action listeners
        JButton[] buttons = {b0,b1,b2,b3,b4,b5,b6,b7,b8,b9,
                             bAdd,bSub,bMul,bDiv,bEq,bClr};

        for (JButton b : buttons) {
            b.addActionListener(this);
        }

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String s = e.getActionCommand();

        if (s.charAt(0) >= '0' && s.charAt(0) <= '9') {
            t1.setText(t1.getText() + s);
        }
        else if (s.equals("C")) {
            t1.setText("");
        }
        else if (s.equals("=")) {
            num2 = Double.parseDouble(t1.getText());

            switch (operator) {
                case '+': result = num1 + num2; break;
                case '-': result = num1 - num2; break;
                case '*': result = num1 * num2; break;
                case '/': result = num1 / num2; break;
            }

            t1.setText("" + result);
        }
        else {
            num1 = Double.parseDouble(t1.getText());
            operator = s.charAt(0);
            t1.setText("");
        }
    }

    public static void main(String[] args) {
        new CalculatorSwing();
    }
}