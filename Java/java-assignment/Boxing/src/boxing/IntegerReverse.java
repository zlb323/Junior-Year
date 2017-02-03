package boxing;


import java.util.Comparator;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author zach1
 */
public class IntegerReverse implements Comparator<Integer>{
    @Override
    public int compare(Integer o1, Integer o2) {
        return -o1.compareTo(o2);
    }
}
