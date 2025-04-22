package apresentação;

import negocio.Matematica;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VisaoCalculadora {
    public static void main(String[] args) {

        //Criando a janela
        JFrame tela = new JFrame("Calculadora");
        tela.setSize(350, 450);
        tela.setLayout(new BorderLayout());

        // Display para o texto
        JTextField display = new JTextField();
        display.setEditable(false);
        tela.add(display, BorderLayout.NORTH);

        // Painel dos botoes
        JPanel painelB = new JPanel();
        painelB.setLayout(new GridLayout(4, 4, 10, 10)); // 4x4 grid layout

        // Numeros na tela
        String[] buttonLabels = {
                "7", "8", "9", "/",
                "4", "5", "6", "*",
                "1", "2", "3", "-",
                ".", "0", "=", "+"
        };

        ActionListener buttonListener = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String buttonText = e.getActionCommand();

                if (buttonText.equals("=")) {
                    try {
                        // Calcular e mostrar o resultado
                        display.setText(Matematica.calcular(display.getText()));
                    } catch (Exception ex) {
                        display.setText("Error");
                    }
                } else {
                    display.setText(display.getText() + buttonText);
                }
            }
        };

        for (String label : buttonLabels) {
            JButton button = new JButton(label);
            button.addActionListener(buttonListener);
            painelB.add(button);
        }

        tela.add(painelB, BorderLayout.CENTER);

        tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        tela.setVisible(true);
    }
}
