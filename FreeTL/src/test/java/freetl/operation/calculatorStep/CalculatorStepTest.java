package freetl.operation.calculatorStep;

import freetl.testhelpers.FieldInfoListTestHelper;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import freetl.util.DataCollection;
import freetl.util.FieldInfo;
import freetl.util.Record;
import freetl.exceptions.StepException;
import freetl.operation.StepFactory;
import freetl.operation.calculator.CalculatorStep;
import freetl.operation.calculator.OperationType;
import freetl.testhelpers.RecordsTestHelper;

import java.util.ArrayList;
import java.util.List;

public class CalculatorStepTest {

    Record scarletRecord;
    Record violetRecord;
    Record stanRecord;
    Record ethanRecord;


   List<FieldInfo> fieldInfos;
    DataCollection testCollection;

    List<String> addCols;
    List<String> subCols;
    List<String> multCols;
    List<String> divCols;

    String addDest;
    String subDest;
    String multDest;
    String divDest;

    @Before
    public void before() {

       scarletRecord = RecordsTestHelper.newEmployeeRecord("Scarlet", 20, 35, 0, 7.5, 5.0, 0.0);
       violetRecord = RecordsTestHelper.newEmployeeRecord("Violet", 15, 25, 0, 6.5, 6.0, 0.0);
       stanRecord = RecordsTestHelper.newEmployeeRecord("Stan", 40, 20, 0, 5.6, 0.0, 0.0);
       ethanRecord = RecordsTestHelper.newEmployeeRecord("Ethan", 90, 30, 0, 1.6, 0.0, 0.0);

        fieldInfos =  FieldInfoListTestHelper.employeeFieldInfoList();

        testCollection = new DataCollection();
        testCollection.setFieldInfos((List<FieldInfo>) fieldInfos);
        testCollection.add(scarletRecord);
        testCollection.add(violetRecord);
        testCollection.add(stanRecord);
        testCollection.add(ethanRecord);



        addCols = new ArrayList<String>();
        addCols.add("Wage");
        addCols.add("Raise");
        addDest = "New Wage";

        subCols = new ArrayList<String>();
        subCols.add("Raise");
        subCols.add("Wage");
        subDest = "New Wage";

        multCols = new ArrayList<String>();
        multCols.add("Hours");
        multCols.add("Days");
        multDest = ("Total Hours");

        divCols = new ArrayList<String>();
        divCols.add("Wage");
        divCols.add("Raise");
        divDest = "New Wage";

    }

    @Test
    public void whenTwoColumnsAreAddedTheResultColShouldContainTheSum() throws StepException {
    OperationType testOpType = OperationType.ADD;

    CalculatorStep testStep = (CalculatorStep) StepFactory.getInstance().getStep(new CalculatorStep.Parameters(addCols, testOpType, addDest));
    DataCollection resultColl = testStep.run(testCollection);

        Assert.assertEquals(55, scarletRecord.getField(3));
        Assert.assertEquals(40, violetRecord.getField(3));

    }

    @Test
    public void whenOneColIsSubtractedFromAnotherTheResultColShouldContainTheDifference() throws StepException {
        OperationType testOpType = OperationType.SUBTRACT;
        CalculatorStep  testStep = (CalculatorStep) StepFactory.getInstance().getStep(new CalculatorStep.Parameters(subCols, testOpType, subDest));
        DataCollection resultColl = testStep.run(testCollection);
        Assert.assertEquals(15, scarletRecord.getField(3));
        Assert.assertEquals(10, violetRecord.getField(3));
    }

    @Test
    public void whenOneColIsSubtractedFromAnotherWithoutASpecifiedResultColANewColShouldContainTheDifference() throws StepException{
        OperationType testOpType = OperationType.SUBTRACT;
        CalculatorStep  testStep = (CalculatorStep) StepFactory.getInstance().getStep(new CalculatorStep.Parameters(subCols, testOpType, null));
        DataCollection resultColl = testStep.run(testCollection);
        Assert.assertEquals(15, scarletRecord.getField(7));
        Assert.assertEquals(10, violetRecord.getField(7));
    }

    @Test
    public void whenTwoColsAreMultipliedTheResultColShouldContainTheProduct () throws StepException {
        OperationType testOpType = OperationType.MULTIPLY;
        CalculatorStep testStep = (CalculatorStep) StepFactory.getInstance().getStep(new CalculatorStep.Parameters(multCols, testOpType, multDest));
        DataCollection resultColl = testStep.run(testCollection);

        Assert.assertEquals(37.5, scarletRecord.getField(6));
        Assert.assertEquals(39.0, violetRecord.getField(6));


    }

    @Test
    public void whenOneColIsDividedByAnotherColTheResultColShouldContainTheQuotient () throws StepException {
        OperationType testOpType = OperationType.DIVIDE;
        CalculatorStep testStep = (CalculatorStep) StepFactory.getInstance().getStep(new CalculatorStep.Parameters(divCols, testOpType, divDest));
        DataCollection resultColl = testStep.run(testCollection);

        Assert.assertEquals(2, stanRecord.getField(3));
        Assert.assertEquals(3, ethanRecord.getField(3));

    }

    @Test
    public void whenOneColIsDividedByZeroResultColShouldBeNull  () throws StepException {
        OperationType testOpType = OperationType.DIVIDE;
        CalculatorStep testStep = (CalculatorStep) StepFactory.getInstance().getStep(new CalculatorStep.Parameters(multCols, testOpType, multDest));
        DataCollection resultColl = testStep.run(testCollection);

        Assert.assertNull(stanRecord.getField(6));
        Assert.assertNull(ethanRecord.getField(6));



    }

    @Test (expected = IllegalArgumentException.class)
    public void whenResultColIsInvalidExceptionShouldBeThrown () throws Exception {
        OperationType testOpType = OperationType.SUBTRACT;
        CalculatorStep  testStep = (CalculatorStep) StepFactory.getInstance().getStep(new CalculatorStep.Parameters(subCols, testOpType, "Not A Column"));
        DataCollection resultColl = testStep.run(testCollection);

    }
}