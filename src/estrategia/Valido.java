package estrategia;

import wordCount.WordCount;

public class Valido implements EstadoCount {
	private static final Valido instance = new Valido();
	
	private Valido () {
        }
	
	public static Valido getInstance() {
		return instance;
	}

	@Override
	public void checkChar(WordCount wordCount) {
		int ascii  = wordCount.getChar();
                int auxNumLines = wordCount.getNumLines();

                if (ascii == 10) {//ascii 10 = '\n'
                    incrementLine(wordCount);
                    wordCount.setEstado(Selector.getInstance());
                    
                } else if (ascii == 47) {//ascii 47 = '/'
                    wordCount.setEstado(Comentario.getInstance());
                } 

	}
        

        @Override
        public void incrementLine(WordCount wordCount) {
            int auxNumLines = wordCount.getNumLines();
            auxNumLines++;
            wordCount.setNumLines(auxNumLines);
        }

}
