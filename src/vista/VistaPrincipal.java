package vista;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import modelo.MensajesPull;

public final class VistaPrincipal extends JFrame implements ActionListener {

	private static final VistaPrincipal vp = new VistaPrincipal();

	private MensajesPull mp = new MensajesPull();

	private Container content = getContentPane();
	private JLabel lblImage = new JLabel(new ImageIcon(getClass().getResource(
			"/image/mensajesPull.png")));
	private JLabel lblNombre = new JLabel();
	private JTextField txtNombre = new JTextField();
	private JButton btnEntrar = new JButton("Entrar");

	/**
	 * Constructor privado de la clase
	 */
	private VistaPrincipal() {
		super("Entrar");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(353, 285);
		setLocationRelativeTo(null);
		setResizable(false);
		getContentPane().setLayout(null);

		cargarControles();
	}

	/**
	 * Metodo que hace visible a la ventana
	 */
	public void showView(boolean visibility) {
		setVisible(visibility);
	}

	/**
	 * Metodo que agrega los controles necesarios a la ventana
	 */
	public void cargarControles() {
		content.setLayout(null);
		content.setBackground(Color.white);

		lblImage.setBounds(100, 0, 150, 150);
		content.add(lblImage);

		lblNombre.setBounds(10, 140, 200, 30);
		lblNombre.setText("Nombre de usuario");
		content.add(lblNombre);

		txtNombre.setBounds(10, 170, 200, 30);
		content.add(txtNombre);

		btnEntrar.setBounds(110, 210, 100, 30);
		btnEntrar.setBackground(Color.getHSBColor((float) 85, (float) 172,
				(float) 238));
		btnEntrar.addActionListener(this);
		content.add(btnEntrar);

	}

	/**
	 * Metodo que devuelve la instancia de la clase
	 */
	public static VistaPrincipal getVp() {
		return vp;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		mp.login(txtNombre.getText());
	}
}
