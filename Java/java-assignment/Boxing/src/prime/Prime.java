/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prime;

import kiss.API.*;
import static kiss.API.outExpect;

/**
 *
 * @author zach1
 */
public class Prime {
    void testSmallPrimes(){
        Prime prime = new Prime();
        assert prime.isPrime(2) == true;
        assert prime.isPrime(3) == true;
        assert prime.isPrime(5) == true;
    }
    void testSmallComposites(){
        Prime prime = new Prime();
        assert prime.isPrime(4) == false;
        assert prime.isPrime(6) == false;
    }
    void testHi(){
        System.out.println("Hi");
    }
    boolean isPrime(int x){
        return true;
    }
}
