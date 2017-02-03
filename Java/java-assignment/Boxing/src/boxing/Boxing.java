/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boxing;
import java.io.IOException;
import java.util.*;
import static jdk.nashorn.internal.parser.TokenType.EOL;
import kiss.API.Close;
import static kiss.API.outExpect;

/**
 *
 * @author zach1
 */
public class Boxing {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("hey");
    }
    
    void testBoxing() {
        Integer x = new Integer(3);
        Integer y = x;
        x = new Integer(x.intValue() +1);
        assert x == 4;
        assert y == 3;
        assert y != new Integer(3);
    }
    
    class Reverse implements Comparator<Integer>{
        @Override
        public int compare(Integer o1, Integer o2) {
            return -o1.compareTo(o2);
        }
    }
    
    void testArrayListInt() {
        ArrayList<Integer> ages = new ArrayList<Integer>();
        ages.add(3);
        ages.add(17);
        ages.add(100);
        for (int age :ages){
            System.out.println(age);
        }
        
        ages.sort(new Reverse());
        ages.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b){
                return -a.compareTo(b);
            }
        });
        ages.sort((a,b) -> -a.compareTo(b)); //lambda
        
        for(int age : ages) {
            System.out.println(age);
        }
    }
    
    void testHashMap(){
        Map<String, Integer> petAges = new HashMap<String, Integer>();
        petAges.put("Fluffy", 7);
        petAges.put("Pookie", 2);
        petAges.put("Pupper", 100);
        petAges.put("Doge", 3);
        petAges.put("Pepe", 83);
        
        for (String key : petAges.keySet()){
            System.out.println("petAges[" + key + "] = " + petAges.get(key));
        }
    }
    void testCollection() {
        Collection<Integer> c = new LinkedList<Integer>();
        c.add(3);
        c.add(1);
        c.add(7);
        c.add(2);
    }
    void testLinkedList(){
        List<String> names = new LinkedList<String>();
        names.add("Doge");
        names.add("Fluffy");
        names.add("Pepe");
        assert names.get(names.size()-1).equals("Pepe");
        
    }
    void doStuff()throws IOException {};
    void doOtherStuff(){};
    void testException(){
    try {
        doStuff();
    } catch (IOException ex) {
        doOtherStuff();
    }}
    void testException2() throws IOException {
        doStuff();
    }
}
    

