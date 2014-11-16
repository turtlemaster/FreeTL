package freetl.operation;

import freetl.descriptor.StepDescriptor;
import freetl.util.DataCollection;
import freetl.exceptions.StepException;
import freetl.vo.step.StepVO;


import java.util.UUID;

public interface Step<T extends StepVO, U extends Step.Parameters> {


    DataCollection run(DataCollection data) throws StepException;

    T getStepVO();
    int getStepVOId();



//     UUID getId();

    U getParameters();
    void setParameters(U parameters);

    interface Parameters {
        public UUID getId();
    }



    public String getStepLabel();

    public void setStepLabel(String label);

    public StepDescriptor getDescriptor();


}

