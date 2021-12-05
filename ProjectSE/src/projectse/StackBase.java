/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projectse;

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
    
   

    @Override
    public void addObserver(Observer o) {
        co.addObserver(o);
    }

    @Override
    public void clearChanged() {
        co.clearChanged();
    }

    @Override
    public int countObservers() {
        return co.countObservers();
    }

    @Override
    public void deleteObserver(Observer o) {
        co.deleteObserver(o);
    }

    @Override
    public void deleteObservers() {
        co.deleteObservers();
    }

    @Override
    public boolean hasChanged() {
        return co.hasChanged();
    }

    @Override
    public void notifyObservers() {
        co.notifyObservers();
    }

    @Override
    public void notifyObservers(Object arg) {
        co.notifyObservers(arg);
    }

    @Override
    public void setChanged() {
        co.setChanged();
    }

}
