/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projectse;

import java.util.ArrayList;


public class StackBase<E> implements Stack<E>{
    private E[] e;
    private int sp;
    
    public StackBase(int maxSize){
        e=new ArrayList<E>(maxSize).toArray(e);
        sp=0;
    }
    
    public StackBase(){
        e=new ArrayList<E>(100).toArray(e);
        sp=0;
    }

    @Override
    public boolean isFull() {
        return e.length==sp;
    }

    @Override
    public boolean isEmpty() {
        return sp==0;
    }

    @Override
    public void push(E e) throws FullStackException{
        if (isFull())
            throw new  FullStackException();
        this.e[sp++]=e;
    }

    @Override
    public E pop() throws EmptyStackException{
       if (isEmpty())
           throw new EmptyStackException();
       E e=this.e[--sp];
       this.e[sp]=null;
       return e;
    
    }

    @Override
    public E top() throws EmptyStackException{
        if (isEmpty())
           throw new EmptyStackException();
        return e[sp-1];
    }

    @Override
    public int size() {
        return e.length;
    }

    @Override
    public int length() {
        return sp;
    }

    @Override
    public void incrementSize(int newSize) {
        if(isFull()){
            E[] e1=new ArrayList<E>(newSize).toArray(e);
            for(int i=0;i<e.length;i++){
                e1[i]=e[i];
            }
            e=e1;                
            }
        }
            
    
    
    
}
