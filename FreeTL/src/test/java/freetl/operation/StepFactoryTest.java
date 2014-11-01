package freetl.operation;

import freetl.testhelpers.StepTestHelper;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import freetl.operation.input.CSVInput;

public class StepFactoryTest {

    StepFactory stepFactory;

    @Before
    public void setup() {
        stepFactory = new StepFactory();
    }

    @Test
    public void getInstanceShouldReturnAStepFactory() {
        Assert.assertNotNull(StepFactory.getInstance());
    }

    @Test
    public void getStepWithNullParametersShouldReturnNull() {
        Assert.assertNull(stepFactory.getStep(null));
    }

    @Test
    public void getStepWithParameterShouldReturnStepForThatParameter() {
        Assert.assertEquals(StepTestHelper.class, stepFactory.getStep(new StepTestHelper.Parameters()).getClass());
    }

    @Test
    public void getStepWithParameterShouldReturnStepForThatParameter2() {
        Assert.assertEquals(CSVInput.class, stepFactory.getStep(new CSVInput.Parameters()).getClass());
    }

}
