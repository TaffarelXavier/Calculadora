/*
 * Feito 07 de Março de 2018
 */
package classes;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 * <p style="font:20px arial;color:green;">
 * Para mostrar os dados serão necessários dois JTextFields. No JTextField1,
 * será mostrado o resultado no primeiro.
 * </p>
 *
 * @author Taffarel
 */
public class Calculadora {

    /**
     * <p style="font:16px arial">A Variável principal que receberá os valores.
     * <b>Por exemplo:</b> Quando alguém pressionar o número 9, ele será
     * atribuído a esta variável.
     * </p>
     */
    public static double algarismo = 0;

    /**
     *
     */
    private static String opedaror;
    /**
     *
     */
    private static String valorOperadorPressionado = "";
    /**
     *
     */
    public static String[] array;

    /**
     *
     * @param txt1 <p style="font:16px arial">O Visor Principal</p>
     * @param numero <p style="font:16px arial">Os números da calculadora: de 0
     * a 9. </p>
     * @param txt2 <p style="font:16px arial">O segundo Visor Principal</p>
     */
    public static void setNumeroX(JTextField txt1, String numero, JTextField txt2) {
        if (txt1.getText().equals("0.0") || txt1.getText().equals("0")) {
            //txt1.setText("");
            String n = txt1.getText() + numero;
            txt1.setText(n.replace("0", ""));
            algarismo = Double.valueOf(n);
            txt2.setText(numero);
        } else {
            String n = txt1.getText() + numero;
            txt1.setText(n);
            algarismo = Double.valueOf(n);
            //Valor Padrão
            if (Boolean.valueOf(valorOperadorPressionado)) {
                txt2.setText(txt1.getText() + "" + valorOperadorPressionado);
            } else {
                txt2.setText(txt2.getText() + "" + numero);
            }

        }
    }

    /**
     *
     * @param j1 <p style="font:16px arial">O JTextField principal</p>
     * @param j2 <p style="font:16px arial">O JTextField secundário</p>
     */
    public static void calcular(JTextField j1, JTextField j2) {

        double resultado;

        if (!getTextFiel1(j1)) {

            switch (opedaror) {
                case "x":
                    array = j2.getText().split("x");
                    resultado = multiplicar(Double.valueOf(array[0]), Double.valueOf(j1.getText()));
                    j2.setText(array[0] + opedaror + Double.valueOf(j1.getText()) + "=" + String.valueOf(resultado));
                    j1.setText(String.valueOf(resultado));
                    break;
                case ":":
                    array = j2.getText().split(":");
                    resultado = Double.valueOf(array[0]) / Double.valueOf(j1.getText());
                    j2.setText(array[0] + opedaror + Double.valueOf(j1.getText()) + "=" + String.valueOf(resultado));
                    j1.setText(String.valueOf(resultado));
                    break;
                case "+":
                    array = j2.getText().split("\\+");
                    resultado = somar(Double.valueOf(array[0]), Double.valueOf(j1.getText()));
                    j2.setText(array[0] + opedaror + Double.valueOf(j1.getText()) + "=" + String.valueOf(resultado));
                    j1.setText(String.valueOf(resultado));
                    break;
                case "-":
                    array = j2.getText().split("-");
                    resultado = subtrair(Double.valueOf(array[0]), Double.valueOf(j1.getText()));
                    j2.setText(array[0] + opedaror + Double.valueOf(j1.getText()) + "=" + String.valueOf(resultado));
                    j1.setText(String.valueOf(resultado));
                    break;
                case "^":
                    array = j2.getText().split("\\^");
                    resultado = potencia(Double.valueOf(array[0]), Double.valueOf(j1.getText()));
                    j2.setText(array[0] + opedaror + Double.valueOf(j1.getText()) + "=" + String.valueOf(resultado));
                    j1.setText(String.valueOf(resultado));
                    break;
                case "%":
                    calcularPorcentagem(j1, j2);
                    break;
            }

        }
    }

    /**
     * <p style="font:16px arial">Calcular a quantidade, em função do total e a
     * porcentagem que representa</p>
     *
     * @param j1 <p style="font:16px arial">O JTextField principal</p>
     * @param j2 <p style="font:16px arial">O JTextField secundário</p>
     * @return 0
     */
    public static double calcularPorcentagem(JTextField j1, JTextField j2) {

        array = j2.getText().split("\\%");

        double resultado = (Double.valueOf(array[0]) / 100) * algarismo;

        j2.setText(Double.valueOf(j1.getText()) + "% de " + array[0] + " é igual a " + String.valueOf(resultado));

        j1.setText(String.valueOf(resultado));

        return 0;
    }

    /**
     * <p style="font:16px arial">Verifica se o texto de um jTextField está <br>
     * vazio, igual a zero, ou com espaço
     * </p>
     *
     * @param txt1 <p style="font:16px arial">O JTextField principal</p>
     * @return true <p style="font:16px arial">Se o JTextField está com o valor
     * 0, "" ou " "</p>
     */
    public static boolean getTextFiel1(JTextField txt1) {
        return txt1.getText().equals("0") || txt1.getText().equals("") || txt1.getText().equals(" ");
    }

