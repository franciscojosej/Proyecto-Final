package logico;

import java.util.ArrayList;

public class Tricom {
	private ArrayList<Contrato> misContrato;
	
	
	//buscar Contrato por codiog , retorna el contrato si existe de lo contrario null
	private Contrato findCintratoByCode(String id) {
		Contrato contrato=null;
		
		boolean find = false;
		int i=0;
		while (i<misContrato.size()&&!find) {
			if(misContrato.get(i).getCodigoDeContrato().equalsIgnoreCase(id)){
				contrato = misContrato.get(i);
				find = true;
			}
			i++;
		}
		return contrato;
	}

}
