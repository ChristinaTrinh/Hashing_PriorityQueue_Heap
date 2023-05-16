import java.util.Arrays;

public class HashIntSetClient 
{
    public static void main(String[]args)
    {
        System.out.println("Exercise 1: addAll");
        HashIntSet set1a = new HashIntSet();
        set1a.add(-5);
        set1a.add(1);
        set1a.add(2);
        set1a.add(3);
        HashIntSet set1b = new HashIntSet();
        set1b.add(2);
        set1b.add(3);
        set1b.add(6);
        set1b.add(44);
        set1b.add(79);
        System.out.println("The set before adding: " + set1a.toString());
        set1a.addAll(set1b);
        System.out.println("The set after adding: " + set1a.toString());
        System.out.println();

        System.out.println("Exercise 2: containsAll");
        HashIntSet set2a = new HashIntSet();
        set2a.add(-2);
        set2a.add(3);
        set2a.add(5);
        set2a.add(6);
        set2a.add(8);
        HashIntSet set2b = new HashIntSet();
        set2b.add(3);
        set2b.add(6);
        set2b.add(8);
        System.out.println("set2a contains all elements in set2b: " + set2a.containsAll(set2b));
        set2b.add(9);
        System.out.println("after adding '9', set2a contains all elements in set2b: " + set2a.containsAll(set2b));
        System.out.println();

        System.out.println("Exercise 3: equals");
        HashIntSet set3a = new HashIntSet();
        set3a.add(1);
        set3a.add(2);
        set3a.add(3);
        HashIntSet set3b = new HashIntSet();
        set3b.add(1);
        set3b.add(2);
        set3b.add(3);
        System.out.println("set3a equals set3b: " + set3a.equals(set3b));
        set3b.remove(3);
        set3b.add(4);
        System.out.println("set3a equals set3b: " + set3a.equals(set3b));
        System.out.println();

        System.out.println("Exercise 4: removeAll");
        HashIntSet set4a = new HashIntSet();
        set4a.add(-2);
        set4a.add(3);
        set4a.add(5);
        set4a.add(6);
        set4a.add(8);
        HashIntSet set4b = new HashIntSet();
        set4b.add(2);
        set4b.add(3);
        set4b.add(6);
        set4b.add(8);
        set4b.add(11);
        System.out.println("set4a before removing: " + set4a.toString());
        System.out.println("set4b original: " + set4b.toString());
        set4a.removeAll(set4b);
        System.out.println("set4a after removing: " + set4a.toString());
        System.out.println();

        System.out.println("Exercise 5: retainAll");
        HashIntSet set5a = new HashIntSet();
        set5a.add(-2);
        set5a.add(3);
        set5a.add(5);
        set5a.add(6);
        set5a.add(8);
        HashIntSet set5b = new HashIntSet();
        set5b.add(2);
        set5b.add(3);
        set5b.add(6);
        set5b.add(8);
        set5b.add(11);
        System.out.println("set5a before removing: " + set5a.toString());
        System.out.println("set5b original: " + set5b.toString());
        set5a.retainAll(set5b);
        System.out.println("set5a after removing: " + set5a.toString());
        System.out.println();

        System.out.println("Exercise 6: toArray");
        HashIntSet set6 = new HashIntSet();
        set6.add(-2);
        set6.add(3);
        set6.add(5);
        set6.add(6);
        set6.add(8);
        System.out.println("The array of the set6 is: " + Arrays.toString(set6.toArray()));
        System.out.println();

        System.out.println("Exercise 7: toString");
        HashIntSet set7 = new HashIntSet();
        set7.add(-2);
        set7.add(3);
        set7.add(5);
        set7.add(6);
        set7.add(8);
        System.out.println("The toString presentation of the set7 is: " + set7.toString());
        System.out.println();
    }
    
}
