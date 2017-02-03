/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package collectionshomework;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import static kiss.API.*;

/**
 *
 * @author zach1
 */
public class LinkedBlocks  extends LinkedList<LinkedList<block>>{
    
    
    
    private void printBlocks(){
        Iterator<LinkedList<block>> CIt = this.iterator();
        List tempIt = new LinkedList<block>();
        block temp;
        
        while(CIt.hasNext()){//two dimensional iteration
            tempIt = CIt.next();
            Iterator<block> BIt = tempIt.iterator();
            while(BIt.hasNext()){
                temp = BIt.next();
                System.out.print(temp.getX() + "," + temp.getY() + "  ");
            }
            System.out.print("\n");
        }
    }
    
    public static void testPrint(LinkedBlocks c){
        {
            outExpect("0,0  0,1  0,2  0,3  0,4  0,5  0,6  0,7  0,8  0,9\n1,0  1,1  1,2  1,3  1,4  1,5  1,6  1,7  1,8  1,9");
            c.printBlocks();
        }
    }
    
    void testBlocks (LinkedBlocks c){
        Iterator<LinkedList<block>> LBIt = c.iterator();
        LinkedList<block> temp1 = LBIt.next();
        Iterator<block> BIt = temp1.iterator();
        block tempBlock = BIt.next();
        
        assert (tempBlock.getX() == 0);
        assert (tempBlock.getY() == 0);
        tempBlock = BIt.next();
        assert (tempBlock.getX() == 1);
        assert (tempBlock.getY() == 0);
    }

    void run(){
        System.out.println("hey there");
    }
    
    public static void main(String[] args) {
        block.builder b = new block.builder();
        LinkedBlocks cB = new LinkedBlocks(); //two dimensional linked list
        List cL = cB;
        for (int x =0; x<10; x++){
            b.setX(x);
            List tempList = new LinkedList<block>();
            for (int y =0; y < 10; y++){
                
                b.setY(y);
                tempList.add(b.build());
            }
            cL.add(tempList);
        }
        cB.testPrint(cB);
        cB.testBlocks(cB);
        assert (1 == 2);
        //Frame f = new Frame();
        //f.createFrame();
        
    }
}
    
