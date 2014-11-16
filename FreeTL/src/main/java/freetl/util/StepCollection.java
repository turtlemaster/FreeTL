package freetl.util;

import freetl.operation.Step;
import freetl.runner.operation.start.Start;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class StepCollection {
    private List<Step> steps = new ArrayList<Step>();

    public void addStep(Step step) {
        steps.add(step);
    }

    public Step getStepWithId(int id) {
        for(Step s : steps){
            if (s.getStepVOId() == id){
                return s;
            }
        }
        return null;
    }

    public Step getStartStep(){
        for (Step s : steps) {
            if (s instanceof Start) {
                return s;
            }
        }
        return null;
    }


    public List<Step> getSteps() {
        return steps;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StepCollection that = (StepCollection) o;

        if (steps != null ? !steps.equals(that.steps) : that.steps != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return steps != null ? steps.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "StepCollection{" +
                "steps=" + steps +
                '}';
    }
}
