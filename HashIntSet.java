public class HashIntSet
{
    private static final double MAX_LOAD_FACTOR = 0.75;
    private HashEntry[] elementData;
    private int size;
    public HashIntSet()
    {
        elementData = new HashEntry[10];
        size = 0;
    }

    // for checking if the size of the set is time to be enlarged
    private double loadFactor()
    {
        return (double) size / elementData.length;
    }

    // this method enlarge the set if it reaches the load factor
    private void rehash() 
    {
        HashEntry[] oldElementData = elementData;
        elementData = new HashEntry[2 * oldElementData.length];
        size = 0;
        for (int i = 0; i < oldElementData.length; i++) 
        {
            HashEntry current = oldElementData[i];
            while (current != null) 
            {
                add(current.data);
                current = current.next;
            }
        }
    }

    // this function gives the desired bucket
    private int hashFunction(int value)
    {
        return Math.abs(value) % elementData.length;
    }

    public void clear()
    {
        for(int i = 0; i < elementData.length; i++)
            elementData[i] = null;
        size = 0;
    }

    public boolean isEmpty()
    {
        return size == 0;
    }

    public int size()
    {
        return size;
    }

    public HashEntry[] getElementData()
    {
        return this.elementData;
    }

    public boolean contains(int value)
    {
        int bucket = hashFunction(value);
        HashEntry current = elementData[bucket];
        while(current != null)
        {
            if(current.getData() == value)
                return true;
            current = current.getNext();
        }
        return false;
    }

    // returns a string presentation of the hash set
    public String toString()
    {
        String str = "[";
        boolean went = false;
        for(int i = 0; i < this.elementData.length; i++)
        {
            went = true;
            HashEntry current = elementData[i];
            while(current != null)
            {
                str += current.getData() + ", ";
                current = current.getNext();
            }
        }
        if(went)
            str = str.substring(0, str.length()-2) + "]";
        else 
            str += "]";
        return str;
    }
    
    // this method adds the value into the set if the set doesn't contain it
    public void add(int value)
    {
        if(!contains(value))
        {
            if(loadFactor() >= MAX_LOAD_FACTOR)
                rehash();
            int bucket = hashFunction(value);
            elementData[bucket] = new HashEntry(value, elementData[bucket]);
            size++;
        }
    }

    // this method removes a value from a set if the set contains it
    public void remove(int value)
    {
        int bucket = hashFunction(value);
        if (elementData[bucket] != null) 
        {
            if (elementData[bucket].data == value) 
            {
                elementData[bucket] = elementData[bucket].getNext();
                size--;
            } 
            else 
            {
                HashEntry current = elementData[bucket];
                while (current.getNext()!= null && current.getNext().getData() != value)
                    current = current.getNext();
                
                if (current.getNext()!= null && current.getNext().getData() == value) 
                {
                    current.setNext(current.getNext().getNext());
                    size--;
                }
            }
        }
    }

    // accepts another hash set as a parameter 
    // and adds all of the elements from the other set into the current set
    public void addAll(HashIntSet other)
    {
        HashEntry[] otherElementData = other.getElementData();
        for(int i = 0; i < otherElementData.length; i++)
        {
            HashEntry current = otherElementData[i];
            while(current!=null)
            {
                if(!this.contains(current.getData()))
                    this.add(current.getData());
                current = current.getNext();
            }
        }
    }

    // accepts another hash set as a parameter and returns true if 'this' set contains
    // every element from the 'other' set
    public boolean containsAll(HashIntSet other)
    {
        HashEntry[] otherElementData = other.getElementData();
        for(int i = 0; i < otherElementData.length; i++)
        {
            HashEntry current = otherElementData[i];
            while(current != null)
            {
                if(!this.contains(current.getData()))
                    return false;
                current = current.getNext();
            }
        }
        return true;
    }

    // accepts another hash set as a parameter and returns true if two sets contain 
    // exactly the same elements
    // return false if their sizes are different
    public boolean equals(HashIntSet other)
    {
        if(this.size() != other.size())
            return false;
        else
        {
            for(int i = 0; i < this.elementData.length; i++)
            {
                HashEntry current = this.elementData[i];
                while(current != null)
                {
                    if(!other.contains(current.getData()))
                        return false;
                    current = current.getNext();
                }
            }
        }
        return true;
    }

    // accepts another hash set as a parameter and ensures that this set does not contain
    // any of the elements from the other set
    public void removeAll(HashIntSet other)
    {
        HashEntry[] otherElementData = other.getElementData();
        for(int i = 0; i < otherElementData.length; i++)
        {
            HashEntry current = otherElementData[i];
            while(current != null)
            {
                if(this.contains(current.getData()))
                    this.remove(current.getData());
                current = current.getNext();
            }
        }
    }

    public void retainAll(HashIntSet other)
    {
        for(int i = 0; i < this.elementData.length; i++)
        {
            HashEntry current = elementData[i];
            while(current != null)
            {
                if(!other.contains(current.getData()))
                    this.remove(current.getData());
                current = current.getNext();
            }
        }
    }

    public int[] toArray()
    {
        int[] array = new int[this.size()];
        int index = 0;
        for(int i = 0; i < elementData.length; i++)
        {
            HashEntry current = elementData[i];
            while(current != null)
            {
                array[index] = current.getData();
                index++;
                current = current.getNext();
            }
        }
        return array;
    }

    // Represents a single value in a chain stored in one hash bucket
    private class HashEntry
    {
        public int data;
        public HashEntry next;

        public HashEntry(int data)
        {
            this(data, null);
        }
        
        public HashEntry(int data, HashEntry next)
        {
            this.data = data;
            this.next = next;
        }

        public int getData()
        {
            return data;
        }

        public HashEntry getNext()
        {
            return next;
        }

        public void setData(int data)
        {
            this.data = data;
        } 

        public void setNext(HashEntry next)
        {
            this.next = next;
        }
    }
}