package freetl.testhelpers;


import freetl.operation.Step;
import freetl.operation.StepFactory;
import freetl.runner.operation.input.CSVInput;
import freetl.util.StepCollection;
import freetl.vo.step.operation.start.StartStepVO;
import freetl.vo.step.operation.input.CSVInputStepVO;

public class StepCollectionTestHelper {

    public static StepCollection stepCollection (){
        StartStepVO startStepVO = new StartStepVO();
        CSVInputStepVO csvInputStepVO = new CSVInputStepVO("test/java/resources/simple.csv", false, null);


        Step step0 = StepFactory.getInstance().getStep(startStepVO);
        CSVInput step1 = (CSVInput) StepFactory.getInstance().getStep(csvInputStepVO);
       // CSVOutput step2 = (CSVOutput) StepFactory.getInstance().getStep(new CSVOutput.Parameters("test/java/resources/TestOutput.csv", FieldInfoListTestHelper.employeeFieldInfoList()));

        StepCollection steps = new StepCollection();
        steps.addStep(step0);
        steps.addStep(step1);
        //steps.addStep(step2);
        return steps;


    }
}
