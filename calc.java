import java.awt.event.ActionListener; //import statements
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.util.ArrayList;

public class calc implements ActionListener {
    private JTextField textPart;
    private ArrayList<String> expressionParts;

    public calc(JTextField textPart) { //PART 1: Constructor; associates a JTextField for displaying results and initializes an ArrayList
        this.textPart = textPart;
        this.expressionParts = new ArrayList<>();
    } 

    public void actionPerformed(ActionEvent e) { //PART 2A: Method; when clicks button, retrieves it, its text and stores in 'buttonText' variable
        JButton jBut = (JButton) e.getSource();
        String buttonText = jBut.getText();

        if (!buttonText.equals("=") && !buttonText.equals("C")) { //Defining buttons "=" & "C"
            expressionParts.add(buttonText);
            updateTextPart();
        } else if (buttonText.equals("=")) {
            evaluateExpression();
        } else if (buttonText.equals("C")) {
            clearExpression();
        }
    }

    private void updateTextPart() { //Putting and updating given expression & parts into text
        StringBuilder expression = new StringBuilder();
        for (String part : expressionParts) {
            expression.append(part);
        }
        textPart.setText(expression.toString());
    }

    private String concatenateDigits(int startIndex) { //PART 3A: Method; concatenates digits starting from the given index in 'expressionParts'
        StringBuilder expression = new StringBuilder();
        for (int i = startIndex; i < expressionParts.size(); i ++) {
            String part = expressionParts.get(i);
            if (isOperator(part)){
                break;
            }
            expression.append(part);
        }
        return expression.toString();
    }
    private boolean isOperator(String part) {//PART 3B: Checks if given string respresents an operator
        return part.equals("+") || part.equals("-") || part.equals("*") || part.equals("/");
    }
    private int performOperation(String num1, String operator, String num2) {//PART 3C: Performing operation based on 2 numbers/operands and operator
        int operand1 = Integer.parseInt(num1);
        int operand2 = Integer.parseInt(num2);
        switch (operator) {
            case "+":
                return operand1 + operand2;
            case "-":
                return operand1 - operand2;
            case "*":
                return operand1 * operand2;
            case "/":
                if (operand2 != 0) {
                    return operand1 / operand2;
                } else { //For division by zero
                    clearExpression();
                    return 0;
                }
            default: //For unknown operator
                clearExpression();
                return 0;
        }
    }
    
    private void evaluateExpression() { //Defining whats going into the expression & its parts. Then, printing result into terminal & TextField
        if (expressionParts.size() < 3) {// Handles expression size when less than 3; clears expression
            clearExpression();
            return;
        }
        if (expressionParts.size() > 3){ //PART3D
            try { //For expression size > 3, attempts to convert int to strings and perform a calculator
            String num1 = concatenateDigits(0);
            String operator = expressionParts.get(num1.length());
            String num2 = concatenateDigits(num1.length()+1);
            int result= performOperation(num1, operator, num2);
            String resultString = Integer.toString(result);
            textPart.setText(resultString);
            System.out.println("Result: " + resultString);
            } catch (NumberFormatException | IndexOutOfBoundsException | ArithmeticException e) {
                clearExpression();
            }
            expressionParts.clear();
            
        } else { //PART 2B
            try { //For expression equal to 3, attempts to convert strings to int and perform a calculation
            int num1 = Integer.parseInt(expressionParts.get(0));
            String operator = expressionParts.get(1);
            int num2 = Integer.parseInt(expressionParts.get(2));
            int result = 0;
            switch (operator) { //if operator, then its operation is chosen
                case "+":
                    result = num1 + num2;
                    break;
                case "-":
                    result = num1 - num2;
                    break;
                case "*":
                    result = num1 * num2;
                    break;
                case "/":
                    result = num1 / num2;
                    break;
    
                default:
                    break;
            }
            textPart.setText(Integer.toString(result)); //prints result into TextField and terminal
            System.out.println("Result: " + result);
            
        } catch (NumberFormatException e) { //If conversion fails, aka non-numbers, clears expression in case of exception
            clearExpression();
        }
        expressionParts.clear(); //after print result, clears TextField
        }  
    }
    private void clearExpression() { //Defining clearExpression & clearing TextField
        expressionParts.clear();
        textPart.setText("");
    }
}
