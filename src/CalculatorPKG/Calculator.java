package CalculatorPKG;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Calculator extends JFrame{
    private JPanel mainPanel;
    private JButton btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn0, btnMult, btnSub, btnAdd, btnDot, btnEqual,
            btnClear, btnOverX, btnBack, btnDiv, btnRoot, btnSqr;
    private JLabel pic, ansField;
    private JButton btnNeg;

    int counter = 1;
    String s1 = "";
    String s2 = "";
    String s3 = "";
    char op = '0';
    boolean eql = false;

    //size limit for the JLabel that displays the text at the top of the calculator
    void sizeLimiter(String s){
        if(s.length()>=14){ansField.setText(s.substring(0,13));} else {ansField.setText(s);}
    }
    void typing(String str){
        if(op=='1'){s1 = "";}
        if(counter==1){ s1 += str; sizeLimiter(s1);}
        else {s2 += str; sizeLimiter(s2);}
    }

    void getAns(){
        double n1 = Double.valueOf(s1);
        double n2 = Double.valueOf(s2);
        double n3 = switch (op) {
            case '+' -> n1 + n2;
            case '-' -> n1 - n2;
            case '*' -> n1 * n2;
            case '/' -> n1 / n2;
            default -> 0;
        };

        s1 = String.valueOf(n3);
        s2 = "";
        s3 = String.valueOf(n3);
        sizeLimiter(s3);
        op = '1';

    }

    void complexOperator(double x){
        double n3 = 0;

        n3 = x;

        s1 = String.valueOf(n3);
        s2 = "";
        s3 = String.valueOf(n3);
        sizeLimiter(s3);
        op = '1';

        counter = 1;
    }


    public Calculator() {
        setContentPane(mainPanel);
        setTitle("Calculator");
        setSize(300, 240);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        pic.setIcon(new ImageIcon(Calculator.class.getResource("/CalculatorPKG/Calvin&Hobbes.png")));

        //////////////////////////////////////////////////////////////////////////////////////////////////////
        //NUMBERS
        //////////////////////////////////////////////////////////////////////////////////////////////////////
        btnNeg.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {typing("-");}
        });

        btn0.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {typing("0");}
        });
        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {typing("1");}
        });
        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {typing("2");}
        });
        btn3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {typing("3");}
        });
        btn4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {typing("4");}
        });
        btn5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {typing("5");}
        });
        btn6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {typing("6");}
        });
        btn7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {typing("7");}
        });
        btn8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {typing("8");}
        });
        btn9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {typing("9");}
        });
        btnDot.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {typing(".");}
        });

        //////////////////////////////////////////////////////////////////////////////////////////////////////
        //OPERATORS
        //////////////////////////////////////////////////////////////////////////////////////////////////////

        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(counter==2){getAns();}
                op = '+';
                counter = 2;
            }
        });
        btnSub.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(counter==2){getAns();}
                op = '-';
                counter = 2;
            }
        });
        btnMult.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(counter==2){getAns();}
                op = '*';
                counter = 2;
            }
        });
        btnDiv.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(counter==2){getAns();}
                op = '/';
                counter = 2;
            }
        });

        //////////////////////////////////////////////////////////////////////////////////////////////////////
        //COMPLEX OPERATORS
        //////////////////////////////////////////////////////////////////////////////////////////////////////

        btnRoot.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                complexOperator(Math.sqrt(Double.valueOf(s1)));
            }
        });
        btnSqr.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                complexOperator(Math.pow(Double.valueOf(s1),2 ));
            }
        });
        btnOverX.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                complexOperator(1/(Double.valueOf(s1)));
            }
        });

        //////////////////////////////////////////////////////////////////////////////////////////////////////
        //EQUAL
        //////////////////////////////////////////////////////////////////////////////////////////////////////

        btnEqual.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getAns();
                counter = 1;
                eql = true;
            }
        });

        //////////////////////////////////////////////////////////////////////////////////////////////////////
        //CLEAR
        //////////////////////////////////////////////////////////////////////////////////////////////////////

        btnClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                s1 = s2 = s3 = "";
                ansField.setText("0");
                counter = 1;
                op = '0';
            }
        });

        //////////////////////////////////////////////////////////////////////////////////////////////////////
        //DELETE
        //////////////////////////////////////////////////////////////////////////////////////////////////////

        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(counter==1){
                    if(s1.length()!=1){
                        s1 = s1.substring(0,s1.length()-1);
                        sizeLimiter(s1);
                    } else {
                        s1 = "";
                        ansField.setText("0");
                    }
                    if(eql == true){ //this is redundant but easier to understand with it being like this
                        s1 = "";
                        ansField.setText("0");
                        eql = false;
                    }
                }
                if(counter==2){
                    if(s2.length()!=1){
                        s2 = s2.substring(0,s2.length()-1);
                        sizeLimiter(s2);
                    } else {
                        s2 = "";
                        ansField.setText("0");
                    }
                }
            }
        });
    }

    public static void main(String[] args){
        Calculator myFrame = new Calculator();
    }
}