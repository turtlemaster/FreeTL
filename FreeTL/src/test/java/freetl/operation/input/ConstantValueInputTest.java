package freetl.operation.input;

import freetl.operation.StepFactory;
import org.junit.Assert;
import org.junit.Test;
import freetl.util.DataCollection;
import freetl.util.FieldInfo;
import freetl.exceptions.StepException;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertSame;

public class ConstantValueInputTest {

    @Test
    public void runShouldAddFieldTypeToReturnedDataCollection() throws StepException {
        List<FieldInfo> fieldInfos = new ArrayList<FieldInfo>();
        fieldInfos.add(new FieldInfo("bob", String.class, false, null));

        ConstantValueInput.Parameters parameters = new ConstantValueInput.Parameters(fieldInfos, new ArrayList<List<String>>());



        DataCollection testData = new DataCollection();
        DataCollection dataCollection = StepFactory.getInstance().getStep(parameters).run(testData);

        Assert.assertEquals(fieldInfos, dataCollection.getFieldInfos());
    }


}
