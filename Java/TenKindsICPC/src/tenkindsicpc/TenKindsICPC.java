/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tenkindsicpc;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author zach1
 */
public class TenKindsICPC {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("test.txt");
        Scanner sc = new Scanner(file);
        Integer j = sc.nextInt();
        Integer k = sc.nextInt();
        twoArray map = new twoArray(j,k);
        boolean isVisited[][];
        for (int a = 0; a <j; a ++){
            for (int b =0; b< k; b++){
                map.add(a,b,sc.nextInt());

            }
        }
        
        int numOfChecks = sc.nextInt();
        int x1,x2,y1,y2;
        boolean isOne;
        
        for (int checks = 0; checks < numOfChecks; checks++){
            isVisited = new boolean[j][k];
            
        for (int a = 0; a <j; a ++){
            for (int b =0; b< k; b++){
                            isVisited[a][b] = false;
            }
        }
        
            y1 = sc.nextInt()-1;
            x1 = sc.nextInt()-1;
            y2 = sc.nextInt()-1;
            x2 = sc.nextInt()-1;
            isOne = map.isOne(x1,y1);
            System.out.println(isConnected(isOne,y1,x1,y2,x2,j,k,map,isVisited));
        }
    }
    
    static public boolean isConnected(boolean isOne, int y1, int x1, int y2, int x2, int maxX, int maxY, twoArray _map, boolean[][] isVisited){
        if ((x1 == x2) && (y1 == y2)) return true;
        isVisited[x1][y1] = true;
        if(isOne){
            if ((x1 - 1 >= 0) && (_map.isOne(x1-1, y1)) && !isVisited[x1-1][y1]){
                if (isConnected(isOne,y1,x1-1,y2,x2,maxX,maxY,_map,isVisited)) return true;
            }
            if ((y1 - 1 >= 0) && (_map.isOne(x1, y1-1)) && !isVisited[x1][y1-1]){

                if(isConnected(isOne,y1-1,x1,y2,x2,maxX,maxY,_map,isVisited)) return true;
            }
            if ((x1 + 1 < maxX) && (_map.isOne(x1+1, y1)) && !isVisited[x1+1][y1]){                
                if (isConnected(isOne,y1,x1+1,y2,x2,maxX,maxY,_map,isVisited)) return true;
            }
            if ((y1+1 < maxY) && (_map.isOne(x1, y1+1) && (!isVisited[x1][y1+1]))){

                if (isConnected(isOne,y1+1,x1,y2,x2,maxX,maxY,_map,isVisited)) return true;
            }
        }
        else{
            if ((x1 - 1 >= 0) && (!(_map.isOne(x1-1, y1))) && (!isVisited[x1-1][y1])){
                                System.out.print(1 +" ");                               //left

                if (isConnected(isOne,y1,x1-1,y2,x2,maxX,maxY,_map,isVisited)) return true;
            }
            if ((y1 - 1 >= 0) && (!(_map.isOne(x1, y1-1))) && (!isVisited[x1][y1-1])){
                System.out.print(2 +" ");                                               //up

                if(isConnected(isOne,y1-1,x1,y2,x2,maxX,maxY,_map,isVisited)) return true;

            }
            if ((x1 + 1 < maxX) && (!(_map.isOne(x1+1, y1))) && (!isVisited[x1+1][y1])){   
                                System.out.print(3 +" ");                               //right

                if (isConnected(isOne,y1,x1+1,y2,x2,maxX,maxY,_map,isVisited)) return true;

            }
            if ((y1+1 < maxY) && (!(_map.isOne(x1, y1+1))) && (!isVisited[x1][y1+1])){
                                System.out.print(4 +" ");                               //down

                if (isConnected(isOne,y1+1,x1,y2,x2,maxX,maxY,_map,isVisited)) return true;
            }
        }
        return false;
    }
    
}
