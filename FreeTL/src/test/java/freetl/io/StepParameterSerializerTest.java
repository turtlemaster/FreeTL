package freetl.io;

import freetl.testhelpers.FieldInfoListTestHelper;
import org.junit.Assert;
import org.junit.Test;
import freetl.operation.AbstractStep;
import freetl.operation.StepFactory;
import freetl.operation.input.CSVInput;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StepParameterSerializerTest {

   /* private List<Object> saveAndLoadStep(AbstractStep testStep) throws IOException {

        List<Object> savedParams = new ArrayList<Object>();
        StepParameterSerializer saver = new StepParameterSerializer();
        String saveString = saver.saveStep(testStep);
        AbstractStep.AbstractParameters loadString  = saver.deSerialize(saveString, String.class);
        savedParams.add(saveString);
        savedParams.add(loadString);
        return savedParams;
    }*/


    @Test
    public void whenACSVInputStepIsSavedTheSavedStepShouldContainTheSameParameters() throws IOException {
        CSVInput testStep = (CSVInput) StepFactory.getInstance().getStep(new CSVInput.Parameters("CSV Test", false, FieldInfoListTestHelper.employeeFieldInfoList()));
        List<AbstractStep.AbstractParameters> parameters = new ArrayList<AbstractStep.AbstractParameters>();
        parameters.add(testStep.getParameters());

        StepParameterSerializer<AbstractStep.AbstractParameters> saver = new StepParameterSerializer<AbstractStep.AbstractParameters>();
        String saveString = saver.serializeStepParameters(parameters);

        List<AbstractStep.AbstractParameters> loadString = saver.deserializeStepParameters(saveString);

        Assert.assertEquals(parameters, loadString);

    }

    /*@Test
    public void  whenACSVOutputStepIsSavedTheSavedStepShouldContainTheSameParameters() throws IOException {

        CSVOutput testStep = new CSVOutput(new CSVOutput.Parameters("Name", FieldTypeList.employeeFieldTypeList()));
        List<String> savedSteps = this.saveAndLoadStep(testStep);
        Assert.assertEquals(savedSteps.get(0),savedSteps.get(1));


    }
    @Test
    public void whenACalculatorStepIsSavedTheSavedStepShouldContainTheSameParameters() throws IOException {

        List<String> strings = new ArrayList<String>();
        strings.add("One");
        strings.add("Two");

        String dest = "Three";
        OperationType type = OperationType.ADD;

        CalculatorStep testStep =new CalculatorStep(new CalculatorStep.Parameters(strings, type, dest));
        List<String> savedSteps = this.saveAndLoadStep(testStep);
        Assert.assertEquals(savedSteps.get(0), savedSteps.get(1));


    }

    @Test
    public void  whenARetainColsStepIsSavedTheSavedStepShouldContainTheSameParameters() throws IOException {
        List<String> strings = new ArrayList<String>();
        strings.add("One");
        strings.add("Two");

        RetainCols testStep = new RetainCols(new RetainCols.Parameters(strings));
        List<String> savedSteps = this.saveAndLoadStep(testStep);
        Assert.assertEquals(savedSteps.get(0),savedSteps.get(1));

    }

    @Test
    public void  whenARSortStepIsSavedTheSavedStepShouldContainTheSameParameters() throws IOException {

        List<SortKey> testKeyList = new ArrayList<SortKey>();
        SortKey key1 = new SortKey("First Name", SortKey.Order.ASCENDING);
        SortKey key2 = new SortKey("Wage", SortKey.Order.ASCENDING);
        testKeyList.add(key1);
        testKeyList.add(key2);


        Sort testStep = new Sort(new Sort.Parameters(testKeyList, FieldTypeList.employeeFieldTypeList()));
        List<String> savedSteps = this.saveAndLoadStep(testStep);
        Assert.assertEquals(savedSteps.get(0),savedSteps.get(1));

    }


    @Test
    public void whenMultipleStepsAreSavedThenLoadedBothVersionsShouldHaveTheSameParameters() throws IOException {
        CSVInput testInput = new CSVInput(new CSVInput.Parameters("CSV Test", false, FieldTypeList.employeeFieldTypeList()));
        CSVOutput testOutput = new CSVOutput(new CSVOutput.Parameters("Name", FieldTypeList.employeeFieldTypeList()));


        List<String> savedSteps = new ArrayList<String>();
        List<String> loadedSteps = new ArrayList<String>();

        List<AbstractStep> stepsForSaving = new ArrayList<AbstractStep>();
        stepsForSaving.add(testInput);
        stepsForSaving.add(testOutput);

        StepParameterSerializer saver = new StepParameterSerializer();

        for (int i = 0; i < stepsForSaving.size(); i++) {

            String saveString = saver.saveStep(stepsForSaving.get(i));
            savedSteps.add(saveString);

        }


        List<Object> stepsFromSaver = saver.loadSteps();

        for(int i = 0; i < stepsFromSaver.size(); i++){
            String loadString = (String)stepsFromSaver.get(i);
            loadedSteps.add(loadString);
        }

       for(int i = 0; i < savedSteps.size(); i++) {
           Assert.assertEquals(savedSteps.get(i), loadedSteps.get(i));
       }
    }

*/
}