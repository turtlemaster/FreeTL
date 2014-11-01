package freetl.testhelpers;


import freetl.operation.Step;
import freetl.operation.StepFactory;
import freetl.operation.input.CSVInput;
import freetl.operation.output.CSVOutput;
import freetl.operation.util.StartStep;
import freetl.util.StepCollection;

public class StepCollectionTestHelper {

    public static StepCollection stepCollection (){
        Step step0 = StepFactory.getInstance().getStep(new StartStep.Parameters());
        CSVInput step1 = (CSVInput) StepFactory.getInstance().getStep(new CSVInput.Parameters("test/java/resources/simple.csv", false, FieldInfoListTestHelper.employeeFieldInfoList()));
        CSVOutput step2 = (CSVOutput) StepFactory.getInstance().getStep(new CSVOutput.Parameters("test/java/resources/TestOutput.csv", FieldInfoListTestHelper.employeeFieldInfoList()));

        StepCollection steps = new StepCollection();
        steps.addStep(step0);
        steps.addStep(step1);
        steps.addStep(step2);
        return steps;
    }
}
