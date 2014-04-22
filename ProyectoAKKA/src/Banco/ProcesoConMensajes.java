
package Banco;

import akka.actor.UntypedActor;

/**
 *
 * @author w7
 */
public class ProcesoConMensajes extends UntypedActor{

    public static Cuenta cuenta;
    
    @Override
    public void onReceive(Object message) throws Exception {
        if( message instanceof Integer ) {

            Integer sum = (Integer) message;

            int temp = cuenta.numero;
            temp += sum;
            cuenta.numero = temp;

        } else {

            unhandled(message);

        }
    }
    
}
