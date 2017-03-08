/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estrategia;

import wordCount.WordCount;

/**
 *
 * @author alex
 */
public class Selector implements EstadoCount {

    private static final EstadoCount estado = new Selector();
    
    private Selector() {
        
    }

    public static EstadoCount getInstance() {
        return estado;
    }
    
    
    @Override
    public void checkChar(WordCount wordCount) {
        int ascii = wordCount.getChar();
        int val = wordCount.isBetween(ascii,33, 125) && (ascii != 47) ? 1 : 0;

        if (val == 1) {
            wordCount.setEstado(Valido.getInstance());
        } else {
            if (ascii == 47) wordCount.setEstado(Comentario.getInstance());
        }
    }

    @Override
    public void incrementLine(WordCount wordCount) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}