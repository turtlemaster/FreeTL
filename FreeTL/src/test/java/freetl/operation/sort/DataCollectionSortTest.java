package freetl.operation.sort;

import freetl.vo.FieldInfoVO;
import freetl.vo.type.DataType;
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
   //FIX LATER
   /* DataCollection testCollection;

    RecordComparator testComparator;
    SortKey key1;
    SortKey key2;

    List<SortKey> stringFirstKeyList;
    List<SortKey> intFirstKeyList;
    List<SortKey> emptyKeyList;
    List<FieldInfoVO> fieldInfos;

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

       fieldInfos = new ArrayList<FieldInfoVO>();
       fieldInfos.add(new FieldInfoVO("First Name", DataType.STRING, false, null));
       fieldInfos.add(new FieldInfoVO("Wage", Integer.class, false, null));

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

*/

}
