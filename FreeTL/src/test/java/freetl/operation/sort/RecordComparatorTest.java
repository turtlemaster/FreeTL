package freetl.operation.sort;

import org.junit.Before;
import org.junit.Test;
import freetl.util.FieldInfo;
import freetl.util.Record;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class RecordComparatorTest {

    RecordComparator testComparator;
    SortKey key1;
    SortKey key2;

    List<SortKey> stringFirstKeyList;
    List<SortKey> intFirstKeyList;
    List<SortKey> emptyKeyList;
    List<FieldInfo> fieldInfos;
    Record amyRecord;
    Record karenRecord;

    @Before
    public void before() {

        List<Object> objs1 = new ArrayList<Object>();
        objs1.add("Amy");
        objs1.add(100);

        List<Object> objs2 = new ArrayList<Object>();
        objs2.add("Karen");
        objs2.add(50);

        amyRecord = new Record(objs1);
        karenRecord = new Record(objs2);

        //make sortkeys
        emptyKeyList = new ArrayList<SortKey>();
        stringFirstKeyList = new ArrayList<SortKey>();
        key1 = new SortKey("First Name", SortKey.Order.ASCENDING);
        key2 = new SortKey("Wage", SortKey.Order.ASCENDING);
        stringFirstKeyList.add(key1);
        stringFirstKeyList.add(key2);

        intFirstKeyList = new ArrayList<SortKey>();
        intFirstKeyList.add(key2);
        intFirstKeyList.add(key1);

        fieldInfos = new ArrayList<FieldInfo>();
        fieldInfos.add(new FieldInfo("First Name", String.class, false, null));
        fieldInfos.add(new FieldInfo("Wage", Integer.class, false, null));


        testComparator = new RecordComparator(stringFirstKeyList, fieldInfos);
    }

    @Test
    public void shouldNotCrashWithEmptySortKeys (){
        testComparator = new RecordComparator(emptyKeyList, fieldInfos);

        int result = testComparator.compare(amyRecord, karenRecord);
        int expected = 0;
        assertEquals(expected, result);



    }


    @Test
    public void  shouldDoStringCompare () {
        int result = testComparator.compare(amyRecord, karenRecord);
        int expected = -1;
        assertEquals(expected, result);


    }

    @Test
    public void shouldDoIntCompare () {
        testComparator = new RecordComparator(intFirstKeyList, fieldInfos);
        int result = testComparator.compare(amyRecord, karenRecord);
        int expected = 1;
        assertEquals(expected, result);
    }
}
