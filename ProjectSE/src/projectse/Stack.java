/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package projectse;


public interface Stack<E> {
    
    public boolean isFull();
    public boolean isEmpty();
    public void push(E e) throws FullStackException;
    public E pop()throws EmptyStackException;
    public E top()throws EmptyStackException;
    public int size();
    public int length();
    public void incrementSize(int newSize);
}
