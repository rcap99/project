/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package projectse;


public interface Stack<E> {
    
    public boolean isFull();
    public boolean isEmpty();
    public void push(E e);
    public E pop();
    public E top();
    public int size();
    public int length();
    
}
