package freetl.operation.input;

import freetl.descriptor.StepDescriptor;
import freetl.descriptor.StepParameterDescriptor;
import freetl.operation.AbstractStep;
import freetl.util.DataCollection;
import freetl.util.FieldInfo;
import freetl.util.Record;
import freetl.exceptions.StepException;
import freetl.vo.step.StepVO;

import java.util.ArrayList;
import java.util.List;

public class ConstantValueInput extends AbstractInput<StepVO, ConstantValueInput.Parameters> {


    public ConstantValueInput() {
    }

    @Override
    public DataCollection run(DataCollection data) throws StepException {
       //FIX LATER
       /* try {

            DataCollection dataCollection = new DataCollection();
            dataCollection.setFieldInfos(parameters.fieldInfo);

            for (int i = 0; i < parameters.inputData.size(); i++) {
                List<Object> processedInputData = new ArrayList<Object>();
                List<String> inputLine = parameters.inputData.get(i);

                for (int j = 0; j < inputLine.size(); j++) {
                    FieldInfo ft = parameters.fieldInfo.get(j);
                    processedInputData.add(this.convertToDataType(ft, inputLine.get(j).trim()));
                }
                dataCollection.add(new Record(processedInputData));
            }


            return dataCollection;
        } catch (Exception e) {
            throw new StepException(e);
        }*/

        return null;
    }


    @Override
    public StepDescriptor getDescriptor() {
        List<StepParameterDescriptor> params = new ArrayList<StepParameterDescriptor>();
        params.add(new StepParameterDescriptor("Input Data", "Bleep Blood Blup"));
        params.add(new StepParameterDescriptor("FieldTypes", " Go Go Gobots"));
        return new StepDescriptor(params, getStepLabel(), parameters.getId());
    }

    public static class Parameters extends AbstractStep.AbstractParameters {
        private List<List<String>> inputData;
        private List<FieldInfo> fieldInfo;


        public Parameters(List<FieldInfo> fieldInfo, List<List<String>> inputData) {
            this.fieldInfo = fieldInfo;
            this.inputData = inputData;
        }


    }
}
