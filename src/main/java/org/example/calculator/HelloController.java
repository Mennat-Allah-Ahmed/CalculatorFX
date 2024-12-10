package org.example.calculator;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import javafx.scene.control.Button;

public class HelloController {
    @FXML
    private TextField txt_result;
    String op ="";
    long number1;
    long number2;
    String C= "";
    // Number Method
    public void Number (javafx.event.ActionEvent N){
        String nu = ((Button)N.getSource()).getText();
        txt_result.setText(txt_result.getText()+nu);
    }

    // Operation Method
    public void Operation (javafx.event.ActionEvent O){

        String operation = ((Button)O.getSource()).getText();
        if (!operation.equals("=")){
            if(!op.equals("")){
                return;
            }
            op = operation;
            number1 = Long.parseLong(txt_result.getText());
            txt_result.setText("");
        }else {
            if(op.equals("")){
                return;
            }
            number2 = Long.parseLong(txt_result.getText());
            calculate(number1, number2, op);
            op="";
        }
    }
    // Calc Methode
    public void calculate (long n1, long n2, String op) {

        switch (op) {

            case "+":
                txt_result.setText(n1 + n2 + "");
                break;
            case "-":
                txt_result.setText(n1 - n2 + "");
                break;
            case "*":
                txt_result.setText(n1 * n2 + "");
                break;
            case "/":
                if (n2 == 0) {
                    txt_result.setText("0");
                    break;
                }
                txt_result.setText(n1 / n2 + "");
                break;
        }
    }
    //Clear Methode
    public void Clear(javafx.event.ActionEvent c){
        String cc = ((Button)c.getSource()).getText();
        if (C.equals("")){
            txt_result.setText("");
        }
    }
}