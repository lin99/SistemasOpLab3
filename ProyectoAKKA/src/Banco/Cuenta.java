package Banco;

/**
 *
 * @author usuario08
 */
public class Cuenta {
    int numero;

    public Cuenta(int numero) {
        this.numero = numero;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    @Override
    public String toString() {
        return "Cuenta{" + "numero=" + numero + '}';
    }
    
}
