import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TelaAlterarDepartamento extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtCodigo;
	private JTextField tfNome;
	private JTextField tfSigla;
	/**
	 * Create the panel.
	 */
	public TelaAlterarDepartamento(CadastroDepartamento cadDep) {
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.setBounds(106, 215, 100, 25);
		panel.add(btnAlterar);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cadDep.getFrame().getContentPane().add(new TelaInicial(cadDep), BorderLayout.CENTER);
				remove(panel);
				cadDep.getFrame().setVisible(true);
			}
		});
		btnVoltar.setBounds(227, 215, 100, 25);
		panel.add(btnVoltar);

		txtCodigo = new JTextField();
		txtCodigo.setBounds(116, 76, 120, 20);
		panel.add(txtCodigo);
		txtCodigo.setColumns(10);

		JLabel lblCodigoDoDepartamento = new JLabel("Insira o código do departamento");
		lblCodigoDoDepartamento.setBounds(146, 50, 195, 16);
		panel.add(lblCodigoDoDepartamento);
		
		JLabel lblAlterar = new JLabel("Alterar dados");
		lblAlterar.setBounds(184, 24, 129, 14);
		panel.add(lblAlterar);
		
		JLabel lblDados = new JLabel("Dados");
		lblDados.setBounds(99, 116, 51, 14);
		panel.add(lblDados);
		
		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.setBounds(246, 75, 89, 23);
		panel.add(btnConsultar);
		
		tfNome = new JTextField();
		tfNome.setBounds(120, 142, 86, 20);
		panel.add(tfNome);
		tfNome.setColumns(10);
		
		tfSigla = new JTextField();
		tfSigla.setBounds(264, 140, 86, 20);
		panel.add(tfSigla);
		tfSigla.setColumns(10);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(75, 145, 43, 14);
		panel.add(lblNome);
		
		JLabel lblSigla = new JLabel("Sigla");
		lblSigla.setBounds(227, 143, 36, 14);
		panel.add(lblSigla);
	}
}
