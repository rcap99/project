package complexcalculator.operation;

import java.util.List;

/**
 *Operation Interface
 *Supports the execute and modify commands
 * @author Group11
 */
public interface Operation {
    public void modify(String s) throws Exception;
    public List<String> getOperations();
}
