package interfaz;
import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.GridLayout;

import javax.swing.JLabel;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JPasswordField;

public class DialogoRegistroUsuario extends JDialog implements ActionListener  {




	private final JPanel contentPanel = new JPanel();

	private JLabel lblNombre;
	private JLabel lblApellido;
	private JLabel lblCedula;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtCedula;
	private JTextField txtCorreo;
	private JLabel lblUser;
	private JTextField txtUser;
	private JLabel lblPass;
	private JPasswordField passwordField;
	private JLabel lblNewLabel;
	private JPasswordField campoConfirmacion;
	private JButton okButton;
	private JButton cancelButton;

	private ventanaInicial principal;


	/**
	 * Create the dialog.
	 * @param interfazPpal 
	 */
	public DialogoRegistroUsuario(ventanaInicial interfazPpal) {

		principal = interfazPpal;
		setTitle("Registro Usuario");
		setModal(true);
		setBounds(100, 100, 317, 337);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[] {18, 67, 0, 0, 0, 127, 70};
		gbl_contentPanel.rowHeights = new int[] {30, 30, 30, 0, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 1.0};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
		contentPanel.setLayout(gbl_contentPanel);
		{
			lblNombre = new JLabel("Nombre");
			GridBagConstraints gbc_lblNombre = new GridBagConstraints();
			gbc_lblNombre.gridwidth = 2;
			gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
			gbc_lblNombre.gridx = 0;
			gbc_lblNombre.gridy = 0;
			contentPanel.add(lblNombre, gbc_lblNombre);
		}
		{
			txtNombre = new JTextField();
			GridBagConstraints gbc_txtNombre = new GridBagConstraints();
			gbc_txtNombre.gridwidth = 5;
			gbc_txtNombre.insets = new Insets(0, 0, 5, 5);
			gbc_txtNombre.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtNombre.gridx = 2;
			gbc_txtNombre.gridy = 0;
			contentPanel.add(txtNombre, gbc_txtNombre);
			txtNombre.setColumns(10);
		}
		{
			lblApellido = new JLabel("Apellido");
			GridBagConstraints gbc_lblApellido = new GridBagConstraints();
			gbc_lblApellido.gridwidth = 2;
			gbc_lblApellido.insets = new Insets(0, 0, 5, 5);
			gbc_lblApellido.gridx = 0;
			gbc_lblApellido.gridy = 1;
			contentPanel.add(lblApellido, gbc_lblApellido);
		}
		{
			txtApellido = new JTextField();
			txtApellido.setText("");
			GridBagConstraints gbc_txtApellido = new GridBagConstraints();
			gbc_txtApellido.gridwidth = 5;
			gbc_txtApellido.insets = new Insets(0, 0, 5, 5);
			gbc_txtApellido.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtApellido.gridx = 2;
			gbc_txtApellido.gridy = 1;
			contentPanel.add(txtApellido, gbc_txtApellido);
			txtApellido.setColumns(10);
		}
		{
			lblCedula = new JLabel("Cedula");
			GridBagConstraints gbc_lblCedula = new GridBagConstraints();
			gbc_lblCedula.gridwidth = 2;
			gbc_lblCedula.insets = new Insets(0, 0, 5, 5);
			gbc_lblCedula.gridx = 0;
			gbc_lblCedula.gridy = 2;
			contentPanel.add(lblCedula, gbc_lblCedula);
		}
		{
			txtCedula = new JTextField();
			GridBagConstraints gbc_txtCedula = new GridBagConstraints();
			gbc_txtCedula.gridwidth = 5;
			gbc_txtCedula.insets = new Insets(0, 0, 5, 5);
			gbc_txtCedula.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtCedula.gridx = 2;
			gbc_txtCedula.gridy = 2;
			contentPanel.add(txtCedula, gbc_txtCedula);
			txtCedula.setColumns(10);
		}
		{
			JLabel lblCorreo = new JLabel("Correo");
			GridBagConstraints gbc_lblCorreo = new GridBagConstraints();
			gbc_lblCorreo.gridwidth = 2;
			gbc_lblCorreo.insets = new Insets(0, 0, 5, 5);
			gbc_lblCorreo.gridx = 0;
			gbc_lblCorreo.gridy = 3;
			contentPanel.add(lblCorreo, gbc_lblCorreo);
		}
		{
			txtCorreo = new JTextField();
			GridBagConstraints gbc_txtCorreo = new GridBagConstraints();
			gbc_txtCorreo.gridwidth = 5;
			gbc_txtCorreo.insets = new Insets(0, 0, 5, 5);
			gbc_txtCorreo.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtCorreo.gridx = 2;
			gbc_txtCorreo.gridy = 3;
			contentPanel.add(txtCorreo, gbc_txtCorreo);
			txtCorreo.setColumns(10);
		}
		{
			lblUser = new JLabel("Username");
			GridBagConstraints gbc_lblUser = new GridBagConstraints();
			gbc_lblUser.gridwidth = 2;
			gbc_lblUser.insets = new Insets(0, 0, 5, 5);
			gbc_lblUser.gridx = 0;
			gbc_lblUser.gridy = 4;
			contentPanel.add(lblUser, gbc_lblUser);
		}
		{
			txtUser = new JTextField();
			GridBagConstraints gbc_txtUser = new GridBagConstraints();
			gbc_txtUser.gridwidth = 5;
			gbc_txtUser.insets = new Insets(0, 0, 5, 5);
			gbc_txtUser.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtUser.gridx = 2;
			gbc_txtUser.gridy = 4;
			contentPanel.add(txtUser, gbc_txtUser);
			txtUser.setColumns(10);
		}
		{
			lblPass = new JLabel("Password");
			GridBagConstraints gbc_lblPass = new GridBagConstraints();
			gbc_lblPass.gridwidth = 2;
			gbc_lblPass.insets = new Insets(0, 0, 5, 5);
			gbc_lblPass.gridx = 0;
			gbc_lblPass.gridy = 5;
			contentPanel.add(lblPass, gbc_lblPass);
		}
		{
			passwordField = new JPasswordField();
			GridBagConstraints gbc_passwordField = new GridBagConstraints();
			gbc_passwordField.gridwidth = 5;
			gbc_passwordField.insets = new Insets(0, 0, 5, 5);
			gbc_passwordField.fill = GridBagConstraints.HORIZONTAL;
			gbc_passwordField.gridx = 2;
			gbc_passwordField.gridy = 5;
			contentPanel.add(passwordField, gbc_passwordField);
		}
		{
			lblNewLabel = new JLabel("Confirmar Pass");
			GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
			gbc_lblNewLabel.gridwidth = 2;
			gbc_lblNewLabel.insets = new Insets(0, 0, 0, 5);
			gbc_lblNewLabel.gridx = 0;
			gbc_lblNewLabel.gridy = 6;
			contentPanel.add(lblNewLabel, gbc_lblNewLabel);
		}
		{
			campoConfirmacion = new JPasswordField();
			GridBagConstraints gbc_campoConfirmacion = new GridBagConstraints();
			gbc_campoConfirmacion.gridwidth = 5;
			gbc_campoConfirmacion.insets = new Insets(0, 0, 0, 5);
			gbc_campoConfirmacion.fill = GridBagConstraints.HORIZONTAL;
			gbc_campoConfirmacion.gridx = 2;
			gbc_campoConfirmacion.gridy = 6;
			contentPanel.add(campoConfirmacion, gbc_campoConfirmacion);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
				okButton.addActionListener(this);
			}
			{
				cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
				cancelButton.addActionListener(this);
			}
		}
	}


	@Override
	public void actionPerformed(ActionEvent e)
	{
		// TODO Auto-generated method stub
		String comando = e.getActionCommand();
		if(comando.equals(okButton.getActionCommand()))
		{
			if(txtNombre.getText().equals("")==false && txtApellido.getText().equals("")==false && txtCedula.getText().equals("")== false && txtCorreo.getText().equals("")==false && txtUser.getText().equals("")==false && passwordField.getText().equals("")==false &&campoConfirmacion.getText().equals("")==false )
			{
				if(passwordField.getText().equals(campoConfirmacion.getText()))
				{
					try {
						principal.darDirectorio().registrarUsuario(txtUser.getText(),passwordField.getText(), txtNombre.getText(), txtApellido.getText(), txtCedula.getText(), txtCorreo.getText());
						dispose();
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(this, e1.getMessage());
					}
				}
				else
				{
					JOptionPane.showMessageDialog(this, "Los password no coindiden.");
				}
			}
			else
			{
				JOptionPane.showMessageDialog(this, "Debe llenar todos los campos");
			}
		}
		else if(cancelButton.getActionCommand().equals(comando))
		{
			dispose();
		}

	}



}

