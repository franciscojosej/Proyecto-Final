package Visual;

import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

import logico.CableTV;
import logico.Celular;
import logico.Control;
import logico.Internet;
import logico.Plan;
import logico.Tricom;

public class FacturasPorMes extends JFrame{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JPanel panel;
    public FacturasPorMes(){
        setTitle("Facturas por Mes");
        setSize(800,600);
        setLocationRelativeTo(null);
       // setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        init();
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				dispose();
				
			}
		});
    }
 
    /*private void init() {
        panel = new JPanel();
        getContentPane().add(panel);
        // Fuente de Datos
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.setValue(8, "Pagada", "Enero");
        dataset.setValue(7, "No paga", "Enero");
        dataset.setValue(9, "Pagada", "Febrero");
        dataset.setValue(4, "No paga", "Febrero");
        dataset.setValue(4, "Pagada", "Marzo");
        dataset.setValue(5, "No paga", "Marzo");
        dataset.setValue(8, "Pagada", "Abril");
        dataset.setValue(9, "No paga", "Abril");
        dataset.setValue(7, "Pagada", "Mayo");
        dataset.setValue(8, "No paga", "Mayo");
        // Creando el Grafico
        JFreeChart chart = ChartFactory.createBarChart3D
        ("Facturas por Mes","Estados", "Mes", 
        dataset, PlotOrientation.VERTICAL, true,true, false);
        chart.setBackgroundPaint(Color.cyan);
        chart.getTitle().setPaint(Color.black); 
        CategoryPlot p = chart.getCategoryPlot(); 
        p.setRangeGridlinePaint(Color.red); 
        // Mostrar Grafico
        ChartPanel chartPanel = new ChartPanel(chart);
        panel.add(chartPanel);
    }*/
    
    private void init() {
        panel = new JPanel();
        getContentPane().add(panel);
        // Fuente de Datos
      int internet=10;
      int TV=0;
      int celular=0;
        Tricom.getInstance().getMisFacturas();
        	for (int i = 0; i < Tricom.FacturacionCod; i++) {
			
			ArrayList<Plan> planes=Tricom.getInstance().buscar;
			
			if(planes!=null)
			for (Plan plan : planes) {
				if (plan instanceof Celular) {
				
					celular++;
				}
				if (plan instanceof CableTV) {
					TV++;
				}
				if (plan instanceof Internet) {
					internet++;
				}
				
			}
			
		
		
			

		}
            DefaultPieDataset data = new DefaultPieDataset();
		data.setValue("Telefono", celular);
        data.setValue("Internet", internet);
        data.setValue("TV", TV);
 
        // Creando el Grafico
        JFreeChart chart = ChartFactory.createPieChart(
         "Porcentaje de Planes Utilizados", 
         data, 
         true, 
         true, 
         false);
 
        // Crear el Panel del Grafico con ChartPanel
        ChartPanel chartPanel = new ChartPanel(chart);
        panel.add(chartPanel);
    }
    
    //public static void main(String args[]){
     //   new GraPastel().setVisible(true);
   // }
}
