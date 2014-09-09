package interfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javafx.embed.swing.JFXPanel;
import javafx.stage.Stage;

import javax.swing.ButtonGroup;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;
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
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import mundo.ConsultorRestaurantes;
import mundo.Mapa;
import mundo.Restaurante;
import mundo.creadorGraficoBarras;
import mundo.creadorGraficoPie;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JList;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;

public class ventanaUsuario extends JFrame implements ListSelectionListener, ActionListener
{

	private JPanel panelPrincipal;
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
	private Label labelCiudad;
	private Label labelEstado;
	private Label labDireccion;
	private Label labCocina;
	private Label labCategoria;
	private Label labTelefono;
	private Label labHorario;
	private ventanaInicial principal;
	private ConsultorRestaurantes consultorAct;
	private JList listaFavoritos;
	private JList listaBusqueda;
	private JRadioButton radioListaNormal;
	private JRadioButton radioListaFavortios;
	private JLabel LabelFiltro;
	private JTextField textoBusquedaNombre;
	private JLabel lblNombre;
	private JLabel lblCiudad;
	private JTextField textoBusquedaCiudad;
	private JLabel lblEstado;
	private JTextField textoBusquedaEstado;
	private JLabel lblTipoCocina;
	private JTextField textoBusquedaCocina;
	private JButton botonBusqueda;
	private JLabel lblPaginaWeb;
	private JLabel lblCodigoPostal;
	private JTextField txtNombre;
	private JTextField txtCocina;
	private JTextField txtCiudad;
	private JTextField txtCategoria;
	private JTextField txtEstado;
	private JTextField txtTelefono;
	private JTextField txtDireccion;
	private JTextField txtWeb;
	private JTextField txtHorario;
	private JTextField txtCodigoPostal;
	private JPanel panelMapa;
	private Restaurante visualizado;
	private int listaFiltrar;
	private JFXPanel pane;
	private JTextField txtGraficoEstado;
	private JLabel lblEstado_1;


