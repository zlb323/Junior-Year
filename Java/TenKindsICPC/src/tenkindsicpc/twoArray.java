/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tenkindsicpc;

/**
 *
 * @author zach1
 */
public class twoArray {
    int[][] x;
    boolean[][] isVisited;
    twoArray(int maxX, int maxY){
        x = new int[maxX][maxY];
        for (int a = 0; a < maxX; a++){
            int[] temp;
            temp = new int[maxY];
            for (int b = 0; b < maxY; b++){
                temp[b] = 0;
            }
            x[a] = temp;
        }
    }
    void add(int _x, int _y, int temp){
        x[_x][_y] = temp;
    }
    boolean isOne(int _x, int y){
        if(x[_x][y] == 1) return true;
        else return false;
    }
}
