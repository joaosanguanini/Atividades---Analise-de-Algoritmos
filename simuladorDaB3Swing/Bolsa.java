package simuladorDaB3Swing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

public class Bolsa extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField procurarUmaAcao;
	private JTable table;
	private List<Acao> acoes;
	private List<Investidor> investidores;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Bolsa frame = new Bolsa(null, null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	private void atualizarTabela(DefaultTableModel tabela, Ordem ordem) {
		tabela.setRowCount(0);
	    for (int i = 1; i < tabela.getColumnCount(); i++) {
	    	tabela.addRow(new Object[]{
	            ordem.getAcao(),
	            ordem.getValor(),
	            ordem.getTipo()
	        });
	    }
	}
	public void gerarOrdensTeste(List<Acao> acoes, Investidor investidor) {

	    for (int i = 0; i < 20; i++) {

	        Acao acao = acoes.get((int)(Math.random() * acoes.size()));

	        TipoOrdem tipo = Math.random() < 0.5 ? TipoOrdem.COMPRA : TipoOrdem.VENDA;

	        double variacao = (Math.random() * 0.1) - 0.05;
	        double valor = acao.getValor() * (1 + variacao);

	        valor = Math.round(valor * 100.0) / 100.0;

	        Ordem ordem = new Ordem(investidor, valor, tipo, acao);

	        acao.adicionarOrdem(ordem);
	    }
	}
	
	/**
	 * Create the frame.
	 */
	public Bolsa(List<Acao> acoes, Investidor investidor) {

		investidor.AdicionarAcao(new Acao("PETR4", 30));
		investidor.AdicionarAcao(new Acao("ABEV3", 10));
		investidor.AdicionarAcao(new Acao("ITSA4", 30));
		investidor.AdicionarAcao(new Acao("LOES3", 30));
		investidor.AdicionarAcao(new Acao("BBSB4", 30));
		investidor.AdicionarAcao(new Acao("PAGS4", 30));
		investidor.AdicionarAcao(new Acao("GASR4", 30));
		investidor.AdicionarAcao(new Acao("AGAD4", 30));
		investidor.AdicionarAcao(new Acao("PGAV4", 30));
		investidor.AdicionarAcao(new Acao("GASG4", 30));
		investidor.AdicionarAcao(new Acao("PHFG4", 30));
		
		gerarOrdensTeste(investidor.getAcoes(), investidor);
		CadastroInvestidor dialog = new CadastroInvestidor(this);
		dialog.setVisible(true);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1091, 796);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaption);
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(0, 0, 1075, 86);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton botaoHome = new JButton("");
		botaoHome.setIcon(new ImageIcon("C:\\Users\\lucas\\Downloads\\icons8-casa-64(1).png"));
		botaoHome.setFont(new Font("Tahoma", Font.BOLD, 28));
		botaoHome.setBorder(null);
		botaoHome.setBounds(10, 11, 80, 64);
		panel.add(botaoHome);
		
		JButton botaoUser = new JButton("");
		botaoUser.setIcon(new ImageIcon("C:\\Users\\lucas\\Downloads\\icons8-usuário-60.png"));
		botaoUser.setFont(new Font("Tahoma", Font.BOLD, 28));
		botaoUser.setBorder(null);
		botaoUser.setBounds(985, 11, 80, 64);
		panel.add(botaoUser);
		
		procurarUmaAcao = new JTextField();
		procurarUmaAcao.setFont(new Font("Tahoma", Font.PLAIN, 28));
		procurarUmaAcao.setText("Procurar uma ação");
		procurarUmaAcao.setToolTipText("Procurar uma ação");
		procurarUmaAcao.setBounds(172, 11, 657, 64);
		panel.add(procurarUmaAcao);
		procurarUmaAcao.setColumns(10);
		
		JButton botaoComprar = new JButton("COMPRAR");
		botaoComprar.setForeground(Color.BLACK);
		botaoComprar.setBackground(Color.GREEN);
		botaoComprar.setFont(new Font("Tahoma", Font.BOLD, 14));
		botaoComprar.setBounds(895, 659, 130, 68);
		contentPane.add(botaoComprar);
		
		
		JButton botaoVender = new JButton("VENDER");
		botaoVender.setForeground(Color.BLACK);
		botaoVender.setFont(new Font("Tahoma", Font.BOLD, 14));
		botaoVender.setBackground(Color.RED);
		botaoVender.setBounds(731, 659, 130, 68);
		contentPane.add(botaoVender);
		DefaultTableModel tabela = new DefaultTableModel();
		tabela.addColumn("Ação");
		tabela.addColumn("Valor");
		tabela.addColumn("Tipo");

		table = new JTable(tabela); 
		JScrollPane scroll = new JScrollPane(table);

		JPanel painelCentral = new JPanel();
		painelCentral.setBounds(180, 177, 669, 412);

		painelCentral.setLayout(new BorderLayout());
		painelCentral.add(scroll, BorderLayout.CENTER);

		contentPane.add(painelCentral);
		botaoComprar.addActionListener(e -> {
		    TelaComprar tela = new TelaComprar(acoes, investidor);
		    tela.setLocationRelativeTo(null);
		    tela.setVisible(true);
		});
		botaoVender.addActionListener(e -> {
		    TelaVender tela = new TelaVender(tabela);
		    tela.setLocationRelativeTo(null);
		    tela.setVisible(true);
		});

	}
}
