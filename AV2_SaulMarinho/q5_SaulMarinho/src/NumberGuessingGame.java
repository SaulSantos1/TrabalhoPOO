import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class NumberGuessingGame {
    private JFrame frame;
    private JPanel panel;
    private JButton[] buttons;
    private JTextField attemptTextField;
    private int randomNumber;
    private int attemptsLeft = 5;

    public NumberGuessingGame() {
        frame = new JFrame("Adivinhe o Número");
        panel = new JPanel();
        buttons = new JButton[20];
        attemptTextField = new JTextField(15);
        randomNumber = new Random().nextInt(20) + 1;

        for (int i = 0; i < 20; i++) {
            buttons[i] = new JButton(String.valueOf(i + 1));
            buttons[i].addActionListener(new ButtonClickListener());
            panel.add(buttons[i]);
        }

        panel.add(attemptTextField);
        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        frame.setSize(400, 200);
    }

    private class ButtonClickListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            JButton clickedButton = (JButton) event.getSource();
            int userGuess = Integer.parseInt(clickedButton.getText());
            attemptsLeft--;

            if (userGuess == randomNumber) {
                System.out.println("Opção do usuário: " + userGuess);
                System.out.println("Número Sorteado: " + randomNumber);
                System.out.println("Parabéns! Você adivinhou o número!");
                attemptTextField.setText("Tentativas restantes: " + attemptsLeft);
                disableAllButtons();
            } else {
                System.out.println("Opção do usuário: " + userGuess);
                System.out.println("Número Sorteado: " + randomNumber);
                System.out.println("Opção errada. Tente novamente!");
                attemptTextField.setText("Tentativas restantes: " + attemptsLeft);
                if (attemptsLeft == 0) {
                    System.out.println("Fora das tentativas. O número correto era: " + randomNumber);
                    disableAllButtons();
                }
            }
        }

        private void disableAllButtons() {
            for (int i = 0; i < 20; i++) {
                buttons[i].setEnabled(false);
            }
        }
    }

    public static void main(String[] args) {
        new NumberGuessingGame();
    }
}
