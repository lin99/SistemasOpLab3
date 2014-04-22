package Filosofos;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author JuanFelipe
 */
public class DiningPhilosophers {
    
    public static void main( String args[] ){
        
        Scanner in = new Scanner(System.in);
        int n;
        
        System.out.print("Ingrese el numero de Filosofos: ");
        n = in.nextInt();
        
        Table chopStick = new Table(n);
        Philosopher philosophers[] = new Philosopher[n];
        
        //Creando Filosofos
        for( int i = 0; i < n; i++ ){
            philosophers[i] = new Philosopher(i, chopStick);
        }
        
        //Comenzando Filosofos
        for( int i = 0; i < n; i++ ){
            philosophers[i].start();
        }
        
        
        //Terminando
        for( int i = 0; i < n; i++ ){
            try {
                philosophers[i].join();
            } catch (InterruptedException ex) {
                System.out.println("Fallo en el Join "+i);
                Logger.getLogger(DiningPhilosophers.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        System.out.println("***********************************************");
        for( int i = 0; i < n; i++ ){
            System.out.println("El filosofo "+philosophers[i].id
                    +" comio "+philosophers[i].nEat);
        }
        
    }
    
}
