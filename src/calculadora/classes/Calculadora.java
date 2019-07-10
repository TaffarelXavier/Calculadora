/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadora.classes;

import javax.swing.JTextField;

/**
 *
 * @author Taffarel
 */
public class Calculadora {

    public static double numeroX = 0;

    private static String opedaror;

    public static String[] array;

    public static double getNumeroX() {
        return numeroX;
    }

    /**
     *
     * @param txt1
     * @return
     */
    public static String getTextFiel1(JTextField txt1) {
        return txt1.getText().equals("0") || txt1.getText().equals("") || txt1.getText().equals("") || txt1.getText().equals(" ") ? null : "";
    }

    /**
     *
     * @param numero
     * @return
     */
    public static double calculaFatorial(double numero) {
        double i, fact = 1;
        for (i = 1; i <= numero; i++) {
            fact = fact * i;
        }
        return fact;
    }

    /**
     *
     * @param txt1
     * @param numero
     */
    public static void setNumeroX(JTextField txt1, String numero) {
        if (txt1.getText().equals("0.0") || txt1.getText().equals("0")) {
            txt1.setText("");
            String n = txt1.getText() + numero;
            txt1.setText(n);
            numeroX = Double.valueOf(n);
        } else {
            String n = txt1.getText() + numero;
            txt1.setText(n);
            numeroX = Double.valueOf(n);
        }
    }

    public static void setNumeroAsKeyPress(JTextField txt1) {
        try {
            numeroX = Double.valueOf(txt1.getText());
        } catch (Exception e) {
        }
    }

    /**
     *
     * @param j1
     * @param j2
     * @param oper
     */
    public static void limparVisorEDevinirOperador(JTextField j1, JTextField j2, String oper) {
        opedaror = oper;
        j1.setText("");
        j2.setText(String.valueOf(numeroX) + "" + oper);

    }

    /**
     *
     * @param j1
     * @param j2
     */
    public static void limparVisor(JTextField j1, JTextField j2) {
        j1.setText("0");
        j2.setText("0");
        numeroX = 0;
    }

    public static double multiplicar(double n1, double n2) {
        return n1 * n2;
    }

    public static double dividir(double n1, double n2) {
        return n1 / n2;
    }

    public static double somar(double n1, double n2) {
        return n1 + n2;
    }

    public static double subtrair(double n1, double n2) {
        return n1 - n2;
    }

    /**
     *
     * @param j1
     * @param j2
     */
    public static void calcular(JTextField j1, JTextField j2) {

        double resultado = 0;

        if (!getTextFiel1(j1).equals(null)) {

            switch (opedaror) {
                case "x":
                    array = j2.getText().split("x");
                    resultado = multiplicar(Double.valueOf(array[0]), Double.valueOf(j1.getText()));
                    break;
                case ":":
                    array = j2.getText().split(":");
                    resultado = Double.valueOf(array[0]) / Double.valueOf(j1.getText());
                    break;
                case "+":
                    array = j2.getText().split("\\+");
                    resultado = somar(Double.valueOf(array[0]), Double.valueOf(j1.getText()));
                    break;
                case "-":
                    array = j2.getText().split("-");
                    resultado = subtrair(Double.valueOf(array[0]), Double.valueOf(j1.getText()));
                    break;
            }

            j2.setText(array[0] + opedaror + Double.valueOf(j1.getText()) + "=" + String.valueOf(resultado));

            j1.setText(String.valueOf(resultado));
        }
    }

}
