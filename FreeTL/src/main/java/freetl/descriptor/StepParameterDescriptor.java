package freetl.descriptor;

public class StepParameterDescriptor {
    String name;
    Object value;

    public StepParameterDescriptor() {
    }

    public StepParameterDescriptor(String name, Object value) {
        this.name = name;
        this.value = value;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "StepParameterDescriptor{" +
                "name='" + name + '\'' +
                ", value=" + value +
                '}';
    }
}
