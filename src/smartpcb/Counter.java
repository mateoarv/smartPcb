
package smartpcb;

import java.util.PriorityQueue;

public class Counter 
{
    private final PriorityQueue<Integer> freeNumbers;
    private int index;
    
    public Counter()
    {
        freeNumbers = new PriorityQueue<>();
        index = 1;
    }
    public int getIndex()
    {
        if(freeNumbers.isEmpty())
            return index++;
        else
            return freeNumbers.poll();
    }
    public void removeIndex(int index)
    {
        freeNumbers.add(index);
    }
}
