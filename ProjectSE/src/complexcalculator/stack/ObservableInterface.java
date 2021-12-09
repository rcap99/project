package complexcalculator.stack;

import java.util.Observer;

/**
 * This interface provides the signature for the methods of the {@link java.util.Observable} class
 * @author Group11
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
