/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;

/**
 *
 * @author Taffarel
 */
public class JButtonCalculadora {

    public void definirImagem(JButton[] buttons, String[] imagens) {
        try {
            for (int i = 0; i < buttons.length; i++) {
                buttons[i].setIcon(new ImageIcon(getClass().getResource("/imagens/" + imagens[i])));
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "atenção", JOptionPane.ERROR_MESSAGE);
        }
    }
}
