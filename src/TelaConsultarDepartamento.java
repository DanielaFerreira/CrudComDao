import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class TelaConsultarDepartamento extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtCodigo;
	/**
	 * Create the panel.
	 */
	public TelaConsultarDepartamento(CadastroDepartamento cadDep) {
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblCodigoDoDepartamento = new JLabel("Insira o código do departamento");
		lblCodigoDoDepartamento.setBounds(125, 125, 183, 16);
		panel.add(lblCodigoDoDepartamento);
		
		JLabel lblNome = new JLabel("Nome: ");
		lblNome.setBounds(70, 40, 200, 16);
		panel.add(lblNome);
		
		JLabel lblSigla = new JLabel("Sigla: ");
		lblSigla.setBounds(70, 80, 200, 16);
		panel.add(lblSigla);
		
		txtCodigo = new JTextField();
		txtCodigo.setBounds(155, 150, 120, 20);
		panel.add(txtCodigo);
		txtCodigo.setColumns(10);
		
		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Departamento dpmt = DepartamentoDAO.pesquisa(Integer.parseInt(txtCodigo.getText()));
				
				lblNome.setText("Nome: " + dpmt.getNome());
				lblSigla.setText("Sigla: " + dpmt.getSigla());
				
			}
		});
		btnConsultar.setBounds(165, 180, 100, 25);
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
		btnVoltar.setBounds(165, 215, 100, 25);
		panel.add(btnVoltar);
	}
}
