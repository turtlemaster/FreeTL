package freetl.operation.input;

import freetl.testhelpers.FieldInfoListTestHelper;
import org.junit.Assert;
import org.junit.Test;
import freetl.util.FieldInfo;
import freetl.operation.StepFactory;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class CSVInputTest {

    @Test
    public void createFieldsTypesForNumberOfColumnsShouldCreateNColumns() throws Exception {
        CSVInput testInput = (CSVInput) StepFactory.getInstance().getStep(new CSVInput.Parameters(null, false, null));

        List<FieldInfo> testList = testInput.createFieldsTypesForNumberOfColumns(3);


        assertEquals(testList.size(), 3);

        assertEquals("2", testList.get(1).getFieldname());


    }

    @Test
    public void createFieldTypesFromHeaderShouldCreateColumnsWithLabelsFromTheHeader() throws Exception {

        String[] tests = new String[]{"A", "V", "D"};


        CSVInput testInput = (CSVInput) StepFactory.getInstance().getStep(new CSVInput.Parameters(null, true, null));
        List<FieldInfo> testList = testInput.createFieldTypesFromHeader(tests);

        assertEquals(testList.size(), 3);
        assertEquals("A", testList.get(0).getFieldname());
        assertEquals("V", testList.get(1).getFieldname());
        assertEquals("D", testList.get(2).getFieldname());
    }

    @Test
    public void theDefaultStepLabelShouldBeTheStepName() {

        CSVInput testInput = (CSVInput) StepFactory.getInstance().getStep(new CSVInput.Parameters(null, false, null));

        String defaultLabel = testInput.getStepLabel();
        Assert.assertEquals("CSVInput", defaultLabel);
    }

    @Test
    public void settingTheStepLabelShouldChangeItToTheDesiredString() {
        CSVInput testInput = (CSVInput) StepFactory.getInstance().getStep(new CSVInput.Parameters(null, false, null));
        testInput.setStepLabel("CSVInput - Test");
        Assert.assertEquals("CSVInput - Test", testInput.getStepLabel());

    }

    @Test
    public void addingAFieldTypeAtAnIndexShouldInsertTheFieldTypeIntoTheFieldTypeList() {
        CSVInput testInput = (CSVInput) StepFactory.getInstance().getStep(new CSVInput.Parameters(null, false, FieldInfoListTestHelper.employeeFieldInfoList()));

        FieldInfo fieldInfo = new FieldInfo("video", String.class, false, null);

        testInput.addFieldType(fieldInfo, 3);
        Assert.assertEquals(testInput.getParameters().getFieldInfos().size(), 8);
        Assert.assertEquals(testInput.getParameters().getFieldInfos().get(3), fieldInfo);
    }

    @Test
    public void whenAFieldTypeIsRemovedItShouldNoLongerBePresentInTheFieldTypeList () {
        CSVInput testInput = (CSVInput) StepFactory.getInstance().getStep(new CSVInput.Parameters(null, false, FieldInfoListTestHelper.employeeFieldInfoList()));
        testInput.removeFieldType(5);
        Assert.assertEquals(testInput.getParameters().getFieldInfos().size(), 6);

    }

}