	/**
	 * Create the frame.
	 */
	public ventanaUsuario(ConsultorRestaurantes cons) {
		consultorAct=cons;
		setSize(new Dimension(1000, 720));
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
		gbl_panelBusquedas.rowHeights = new int[]{0, 0, 0, 27, 0};
		gbl_panelBusquedas.columnWeights = new double[]{0.0, 1.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_panelBusquedas.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panelBusquedas.setLayout(gbl_panelBusquedas);
		
		LabelFiltro = new JLabel("Lista a filtrar");
		GridBagConstraints gbc_LabelFiltro = new GridBagConstraints();
		gbc_LabelFiltro.insets = new Insets(0, 0, 5, 5);
		gbc_LabelFiltro.gridx = 0;
		gbc_LabelFiltro.gridy = 0;
		panelBusquedas.add(LabelFiltro, gbc_LabelFiltro);
		
		lblNombre = new JLabel("Nombre");
		GridBagConstraints gbc_lblNombre = new GridBagConstraints();
		gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombre.gridx = 1;
		gbc_lblNombre.gridy = 0;
		panelBusquedas.add(lblNombre, gbc_lblNombre);
		
		lblEstado = new JLabel("Estado");
		GridBagConstraints gbc_lblEstado = new GridBagConstraints();
		gbc_lblEstado.insets = new Insets(0, 0, 5, 5);
		gbc_lblEstado.gridx = 2;
		gbc_lblEstado.gridy = 0;
		panelBusquedas.add(lblEstado, gbc_lblEstado);
		
		radioListaNormal = new JRadioButton("Lista Busqueda");
		radioListaNormal.addActionListener(this);
		GridBagConstraints gbc_radioListaNormal = new GridBagConstraints();
		gbc_radioListaNormal.insets = new Insets(0, 0, 5, 5);
		gbc_radioListaNormal.gridx = 0;
		gbc_radioListaNormal.gridy = 1;
		panelBusquedas.add(radioListaNormal, gbc_radioListaNormal);
		
		textoBusquedaNombre = new JTextField();
		GridBagConstraints gbc_textoBusquedaNombre = new GridBagConstraints();
		gbc_textoBusquedaNombre.insets = new Insets(0, 0, 5, 5);
		gbc_textoBusquedaNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_textoBusquedaNombre.gridx = 1;
		gbc_textoBusquedaNombre.gridy = 1;
		panelBusquedas.add(textoBusquedaNombre, gbc_textoBusquedaNombre);
		textoBusquedaNombre.setColumns(10);
		
		textoBusquedaEstado = new JTextField();
		GridBagConstraints gbc_textoBusquedaEstado = new GridBagConstraints();
		gbc_textoBusquedaEstado.insets = new Insets(0, 0, 5, 5);
		gbc_textoBusquedaEstado.fill = GridBagConstraints.HORIZONTAL;
		gbc_textoBusquedaEstado.gridx = 2;
		gbc_textoBusquedaEstado.gridy = 1;
		panelBusquedas.add(textoBusquedaEstado, gbc_textoBusquedaEstado);
		textoBusquedaEstado.setColumns(10);
		
		lblCiudad = new JLabel("Ciudad");
		GridBagConstraints gbc_lblCiudad = new GridBagConstraints();
		gbc_lblCiudad.insets = new Insets(0, 0, 5, 5);
		gbc_lblCiudad.gridx = 1;
		gbc_lblCiudad.gridy = 2;
		panelBusquedas.add(lblCiudad, gbc_lblCiudad);
		
		lblTipoCocina = new JLabel("Tipo Cocina");
		GridBagConstraints gbc_lblTipoCocina = new GridBagConstraints();
		gbc_lblTipoCocina.insets = new Insets(0, 0, 5, 5);
		gbc_lblTipoCocina.gridx = 2;
		gbc_lblTipoCocina.gridy = 2;
		panelBusquedas.add(lblTipoCocina, gbc_lblTipoCocina);
		
		botonBusqueda = new JButton("Filtrar");
		botonBusqueda.addActionListener(this);
		botonBusqueda.setActionCommand("busq");
		GridBagConstraints gbc_botonBusqueda = new GridBagConstraints();
		gbc_botonBusqueda.gridheight = 3;
		gbc_botonBusqueda.insets = new Insets(0, 0, 5, 0);
		gbc_botonBusqueda.gridx = 3;
		gbc_botonBusqueda.gridy = 1;
		panelBusquedas.add(botonBusqueda, gbc_botonBusqueda);
		
		radioListaFavortios = new JRadioButton("Lista Favoritos");
		radioListaFavortios.addActionListener(this);
		GridBagConstraints gbc_radioListaFavortios = new GridBagConstraints();
		gbc_radioListaFavortios.insets = new Insets(0, 0, 0, 5);
		gbc_radioListaFavortios.gridx = 0;
		gbc_radioListaFavortios.gridy = 3;
		panelBusquedas.add(radioListaFavortios, gbc_radioListaFavortios);
		
		textoBusquedaCiudad = new JTextField();
		GridBagConstraints gbc_textoBusquedaCiudad = new GridBagConstraints();
		gbc_textoBusquedaCiudad.insets = new Insets(0, 0, 0, 5);
		gbc_textoBusquedaCiudad.fill = GridBagConstraints.HORIZONTAL;
		gbc_textoBusquedaCiudad.gridx = 1;
		gbc_textoBusquedaCiudad.gridy = 3;
		panelBusquedas.add(textoBusquedaCiudad, gbc_textoBusquedaCiudad);
		textoBusquedaCiudad.setColumns(10);
		
		textoBusquedaCocina = new JTextField();
		GridBagConstraints gbc_textoBusquedaCocina = new GridBagConstraints();
		gbc_textoBusquedaCocina.insets = new Insets(0, 0, 0, 5);
		gbc_textoBusquedaCocina.fill = GridBagConstraints.HORIZONTAL;
		gbc_textoBusquedaCocina.gridx = 2;
		gbc_textoBusquedaCocina.gridy = 3;
		panelBusquedas.add(textoBusquedaCocina, gbc_textoBusquedaCocina);
		textoBusquedaCocina.setColumns(10);
		
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
		
		listaFavoritos = new JList();
		listaFavoritos.addListSelectionListener(this);
		scrollPaneListaFavoritos.setViewportView(listaFavoritos);
		
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
		
		listaBusqueda = new JList();
		listaBusqueda.addListSelectionListener(this);
		scrollPaneListaBusquedas.setViewportView(listaBusqueda);
		
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
		gbl_panelBotonesGraficas.rowHeights = new int[]{211, 174, 0, 38, 0};
		gbl_panelBotonesGraficas.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panelBotonesGraficas.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panelBotonesGraficas.setLayout(gbl_panelBotonesGraficas);
		
		btnGráficaCategorias = new JButton("Gr\u00E1fica categor\u00EDas");
		btnGráficaCategorias.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new creadorGraficoPie("6 Categorías mas comunes", consultorAct.darCategorias()).setVisible(true);
			}
		});
		GridBagConstraints gbc_btnGráficaCategorias = new GridBagConstraints();
		gbc_btnGráficaCategorias.insets = new Insets(0, 0, 5, 0);
		gbc_btnGráficaCategorias.gridx = 0;
		gbc_btnGráficaCategorias.gridy = 0;
		panelBotonesGraficas.add(btnGráficaCategorias, gbc_btnGráficaCategorias);
		
		btnGraficaTipos = new JButton("Gr\u00E1fica tipos");
		btnGraficaTipos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
					
					if(txtGraficoEstado.getText().equals(""))
					{
						try {
							throw new Exception("Debe escribir un estado");
						} catch (Exception e) {
							// TODO Auto-generated catch block
							JOptionPane.showMessageDialog(principal,e.getMessage());
						}
					}
					else
					{
						new creadorGraficoBarras("8 tipos de cocina más comunes en: "+ txtGraficoEstado.getText()  , consultorAct.darCocinas(),txtGraficoEstado.getText()).setVisible(true);
					}
					
			}
		});
		GridBagConstraints gbc_btnGraficaTipos = new GridBagConstraints();
		gbc_btnGraficaTipos.insets = new Insets(0, 0, 5, 0);
		gbc_btnGraficaTipos.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnGraficaTipos.gridx = 0;
		gbc_btnGraficaTipos.gridy = 1;
		panelBotonesGraficas.add(btnGraficaTipos, gbc_btnGraficaTipos);
		
		lblEstado_1 = new JLabel("Estado");
		GridBagConstraints gbc_lblEstado_1 = new GridBagConstraints();
		gbc_lblEstado_1.insets = new Insets(0, 0, 5, 0);
		gbc_lblEstado_1.gridx = 0;
		gbc_lblEstado_1.gridy = 2;
		panelBotonesGraficas.add(lblEstado_1, gbc_lblEstado_1);
		
		txtGraficoEstado = new JTextField();
		GridBagConstraints gbc_txtGraficoEstado = new GridBagConstraints();
		gbc_txtGraficoEstado.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtGraficoEstado.gridx = 0;
		gbc_txtGraficoEstado.gridy = 3;
		panelBotonesGraficas.add(txtGraficoEstado, gbc_txtGraficoEstado);
		txtGraficoEstado.setColumns(10);
		
		panelInfo = new JPanel();
		panelInfo.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Información Restaurante", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelCentral.add(panelInfo, BorderLayout.CENTER);
		GridBagLayout gbl_panelInfo = new GridBagLayout();
		gbl_panelInfo.columnWidths = new int[]{131, 133, 124, 127, 0};
		gbl_panelInfo.rowHeights = new int[]{47, 45, 46, 31, 46, 300, 0};
		gbl_panelInfo.columnWeights = new double[]{1.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_panelInfo.rowWeights = new double[]{1.0, 1.0, 1.0, 0.0, 1.0, 1.0, Double.MIN_VALUE};
		panelInfo.setLayout(gbl_panelInfo);
		
		labelNombre = new Label("Nombre:");
		GridBagConstraints gbc_labelNombre = new GridBagConstraints();
		gbc_labelNombre.anchor = GridBagConstraints.EAST;
		gbc_labelNombre.insets = new Insets(0, 0, 5, 5);
		gbc_labelNombre.gridx = 0;
		gbc_labelNombre.gridy = 0;
		panelInfo.add(labelNombre, gbc_labelNombre);
		
		txtNombre = new JTextField();
		GridBagConstraints gbc_txtNombre = new GridBagConstraints();
		gbc_txtNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNombre.insets = new Insets(0, 0, 5, 5);
		gbc_txtNombre.gridx = 1;
		gbc_txtNombre.gridy = 0;
		panelInfo.add(txtNombre, gbc_txtNombre);
		txtNombre.setColumns(10);
		
		txtNombre.setEditable(false);
		
		labCocina = new Label("Cocina:");
		GridBagConstraints gbc_labCocina = new GridBagConstraints();
		gbc_labCocina.anchor = GridBagConstraints.EAST;
		gbc_labCocina.insets = new Insets(0, 0, 5, 5);
		gbc_labCocina.gridx = 2;
		gbc_labCocina.gridy = 0;
		panelInfo.add(labCocina, gbc_labCocina);
		
		txtCocina = new JTextField();
		GridBagConstraints gbc_txtCocina = new GridBagConstraints();
		gbc_txtCocina.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtCocina.insets = new Insets(0, 0, 5, 0);
		gbc_txtCocina.gridx = 3;
		gbc_txtCocina.gridy = 0;
		panelInfo.add(txtCocina, gbc_txtCocina);
		txtCocina.setColumns(10);
		txtCocina.setEditable(false);
		
		labelCiudad = new Label("Ciudad:");
		GridBagConstraints gbc_labelCiudad = new GridBagConstraints();
		gbc_labelCiudad.anchor = GridBagConstraints.EAST;
		gbc_labelCiudad.insets = new Insets(0, 0, 5, 5);
		gbc_labelCiudad.gridx = 0;
		gbc_labelCiudad.gridy = 1;
		panelInfo.add(labelCiudad, gbc_labelCiudad);
		
		txtCiudad = new JTextField();
		GridBagConstraints gbc_txtCiudad = new GridBagConstraints();
		gbc_txtCiudad.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtCiudad.insets = new Insets(0, 0, 5, 5);
		gbc_txtCiudad.gridx = 1;
		gbc_txtCiudad.gridy = 1;
		panelInfo.add(txtCiudad, gbc_txtCiudad);
		txtCiudad.setColumns(10);
		txtCiudad.setEditable(false);
		
		labCategoria = new Label("Categor\u00EDa:");
		GridBagConstraints gbc_labCategoria = new GridBagConstraints();
		gbc_labCategoria.anchor = GridBagConstraints.EAST;
		gbc_labCategoria.insets = new Insets(0, 0, 5, 5);
		gbc_labCategoria.gridx = 2;
		gbc_labCategoria.gridy = 1;
		panelInfo.add(labCategoria, gbc_labCategoria);
		
		txtCategoria = new JTextField();
		GridBagConstraints gbc_txtCategoria = new GridBagConstraints();
		gbc_txtCategoria.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtCategoria.insets = new Insets(0, 0, 5, 0);
		gbc_txtCategoria.gridx = 3;
		gbc_txtCategoria.gridy = 1;
		panelInfo.add(txtCategoria, gbc_txtCategoria);
		txtCategoria.setColumns(10);
		txtCategoria.setEditable(false);
		
		labelEstado = new Label("Estado:");
		GridBagConstraints gbc_labelEstado = new GridBagConstraints();
		gbc_labelEstado.anchor = GridBagConstraints.EAST;
		gbc_labelEstado.insets = new Insets(0, 0, 5, 5);
		gbc_labelEstado.gridx = 0;
		gbc_labelEstado.gridy = 2;
		panelInfo.add(labelEstado, gbc_labelEstado);
		
		txtEstado = new JTextField();
		GridBagConstraints gbc_txtEstado = new GridBagConstraints();
		gbc_txtEstado.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtEstado.insets = new Insets(0, 0, 5, 5);
		gbc_txtEstado.gridx = 1;
		gbc_txtEstado.gridy = 2;
		panelInfo.add(txtEstado, gbc_txtEstado);
		txtEstado.setColumns(10);
		txtEstado.setEditable(false);
		
		labTelefono = new Label("Tel\u00E9fono:");
		GridBagConstraints gbc_labTelefono = new GridBagConstraints();
		gbc_labTelefono.anchor = GridBagConstraints.EAST;
		gbc_labTelefono.insets = new Insets(0, 0, 5, 5);
		gbc_labTelefono.gridx = 2;
		gbc_labTelefono.gridy = 2;
		panelInfo.add(labTelefono, gbc_labTelefono);
		
		txtTelefono = new JTextField();
		GridBagConstraints gbc_txtTelefono = new GridBagConstraints();
		gbc_txtTelefono.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtTelefono.insets = new Insets(0, 0, 5, 0);
		gbc_txtTelefono.gridx = 3;
		gbc_txtTelefono.gridy = 2;
		panelInfo.add(txtTelefono, gbc_txtTelefono);
		txtTelefono.setColumns(10);
		txtTelefono.setEditable(false);
		
		labDireccion = new Label("Direcci\u00F3n:");
		GridBagConstraints gbc_labDireccion = new GridBagConstraints();
		gbc_labDireccion.anchor = GridBagConstraints.EAST;
		gbc_labDireccion.insets = new Insets(0, 0, 5, 5);
		gbc_labDireccion.gridx = 0;
		gbc_labDireccion.gridy = 3;
		panelInfo.add(labDireccion, gbc_labDireccion);
		
		txtDireccion = new JTextField();
		GridBagConstraints gbc_txtDireccion = new GridBagConstraints();
		gbc_txtDireccion.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtDireccion.insets = new Insets(0, 0, 5, 5);
		gbc_txtDireccion.gridx = 1;
		gbc_txtDireccion.gridy = 3;
		panelInfo.add(txtDireccion, gbc_txtDireccion);
		txtDireccion.setColumns(10);
		txtDireccion.setEditable(false);
		
		labHorario = new Label("Horario:");
		GridBagConstraints gbc_labHorario = new GridBagConstraints();
		gbc_labHorario.anchor = GridBagConstraints.EAST;
		gbc_labHorario.insets = new Insets(0, 0, 5, 5);
		gbc_labHorario.gridx = 2;
		gbc_labHorario.gridy = 3;
		panelInfo.add(labHorario, gbc_labHorario);
		
		txtHorario = new JTextField();
		GridBagConstraints gbc_txtHorario = new GridBagConstraints();
		gbc_txtHorario.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtHorario.insets = new Insets(0, 0, 5, 0);
		gbc_txtHorario.gridx = 3;
		gbc_txtHorario.gridy = 3;
		panelInfo.add(txtHorario, gbc_txtHorario);
		txtHorario.setColumns(10);
		txtHorario.setEditable(false);
		
		lblPaginaWeb = new JLabel("Pagina Web:  ");
		lblPaginaWeb.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_lblPaginaWeb = new GridBagConstraints();
		gbc_lblPaginaWeb.anchor = GridBagConstraints.EAST;
		gbc_lblPaginaWeb.insets = new Insets(0, 0, 5, 5);
		gbc_lblPaginaWeb.gridx = 0;
		gbc_lblPaginaWeb.gridy = 4;
		panelInfo.add(lblPaginaWeb, gbc_lblPaginaWeb);
		
		txtWeb = new JTextField();
		GridBagConstraints gbc_txtWeb = new GridBagConstraints();
		gbc_txtWeb.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtWeb.insets = new Insets(0, 0, 5, 5);
		gbc_txtWeb.gridx = 1;
		gbc_txtWeb.gridy = 4;
		panelInfo.add(txtWeb, gbc_txtWeb);
		txtWeb.setColumns(10);
		txtWeb.setEditable(false);
		
		lblCodigoPostal = new JLabel("Codigo Postal:  ");
		GridBagConstraints gbc_lblCodigoPostal = new GridBagConstraints();
		gbc_lblCodigoPostal.anchor = GridBagConstraints.EAST;
		gbc_lblCodigoPostal.insets = new Insets(0, 0, 5, 5);
		gbc_lblCodigoPostal.gridx = 2;
		gbc_lblCodigoPostal.gridy = 4;
		panelInfo.add(lblCodigoPostal, gbc_lblCodigoPostal);
		
		txtCodigoPostal = new JTextField();
		GridBagConstraints gbc_txtCodigoPostal = new GridBagConstraints();
		gbc_txtCodigoPostal.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtCodigoPostal.insets = new Insets(0, 0, 5, 0);
		gbc_txtCodigoPostal.gridx = 3;
		gbc_txtCodigoPostal.gridy = 4;
		panelInfo.add(txtCodigoPostal, gbc_txtCodigoPostal);
		txtCodigoPostal.setColumns(10);
		txtCodigoPostal.setEditable(false);
		
		panelMapa = new JPanel();
		GridBagConstraints gbc_panelMapa = new GridBagConstraints();
		gbc_panelMapa.gridwidth = 4;
		gbc_panelMapa.fill = GridBagConstraints.BOTH;
		gbc_panelMapa.gridx = 0;
		gbc_panelMapa.gridy = 5;
		panelInfo.add(panelMapa, gbc_panelMapa);
		
		ButtonGroup grupoBotones = new ButtonGroup();
		grupoBotones.add(radioListaFavortios);
		grupoBotones.add(radioListaNormal);
		
		listaFiltrar=2;
		textoBusquedaCocina.setEditable(false);
		textoBusquedaNombre.setEditable(true);
		textoBusquedaCiudad.setEditable(true);
		
		pane = new JFXPanel();
		JScrollPane scrool = new JScrollPane();
		scrool.setViewportView(pane);
		panelMapa.setLayout(new BorderLayout());
		panelMapa.add(scrool, BorderLayout.CENTER);
	}

	public void setPrincipal(ventanaInicial pPrincipal) 
	{
		principal = pPrincipal;
		principal.setVisible(false);	
	}

	@Override
	public void valueChanged(ListSelectionEvent l)
	{
		if(l.getSource().equals(listaBusqueda))
		{
			if(listaBusqueda.getSelectedValue()!=null)
			{
				visualizado = (Restaurante) listaBusqueda.getSelectedValue();
				refrescarInformacionVisualizada();
			}
		}
		else if(l.getSource().equals(listaFavoritos))
		{
			if(listaFavoritos.getSelectedValue()!=null)
			{
				visualizado = (Restaurante) listaFavoritos.getSelectedValue();
				refrescarInformacionVisualizada();
			}
		}
		
	}
	
	public void refrescarListaFavoritos(Restaurante[] restaurantes)
	{
		listaFavoritos.removeAll();
		listaFavoritos.setListData(restaurantes);
		listaFavoritos.setSelectedIndex(-1);
		listaFavoritos.updateUI();
	}
	
	public void refrescarListaBusqueda(Restaurante[] restaurantes)
	{
		listaBusqueda.removeAll();
		listaBusqueda.setListData(restaurantes);
		listaBusqueda.setSelectedIndex(-1);
		listaBusqueda.updateUI();
	}
	
	public void refrescarInformacionVisualizada()
	{
		txtNombre.setText(visualizado.getNombre());
		txtTelefono.setText(visualizado.getTelefono());
		txtCategoria.setText(visualizado.getCategoria());
		txtCocina.setText(visualizado.getCocina());
		txtCiudad.setText(visualizado.getCiudad());
		txtCodigoPostal.setText(visualizado.getPostal());
		txtDireccion.setText(visualizado.getDireccion());
		txtEstado.setText(visualizado.getEstado());
		txtHorario.setText(visualizado.getHorario());
		txtWeb.setText(visualizado.getWeb());
		
		if(txtHorario.getText().equals(""))
		{
			txtHorario.setText("Información No Disponible");
		}
		if(txtCodigoPostal.getText().equals(""))
		{
			txtCodigoPostal.setText("Información No Disponible");
		}
		if(txtDireccion.getText().equals(""))
		{
			txtDireccion.setText("Información No Disponible");
		}
		if(txtTelefono.getText().equals(""))
		{
			txtTelefono.setText("Información No Disponible");
		}
		if(txtWeb.getText().equals(""))
		{
			txtWeb.setText("Información No Disponible");
		}
		crearArchivoMapa(visualizado.getLongitud(), visualizado.getLatitud());
		Mapa nuevo = new Mapa(pane, visualizado.getNombre());
		nuevo.start();
		repaint();
		revalidate();
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		String comando = e.getActionCommand();
		if(comando.equals(radioListaFavortios.getActionCommand()))
		{
			listaFiltrar=1;
			textoBusquedaNombre.setEditable(false);
			textoBusquedaCiudad.setEditable(false);
			textoBusquedaCocina.setEditable(true);
		}
		else if(comando.equals(radioListaNormal.getActionCommand()))
		{
			listaFiltrar=2;
			textoBusquedaCocina.setEditable(false);
			textoBusquedaNombre.setEditable(true);
			textoBusquedaCiudad.setEditable(true);
		}
		else if(botonBusqueda.getActionCommand().equals(comando))
		{
			if(listaFiltrar==1)
			{
				if(textoBusquedaCocina.getText().equals("")||textoBusquedaEstado.getText().equals(""))
				{
					try {
						throw new Exception("Debe llenar todos los campos de busqueda.");
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(this, e1.getMessage());
					}
				}
				else
				{
					Restaurante[] restaurantes = consultorAct.darUsuarioActual().filtrarFavoritoPorEstadoCocina(textoBusquedaEstado.getText(), textoBusquedaCocina.getText());
					refrescarListaFavoritos(restaurantes);
				}
			}
			else if(listaFiltrar==2)
			{
				if(textoBusquedaNombre.getText().equals("")||textoBusquedaEstado.getText().equals("")||textoBusquedaCiudad.getText().equals(""))
				{
					try {
						throw new Exception("Debe llenar todos los campos de busqueda.");
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(this, e1.getMessage());
					}
				}
				else
				{
					Restaurante[] restaurantes = consultorAct.crearArregloPorId(textoBusquedaNombre.getText()+"-"+textoBusquedaCiudad.getText()+"-"+textoBusquedaEstado.getText());
					refrescarListaBusqueda(restaurantes);
				}
			}
		}
	}
	
	public void crearArchivoMapa(String longitud , String latitud)
	{
		if(longitud.equals("")||latitud.equals(""))
		{
			
		}
		else
		{
			File mapa = new File("./datos/mapaFinal.html");
			try 
			{
				PrintWriter escritor = new PrintWriter(mapa);
				BufferedReader lector = new BufferedReader(new FileReader(new File("./datos/mapa.html")));
				String linea = lector.readLine();
				while(linea!=null)
				{
					String texto = linea;
					if(linea.contains("longitud")&& linea.contains("latitud"))
					{
						texto = texto.replace("longitud", longitud);
						texto = texto.replace("latitud", latitud);
					}
					escritor.println(texto);
					linea = lector.readLine();
				}
				escritor.close();
				lector.close();
			} 
			catch (IOException e) 
			{
				JOptionPane.showMessageDialog(this, "No se pudo crear mapa");
			}

		}

	}

}
