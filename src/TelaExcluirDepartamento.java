import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TelaExcluirDepartamento extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtCodigo;
	/**
	 * Create the panel.
	 */
	public TelaExcluirDepartamento(CadastroDepartamento cadDep) {
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		JLabel lblCodigoDoDepartamento = new JLabel("Insira o código do departamento");
		lblCodigoDoDepartamento.setBounds(131, 36, 198, 16);
		panel.add(lblCodigoDoDepartamento);
		
		txtCodigo = new JTextField();
		txtCodigo.setBounds(96, 70, 120, 20);
		panel.add(txtCodigo);
		txtCodigo.setColumns(10);
		
		JButton btnConsultar = new JButton("Excluir");
		btnConsultar.setBounds(96, 216, 100, 25);
		panel.add(btnConsultar);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cadDep.getFrame().getContentPane().add(new TelaInicial(cadDep), BorderLayout.CENTER);
				remove(panel);
				cadDep.getFrame().setVisible(true);
			}
		});
		btnVoltar.setBounds(214, 216, 100, 25);
		panel.add(btnVoltar);
		
		JLabel lblExcluir = new JLabel("Excluir");
		lblExcluir.setBounds(195, 11, 46, 14);
		panel.add(lblExcluir);
		
		JButton btnConsultar_1 = new JButton("Consultar");
		btnConsultar_1.setBounds(226, 69, 89, 23);
		panel.add(btnConsultar_1);
		
		JLabel lblDados = new JLabel("Dados");
		lblDados.setBounds(96, 101, 46, 14);
		panel.add(lblDados);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(116, 146, 198, 14);
		panel.add(lblNome);
		
		JLabel lblSigla = new JLabel("Sigla");
		lblSigla.setBounds(116, 164, 100, 14);
		panel.add(lblSigla);
		
		JLabel lblCodigo = new JLabel("Codigo");
		lblCodigo.setBounds(116, 126, 100, 14);
		panel.add(lblCodigo);
	}

}
