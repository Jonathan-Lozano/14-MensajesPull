package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

/**
 * 
 * @author Jonathan Lozano
 *
 */
public final class Conexion {

	private static final Conexion con = new Conexion();
	private Connection conect = null;

	/**
	 * Constructor privado de la clase
	 */
	private Conexion() {
		getConect();
	}

	/**
	 * Metodo privado que realiza la conexion
	 */
	private boolean conection() {
		String bd = "mensajesPull";
		String url = "jdbc:mysql://localhost/" + bd
				+ "?noAccessToProcedureBodies=true";
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conect = DriverManager.getConnection(url, "root", "secret");
			return true;
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Error con la base de datos. "
					+ ex.getLocalizedMessage(), " Error",
					JOptionPane.ERROR_MESSAGE);
			return false;
		} catch (InstantiationException ex) {
			JOptionPane.showMessageDialog(null,
					"No se puedo establecer la conexion", "Error",
					JOptionPane.ERROR_MESSAGE);
			return false;
		} catch (ClassNotFoundException ex) {
			JOptionPane.showMessageDialog(null, "No se econtro el Driver",
					"Error", JOptionPane.ERROR_MESSAGE);
			return false;
		} catch (IllegalAccessException ex) {
			JOptionPane.showMessageDialog(null, "Error de compatibilidad",
					"Error", JOptionPane.ERROR_MESSAGE);
			return false;
		}
	}

	/**
	 * Metodo que optiene la conexion
	 * 
	 * @return la variable que mantiene la conexion
	 */
	public Connection getConect() {
		if (conect == null) {
			conection();
		}
		return conect;
	}

	/**
	 * 
	 * @return Instancia de la clase
	 */
	public static Conexion getCon() {
		return con;
	}

}