package freetl.testhelpers;

import freetl.descriptor.StepDescriptor;
import freetl.operation.Step;
import freetl.util.DataCollection;
import freetl.exceptions.StepException;

import java.util.UUID;

public class StepTestHelper implements Step<StepTestHelper.Parameters> {
    Parameters parameters = new Parameters();

    @Override
    public DataCollection run(DataCollection data) throws StepException {
        return data;
    }

    @Override
    public String getStepLabel() {
        return null;
    }

    @Override
    public void setStepLabel(String label) {

    }

    @Override
    public Parameters getParameters() {
        return parameters;
    }

    @Override
    public void setParameters(Parameters parameters) {
        this.parameters = parameters;
    }

    @Override
    public StepDescriptor getDescriptor() {
        return null;
    }

    public static class Parameters implements Step.Parameters {
        @Override
        public UUID getId() {
            return UUID.randomUUID();
        }


    }
}
