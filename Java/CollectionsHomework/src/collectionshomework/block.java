/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package collectionshomework;

import static collectionshomework.type.REG;

/**
 *
 * @author zach1
 */

enum type {
    REG, SPEC
};

public class block {
    int x, y;
    type t = REG;
    
    void setX(int _x){x = _x;}
    void setY(int _y){y = _y;}
    void setT(type _t){t = _t;}
    
    public int getX(){return x;}
    int getY() {return y;}
    type getT() {return t;}
    
    block(int _x, int _y, type _t){
        x = _x;
        y = _y;
        t = _t;
    }
    

    static class builder {
        int x, y;
        type t;
        
        static int defaultX = 0;
        static int defaultY = 0;
        static type defaultType = REG;
        void setX(int _x){
            x=_x;
        }
        void setY(int _y){
            y=_y; 
        }
        void setT(type _t){
            t=_t;
        }
        block build(){
            block b = new block(x, y, t);
            return b;}
            public builder() {
                x = defaultX;
                y = defaultY;
                t = defaultType;
        }
    }
}
