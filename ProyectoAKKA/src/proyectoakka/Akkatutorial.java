package proyectoakka;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;

/**
 *
 * @author w7
 */
public class Akkatutorial {
    /**
     *
     * @param args the command line arguments
     *
     */
    public static void main(String[] args) {

        ActorSystem system = ActorSystem.create("Hola");

        ActorRef helloActor;
        helloActor = system.actorOf( Props.create(HelloActor.class), "hola");

        helloActor.tell("hello", null);

        helloActor.tell("chao", null);

        system.shutdown();

        system.awaitTermination();//JOIN

    }
}
