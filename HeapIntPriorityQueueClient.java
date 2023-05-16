import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class HeapIntPriorityQueueClient
{
    public static void main(String[]args)
    {
        // testing the heap sort static method 
        System.out.println("Testing the heap sort static method implemented in HeapIntPriorityQueue: ");
        int[]a = {4, 3, 5, 2, 0};
        HeapIntPriorityQueue.heapSort(a);
        System.out.println();

        System.out.println("Exercise 8: descending");
        int[] array8 = {42, 9, 22, 17, -3, 81};
        System.out.println("Original order of array8 is: " + Arrays.toString(array8));
        descending(array8);
        System.out.println("Descending order of array8 is: " + Arrays.toString(array8));
        System.out.println();

        System.out.println("Exercise 9: kthSmallest");
        PriorityQueue<Integer> pq9 = new PriorityQueue<Integer>();
        pq9.add(42);
        pq9.add(50);
        pq9.add(45);
        pq9.add(78);
        pq9.add(61);
        System.out.println("pq9 is: " + pq9.toString());
        System.out.println("The 4th smallest in pq9 is: " + kthSmallest(pq9, 4));
        System.out.println();

        System.out.println("Exercise 10: isConsecutive");
        PriorityQueue<Integer> pq10 = new PriorityQueue<Integer>();
        pq10.add(7);
        pq10.add(8);
        pq10.add(9);
        pq10.add(10);
        pq10.add(11);
        System.out.println("pq10 is: " + pq10.toString());
        System.out.println("pq10 is consecutive: " + isConsecutive(pq10));
        System.out.println();

        System.out.println("Exercise 11: removeDuplicates");
        PriorityQueue<Integer> pq11 = new PriorityQueue<Integer>();
        pq11.add(7);
        pq11.add(7);
        pq11.add(8);
        pq11.add(8);
        pq11.add(8);
        pq11.add(10);
        pq11.add(45);
        pq11.add(45);
        System.out.println("pq11 before removing duplicates is: " + pq11.toString());
        removeDuplicates(pq11);
        System.out.println("pq11 after removing duplicates is: " + pq11.toString());
        System.out.println();

        System.out.println("Exercise 12: stutter");
        PriorityQueue<Integer> pq12 = new PriorityQueue<Integer>();
        pq12.add(7);
        pq12.add(8);
        pq12.add(10);
        pq12.add(45);
        System.out.println("pq12 before stuttering is: " + pq12.toString());
        stutter(pq12);
        System.out.println("pq12 after stuttering is: " + pq12.toString());
        System.out.println();

        System.out.println("Exercise 13: toArray");
        HeapIntPriorityQueue pq13 = new HeapIntPriorityQueue();
        pq13.add(3);
        pq13.add(2);
        pq13.add(5);
        System.out.println("The array version of the pq13 is: " + Arrays.toString(pq13.toArray()));
        System.out.println();

        System.out.println("Exercise 14: toString");
        HeapIntPriorityQueue pq14 = new HeapIntPriorityQueue();
        pq14.add(6);
        pq14.add(2);
        pq14.add(10);
        System.out.println("The string presentation of pq14 is: " + pq14.toString());
        System.out.println();

        System.out.println("Exercise 15: merge");
        HeapIntPriorityQueue pq15 = new HeapIntPriorityQueue();
        pq15.add(6);
        pq15.add(4);
        pq15.add(1);
        System.out.println("pq15 before merging is: " + pq15.toString());
        HeapIntPriorityQueue pq16 = new HeapIntPriorityQueue();
        pq16.add(0);
        pq16.add(-5);
        pq16.add(-100);
        System.out.println("pq16 before merging is: " + pq16.toString());
        pq15.merge(pq16);
        System.out.println("pq15 after merging with pq16 is: " + pq15.toString());
        System.out.println("pq16 after merging with pq15 is: " + pq16.toString());
        System.out.println();
    }

    public static void descending(int[] a)
    {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        for(int i = 0; i < a.length; i++)
            pq.add(a[i]);
        for(int i = a.length-1; i >= 0; i--)
            a[i] = pq.remove();
    }

    public static int kthSmallest(PriorityQueue<Integer> pq, int k)
    {
        if(k <= 0 || k > pq.size())
            throw new IllegalArgumentException();
        else
        {
            Queue<Integer> q = new LinkedList<Integer>();
            while(!pq.isEmpty())
                q.add(pq.remove());
            int value = -1;
            int count = 0;
            while(!q.isEmpty())
            {
                int n = q.remove();
                pq.add(n);
                count++;
                if(count == k)
                    value = n;
            }
            return value;
        }
    }

    public static boolean isConsecutive(PriorityQueue<Integer> pq)
    {
        int pastValue = -1;
        Queue<Integer> q = new LinkedList<Integer>();
        while(!pq.isEmpty()) // put the values into the queue so it is in ascending order
            q.add(pq.remove());
        if(!q.isEmpty()) // store the first value first to start comparing
            pastValue = q.remove();
        while(!q.isEmpty())
        {
            int currValue = q.remove();
            pq.add(currValue); //restore the priority queue
            if(currValue != (pastValue+1)) //if the past value+1 doesn't equal to currValue then it's not consecutive
                return false;
            pastValue = currValue;
        }
        return true;
    }

    public static void removeDuplicates(PriorityQueue<Integer> pq)
    {
        int lastValue = -1;
        Queue<Integer> q = new LinkedList<Integer>();
        if(!pq.isEmpty())
        {
            lastValue = pq.remove();
            q.add(lastValue);
        }
        while(!pq.isEmpty())
        {
            int currValue = pq.remove();
            if(currValue != lastValue)
            {
                lastValue = currValue;
                q.add(lastValue);
            }
        }

        while(!q.isEmpty())
            pq.add(q.remove());
    }

    public static void stutter(PriorityQueue<Integer> pq)
    {
        Queue<Integer> q = new LinkedList<Integer>();

        while(!pq.isEmpty())
            q.add(pq.remove());
        while(!q.isEmpty())
        {
            int value = q.remove();
            for(int i = 1; i <= 2; i++)
                pq.add(value);
        }
    }

    

    
}