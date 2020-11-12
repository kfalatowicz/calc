import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class Calc {


    public String calculate(String s){

        ScriptEngineManager mgr = new ScriptEngineManager();
        ScriptEngine engine = mgr.getEngineByName("JavaScript");

        Object o = new Object();
        try {
            o = engine.eval(s);
        } catch (ScriptException e) {
            e.printStackTrace();
        }

        return o.toString();
    }

}
