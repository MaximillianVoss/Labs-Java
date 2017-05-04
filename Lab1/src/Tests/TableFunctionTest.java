package Tests;


import Main.TableFunction;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Map;


public class TableFunctionTest {
    private TableFunction t;
    ArrayList<Double> keys;
    ArrayList<Double> values;

    @Before
    public void Init() {
        t = new TableFunction();
        keys = new ArrayList<Double>();
        values = new ArrayList<Double>();
        for (double i = 0; i < 100; i += 0.5) {
            keys.add(i);
            values.add(i);
        }
        for (int i = 0; i < keys.size(); i++)
            t.Add(keys.get(i), values.get(i));
    }

    @Test
    public void get() throws Exception {
        for (double i = 0; i < 100; i++)
            org.junit.Assert.assertEquals((double) t.Get(i).getValue(), i, 1E-7);
        org.junit.Assert.assertEquals((double) t.Get(0.25).getValue(), 0, 1E-7);
        org.junit.Assert.assertEquals((double) t.Get(0.5).getValue(), 0.5, 1E-7);
    }

    @Test
    public void interPolation() throws Exception {
        for (double i = 1; i < 100; i++) {
            Object val = t.InterPolation(i);
            if (val != null)
                org.junit.Assert.assertEquals((double) ((Map.Entry) t.InterPolation(i)).getValue(), i, 1E-7);
        }
        org.junit.Assert.assertEquals((double) t.InterPolation(0).getValue(), 0, 1E-7);
        for (double i = -1; i > -100; i--)
            org.junit.Assert.assertEquals(t.InterPolation(i), null);
    }

}