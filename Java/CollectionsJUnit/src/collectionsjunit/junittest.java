
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package collectionsjunit;

import static junit.framework.TestCase.assertEquals;
import org.junit.Test;
import static collectionsjunit.type.*;

/**
 *
 * @author zach1
 */
public class junittest {
     @Test
	
   public void testAdd(){
       assertEquals(5,5);
       assertEquals(9,(6+3));
   }
   @Test
   public void testString() {
      String str = "Junit is working fine";
      assertEquals("Junit is working fine",str);
   }
   @Test
   public void testBlocks(){
       Blocks b = new Blocks(1,1,REGULAR);
       
       assertEquals(b.getX(), 1);
       assertEquals(b.getY(), 1);
       assertEquals(b.getT(), REGULAR);
       
       b.setX(2);
       b.setY(2);
       b.setT(SPECIAL);
       
       assertEquals(b.getX(), 2);
       assertEquals(b.getY(), 2);
       assertEquals(b.getT(),SPECIAL);
   }
   @Test
   public void testBLockBuilder(){
       Blocks.builder builder = new Blocks.builder();
       Blocks b = builder.build();
       
       assertEquals(b.getX(), 0);
       assertEquals(b.getY(),0);
       assertEquals(b.getT(), REGULAR);
       
       b = builder.setX(55).setY(66).setT(HIT).build();
       
       assertEquals(b.getX(),55);
       assertEquals(b.getY(),66);
       assertEquals(b.getT(), HIT);
   }
   @Test
   public void testLinkedBlocks(){
       LinkedBlocks lb = new LinkedBlocks(5,5);
       Blocks b = lb.iterator().next().iterator().next();
       assertEquals(b.getT(), REGULAR);
       assertEquals(b.getX(), 1);
       assertEquals(b.getY(), 1);
   }
   @Test
   public void testLinkedBlocksIterator(){
       LinkedBlocks lb = new LinkedBlocks(10,10);
       LinkedBlocks.LBIterator it;
       it = new LinkedBlocks.LBIterator(lb);
       Blocks b;
       for(int i = 1; i <= 10; i++){
           for(int j = 1; j <= 10; j++){
               b = it.next();
               assertEquals(b.getX(), j);
               assertEquals(b.getY(), i);
           }
       }
   }
   @Test
   public void testIsDone(){
       LinkedBlocks lb = new LinkedBlocks(4,4);
       LinkedBlocks.LBIterator it = new LinkedBlocks.LBIterator(lb);
      // System.out.println(it.done);
       for(int i = 0; i < 2; i++){
           for(int j = 0; j < 4; j++){
               it.next().setT(HIT);
           }
       }
       System.out.println(lb.done);
       
       assertEquals(lb.done, false);
       
       //if(it.next().getT() == HIT) System.out.println("fail");
   }
}

