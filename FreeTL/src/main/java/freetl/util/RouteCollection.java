package freetl.util;

import freetl.operation.Route;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class RouteCollection {

    private List<Route> routes = new ArrayList<Route>();

    public void addRoute(Route route) {
        routes.add(route);
    }

    public void addRoutes(List<Route> routes) {
        for(Route r : routes) {
            this.addRoute(r);
        }
    }

    public List<Route> getRoutesWithSource(UUID source) {
        List<Route> result = new ArrayList<Route>();

        for (Route r : routes) {
            if (r.getSource().equals(source)) {
                result.add(r);
            }
        }
        return result;
    }

    public List<Route> getRoutes() {
        return routes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RouteCollection that = (RouteCollection) o;

        if (routes != null ? !routes.equals(that.routes) : that.routes != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return routes != null ? routes.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "RouteCollection{" +
                "routes=" + routes +
                '}';
    }
}



