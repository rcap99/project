
package complexcalculator.stack;

import complexcalculator.ComplexNumber;
import java.util.ConcurrentModificationException;
import java.util.EmptyStackException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Stack;

/**
 * This class extends the stack data structure of the java.util library providing a stack of
 *  {@link ComplexNumber} with the functionalities of dup, swap, over, clear and  drop 
 *  expected for our calculator
 * 
 * @see java.util
 * @see Stack
 * @author Group11
 */
public class ComplexStack extends StackBase implements Iterable<ComplexNumber>{
    private ObservableInterface co;
    /**
     *  Constructor of the class {@link ComplexStack} that calls the constructor of the generic stack data structure included in the {@link java.util} library
     *  @see ComplexStack
     */
    public ComplexStack() {
        super();
        co=new ComplexObservable();
    }
    
    /**
     *   This method pushes a copy of the last element.
     *   It allows us to operate on a copy of the last element.
     * 
     *   @throws EmptyStackException it throws an {@link EmptyStackException} if the stack is empty
     *  
     */
    public void dup()throws EmptyStackException{
        if (isEmpty()){
            throw new EmptyStackException();
        }
        ComplexNumber b=peek();
        push(b);
        setChanged();
        
    }
        
    /**
     *  This method exchanges the last two elements on the top of the stack.
     *  It allows us to change the order of the operations.
     *   
     * @throws EmptyStackException it throws an {@link EmptyStackException} if the stack is empty
     */
    public void swap() throws EmptyStackException{
        if(isEmpty()){
            throw new EmptyStackException();
        }
        ComplexNumber b1=pop();
        if(isEmpty()){
            throw new EmptyStackException();
        }
        ComplexNumber b2=pop();
        push(b1);
        push(b2);
        setChanged();
        
    }
    
    /**
     *  This method pushes a copy of the second last element on the top of the stack.
     *  It allows us to operate on a copy of the second last element.
     *  @throws EmptyStackException it throws an {@link EmptyStackException} if the stack is empty
     */
    public void over()throws EmptyStackException{
        if(isEmpty()){
            throw new EmptyStackException();
        }
        ComplexNumber last=pop();
        if(isEmpty()){
            push(last);
            throw new EmptyStackException();
        }
        ComplexNumber secondlast=pop();
        push(secondlast);
        push(last);
        push(secondlast);
        setChanged();
        
    }
    /**
    *   This method overrides the clear method of the {@link java.util} library.
    *   It allows us to insert new numbers in the stack.
    */
    @Override
    public void clear(){
        super.clear();
        setChanged();
        
    }
    
    /**
     *  This method removes the last element into the stack.
     *  It allows us to insert a new number if we chose the wrong one. 
     * @throws EmptyStackException it throws an {@link EmptyStackException} if the stack is empty
     */
    public void drop() throws EmptyStackException{
        if(isEmpty()){
            throw new EmptyStackException();
        }
        pop();
        setChanged();
        
    }
     /** This method returns a new ComplexStackIterator using a LIFO logic to iterate
     * the elements into the stack
     * 
     * @return new ComplexStackIterator
     */
    @Override
    public synchronized Iterator<ComplexNumber> iterator() {
        return new ComplexStackIterator();
    }
        
      private class ComplexStackIterator implements Iterator<ComplexNumber>{
        
        private int visited=0;
        private int currentPosition;
        private final int elementsInside;
        private final long initialCount;

        public ComplexStackIterator() {
            elementsInside=size();
            initialCount=elementCount;
            if(!isEmpty()){
                currentPosition=lastIndexOf(peek());
        }}
        
        
        @Override
        public boolean hasNext() {
            if(initialCount!=elementCount ){
                throw new ConcurrentModificationException();
            }
            return visited <elementsInside;
        }

        @Override
        public ComplexNumber next() {
            if(!hasNext()){
                throw new NoSuchElementException();
            }
            ComplexNumber cn=get(currentPosition);
            currentPosition--;
            visited++;
            return cn;
        }
    }
    
}
