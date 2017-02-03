
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package collectionsjunit;

import static collectionsjunit.type.*;

/**
 *
 * @author zach1
 */
enum type{SPECIAL, REGULAR, HIT};
public class Blocks {
    private volatile int x,y;
    private volatile type t;
    
    public void print(){
        System.out.print("(" +this.getX() + " " + this.getY() + ") ");
    }
    
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
    public type getT(){
        return t;
    }
    
    
    public void setX(int _x){
        x = _x;
    }
    public void setY(int _y){
        y = _y;
    }
    public void setT(type _t){
        t = _t;
    }
    
    Blocks(int _x, int _y, type _t){
        x = _x;
        y = _y;
        t = _t;
    }
    
    
    public static class builder{
        private static int defaultX = 0;
        private static int defaultY = 0;
        private static type defaultT = REGULAR;
        
        private int x;
        private int y;
        private type t;
        
        builder(){
            x = defaultX;
            y = defaultY;
            t = defaultT;
        }
        
        public builder setX(int _x){
            x = _x;
            return this;
        }
        public builder setY(int _y){
            y = _y;
            return this;
        }
        public builder setT(type _t){
            t = _t;
            return this;
        }
        
        public Blocks build(){
            return new Blocks(x,y,t);
        }
    }
}

