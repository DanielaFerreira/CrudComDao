import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JPanel;

public class TelaInicial extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private TelaNovoDepartamento telaNovoDep;
	private TelaAlterarDepartamento telaAlterarDep;
	private TelaExcluirDepartamento telaExcluirDep;
	private TelaConsultarDepartamento telaConsultarDep;

	/**
	 * Create the panel.
	 */
	public TelaInicial(CadastroDepartamento cadDep) {
		setLayout(new BorderLayout(0, 0));
		
		telaNovoDep = new TelaNovoDepartamento(cadDep);
		telaAlterarDep = new  TelaAlterarDepartamento(cadDep);
		telaExcluirDep = new TelaExcluirDepartamento(cadDep);
		telaConsultarDep = new TelaConsultarDepartamento(cadDep);
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JButton btnNovoDepartamento = new JButton("Novo Departamento");
		btnNovoDepartamento.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				add(telaNovoDep, BorderLayout.CENTER);
				remove(panel);
				cadDep.getFrame().setVisible(true);
			}
		});
		btnNovoDepartamento.setBounds(110, 90, 180, 25);
		panel.add(btnNovoDepartamento);

		JButton btnExcluirDepartamento = new JButton("Excluir Departamento");
		btnExcluirDepartamento.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				add(telaExcluirDep, BorderLayout.CENTER);
				remove(panel);
				cadDep.getFrame().setVisible(true);
			}
		});
		btnExcluirDepartamento.setBounds(110, 120, 180, 25);
		panel.add(btnExcluirDepartamento);

		JButton btnAlterarDepartamento = new JButton("Alterar Departamento");
		btnAlterarDepartamento.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				add(telaAlterarDep, BorderLayout.CENTER);
				remove(panel);
				cadDep.getFrame().setVisible(true);
			}
		});
		btnAlterarDepartamento.setBounds(110, 150, 180, 25);
		panel.add(btnAlterarDepartamento);

		JButton btnConsultarDepartamento = new JButton("Consultar Departamento");
		btnConsultarDepartamento.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				add(telaConsultarDep, BorderLayout.CENTER);
				remove(panel);
				cadDep.getFrame().setVisible(true);
			}
		});
		btnConsultarDepartamento.setBounds(110, 180, 180, 25);
		panel.add(btnConsultarDepartamento);
	}

}
