package freetl.operation;

import freetl.descriptor.StepDescriptor;
import freetl.util.DataCollection;
import freetl.exceptions.StepException;


import java.util.UUID;

public interface Step<T extends Step.Parameters> {

    DataCollection run(DataCollection data) throws StepException;
//     UUID getId();

    T getParameters();
    void setParameters(T parameters);

    interface Parameters {
        public UUID getId();
    }

    public String getStepLabel();

    public void setStepLabel(String label);

    public StepDescriptor getDescriptor();


}

