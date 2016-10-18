/**
 * Created by Minwei Chen on 10/13/2016.
 */
import java.util.NoSuchElementException;

import java.util.*;

class PeekingIterator implements Iterator<Integer> {


    private boolean hasNext;
    private int top;
    private Iterator<Integer> iter;

    public PeekingIterator(Iterator<Integer> iterator) {
        // initialize any member here.
        iter = iterator;
        if(iter.hasNext()) {
            hasNext = true;
            top = iter.next();
        }
        else hasNext = false;
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        if(!hasNext) throw new NoSuchElementException();
        return top;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        if(!hasNext) throw new NoSuchElementException();

        int rs = top;

        if(iter.hasNext()) {
            hasNext = true;
            top = iter.next();
        }
        else hasNext = false;

        return rs;
    }

    @Override
    public boolean hasNext() {
        return hasNext;
    }
}