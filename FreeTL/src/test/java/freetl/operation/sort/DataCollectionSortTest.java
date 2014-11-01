package freetl.operation.sort;

import org.junit.Before;
import org.junit.Test;
import freetl.util.DataCollection;
import freetl.util.FieldInfo;
import freetl.util.Record;
import freetl.testhelpers.RecordsTestHelper;

import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertEquals;

public class DataCollectionSortTest {

    DataCollection testCollection;

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
       amyRecord   = RecordsTestHelper.newSimpleRecord("Amy", "Pond", 20);
       karenRecord = RecordsTestHelper.newSimpleRecord("Karen", "Doppler", 30);

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

       testCollection = new DataCollection();
       testCollection.setFieldInfos(fieldInfos);
       testCollection.add(amyRecord);
       testCollection.add(karenRecord);


   }

   @Test
   public void shouldSortDataCollectionAccordingToSortKeys() {
       testCollection.sort(testComparator);

       assertEquals(amyRecord, testCollection.getRecord(0));
       assertEquals(karenRecord, testCollection.getRecord(1));


   }



}
