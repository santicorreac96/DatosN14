package mundo;

import java.awt.Container;
import java.awt.Dialog.ModalExclusionType;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.ui.ApplicationFrame;

import estructuraDatos.IListaEncadenadaDoble;



public class creadorGraficoPie extends ApplicationFrame
{
	private String titulo;

	public creadorGraficoPie(String title, IListaEncadenadaDoble<Categoria> lista) {
		super(title);
		titulo = title;
		setSize(400, 400);
		setContentPane(new ChartPanel(crearGrafica(crearDatos(lista))));
		// TODO Auto-generated constructor stub
	}

	
	private  PieDataset crearDatos(IListaEncadenadaDoble<Categoria> lista)
	{
		DefaultPieDataset datos = new DefaultPieDataset();
		Categoria ini = lista.volverActualPrimero();
		int agregados = 0;
		while(agregados<8)
		{
			datos.setValue(ini.getNombre(),ini.getCantidad());
			agregados++;
			ini = lista.adelantarse();
		}
		return datos;
		
	}
	
	private JFreeChart crearGrafica(PieDataset datos)
	{
		JFreeChart pie = ChartFactory.createPieChart3D(titulo, datos, true, true, false);
		PiePlot grafica = (PiePlot) pie.getPlot();
		grafica.setCircular(false);
		grafica.setLabelGap(0.02);
		return pie;
	}



}
