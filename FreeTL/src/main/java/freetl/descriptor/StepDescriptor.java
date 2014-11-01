package freetl.descriptor;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class StepDescriptor {
    private List<StepParameterDescriptor> stepParameterDescriptorList;
    private String stepLabel;
    private String id;



    public StepDescriptor() {
        stepParameterDescriptorList = new ArrayList<StepParameterDescriptor>();
    }

    public StepDescriptor(List<StepParameterDescriptor> stepParameterDescriptorList, String label, UUID id) {
        this.stepParameterDescriptorList = stepParameterDescriptorList;
        this.stepLabel = label;
        this.id = id.toString();
    }

    public List<StepParameterDescriptor> getStepParameterDescriptorList() {
        return stepParameterDescriptorList;
    }

    public void setStepParameterDescriptorList(List<StepParameterDescriptor> stepParameterDescriptorList) {
        this.stepParameterDescriptorList = stepParameterDescriptorList;
    }

    public String getStepLabel() {
        return stepLabel;
    }


    public String getUUID() {
        return id;
    }

    public void setStepLabel(String stepLabel) {
        this.stepLabel = stepLabel;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }


    @Override
    public String toString() {
        return "StepDescriptor{" +
                "stepParameterDescriptorList=" + stepParameterDescriptorList +
                ", stepLabel='" + stepLabel + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}