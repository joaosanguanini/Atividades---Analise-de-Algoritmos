package simuladorDaB3Swing;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class TelaComprar extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JTextField textProcurarAcoes;
	private List<Acao> acoes;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaComprar frame = new TelaComprar(null, null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaComprar(List<Acao> acoes, Investidor investidor) {
		this.acoes = acoes;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 531, 704);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextPane textoSuasAcoes = new JTextPane();
		textoSuasAcoes.setForeground(Color.BLACK);
		textoSuasAcoes.setEnabled(false);
		textoSuasAcoes.setEditable(false);
		textoSuasAcoes.setBackground(new Color(240, 240, 240));
		textoSuasAcoes.setFont(new Font("Tahoma", Font.BOLD, 28));
		textoSuasAcoes.setText("Ações disponiveis");
		textoSuasAcoes.setBounds(141, 11, 253, 38);
		contentPane.add(textoSuasAcoes);
		
		JButton botaoComprar = new JButton("Comprar");
		botaoComprar.setBackground(Color.GREEN);
		botaoComprar.setBounds(410, 631, 95, 23);
		contentPane.add(botaoComprar);
		
		JButton botaoCancelar = new JButton("Cancelar");
		botaoCancelar.setBackground(Color.RED);
		botaoCancelar.setBounds(299, 631, 95, 23);
		contentPane.add(botaoCancelar);
		
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("Ação");
		model.addColumn("Valor Atual");

		table = new JTable(model);
		JScrollPane scroll = new JScrollPane(table);
		scroll.setBounds(67, 175, 378, 409);
		contentPane.add(scroll);
				
		for (Acao a : acoes) {
		    model.addRow(new Object[]{
		        a.getNome(),
		        a.getValor()
		    });
		}
				textProcurarAcoes = new JTextField();
				textProcurarAcoes.setForeground(Color.LIGHT_GRAY);
				textProcurarAcoes.setFont(new Font("Tahoma", Font.PLAIN, 14));
				textProcurarAcoes.setText("Procurar ações");
				textProcurarAcoes.setBounds(67, 106, 378, 20);
				contentPane.add(textProcurarAcoes);
				textProcurarAcoes.setColumns(10);
				botaoComprar.addActionListener(e -> {

				    int linha = table.getSelectedRow();

				    if (linha == -1) {
				        JOptionPane.showMessageDialog(this, "Selecione uma ação!");
				        return;
				    }

				    String nomeAcao = table.getValueAt(linha, 0).toString();

				    Acao acaoSelecionada = null;

				    for (Acao a : acoes) {
				        if (a.getNome().equals(nomeAcao)) {
				            acaoSelecionada = a;
				            break;
				        }
				    }

				    Ordem ordem = new Ordem(investidor, acaoSelecionada.getValor(), TipoOrdem.COMPRA, acaoSelecionada);

				    acaoSelecionada.adicionarOrdem(ordem);

				    JOptionPane.showMessageDialog(this, "Ordem de compra criada!");

				    dispose();
				});
	}
}
