/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threading;

import static kiss.API.*;

/**
 *
 * @author zach1
 */
public class App {
    void run(){
        new Thread(()->{ pause(2); println("hi");}).start();
        ConsoleClock clock = new ConsoleClock();
        clock.start();
        pause(4.0);
        clock.close();
        println("done");
    }
}
