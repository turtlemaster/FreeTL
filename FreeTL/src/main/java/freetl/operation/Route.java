package freetl.operation;

import java.util.UUID;

public class Route {

    private UUID source;
    private UUID destination;

    public Route(UUID source, UUID destination) {
        this.source = source;
        this.destination = destination;
    }

    public UUID getSource() {
        return source;
    }

    public UUID getDestination() {
        return destination;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Route route = (Route) o;

        if (destination != null ? !destination.equals(route.destination) : route.destination != null) return false;
        if (source != null ? !source.equals(route.source) : route.source != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = source != null ? source.hashCode() : 0;
        result = 31 * result + (destination != null ? destination.hashCode() : 0);
        return result;
    }
}
