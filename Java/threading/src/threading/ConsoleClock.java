/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threading;
import java.util.logging.Level;
import java.util.logging.Logger;
import static kiss.API.*;
/**
 *
 * @author zach1
 */
public class ConsoleClock extends Thread{
    volatile boolean running = false;
    double startTime;
    
    public void start(){
        startTime = kiss.API.time();
        super.start();
        running = true;
    }
    public void close(){
        running = false;
        try {
            join();
        } catch (InterruptedException ex) {
            Logger.getLogger(ConsoleClock.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void run(){
        while(running){
            pause(1.0); 
            println("t=" + (time()-startTime));
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}
