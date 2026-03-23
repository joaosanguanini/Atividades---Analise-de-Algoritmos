package simuladorDaB3;

import javax.swing.*;
import java.awt.*;

public class CadastroInvestidor extends JDialog {

    private JTextField campoNome;

    public CadastroInvestidor(JFrame parent) {
        super(parent, "Cadastro de Investidor", true);

        setSize(300, 200);
        setLocationRelativeTo(parent);
        setLayout(new BorderLayout());

        JPanel panel = new JPanel(new GridLayout(2, 1, 10, 10));

        campoNome = new JTextField();
        panel.add(new JLabel("Nome do investidor:"));
        panel.add(campoNome);

        add(panel, BorderLayout.CENTER);

        JButton botaoSalvar = new JButton("Salvar");

        botaoSalvar.addActionListener(e -> {
            String nome = campoNome.getText();

            if (nome.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Digite um nome!");
            } else {
                Investidor investidor = new Investidor(nome);
                JOptionPane.showMessageDialog(this, "Usuario cadastrado");
                dispose();
            }
        });

        add(botaoSalvar, BorderLayout.SOUTH);
    }
}