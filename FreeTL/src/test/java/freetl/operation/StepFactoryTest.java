package freetl.operation;


import freetl.vo.step.operation.input.CSVInputStepVO;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import freetl.runner.operation.input.CSVInput;

public class StepFactoryTest {

    StepFactory stepFactory;

    @Before
    public void setup() {
        stepFactory = new StepFactory();
    }

    @Test
    public void getStepWithCSVInputStepVOShouldReturnCSVInputStep() {
        CSVInputStepVO stepVO = new CSVInputStepVO("test/java/resources/simple.csv", false, null);
        Assert.assertEquals(CSVInput.class, stepFactory.getStep(stepVO).getClass());
    }



}
