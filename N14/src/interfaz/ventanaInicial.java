package interfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Dimension;

import javax.swing.border.TitledBorder;

import java.awt.GridBagLayout;

import javax.swing.JLabel;

import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;







import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Component;

import javax.swing.SwingConstants;

import java.awt.Point;

import javax.swing.JPasswordField;

import mundo.Aplicacion;
import mundo.Restaurante;


public class ventanaInicial extends JFrame {

	private JPanel panelPrincipal;
	private JLabel lblUsername;
	private JLabel lblPassword;
	private JTextField textFieldUsername;
	private JTextField textFieldPassword;
	private JButton btnLogin;
	private JPanel panelRegistrarse;
	private JButton btnRegistro;
	private JPanel panelAdministrador;
	private JLabel lblPassword_1;
	private JButton btnLoginAdmin;
	private JPasswordField textFieldAdmin;
	private Aplicacion aplicacion;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ventanaInicial frame = new ventanaInicial();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ventanaInicial() {
		aplicacion = new Aplicacion();
		setTitle("RestauApp");
		setResizable(false);
		setSize(new Dimension(300, 300));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panelPrincipal = new JPanel();
		panelPrincipal.setSize(new Dimension(300, 150));
		panelPrincipal.setOpaque(false);
		panelPrincipal.setName("panelPrincipal");
		panelPrincipal.setBorder(new EmptyBorder(5, 5, 5, 5));
		panelPrincipal.setLayout(new BorderLayout(0, 0));
		setContentPane(panelPrincipal);
		
		JPanel panelUsuariosRegistrados = new JPanel();
		panelUsuariosRegistrados.setSize(new Dimension(300, 300));
		panelUsuariosRegistrados.setBorder(new TitledBorder(null, "Usuarios Registrados", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelPrincipal.add(panelUsuariosRegistrados, BorderLayout.NORTH);
		GridBagLayout gbl_panelUsuariosRegistrados = new GridBagLayout();
		gbl_panelUsuariosRegistrados.columnWidths = new int[]{0, 0, 0};
		gbl_panelUsuariosRegistrados.rowHeights = new int[]{37, 34, 40, 0};
		gbl_panelUsuariosRegistrados.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panelUsuariosRegistrados.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		panelUsuariosRegistrados.setLayout(gbl_panelUsuariosRegistrados);
		
		lblUsername = new JLabel("Username:");
		GridBagConstraints gbc_lblUsername = new GridBagConstraints();
		gbc_lblUsername.anchor = GridBagConstraints.EAST;
		gbc_lblUsername.insets = new Insets(0, 0, 5, 5);
		gbc_lblUsername.gridx = 0;
		gbc_lblUsername.gridy = 0;
		panelUsuariosRegistrados.add(lblUsername, gbc_lblUsername);
		
		textFieldUsername = new JTextField();
		GridBagConstraints gbc_textFieldUsername = new GridBagConstraints();
		gbc_textFieldUsername.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldUsername.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldUsername.gridx = 1;
		gbc_textFieldUsername.gridy = 0;
		panelUsuariosRegistrados.add(textFieldUsername, gbc_textFieldUsername);
		textFieldUsername.setColumns(10);
		
		lblPassword = new JLabel("Password:");
		GridBagConstraints gbc_lblPassword = new GridBagConstraints();
		gbc_lblPassword.anchor = GridBagConstraints.EAST;
		gbc_lblPassword.insets = new Insets(0, 0, 5, 5);
		gbc_lblPassword.gridx = 0;
		gbc_lblPassword.gridy = 1;
		panelUsuariosRegistrados.add(lblPassword, gbc_lblPassword);
		
		textFieldPassword = new JTextField();
		GridBagConstraints gbc_textFieldPassword = new GridBagConstraints();
		gbc_textFieldPassword.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldPassword.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldPassword.gridx = 1;
		gbc_textFieldPassword.gridy = 1;
		panelUsuariosRegistrados.add(textFieldPassword, gbc_textFieldPassword);
		textFieldPassword.setColumns(10);
		
		btnLogin = new JButton("Login!");
		btnLogin.setAlignmentX(Component.CENTER_ALIGNMENT);
		GridBagConstraints gbc_btnLogin = new GridBagConstraints();
		gbc_btnLogin.anchor = GridBagConstraints.WEST;
		gbc_btnLogin.gridx = 1;
		gbc_btnLogin.gridy = 2;
		panelUsuariosRegistrados.add(btnLogin, gbc_btnLogin);
		
		panelRegistrarse = new JPanel();
		panelRegistrarse.setBorder(new TitledBorder(null, "Registro", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelPrincipal.add(panelRegistrarse, BorderLayout.WEST);
		GridBagLayout gbl_panelRegistrarse = new GridBagLayout();
		gbl_panelRegistrarse.columnWidths = new int[]{120, 0};
		gbl_panelRegistrarse.rowHeights = new int[]{35, 0, 0};
		gbl_panelRegistrarse.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_panelRegistrarse.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		panelRegistrarse.setLayout(gbl_panelRegistrarse);
		
		btnRegistro = new JButton("Registrarse");
		GridBagConstraints gbc_btnRegistro = new GridBagConstraints();
		gbc_btnRegistro.gridx = 0;
		gbc_btnRegistro.gridy = 1;
		panelRegistrarse.add(btnRegistro, gbc_btnRegistro);
		
		panelAdministrador = new JPanel();
		panelAdministrador.setBorder(new TitledBorder(null, "Administrador", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelPrincipal.add(panelAdministrador, BorderLayout.EAST);
		GridBagLayout gbl_panelAdministrador = new GridBagLayout();
		gbl_panelAdministrador.columnWidths = new int[]{131, 0};
		gbl_panelAdministrador.rowHeights = new int[]{33, 32, 0, 0};
		gbl_panelAdministrador.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panelAdministrador.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		panelAdministrador.setLayout(gbl_panelAdministrador);
		
		lblPassword_1 = new JLabel("Password");
		GridBagConstraints gbc_lblPassword_1 = new GridBagConstraints();
		gbc_lblPassword_1.insets = new Insets(0, 0, 5, 0);
		gbc_lblPassword_1.gridx = 0;
		gbc_lblPassword_1.gridy = 0;
		panelAdministrador.add(lblPassword_1, gbc_lblPassword_1);
		
		textFieldAdmin = new JPasswordField();
		GridBagConstraints gbc_textFieldAdmin = new GridBagConstraints();
		gbc_textFieldAdmin.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldAdmin.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldAdmin.gridx = 0;
		gbc_textFieldAdmin.gridy = 1;
		panelAdministrador.add(textFieldAdmin, gbc_textFieldAdmin);
		textFieldAdmin.setColumns(10);
		
		btnLoginAdmin = new JButton("Login!");
		btnLoginAdmin.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				mostrarInterfazAdministrador();
			}
		});
		GridBagConstraints gbc_btnLoginAdmin = new GridBagConstraints();
		gbc_btnLoginAdmin.gridx = 0;
		gbc_btnLoginAdmin.gridy = 2;
		panelAdministrador.add(btnLoginAdmin, gbc_btnLoginAdmin);
	}
	
	public void mostrarInterfazAdministrador ()
	{
		if (textFieldAdmin.getText().equals(aplicacion.CONTRASENA_ADMIN))
		{
			ventanaAdmin admin = new ventanaAdmin();
			admin.setPrincipal(this);
			admin.setVisible(true);
		}
		else
		{
			JOptionPane.showMessageDialog(this, "Contraseña incorrecta", "Informacion", JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	public Restaurante[] cargarXLS()
	{
		 return (aplicacion.cargarDatos());	
	}

}
