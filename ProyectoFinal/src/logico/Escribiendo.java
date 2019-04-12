package logico;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Escribiendo {

	public void escribir(String rutaDestin,String frace) {
	
		try {
			FileWriter escribir =new FileWriter(rutaDestin);
			
			for (int i = 0; i < frace.length(); i++) {
				try {
					escribir.write(frace.charAt(i));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			escribir.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
