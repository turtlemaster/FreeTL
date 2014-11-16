package freetl.operation.sort;

import freetl.descriptor.StepDescriptor;
import freetl.descriptor.StepParameterDescriptor;
import freetl.util.DataCollection;

import freetl.util.FieldInfo;
import freetl.exceptions.StepException;
import freetl.operation.AbstractStep;
import freetl.vo.step.StepVO;

import java.util.ArrayList;
import java.util.List;

public class Sort extends AbstractStep<StepVO, Sort.Parameters>{


    public Sort(Parameters parameters) {
        this.parameters = parameters;
    }


    @Override
    public DataCollection run(DataCollection data) throws StepException {

        RecordComparator comparator = new RecordComparator(parameters.keys,parameters.fieldInfos);
        data.sort(comparator);

        return data;
    }

    @Override
    public StepDescriptor getDescriptor() {
        List<StepParameterDescriptor> params = new ArrayList<StepParameterDescriptor>();
        params.add(new StepParameterDescriptor("Keys", "A B C"));
        params.add(new StepParameterDescriptor("Field Types", "Bugs Love Soda"));
        return  new StepDescriptor(params, getStepLabel(), parameters.getId());

    }

    public static class Parameters extends AbstractStep.AbstractParameters {
        private List<SortKey> keys;
        private List<FieldInfo> fieldInfos;

        public Parameters(List<SortKey> keys, List<FieldInfo> fieldInfos) {
            this.keys = keys;
            this.fieldInfos = fieldInfos;

        }

        public List<SortKey> getKeys() {
            return keys;
        }

        public void setKeys(List<SortKey> keys) {
            this.keys = keys;
        }

        public List<FieldInfo> getFieldInfos() {
            return fieldInfos;
        }

        public void setFieldInfos(List<FieldInfo> fieldInfos) {
            this.fieldInfos = fieldInfos;
        }
    }
}
