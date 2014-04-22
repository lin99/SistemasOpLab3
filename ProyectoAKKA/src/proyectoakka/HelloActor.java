
package proyectoakka;

import akka.actor.UntypedActor;

class HelloActor extends UntypedActor {
 
    @Override
    public void onReceive(Object message) throws Exception {

        if( message instanceof String ) {

            String s = (String) message;

            switch( s ) {

                case "hello": {

                    System.out.println("hello you");

                    break;

                }

                default:

                    System.out.println("huu?");

            }

        } else {

            unhandled(message);

        }

    
    }
}