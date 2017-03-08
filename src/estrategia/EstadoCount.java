package estrategia;
import wordCount.WordCount;

public interface EstadoCount {
	public void checkChar(WordCount wordCount);
        public void incrementLine(WordCount wordCount);
}
