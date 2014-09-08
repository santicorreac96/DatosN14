package interfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;

import java.awt.Dimension;
import java.awt.GridBagLayout;

import javax.swing.JComboBox;

import java.awt.GridBagConstraints;

import javax.swing.JTextField;
import javax.swing.JLabel;

import java.awt.Insets;
import java.awt.GridLayout;
import java.awt.Rectangle;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JInternalFrame;
import java.awt.Font;
import javax.swing.JDesktopPane;
import java.awt.Label;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import java.awt.Color;

public class ventanaUsuario extends JFrame {

	private JPanel panelPrincipal;
	private JTextField textFieldCriterio1;
	private JTextField textFieldCriterio2;
	private JTextField textFieldCriterio3;
	private JButton btnBuscar;
	private JPanel panelListas;
	private JScrollPane scrollPaneListaFavoritos;
	private JScrollPane scrollPaneListaBusquedas;
	private JLabel lblListaBusquedas;
	private JLabel lblListaFavoritos;
	private JPanel panelCentralGeneral;
	private JPanel panelBotonesFAV;
	private JButton btnNoFavorito;
	private JButton btnFavorito;
	private JPanel panelCentral;
	private JPanel panelTitulo;
	private JLabel lblRestauapp;
	private JPanel panelBotonesGraficas;
	private JButton btnGraficaTipos;
	private JButton btnGráficaCategorias;
	private JPanel panelInfo;
	private Label labelNombre;
	private Label labCNombre;
	private Label labelCiudad;
	private Label labCCiudad;
	private Label labelEstado;
	private Label labCEstado;
	private Label labDireccion;
	private Label labCDireccion;
	private Label labCocina;
	private Label labCCocina;
	private Label labCategoria;
	private Label label_11;
	private Label labTelefono;
	private Label labCTelefono;
	private Label labHorario;
	private Label labCHorario;
	private ventanaInicial principal;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ventanaUsuario frame = new ventanaUsuario();
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
	public ventanaUsuario() {
		setSize(new Dimension(1000, 700));
		setResizable(false);
		setTitle("RESTAU-Usuario");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panelPrincipal = new JPanel();
		panelPrincipal.setBorder(new EmptyBorder(5, 5, 5, 5));
		panelPrincipal.setLayout(new BorderLayout(0, 0));
		setContentPane(panelPrincipal);
		
		JPanel panelBusquedas = new JPanel();
		panelBusquedas.setBorder(new TitledBorder(null, "Busquedas", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelBusquedas.setBounds(new Rectangle(5, 5, 5, 5));
		panelPrincipal.add(panelBusquedas, BorderLayout.SOUTH);
		GridBagLayout gbl_panelBusquedas = new GridBagLayout();
		gbl_panelBusquedas.columnWidths = new int[]{249, 264, 178, 193, 0};
		gbl_panelBusquedas.rowHeights = new int[]{0, 53, 0};
		gbl_panelBusquedas.columnWeights = new double[]{0.0, 1.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_panelBusquedas.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		panelBusquedas.setLayout(gbl_panelBusquedas);
		
		JComboBox comboBoxCriterio1 = new JComboBox();
		GridBagConstraints gbc_comboBoxCriterio1 = new GridBagConstraints();
		gbc_comboBoxCriterio1.anchor = GridBagConstraints.NORTH;
		gbc_comboBoxCriterio1.insets = new Insets(0, 0, 5, 5);
		gbc_comboBoxCriterio1.gridx = 0;
		gbc_comboBoxCriterio1.gridy = 0;
		panelBusquedas.add(comboBoxCriterio1, gbc_comboBoxCriterio1);
		
		JComboBox comboBoxCriterio2 = new JComboBox();
		GridBagConstraints gbc_comboBoxCriterio2 = new GridBagConstraints();
		gbc_comboBoxCriterio2.insets = new Insets(0, 0, 5, 5);
		gbc_comboBoxCriterio2.anchor = GridBagConstraints.NORTH;
		gbc_comboBoxCriterio2.gridx = 1;
		gbc_comboBoxCriterio2.gridy = 0;
		panelBusquedas.add(comboBoxCriterio2, gbc_comboBoxCriterio2);
		
		JComboBox comboBoxCriterio3 = new JComboBox();
		GridBagConstraints gbc_comboBoxCriterio3 = new GridBagConstraints();
		gbc_comboBoxCriterio3.insets = new Insets(0, 0, 5, 5);
		gbc_comboBoxCriterio3.anchor = GridBagConstraints.NORTH;
		gbc_comboBoxCriterio3.gridx = 2;
		gbc_comboBoxCriterio3.gridy = 0;
		panelBusquedas.add(comboBoxCriterio3, gbc_comboBoxCriterio3);
		
		textFieldCriterio1 = new JTextField();
		textFieldCriterio1.setMinimumSize(new Dimension(100, 20));
		GridBagConstraints gbc_textFieldCriterio1 = new GridBagConstraints();
		gbc_textFieldCriterio1.insets = new Insets(0, 0, 0, 5);
		gbc_textFieldCriterio1.gridx = 0;
		gbc_textFieldCriterio1.gridy = 1;
		panelBusquedas.add(textFieldCriterio1, gbc_textFieldCriterio1);
		textFieldCriterio1.setColumns(10);
		
		textFieldCriterio2 = new JTextField();
		textFieldCriterio2.setMinimumSize(new Dimension(100, 20));
		GridBagConstraints gbc_textFieldCriterio2 = new GridBagConstraints();
		gbc_textFieldCriterio2.insets = new Insets(0, 0, 0, 5);
		gbc_textFieldCriterio2.gridx = 1;
		gbc_textFieldCriterio2.gridy = 1;
		panelBusquedas.add(textFieldCriterio2, gbc_textFieldCriterio2);
		textFieldCriterio2.setColumns(10);
		
		textFieldCriterio3 = new JTextField();
		textFieldCriterio3.setMinimumSize(new Dimension(100, 20));
		GridBagConstraints gbc_textFieldCriterio3 = new GridBagConstraints();
		gbc_textFieldCriterio3.insets = new Insets(0, 0, 0, 5);
		gbc_textFieldCriterio3.gridx = 2;
		gbc_textFieldCriterio3.gridy = 1;
		panelBusquedas.add(textFieldCriterio3, gbc_textFieldCriterio3);
		textFieldCriterio3.setColumns(10);
		
		btnBuscar = new JButton("Buscar!");
		GridBagConstraints gbc_btnBuscar = new GridBagConstraints();
		gbc_btnBuscar.gridx = 3;
		gbc_btnBuscar.gridy = 1;
		panelBusquedas.add(btnBuscar, gbc_btnBuscar);
		
		panelListas = new JPanel();
		panelListas.setBorder(new TitledBorder(null, "Listas ", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelListas.setPreferredSize(new Dimension(200, 700));
		panelListas.setMinimumSize(new Dimension(200, 700));
		panelListas.setSize(new Dimension(200, 700));
		panelPrincipal.add(panelListas, BorderLayout.EAST);
		GridBagLayout gbl_panelListas = new GridBagLayout();
		gbl_panelListas.columnWidths = new int[]{200, 0};
		gbl_panelListas.rowHeights = new int[]{35, 251, 37, 309, 0};
		gbl_panelListas.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panelListas.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		panelListas.setLayout(gbl_panelListas);
		
		lblListaFavoritos = new JLabel("Lista Favoritos");
		GridBagConstraints gbc_lblListaFavoritos = new GridBagConstraints();
		gbc_lblListaFavoritos.insets = new Insets(0, 0, 5, 0);
		gbc_lblListaFavoritos.gridx = 0;
		gbc_lblListaFavoritos.gridy = 0;
		panelListas.add(lblListaFavoritos, gbc_lblListaFavoritos);
		
		scrollPaneListaFavoritos = new JScrollPane();
		scrollPaneListaFavoritos.setPreferredSize(new Dimension(150, 275));
		scrollPaneListaFavoritos.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPaneListaFavoritos.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		GridBagConstraints gbc_scrollPaneListaFavoritos = new GridBagConstraints();
		gbc_scrollPaneListaFavoritos.fill = GridBagConstraints.BOTH;
		gbc_scrollPaneListaFavoritos.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPaneListaFavoritos.gridx = 0;
		gbc_scrollPaneListaFavoritos.gridy = 1;
		panelListas.add(scrollPaneListaFavoritos, gbc_scrollPaneListaFavoritos);
		
		lblListaBusquedas = new JLabel("Lista Busquedas");
		GridBagConstraints gbc_lblListaBusquedas = new GridBagConstraints();
		gbc_lblListaBusquedas.insets = new Insets(0, 0, 5, 0);
		gbc_lblListaBusquedas.gridx = 0;
		gbc_lblListaBusquedas.gridy = 2;
		panelListas.add(lblListaBusquedas, gbc_lblListaBusquedas);
		
		scrollPaneListaBusquedas = new JScrollPane();
		GridBagConstraints gbc_scrollPaneListaBusquedas = new GridBagConstraints();
		scrollPaneListaBusquedas.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPaneListaBusquedas.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		gbc_scrollPaneListaBusquedas.fill = GridBagConstraints.BOTH;
		gbc_scrollPaneListaBusquedas.gridx = 0;
		gbc_scrollPaneListaBusquedas.gridy = 3;
		panelListas.add(scrollPaneListaBusquedas, gbc_scrollPaneListaBusquedas);		
		
		panelCentralGeneral = new JPanel();
		panelPrincipal.add(panelCentralGeneral, BorderLayout.CENTER);
		panelCentralGeneral.setLayout(new BorderLayout(0, 0));
		
		panelBotonesFAV = new JPanel();
		panelCentralGeneral.add(panelBotonesFAV, BorderLayout.EAST);
		GridBagLayout gbl_panelBotonesFAV = new GridBagLayout();
		gbl_panelBotonesFAV.columnWidths = new int[]{89, 0};
		gbl_panelBotonesFAV.rowHeights = new int[]{333, 250, 0};
		gbl_panelBotonesFAV.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_panelBotonesFAV.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		panelBotonesFAV.setLayout(gbl_panelBotonesFAV);
		
		btnNoFavorito = new JButton("UNFAV");
		btnNoFavorito.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		GridBagConstraints gbc_btnNoFavorito = new GridBagConstraints();
		gbc_btnNoFavorito.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnNoFavorito.insets = new Insets(0, 0, 5, 0);
		gbc_btnNoFavorito.gridx = 0;
		gbc_btnNoFavorito.gridy = 0;
		panelBotonesFAV.add(btnNoFavorito, gbc_btnNoFavorito);
		
		btnFavorito = new JButton("FAV");
		GridBagConstraints gbc_btnFavorito = new GridBagConstraints();
		gbc_btnFavorito.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnFavorito.gridx = 0;
		gbc_btnFavorito.gridy = 1;
		panelBotonesFAV.add(btnFavorito, gbc_btnFavorito);
		
		panelCentral = new JPanel();
		panelCentralGeneral.add(panelCentral, BorderLayout.CENTER);
		panelCentral.setLayout(new BorderLayout(0, 0));
		
		panelTitulo = new JPanel();
		panelTitulo.setPreferredSize(new Dimension(80, 100));
		panelCentral.add(panelTitulo, BorderLayout.NORTH);
		GridBagLayout gbl_panelTitulo = new GridBagLayout();
		gbl_panelTitulo.columnWidths = new int[]{695, 0};
		gbl_panelTitulo.rowHeights = new int[]{100, 0};
		gbl_panelTitulo.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_panelTitulo.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panelTitulo.setLayout(gbl_panelTitulo);
		
		lblRestauapp = new JLabel("RestauApp!");
		lblRestauapp.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_lblRestauapp = new GridBagConstraints();
		gbc_lblRestauapp.gridx = 0;
		gbc_lblRestauapp.gridy = 0;
		panelTitulo.add(lblRestauapp, gbc_lblRestauapp);
		
		panelBotonesGraficas = new JPanel();
		panelBotonesGraficas.setBorder(new TitledBorder(null, "Gr\u00E1ficas", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelCentral.add(panelBotonesGraficas, BorderLayout.WEST);
		GridBagLayout gbl_panelBotonesGraficas = new GridBagLayout();
		gbl_panelBotonesGraficas.columnWidths = new int[]{89, 0};
		gbl_panelBotonesGraficas.rowHeights = new int[]{211, 257, 0};
		gbl_panelBotonesGraficas.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_panelBotonesGraficas.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		panelBotonesGraficas.setLayout(gbl_panelBotonesGraficas);
		
		btnGráficaCategorias = new JButton("Gr\u00E1fica categor\u00EDas");
		GridBagConstraints gbc_btnGráficaCategorias = new GridBagConstraints();
		gbc_btnGráficaCategorias.insets = new Insets(0, 0, 5, 0);
		gbc_btnGráficaCategorias.gridx = 0;
		gbc_btnGráficaCategorias.gridy = 0;
		panelBotonesGraficas.add(btnGráficaCategorias, gbc_btnGráficaCategorias);
		
		btnGraficaTipos = new JButton("Gr\u00E1fica tipos");
		GridBagConstraints gbc_btnGraficaTipos = new GridBagConstraints();
		gbc_btnGraficaTipos.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnGraficaTipos.gridx = 0;
		gbc_btnGraficaTipos.gridy = 1;
		panelBotonesGraficas.add(btnGraficaTipos, gbc_btnGraficaTipos);
		
		panelInfo = new JPanel();
		panelInfo.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Info Restaurante", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelCentral.add(panelInfo, BorderLayout.CENTER);
		GridBagLayout gbl_panelInfo = new GridBagLayout();
		gbl_panelInfo.columnWidths = new int[]{0, 131, 133, 0, 124, 127, 0};
		gbl_panelInfo.rowHeights = new int[]{130, 125, 113, 117, 0};
		gbl_panelInfo.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panelInfo.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panelInfo.setLayout(gbl_panelInfo);
		
		labelNombre = new Label("Nombre:");
		GridBagConstraints gbc_labelNombre = new GridBagConstraints();
		gbc_labelNombre.anchor = GridBagConstraints.EAST;
		gbc_labelNombre.insets = new Insets(0, 0, 5, 5);
		gbc_labelNombre.gridx = 1;
		gbc_labelNombre.gridy = 0;
		panelInfo.add(labelNombre, gbc_labelNombre);
		
		labCNombre = new Label("");
		GridBagConstraints gbc_labCNombre = new GridBagConstraints();
		gbc_labCNombre.anchor = GridBagConstraints.WEST;
		gbc_labCNombre.insets = new Insets(0, 0, 5, 5);
		gbc_labCNombre.gridx = 2;
		gbc_labCNombre.gridy = 0;
		panelInfo.add(labCNombre, gbc_labCNombre);
		
		labCocina = new Label("Cocina:");
		GridBagConstraints gbc_labCocina = new GridBagConstraints();
		gbc_labCocina.anchor = GridBagConstraints.EAST;
		gbc_labCocina.insets = new Insets(0, 0, 5, 5);
		gbc_labCocina.gridx = 4;
		gbc_labCocina.gridy = 0;
		panelInfo.add(labCocina, gbc_labCocina);
		
		labCCocina = new Label("");
		GridBagConstraints gbc_labCCocina = new GridBagConstraints();
		gbc_labCCocina.anchor = GridBagConstraints.WEST;
		gbc_labCCocina.insets = new Insets(0, 0, 5, 0);
		gbc_labCCocina.gridx = 5;
		gbc_labCCocina.gridy = 0;
		panelInfo.add(labCCocina, gbc_labCCocina);
		
		labelCiudad = new Label("Ciudad:");
		GridBagConstraints gbc_labelCiudad = new GridBagConstraints();
		gbc_labelCiudad.anchor = GridBagConstraints.EAST;
		gbc_labelCiudad.insets = new Insets(0, 0, 5, 5);
		gbc_labelCiudad.gridx = 1;
		gbc_labelCiudad.gridy = 1;
		panelInfo.add(labelCiudad, gbc_labelCiudad);
		
		labCCiudad = new Label("");
		GridBagConstraints gbc_labCCiudad = new GridBagConstraints();
		gbc_labCCiudad.anchor = GridBagConstraints.WEST;
		gbc_labCCiudad.insets = new Insets(0, 0, 5, 5);
		gbc_labCCiudad.gridx = 2;
		gbc_labCCiudad.gridy = 1;
		panelInfo.add(labCCiudad, gbc_labCCiudad);
		
		labCategoria = new Label("Categor\u00EDa:");
		GridBagConstraints gbc_labCategoria = new GridBagConstraints();
		gbc_labCategoria.anchor = GridBagConstraints.EAST;
		gbc_labCategoria.insets = new Insets(0, 0, 5, 5);
		gbc_labCategoria.gridx = 4;
		gbc_labCategoria.gridy = 1;
		panelInfo.add(labCategoria, gbc_labCategoria);
		
		label_11 = new Label("");
		GridBagConstraints gbc_label_11 = new GridBagConstraints();
		gbc_label_11.anchor = GridBagConstraints.WEST;
		gbc_label_11.insets = new Insets(0, 0, 5, 0);
		gbc_label_11.gridx = 5;
		gbc_label_11.gridy = 1;
		panelInfo.add(label_11, gbc_label_11);
		
		labelEstado = new Label("Estado:");
		GridBagConstraints gbc_labelEstado = new GridBagConstraints();
		gbc_labelEstado.anchor = GridBagConstraints.EAST;
		gbc_labelEstado.insets = new Insets(0, 0, 5, 5);
		gbc_labelEstado.gridx = 1;
		gbc_labelEstado.gridy = 2;
		panelInfo.add(labelEstado, gbc_labelEstado);
		
		labCEstado = new Label("");
		GridBagConstraints gbc_labCEstado = new GridBagConstraints();
		gbc_labCEstado.anchor = GridBagConstraints.WEST;
		gbc_labCEstado.insets = new Insets(0, 0, 5, 5);
		gbc_labCEstado.gridx = 2;
		gbc_labCEstado.gridy = 2;
		panelInfo.add(labCEstado, gbc_labCEstado);
		
		labTelefono = new Label("Tel\u00E9fono:");
		GridBagConstraints gbc_labTelefono = new GridBagConstraints();
		gbc_labTelefono.anchor = GridBagConstraints.EAST;
		gbc_labTelefono.insets = new Insets(0, 0, 5, 5);
		gbc_labTelefono.gridx = 4;
		gbc_labTelefono.gridy = 2;
		panelInfo.add(labTelefono, gbc_labTelefono);
		
		labCTelefono = new Label("");
		GridBagConstraints gbc_labCTelefono = new GridBagConstraints();
		gbc_labCTelefono.anchor = GridBagConstraints.WEST;
		gbc_labCTelefono.insets = new Insets(0, 0, 5, 0);
		gbc_labCTelefono.gridx = 5;
		gbc_labCTelefono.gridy = 2;
		panelInfo.add(labCTelefono, gbc_labCTelefono);
		
		labDireccion = new Label("Direcci\u00F3n:");
		GridBagConstraints gbc_labDireccion = new GridBagConstraints();
		gbc_labDireccion.anchor = GridBagConstraints.EAST;
		gbc_labDireccion.insets = new Insets(0, 0, 0, 5);
		gbc_labDireccion.gridx = 1;
		gbc_labDireccion.gridy = 3;
		panelInfo.add(labDireccion, gbc_labDireccion);
		
		labCDireccion = new Label("");
		GridBagConstraints gbc_labCDireccion = new GridBagConstraints();
		gbc_labCDireccion.anchor = GridBagConstraints.WEST;
		gbc_labCDireccion.insets = new Insets(0, 0, 0, 5);
		gbc_labCDireccion.gridx = 2;
		gbc_labCDireccion.gridy = 3;
		panelInfo.add(labCDireccion, gbc_labCDireccion);
		
		labHorario = new Label("Horario:");
		GridBagConstraints gbc_labHorario = new GridBagConstraints();
		gbc_labHorario.anchor = GridBagConstraints.EAST;
		gbc_labHorario.insets = new Insets(0, 0, 0, 5);
		gbc_labHorario.gridx = 4;
		gbc_labHorario.gridy = 3;
		panelInfo.add(labHorario, gbc_labHorario);
		
		labCHorario = new Label("");
		GridBagConstraints gbc_labCHorario = new GridBagConstraints();
		gbc_labCHorario.anchor = GridBagConstraints.WEST;
		gbc_labCHorario.gridx = 5;
		gbc_labCHorario.gridy = 3;
		panelInfo.add(labCHorario, gbc_labCHorario);
		
	}

	public void setPrincipal(ventanaInicial pPrincipal) 
	{
		principal = pPrincipal;
		principal.setVisible(false);	
	}

}
