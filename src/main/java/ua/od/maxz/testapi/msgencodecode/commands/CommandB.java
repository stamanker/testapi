package ua.od.maxz.testapi.msgencodecode.commands;

import ua.od.maxz.testapi.msgencodecode.Command;
import ua.od.maxz.testapi.msgencodecode.IReq;

/**
 * User: maxz
 * Date: 20.06.2016
 */
public class CommandB implements IReq {

    int data;

    public CommandB(int arg) {
        this.data = arg;
    }

    @Override
    public Command getCommand() {
        return Command.B;
    }

    @Override
    public String toString() {
        return "CommandB{" +
                "data=" + data +
                '}';
    }
}
