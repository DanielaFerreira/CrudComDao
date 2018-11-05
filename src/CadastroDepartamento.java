import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;

public class CadastroDepartamento {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroDepartamento window = new CadastroDepartamento();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CadastroDepartamento() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 420, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		TelaInicial telaInicial = new TelaInicial(this);
		frame.getContentPane().add(telaInicial, BorderLayout.CENTER);
	}
	
	public JFrame getFrame() {
		return frame;
	}
	
}
