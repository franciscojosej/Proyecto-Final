package Visual;

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
import org.jfree.data.general.DefaultPieDataset;

import logico.CableTV;
import logico.Celular;
import logico.Control;
import logico.Internet;
import logico.Plan;
import logico.Tricom;

public class GraCircular extends JFrame{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JPanel panel;
    public GraCircular(){
        setTitle("Como Hacer Graficos con Java");
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
 
    private void init() {
        panel = new JPanel();
        getContentPane().add(panel);
        // Fuente de Datos
      int internet=10;
      int TV=0;
      int celular=0;
        Tricom.getInstance().getMisContrato();
        	for (int i = 0; i < Tricom.getPlanesCod(); i++) {
			
			ArrayList<Plan> planes=Tricom.getInstance().buscarPlanes(i);
			
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
         "Ejemplo Rapido de Grafico en un ChartFrame", 
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