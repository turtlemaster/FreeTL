package freetl.operation.remove;

import freetl.descriptor.StepDescriptor;
import freetl.descriptor.StepParameterDescriptor;
import freetl.util.DataCollection;
import freetl.util.Record;
import freetl.exceptions.StepException;
import freetl.operation.AbstractStep;

import java.util.ArrayList;
import java.util.List;

public class RetainCols extends AbstractStep<RetainCols.Parameters> {

    public RetainCols() { }

    @Override
    public DataCollection run(DataCollection data) throws StepException {

        //Want to make a list of indexes of the cols to be retained
        List<Integer> colIndex = new ArrayList<Integer>();


        for (String fieldName : parameters.retainedCols) {
            for (int i = 0; i < data.getFieldInfos().size(); i++) {
                if (data.getFieldInfos().get(i).getFieldname().equals(fieldName)) {
                    colIndex.add(i);
                }
            }
        }
        //Remove any cols not to be retained

        for (int i = data.getFieldInfos().size() - 1; i >= 0; i--) {
            if (!colIndex.contains(i)) {
                data.removeFieldType(i);
            }
        }


        for (Record cols : data) {
            for (int i = cols.size() - 1; i >= 0; i--) {
                Integer testInt = i;
                if (!colIndex.contains(testInt)) {
                    cols.removeField(i);
                }
            }
        }


        return data;
    }

    @Override
    public StepDescriptor getDescriptor() {
        List<StepParameterDescriptor> params = new ArrayList<StepParameterDescriptor>();
        params.add(new StepParameterDescriptor("Retained Columns", "1,2,3"));
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
        return "RemoveColsStep {" +
                "parameters = " + parameters +
                '}';
    }


    public static class Parameters  extends AbstractStep.AbstractParameters {
        private List<String> retainedCols;

        public Parameters(List<String> retainedCols) {
           this.retainedCols = retainedCols;
        }


        public Parameters() {
        }

        public List<String> getRetainedCols() {
            return retainedCols;
        }

        public void setRetainedCols(List<String> retainedCols) {
            this.retainedCols = retainedCols;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Parameters that = (Parameters) o;

            if (retainedCols != null ? !retainedCols.equals(that.retainedCols) : that.retainedCols != null)
                return false;

            return true;
        }

        @Override
        public int hashCode() {
            return retainedCols != null ? retainedCols.hashCode() : 0;
        }

        @Override
        public String toString() {
            return getClass().getName() + "{" +
                    "retainedCols=" + retainedCols +
                    '}';
        }
    }





}