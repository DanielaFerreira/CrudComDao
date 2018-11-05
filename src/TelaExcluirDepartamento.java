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
		lblCodigoDoDepartamento.setBounds(125, 125, 183, 16);
		panel.add(lblCodigoDoDepartamento);
		
		txtCodigo = new JTextField();
		txtCodigo.setBounds(155, 150, 120, 20);
		panel.add(txtCodigo);
		txtCodigo.setColumns(10);
		
		JButton btnConsultar = new JButton("Procurar");
		btnConsultar.setBounds(165, 180, 100, 25);
		panel.add(btnConsultar);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cadDep.getFrame().add(new TelaInicial(cadDep), BorderLayout.CENTER);
				remove(panel);
				cadDep.getFrame().setVisible(true);
			}
		});
		btnVoltar.setBounds(165, 215, 100, 25);
		panel.add(btnVoltar);
	}

}
