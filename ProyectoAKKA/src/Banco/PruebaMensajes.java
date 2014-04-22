
package Banco;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author w7
 */
public class PruebaMensajes {

    public static void main( String args[] ) throws IOException{
        //Clase donde se realiza la prueba del ejercicio usando mensajes
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));s

        ActorSystem system = ActorSystem.create("Banco");
        int a = Integer.parseInt(bf.readLine().trim());

        int b = Integer.parseInt(bf.readLine().trim());
        Integer personaA[] = new Integer[a];
        Integer personaB[] = new Integer[b];

        for( int k = 0; k < a; k++ ) {
            personaA[k] = Integer.parseInt(bf.readLine());
        }

        for( int k = 0; k < b; k++ ) {
            personaB[k] = Integer.parseInt(bf.readLine());
        }


        //new Thread();
        //Scanner in = new Scanner( ((args==null)?System.in:args[0]));

        Cuenta numero = new Cuenta(0);
        ActorRef actor;
        ProcesoConMensajes.cuenta = numero;
        Props props = Props.create(ProcesoConMensajes.class);
        actor = system.actorOf( props, "Transaccion");

        Proceso hilo1 = new Proceso(numero, 0, actor);

        Proceso hilo2 = new Proceso(numero, 1, actor);


        hilo1.setTransacciones(personaA);
        hilo2.setTransacciones(personaB);
        hilo1.start();

        hilo2.start();
        system.shutdown();

        system.awaitTermination();//JOIN
        try {
            hilo2.join();
            hilo1.join();
        } catch( InterruptedException ex ) {
            System.out.println("Error de sincronizacion "+ex);
        }

        System.out.println("Cuenta final: " + numero);

    }

}