    /**
     * <p style="font:16px arial">Quando pressionado a tecla CE, remove o último
     * caractere.
     * <b>Por exemplo:</b> Se, no visor principal, tiver 0124568799654, e
     * pressionar a tecla CE, então será removido o números da direita pra
     * esquerda, um por um.
     * </p>
     *
     * @param txt1 <p style="font:16px arial">O JTextField principal</p>
     * @return <p style="font:16px arial">O texto removido da direita pra
     * esquera.</p>
     */
    public static String removeLastChar(JTextField txt1) {
        if (txt1.getText().length() != 0 && !txt1.getText().equals("0")) {
            txt1.setText(txt1.getText().substring(0, txt1.getText().length() - 1));
        } else {
            txt1.setText("0");
        }
        return txt1.getText();
    }

    /**
     * <p>
     * Substitui vírgula por ponto. Aqui, é usada uma regular expressão para
     * fazer as substituições</p>
     *
     * @param txt1 <p style="font:16px arial">O JTextField principal</p>
     * @return String
     */
    public static String substituirVirgularPorPonto(JTextField txt1) {
        txt1.setText(txt1.getText().replaceAll("\\,+", ".").replaceAll("\\.", "."));
        return txt1.getText();
    }

    /**
     * <p style="font:16px arial">Calcula o fatoria de um número</p>
     *
     * @param numero <p style="font:16px arial">O número para calcular o
     * fatorial</p>
     * @return double o Fatorial do número
     */
    public static double calculaFatorial(double numero) {
        double i, fact = 1;
        for (i = 1; i <= numero; i++) {
            fact = fact * i;
        }
        return fact;
    }

    /**
     * No JTextField principal,
     *
     * @param txt1 <p style="font:16px arial">Alias</p>
     */
    public static void setNumeroAsKeyPress(JTextField txt1) {
        try {
            algarismo = Double.valueOf(txt1.getText());
        } catch (NumberFormatException e) {
            //JOptionPane.showMessageDialog(null, e.getMessage(), "Atenção", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     *
     * @param j1 <p style="font:16px arial">O JTextField principal</p>
     * @param j2 <p style="font:16px arial">O JTextField secundário</p>
     * @param oper <p style="font:16px arial">O Operador: *, /, +, - , ^ e
     * %.</p>
     */
    public static void limparVisorEDevinirOperador(JTextField j1, JTextField j2, String oper) {
        opedaror = oper;
        valorOperadorPressionado = j1.getText();
        j1.setText("");
        j2.setText(String.valueOf(algarismo) + "" + oper);
    }

    /**
     * <p style="font:16px arial">Limpa o visor, atribui zero à variável
     * <b>algorismo</b> e atribui "" à variável <b>valorOperadorPressionado</b>
     * </p>
     *
     * @param j1 <p style="font:16px arial">O JTextField principal</p>
     * @param j2 <p style="font:16px arial">O JTextField secundário</p>
     */
    public static void limparVisor(JTextField j1, JTextField j2) {
        j1.setText("0");
        j2.setText("0");
        algarismo = 0;
        valorOperadorPressionado = "";
    }

    /**
     *
     * <p style="font:16px arial">Calcula a potência de um número.</p>
     *
     * @param n1
     * @param n2
     * @return
     */
    public static double potencia(double n1, double n2) {
        return (double) Math.pow(n1, n2);
    }

    /**
     *
     * @param n1 <p style="font:16px arial">Primeiro fator</p>
     * @param n2 <p style="font:16px arial"></p>
     * @return Retorna o <b>produto</b> de <b>n1 e n2<b/>
     */
    public static double multiplicar(double n1, double n2) {
        return n1 * n2;
    }

    public static double dividir(double n1, double n2) {
        try {
            return n1 / n2;
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Atenção", JOptionPane.ERROR_MESSAGE);
        }
        return 0;
    }

    public static double somar(double n1, double n2) {
        return n1 + n2;
    }

    public static double subtrair(double n1, double n2) {
        return n1 - n2;
    }

    public static void mostrarPI(JTextField jTxt1) {
        algarismo = (double) Math.PI;
        jTxt1.setText(String.valueOf(Math.PI));
    }

    public static String getValueOf(double a) {
        return String.valueOf(a);
    }

    public static double calcularLog(JTextField jTxt1) {
        jTxt1.setText(getValueOf(Math.log10(algarismo)));
        return 0;
    }

    public static double seno(JTextField jTxt1) {
        jTxt1.setText(getValueOf(Math.sin(algarismo)));
        return 0;
    }

    public static double tangente(JTextField jTxt1) {
        jTxt1.setText(getValueOf(Math.tan(algarismo)));
        return 0;
    }

    public static double conseno(JTextField jTxt1) {
        jTxt1.setText(getValueOf(Math.cos(algarismo)));
        return 0;
    }

    public static double elevarAoCubo(JTextField j1, JTextField j2) {
        try {
            System.out.println(algarismo);
            double resultado = (double) Math.pow(Double.valueOf(j1.getText()), 3);
            j1.setText(String.valueOf(resultado));
            j2.setText(j1.getText() + "^3=" + String.valueOf(resultado));
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
        }

        return 0;
    }

}
