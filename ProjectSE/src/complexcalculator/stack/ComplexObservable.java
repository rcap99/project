package complexcalculator.stack;

import java.util.Observable;
import java.util.Observer;

/**
 * Concrete implementation of {@link ObservableInterface}.
 * @author Group11
 */
public class ComplexObservable extends Observable implements ObservableInterface{

    @Override
    public void addObserver(Observer o) {
        super.addObserver(o);
    }

    @Override
    public void clearChanged() {
        super.clearChanged();
    }

    @Override
    public int countObservers() {
        return super.countObservers();
    }

    @Override
    public void deleteObserver(Observer o) {
        super.deleteObserver(o);
    }

    @Override
    public void deleteObservers() {
        super.deleteObservers();
    }

    @Override
    public boolean hasChanged() {
        return super.hasChanged();
    }

    @Override
    public void notifyObservers() {
        super.notifyObservers();
    }

    @Override
    public void notifyObservers(Object arg) {
        super.notifyObservers(arg);
    }

    @Override
    public void setChanged() {
        super.setChanged();
    }
    
    
}
