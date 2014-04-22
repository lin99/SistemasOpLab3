package Filosofos;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import java.util.Random;

/**
 *
 * @author JuanFelipe
 */
public class Philosopher extends Thread {
    
    Integer id, nEat;
    Table table;
    String state;
    ActorSystem actorSystem;
    ActorRef actorPhilosopher;
    

    public Philosopher( ) {
        nEat = 0;
    }

    public Philosopher(Integer id, Table table) {
        this( );
        this.id = id;
        this.table = table;
        this.state = "Pensando";
        actorSystem = ActorSystem.create( "Actor"+id );
        actorPhilosopher = actorSystem.actorOf(
                            Props.create(PhilosopherActor.class), "Actor"+id);
    }
    
    @Override
    public void run ( ) {
        
        if( id >= table.getTam( ) ) {
            System.out.println( "No me puedo sentar" );
            return;
        }
        
        int aux ;
        

        for( int i = 0; i<10 ; i++ ) {
            aux = 1;
            System.out.println("Esperando el filosofo con id: " + id);
            
            //Preguntar si se puede comer
            
            if( id%2==0 ) {
                table.getChopstick()[id] = true;
                table.getChopstick()[(id+1)%table.getTam()] = true;
            } else {
                table.getChopstick()[(id+1)%table.getTam()] = true;
                table.getChopstick()[id] = true;
            }

            System.out.println( "Comiendo el filosofo con id: " + id );
            //Comiendo
            //while( aux%5!=0 ) {
                //aux = rand.nextInt( 1000 )+1;
            //    System.out.println("*"+aux+" "+id);
            //}

            System.out.println("Termino de comer el filosofo con id: " + id);
            nEat++;
            if( id%2==0 ) {
                table.getChopstick()[(id+1)%table.getTam()] = false;
                table.getChopstick()[id] = false;
            } else {
                table.getChopstick()[id] = false;
                table.getChopstick()[(id+1)%table.getTam()] = false;
            }
        }
        
        
    }
    
}