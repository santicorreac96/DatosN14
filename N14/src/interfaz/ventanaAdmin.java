package interfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

import javax.swing.BoxLayout;

import java.awt.Dimension;
import java.awt.Insets;

import javax.swing.border.LineBorder;

import java.awt.Color;

import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import javax.swing.JScrollPane;

import mundo.Restaurante;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class ventanaAdmin extends JFrame {

	private JPanel panelPrincipal;
	
	private ventanaInicial principal;

	private JList listaRestaurantes;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ventanaAdmin frame = new ventanaAdmin();
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
	public ventanaAdmin() {
		setSize(new Dimension(500, 500));
		setResizable(false);
		setTitle("RESTAU-Administrador");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panelPrincipal = new JPanel();
		panelPrincipal.setBorder(new EmptyBorder(5, 5, 5, 5));
		panelPrincipal.setLayout(new BorderLayout(0, 0));
		setContentPane(panelPrincipal);
		
		JPanel administrarDatos = new JPanel();
		administrarDatos.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Editar Informaci\u00F3n", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelPrincipal.add(administrarDatos, BorderLayout.WEST);
		GridBagLayout gbl_administrarDatos = new GridBagLayout();
		gbl_administrarDatos.columnWidths = new int[]{127, 0};
		gbl_administrarDatos.rowHeights = new int[]{219, 239, 0};
		gbl_administrarDatos.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_administrarDatos.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		administrarDatos.setLayout(gbl_administrarDatos);
		
		JButton btnCargarDatos = new JButton("Cargar datos");
		btnCargarDatos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				refrescarLista(principal.cargarXLS());
			}
		});
		GridBagConstraints gbc_btnCargarDatos = new GridBagConstraints();
		gbc_btnCargarDatos.insets = new Insets(0, 0, 5, 0);
		gbc_btnCargarDatos.gridx = 0;
		gbc_btnCargarDatos.gridy = 0;
		administrarDatos.add(btnCargarDatos, gbc_btnCargarDatos);
		
		JButton btnEliminar = new JButton("Eliminar");
		GridBagConstraints gbc_btnEliminar = new GridBagConstraints();
		gbc_btnEliminar.gridx = 0;
		gbc_btnEliminar.gridy = 1;
		administrarDatos.add(btnEliminar, gbc_btnEliminar);
		
		JPanel panelRestaurantes = new JPanel();
		panelRestaurantes.setBorder(new TitledBorder(null, "Lista Restaurantes", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelRestaurantes.setSize(new Dimension(200, 700));
		panelPrincipal.add(panelRestaurantes, BorderLayout.CENTER);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(326, 25, -302, 415);
		panelRestaurantes.add(scrollPane);
		
		listaRestaurantes = new JList();
		listaRestaurantes.setVisibleRowCount(25);
		scrollPane.setViewportView(listaRestaurantes);
	}
	
	public void setPrincipal (ventanaInicial pPrincipal)
	{
		principal = pPrincipal;
		principal.setVisible(false);
	}
	
	public void refrescarLista (Restaurante[] restaurantes)
	{
		if (restaurantes != null)
		{
			listaRestaurantes.removeAll();
			listaRestaurantes.setListData(restaurantes);
			listaRestaurantes.setSelectedIndex(-1);
			listaRestaurantes.updateUI();
		}
		else
		{
			JOptionPane.showMessageDialog(this, "No hay peliculas para su seleccion", "Informacion", JOptionPane.INFORMATION_MESSAGE);
		}
	}
}

