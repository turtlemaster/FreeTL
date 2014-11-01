package freetl.io;

import freetl.testhelpers.FieldInfoListTestHelper;
import org.junit.Assert;
import org.junit.Test;
import freetl.descriptor.StepDescriptor;
import freetl.descriptor.StepParameterDescriptor;
import freetl.operation.StepFactory;
import freetl.operation.input.CSVInput;

import java.util.List;

public class StepDescriptorTest {
    @Test
    public void whenACSVInputDescriptorIsCreatedItShouldContainThreeStepParameterDesciptors(){
        CSVInput step = (CSVInput) StepFactory.getInstance().getStep(new CSVInput.Parameters("test/java/resources/simple.csv", false, FieldInfoListTestHelper.employeeFieldInfoList()));


        StepDescriptor descriptor = step.getDescriptor();

        List<StepParameterDescriptor> params = descriptor.getStepParameterDescriptorList();

        Assert.assertEquals(params.size(), 3);
    }



    }
