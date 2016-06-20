package ua.od.maxz.testapi.msgencodecode.commands;

import org.codehaus.jackson.annotate.JsonGetter;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonSetter;
import ua.od.maxz.testapi.msgencodecode.Command;
import ua.od.maxz.testapi.msgencodecode.IReq;
import ua.od.maxz.testapi.msgencodecode.SpecificEntity;

/**
 * User: maxz
 * Date: 20.06.2016
 */
public class CommandA implements IReq {

    /**
     * If make field 'public' - then getter/setter are not not necessary
     */
    private String data;
    public SpecificEntity specificEntity;

    /**
     * Empty constructor required
     */
    public CommandA() {
    }

    public CommandA(String arg, SpecificEntity se) {
        this.data = arg;
        this.specificEntity = se;
    }

    @Override
    @JsonProperty(value = "data")
    public Command getCommand() {
        return Command.A;
    }

    @JsonSetter
    public void setData(String data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "CommandA{" +
                "data='" + data + '\'' +
                ", specificEntity=" + specificEntity +
                '}';
    }
}
