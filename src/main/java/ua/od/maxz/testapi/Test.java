package ua.od.maxz.testapi;

/**
 * User: maxz
 * Date: 25.04.2016
 */
public class Test {
    public int id;
    public String data;

    public Test() {
    }

    public Test(int id, String data) {
        this.id = id;
        this.data = data;
    }

    @Override
    public String toString() {
        return "Test{" +
                "id=" + id +
                ", data='" + data + '\'' +
                '}';
    }
}
