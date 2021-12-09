package complexcalculator.stack;

import complexcalculator.ComplexNumber;
import java.util.Collection;
import java.util.Comparator;
import java.util.Observer;
import java.util.Stack;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

/**
 *
 * @author Group11
 */
public class StackBase extends Stack<ComplexNumber> implements ObservableInterface{
    private ObservableInterface co;
    
    /**
     *
     */
    public StackBase() {
        super();
        co=new ComplexObservable();
    }

    @Override
    public synchronized ComplexNumber peek() {
        ComplexNumber returnValue= super.peek(); //To change body of generated methods, choose Tools | Templates.
        
        return returnValue;
    }

    @Override
    public synchronized ComplexNumber pop() {
        ComplexNumber returnValue=super.pop(); //To change body of generated methods, choose Tools | Templates.
        setChanged();
       
        return returnValue;
    }

    @Override
    public ComplexNumber push(ComplexNumber item) {
        ComplexNumber returnValue=super.push(item); //To change body of generated methods, choose Tools | Templates.
        setChanged();
        
        return returnValue;
    }

    @Override
    public synchronized void sort(Comparator<? super ComplexNumber> c) {
        super.sort(c); //To change body of generated methods, choose Tools | Templates.
        setChanged();
        
    }

    @Override
    public synchronized void replaceAll(UnaryOperator<ComplexNumber> operator) {
        super.replaceAll(operator); //To change body of generated methods, choose Tools | Templates.
        setChanged();
        
    }

    @Override
    public synchronized boolean removeIf(Predicate<? super ComplexNumber> filter) {
        boolean returnValue=super.removeIf(filter); //To change body of generated methods, choose Tools | Templates.
        setChanged();
        
        return returnValue;
    }

    @Override
    protected synchronized void removeRange(int fromIndex, int toIndex) {
        super.removeRange(fromIndex, toIndex); //To change body of generated methods, choose Tools | Templates.
        setChanged();
        
    }

    @Override
    public synchronized boolean addAll(int index, Collection<? extends ComplexNumber> c) {
        boolean returnValue=super.addAll(index, c); //To change body of generated methods, choose Tools | Templates.
        setChanged();
        
        return returnValue;
    }

    @Override
    public synchronized boolean retainAll(Collection<?> c) {
        boolean returnValue=super.retainAll(c); //To change body of generated methods, choose Tools | Templates.
        setChanged();
        
        return returnValue;
    }

    @Override
    public synchronized boolean removeAll(Collection<?> c) {
        boolean returnValue=super.removeAll(c); //To change body of generated methods, choose Tools | Templates.
        setChanged();
        
        return returnValue;
    }

    @Override
    public synchronized boolean addAll(Collection<? extends ComplexNumber> c) {
        boolean returnValue=super.addAll(c); //To change body of generated methods, choose Tools | Templates.
        setChanged();
        
        return returnValue;
    }

    @Override
    public void clear() {
        super.clear(); //To change body of generated methods, choose Tools | Templates.
        setChanged();
        
    }

    @Override
    public synchronized ComplexNumber remove(int index) {
        ComplexNumber returnValue=super.remove(index); //To change body of generated methods, choose Tools | Templates.
        setChanged();
        
        return returnValue;
    }

    @Override
    public void add(int index, ComplexNumber element) {
        super.add(index, element); //To change body of generated methods, choose Tools | Templates.
        setChanged();
        
    }

    @Override
    public boolean remove(Object o) {
        boolean returnValue=super.remove(o); //To change body of generated methods, choose Tools | Templates.
        setChanged();
        
        return returnValue;
    }

    @Override
    public synchronized boolean add(ComplexNumber e) {
        boolean returnValue=super.add(e); //To change body of generated methods, choose Tools | Templates.
        setChanged();
        
        return returnValue;
    }

    @Override
    public synchronized ComplexNumber set(int index, ComplexNumber element) {
        ComplexNumber returnValue=super.set(index, element); //To change body of generated methods, choose Tools | Templates.
        setChanged();
        
        return returnValue;
    }

    @Override
    public synchronized void removeAllElements() {
        super.removeAllElements(); //To change body of generated methods, choose Tools | Templates.
        setChanged();
        
    }

    @Override
    public synchronized boolean removeElement(Object obj) {
        boolean returnValue=super.removeElement(obj); //To change body of generated methods, choose Tools | Templates.
        setChanged();
        
        return returnValue;
    }

    @Override
    public synchronized void addElement(ComplexNumber obj) {
        super.addElement(obj); //To change body of generated methods, choose Tools | Templates.
        setChanged();
        
    }

    @Override
    public synchronized void insertElementAt(ComplexNumber obj, int index) {
        super.insertElementAt(obj, index); //To change body of generated methods, choose Tools | Templates.
        setChanged();
        
    }

    @Override
    public synchronized void removeElementAt(int index) {
        super.removeElementAt(index); //To change body of generated methods, choose Tools | Templates.
        setChanged();
       
    }

    @Override
    public synchronized void setElementAt(ComplexNumber obj, int index) {
        super.setElementAt(obj, index); //To change body of generated methods, choose Tools | Templates.
        setChanged();
        
    }

    @Override
    public synchronized void setSize(int newSize) {
        super.setSize(newSize); //To change body of generated methods, choose Tools | Templates.
        setChanged();
        
    }
    
    /**
     * Adds an observer to the set of observers for this object, provided that it is not the same as some observer already in the set.
     * @param o an observer to be added.
     */
    @Override
    public void addObserver(Observer o) {
        co.addObserver(o);
    }

    /**
     * Indicates that this object has no longer changed, or that it has already notified all of its observers of its most recent change, so that the hasChanged method will now return false.
     * This method is called automatically by the notifyObservers methods.
     * 
     */
    @Override
    public void clearChanged() {
        co.clearChanged();
    }

    /**
     * Returns the number of observers of this Observable object.
     * @return the number of observers of this object.
     */
    @Override
    public int countObservers() {
        return co.countObservers();
    }

    /**
     * Deletes an observer from the set of observers of this object. Passing null to this method will have no effect.
     * @param o the observer to be deleted.
     */
    @Override
    public void deleteObserver(Observer o) {
        co.deleteObserver(o);
    }

    /**
     * Clears the observer list so that this object no longer has any observers.
     */
    @Override
    public void deleteObservers() {
        co.deleteObservers();
    }

    /**
     * Tests if this object has changed.
     * @return true if and only if the setChanged method has been called more recently than the clearChanged method on this object; false otherwise.
     */
    @Override
    public boolean hasChanged() {
        return co.hasChanged();
    }

    /**
     * If this object has changed, as indicated by the hasChanged method, then notify all of its observers and then call the clearChanged method to indicate that this object has no longer changed.
     */
    @Override
    public void notifyObservers() {
        co.notifyObservers();
    }

    /**
     * If this object has changed, as indicated by the hasChanged method, then notify all of its observers and then call the clearChanged method to indicate that this object has no longer changed.
     * @param arg any object
     */
    @Override
    public void notifyObservers(Object arg) {
        co.notifyObservers(arg);
    }

    /**
     * Marks this Observable object as having been changed; the hasChanged method will now return true.
     */
    @Override
    public void setChanged() {
        co.setChanged();
    }

}
