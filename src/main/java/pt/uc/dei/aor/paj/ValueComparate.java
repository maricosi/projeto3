package pt.uc.dei.aor.paj;

import java.util.Comparator;
import java.util.Map;

class ValueComparate implements Comparator<String> {

    Map<String, Operador> base;
    
    public ValueComparate(Map<String, Operador> base) {
        this.base = base;
    }

     
    public int compare(String a, String b) {
        if (base.get(a).quant.get() >= base.get(b).quant.get()) {
            return -1;
        } else {
            return 1;
        } 
    }
}