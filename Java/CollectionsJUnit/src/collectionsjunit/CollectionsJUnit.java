
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package collectionsjunit;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import static collectionsjunit.type.*;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author zach1
 */
public class CollectionsJUnit{

    public static void main(String[] args) throws InterruptedException {
      Result result = JUnitCore.runClasses(junittest.class);
		
      for (Failure failure : result.getFailures()) {
         System.out.println(failure.toString());
      }
		
      System.out.println(result.wasSuccessful());
      
      LinkedBlocks lb = new LinkedBlocks(4,4);
      LinkedBlocks.LBIterator it = new LinkedBlocks.LBIterator(lb);
      LinkedBlocks.LBIterator it2 = new LinkedBlocks.LBIterator(lb);
      it.start();
      int i =0;
      do{
          i++;
          try{
              it2.next().setT(HIT);
          }catch (NullPointerException ex){
              
          }
          try{
              Thread.sleep(500);
          }catch(InterruptedException ex){
              Logger.getLogger(LinkedBlocks.class.getName()).log(Level.SEVERE, null, ex); 
          }
      }while(!lb.done);
      System.out.println(lb.done);
   }
    
}
}
