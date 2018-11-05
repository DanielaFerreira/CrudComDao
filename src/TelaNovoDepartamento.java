import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TelaNovoDepartamento extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtNome;
	private JTextField txtSigla;
	private JTextField txtCdigo;

	/**
	 * Create the panel.
	 */
	public TelaNovoDepartamento(CadastroDepartamento cadDep) {
		setLayout(new BorderLayout(0, 0));
		
		JLabel lblPreenchaOsCampos = new JLabel("Preencha os campos abaixo para cadastrar um novo departamento");
		lblPreenchaOsCampos.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblPreenchaOsCampos.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblPreenchaOsCampos, BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNomeDoDepatamento = new JLabel("Nome do Depatamento");
		lblNomeDoDepatamento.setBounds(95, 30, 150, 15);
		panel.add(lblNomeDoDepatamento);
		
		JLabel lblSiglaDoDepartamento = new JLabel("Sigla do Departamento");
		lblSiglaDoDepartamento.setBounds(95, 80, 150, 15);
		panel.add(lblSiglaDoDepartamento);
		
		JLabel lblCdigoDoDepartamento = new JLabel("Código do Departamento");
		lblCdigoDoDepartamento.setBounds(95, 130, 150, 15);
		panel.add(lblCdigoDoDepartamento);
		
		txtNome = new JTextField();
		txtNome.setBounds(265, 30, 100, 20);
		panel.add(txtNome);
		txtNome.setColumns(10);
		
		txtSigla = new JTextField();
		txtSigla.setBounds(265, 80, 100, 20);
		panel.add(txtSigla);
		txtSigla.setColumns(10);
		
		txtCdigo = new JTextField();
		txtCdigo.setBounds(265, 130, 100, 20);
		panel.add(txtCdigo);
		txtCdigo.setColumns(10);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cadDep.getFrame().getContentPane().add(new TelaInicial(cadDep), BorderLayout.CENTER);
				remove(panel);
				cadDep.getFrame().setVisible(true);
			}
		});
		btnVoltar.setBounds(105, 200, 90, 25);
		panel.add(btnVoltar);
		
		JButton btnConcluir = new JButton("Concluir");
		btnConcluir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Departamento dpmt = new Departamento();
				
				if (!txtCdigo.getText().equals("") || !txtNome.getText().equals("") || !txtSigla.getText().equals("")) {
					dpmt.setCodigo(Integer.parseInt(txtCdigo.getText()));
					dpmt.setNome(txtNome.getText());
					dpmt.setSigla(txtSigla.getText());
				} else {
					JOptionPane.showMessageDialog(panel, "Preencha todos os campos!", "Waring", JOptionPane.INFORMATION_MESSAGE);
				}
				
				
				
				DepartamentoDAO.adicionar(dpmt);
			}
		});
		btnConcluir.setBounds(250, 200, 90, 25);
		panel.add(btnConcluir);
		
	}

}
