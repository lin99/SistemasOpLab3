
package Filosofos;

import java.util.concurrent.Semaphore;

/**
 *
 * @author JuanFelipe
 */
class Table {
    private boolean chopstick[];
    private int tam;
    public Table() {
        tam = 5;
        chopstick = new boolean[tam];
        for(int i=0; i<tam; i++){
            chopstick[i] = false;
        }
    }

    public Table( int n ) {
        tam = n;
        chopstick = new boolean[tam];
        for(int i=0; i<tam; i++){
            chopstick[i] = false;
        }
    }
    
    public Table(boolean [] chopstick) {
        this.chopstick = chopstick;
    }
    
    public boolean[] getChopstick() {
        return chopstick;
    }

    public void setChopstick(boolean[] chopstick) {
        this.chopstick = chopstick;
    }

    public int getTam() {
        return tam;
    }

    public void setTam(int tam) {
        this.tam = tam;
    }
    
    
}
