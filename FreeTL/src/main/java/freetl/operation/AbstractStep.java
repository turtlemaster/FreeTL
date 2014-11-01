package freetl.operation;

import java.util.UUID;

public abstract class AbstractStep<T extends AbstractStep.AbstractParameters> implements Step<T> {

    protected T parameters;

    @Override
    public T getParameters() {
        return parameters;
    }

    @Override
    public void setParameters(T parameters) {
        this.parameters = parameters;
    }

    public String getStepLabel()  {
        return parameters.getStepLabel();

    }

    public void setStepLabel (String label) {
        parameters.setStepLabel(label);
    }
    public static abstract class AbstractParameters implements Step.Parameters {
        private UUID id;
        protected String stepLabel;

        protected AbstractParameters() {
            id = UUID.randomUUID();
            stepLabel = getClass().getName().substring((getClass().getPackage().getName().length()+1), getClass().getName().indexOf("$"));



        }

        public UUID getId() {
            return id;
        }

        public void setId(UUID id) {
            this.id = id;
        }

        public String getStepLabel() {
            return stepLabel;
        }

        public void setStepLabel(String label) {
            this.stepLabel = label;
        }
    }

}
