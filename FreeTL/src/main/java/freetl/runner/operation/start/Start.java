package freetl.runner.operation.start;

import freetl.descriptor.StepDescriptor;
import freetl.descriptor.StepParameterDescriptor;
import freetl.util.DataCollection;
import freetl.exceptions.StepException;
import freetl.operation.AbstractStep;
import freetl.vo.step.StepVO;
import freetl.vo.step.operation.start.StartStepVO;

import java.util.ArrayList;
import java.util.List;

public class Start extends AbstractStep {

    public Start(StartStepVO startStepVO) {
        super(startStepVO);
    }

    @Override
    public DataCollection run(DataCollection data) throws StepException {
        return data;
    }


    @Override
    public StepDescriptor getDescriptor() {
       List<StepParameterDescriptor> params = new ArrayList<StepParameterDescriptor>();
       params.add(new StepParameterDescriptor("Start", "So it begins"));

        return new StepDescriptor(params, getStepLabel(), parameters.getId());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AbstractStep that = (AbstractStep) o;

        if (parameters != null ? !parameters.equals(that.getParameters()) : that.getParameters() != null) return false;

        return true;
    }


    @Override
    public int hashCode() {
        return parameters != null ? parameters.hashCode() : 0;
    }

    @Override
    public String
    toString() {
        return "StartStep{" +
                "parameters=" + parameters +
                '}';
    }

    public static class Parameters extends  AbstractParameters {
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            AbstractStep.Parameters that = (AbstractStep.Parameters) o;

            return true;
        }


        @Override
        public int hashCode() {
            return  0;
        }

        @Override
        public String
        toString() {
            return "StartStep.Parameters{}";
        }

    }




}
