package ua.od.maxz.testapi.msgencodecode;

/**
 * Transport message/entity
 * User: maxz
 */
public class TransportEntity {

    public String className;
    public String msgJson;

    public TransportEntity() {
    }

    public TransportEntity(String className, String msgJson) {
        this.className = className;
        this.msgJson = msgJson;
    }

    public TransportEntity(Class clazz, String msgJson) {
        this(clazz.getName(), msgJson);
    }

    public String toString() {
        return "TransMsg{className=\'" + this.className + '\'' + ", msgJson=\'" + this.msgJson + '\'' + '}';
    }
}