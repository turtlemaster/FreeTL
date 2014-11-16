package freetl.operation;

import java.util.UUID;

public class Route {

    private int source;
    private int destination;

    public Route(int source, int destination) {
        this.source = source;
        this.destination = destination;
    }

    public int getSource() {
        return source;
    }

    public int getDestination() {
        return destination;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Route route = (Route) o;

        if (destination != route.destination) return false;
        if (source != route.source) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = source;
        result = 31 * result + destination;
        return result;
    }
}
