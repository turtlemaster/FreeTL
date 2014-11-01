package freetl.util;

import java.util.*;


public class DataCollection implements Iterable<Record> {

    private List<FieldInfo> fieldInfos;
    private List<Record> recordList;

    public DataCollection() {
        this.fieldInfos = new LinkedList<FieldInfo>();
        this.recordList = new LinkedList<Record>();
    }

    @Override
    public Iterator<Record> iterator() {
      return recordList.iterator();
    }

    public void sort(Comparator<Record> comparator) {

        Collections.sort(recordList, comparator);
    }

    public void add(Record record) {
        recordList.add(record);
    }

    public void setFieldInfos(List<FieldInfo> types) {
        fieldInfos.addAll(types);
    }

    public List<FieldInfo> getFieldInfos() {
        return fieldInfos;
    }

    public void removeFieldType(int i) {
        fieldInfos.remove(i);
    }

    public Record getRecord(int i) {
        return recordList.get(i);
    }

    public List<Record> getRecordList(){
        return recordList;
    }
}
