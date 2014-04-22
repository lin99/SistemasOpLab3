
package Banco;

import akka.actor.ActorRef;

/**
 *
 * @author usuario08
 */
public class Proceso extends Thread {

    Cuenta cuenta;
    Integer id;
    Integer transacciones[];
    ActorRef procesoActor;

    public Proceso(Cuenta msg, Integer id, ActorRef af) {

         this.cuenta = msg;
         this.id = id;
         procesoActor = af;
    }

    @Override
    public void run() {

        for (int k = 0; k < transacciones.length; k++) {
            
            procesoActor.tell(transacciones[k], null);
            //System.out.println("numero: " + cuenta + " id: " + id);
        }
        //System.out.println("en lo que termino el numero " + cuenta.numero);
        //System.out.println("Este proceso ha terminado:" + this.getName());
    }

    public Integer[] getTransacciones() {
        return transacciones;
    }

    public void setTransacciones(Integer[] transacciones) {
        this.transacciones = transacciones;
    }
    
    
}
