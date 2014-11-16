package freetl.util;

import freetl.vo.FieldInfoVO;

import java.util.*;


public class DataCollection implements Iterable<Record> {

    private List<FieldInfoVO> fieldInfos;
    private List<Record> recordList;

    public DataCollection() {
        this.fieldInfos = new LinkedList<FieldInfoVO>();
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

    public void setFieldInfos(List<FieldInfoVO> types) {
        fieldInfos.addAll(types);
    }

    public List<FieldInfoVO> getFieldInfos() {
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
