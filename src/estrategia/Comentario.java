package estrategia;

import estrategia.EstadoCount;
import wordCount.WordCount;

public class Comentario implements EstadoCount {
	private static final Comentario instance = new Comentario();
	private boolean previousComment;
        private boolean endOfComment;
        private boolean inLineComment;
	
        private Comentario() {
            previousComment = false;
            endOfComment = false;
            inLineComment = false;
        }
	
	public static Comentario getInstance() {
		return instance;
	}
	
	@Override
	public void checkChar(WordCount wordCount) {
		int ascii  = wordCount.getChar();
                int auxNumLines = 0;
                
                if (ascii == 42) { //Ascii 42 = *
                    //Es un comentario
                    previousComment = true;
                }
      
                if (ascii == 47) {//ascii 47 = '/'
                    inLineComment = true;
                    if (previousComment) {
                        endOfComment = true;
                    } else {
                        endOfComment = true;
                    }
                }
                
                if ((ascii == 10 && endOfComment)) {
                    wordCount.setEstado(Selector.getInstance());
                }

	}

        @Override
        public void incrementLine(WordCount wordCount) {
            int auxNumLines = wordCount.getNumLines();
            auxNumLines++;
            wordCount.setNumLines(auxNumLines);
        }

}