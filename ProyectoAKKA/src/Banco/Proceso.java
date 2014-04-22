
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

        }

    }

    public Integer[] getTransacciones() {
        return transacciones;
    }

    public void setTransacciones(Integer[] transacciones) {
        this.transacciones = transacciones;
    }


}
