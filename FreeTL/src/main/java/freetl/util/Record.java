package freetl.util;
import java.util.List;

public class Record {

    public List<Object> data;

    public Record(List<Object> data) {
        this.data = data;
    }

    public List<Object> getData() {
        return data;
    }

    public Object getField(int i) {
        return data.get(i);
    }

    public void removeField(int i) {
        data.remove(i);

    }

    public void addField(Object obj){
        data.add(obj);
    }
    public void setField(int i, Object obj) {
        data.set(i, obj);
    }

    public int size() {
        return data.size();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Record record = (Record) o;

        if (data != null ? !data.equals(record.data) : record.data != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return data != null ? data.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Record{" +
                "data=" + data +
                '}';
    }
}
