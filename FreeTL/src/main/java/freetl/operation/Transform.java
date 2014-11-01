package freetl.operation;

import freetl.util.DataCollection;
import freetl.exceptions.StepException;
import freetl.util.RouteCollection;
import freetl.util.StepCollection;
import freetl.vo.TransformVO;

import java.util.*;


public class Transform {

    StepCollection steps;
    RouteCollection routes;

    public Transform(StepCollection steps, RouteCollection routes) {
        this.steps = steps;
        this.routes = routes;

    }

    public StepCollection getStepCollection() {
        return steps;
    }

    public void setSteps(StepCollection steps) {
        this.steps = steps;
    }

    public RouteCollection getRouteCollection() {
        return routes;
    }

    public void setRoutes(RouteCollection routes) {
        this.routes = routes;
    }

    public void run() throws StepException {

        Step currentStep = steps.getStartStep();
        DataCollection currentData = currentStep.run(null);

        while(currentStep != null){
            List<Route> currentRoute= routes.getRoutesWithSource(currentStep.getParameters().getId());


            if (!currentRoute.isEmpty()) {
                currentStep = steps.getStepWithId(currentRoute.get(0).getDestination());
                currentData = currentStep.run(currentData);
            }
            else {
                currentStep = null;
            }
        }
    }

    public boolean containsCyclicRoute() {
        UUID startID = steps.getStartStep().getParameters().getId();
        return containsCyclicRoute(new HashSet<UUID>(), startID);
    }

    public boolean containsCyclicRoute(Set<UUID> visitedIds, UUID visitingNode) {

        if(visitedIds.contains(visitingNode)) {
            return true;
        }

        visitedIds.add(visitingNode);

        for(Route route: routes.getRoutesWithSource(visitingNode)) {
            UUID childNode = route.getSource();
            Set<UUID> copyIds = new HashSet<UUID>(visitedIds);
            if(containsCyclicRoute(copyIds, childNode)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "Transform{" +
                "steps=" + steps +
                ", routes=" + routes +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Transform transform = (Transform) o;

        if (routes != null ? !routes.equals(transform.routes) : transform.routes != null) return false;
        if (steps != null ? !steps.equals(transform.steps) : transform.steps != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = steps != null ? steps.hashCode() : 0;
        result = 31 * result + (routes != null ? routes.hashCode() : 0);
        return result;
    }
}
