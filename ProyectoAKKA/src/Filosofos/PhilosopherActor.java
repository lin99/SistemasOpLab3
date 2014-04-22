
package Filosofos;

import akka.actor.UntypedActor;

/**
 *
 * @author w7
 */
public class PhilosopherActor extends UntypedActor {

    @Override
    public void onReceive(Object message) throws Exception {
        if( message instanceof Boolean ) {

            message = true;

        } else {

            unhandled(message);

        }
    }
    
}
