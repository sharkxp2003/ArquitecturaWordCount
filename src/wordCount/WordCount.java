package wordCount;

import estrategia.Selector;
import estrategia.EstadoCount;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;

public class WordCount {

	private EstadoCount estado = Selector.getInstance();
	private String pathFile = null;
	private int character = 0;
	private int numLines;
	
	
	public WordCount(String pathFile) {
		this.pathFile = pathFile;
		numLines = 0;
	}

	public EstadoCount getEstado() {
		return estado;
	}
        
        public int getChar () {
            return character;
        }

	public void setEstado(EstadoCount estado) {
		this.estado = estado;
	}
	
	public int getNumLines() {
		return numLines;
	}
        
        public void setNumLines(int numLines) {
            this.numLines = numLines;
        } 
        
        public boolean isBetween(int x, int lower, int upper) {
            return lower <= x && x <= upper;
        }
	
	public int checkChar() {
            int ascii;
		try {
                    BufferedReader reader =
                            new BufferedReader(
                                    new InputStreamReader(
                                            new FileInputStream(pathFile),
                                            Charset.forName("UTF-8")));
			 
			
			
                while ((ascii = reader.read()) != -1) {
                    character = ascii;
                    estado.checkChar(this);
                }
                
                //if ((character != 0 && character != 47)
                //&& ascii == -1 && numLines ==0)
                    numLines++;
                
                
		} catch (IOException ex) {
			System.err.println(
                            "Archivo no existente"+ ex.getMessage()
                        );
		}
		return 0;
	}
	

}



	