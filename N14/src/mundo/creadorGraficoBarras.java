package mundo;

import java.io.Serializable;

import javax.swing.JFrame;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.ui.ApplicationFrame;

import estructuraDeDatos.IListaEncadenadaDoble;



public class creadorGraficoBarras extends JFrame implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String titulo;
	private String est;

	public creadorGraficoBarras(String title, IListaEncadenadaDoble<Cocina> lista,String estado) {
		super(title);
		titulo = title;
		est = estado;
		setSize(400, 400);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setContentPane(new ChartPanel(crearGrafica(crearDatos(lista))));
		// TODO Auto-generated constructor stub
	}

	private  CategoryDataset crearDatos(IListaEncadenadaDoble<Cocina> lista)
	{
		DefaultCategoryDataset datos = new DefaultCategoryDataset();
		Cocina ini = lista.volverActualPrimero();
		int agregados = 0;
		while(agregados<8)
		{
			if(ini.getEstado().equals(est))
			{
				datos.setValue(ini.getCantidad(), ini.getEstado(), ini.getNombre());
				agregados++;
			}
			ini = lista.adelantarse();
		}
		return datos;
	}
	
	private JFreeChart crearGrafica(CategoryDataset datos)
	{
		JFreeChart pie = ChartFactory.createBarChart3D(titulo, "Tipos de Cocina", "Cantidad", datos, PlotOrientation.VERTICAL, true, true, false);
		return pie;
	}
	
	public void dispose()
	{
		super.dispose();
	}

}
