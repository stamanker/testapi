package ua.od.maxz.testapi.msgencodecode;

import java.util.Arrays;
import java.util.List;

/**
 * User: maxz
 * Date: 20.06.2016
 */

public class SpecificEntity {

    public List<String> data;

    public SpecificEntity() {
    }

    public SpecificEntity(String ... args) {
        data = Arrays.asList(args);
    }

    @Override
    public String toString() {
        return "SpecificEntity{" +
                "data=" + data +
                '}';
    }
}
