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
import javax.swing.JLabel;

public class GraCircular extends JFrame{
	private JLabel lblinter;
	private JLabel lbltele;
	private JLabel lblCalb;
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JPanel panel;
    public GraCircular(){
        setTitle("Planes Utilizados");
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
         "Porcentaje de Planes Utilizados", 
         data, 
         true, 
         true, 
         false);
        panel.setLayout(null);
 
        // Crear el Panel del Grafico con ChartPanel
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setBounds(52, 5, 680, 420);
        panel.add(chartPanel);
        
        lblinter = new JLabel("New label");
        lblinter.setBounds(52, 510, 113, 14);
        panel.add(lblinter);

       lbltele = new JLabel("New label");
        lbltele.setBounds(79, 461, 98, 14);
        panel.add(lbltele);
        

        lblCalb = new JLabel("New label");
        lblCalb.setBounds(52, 486, 98, 14);
        panel.add(lblCalb);
        
        lblCalb.setText("Telefono: "+celular);
        lblinter.setText("Internet: "+ internet);
        lbltele.setText("TV: "+ TV);
    }
    
    //public static void main(String args[]){
     //   new GraPastel().setVisible(true);
   // }
}