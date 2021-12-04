/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package projectse;

import java.util.Observer;

/**
 *
 * @author win10
 */
public interface ObservableInterface {
    public void addObserver(Observer o);
    void clearChanged();
    public int countObservers();
    public void deleteObserver(Observer o);
    public void deleteObservers();
    public boolean hasChanged();
    public void notifyObservers();
    public void notifyObservers(Object arg);
    void setChanged();
    
}
