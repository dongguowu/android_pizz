package ca.dongguo.pizza;

import java.io.Serializable;

public class Pizza implements Serializable {

    private String size;
    private String type;

    public Pizza() {
    }

    public Pizza(String size, String type) {
        this.size = size;
        this.type = type;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return size + " " + type
                 + '\n';
    }
}
