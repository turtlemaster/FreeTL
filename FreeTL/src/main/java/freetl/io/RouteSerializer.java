package freetl.io;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.ObjectMapper;
import freetl.operation.Route;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class RouteSerializer<T extends Route> {

    public String serializeRoutes(List<Route> routes) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        List<String> stringList = new ArrayList<String>();


        for (Route route : routes){
            stringList.add(this.serializeRoute(route));
        }


        return mapper.writeValueAsString(stringList);

    }

    public String serializeRoute(Route route) throws IOException {

        ObjectMapper mapper = new ObjectMapper();
        List<UUID> routeIds = new ArrayList<UUID>();
        routeIds.add(route.getSource());
        routeIds.add(route.getDestination());


        List<String> stringList = new ArrayList<String>();

        for (UUID id: routeIds){
           String serializedString = this.serializeRouteID(mapper, id);
           stringList.add(serializedString);

        }

        return mapper.writeValueAsString(stringList);

    }

   public Route deseriliazeRoute(String s) throws IOException {
       List<UUID> ids = this.deserializeRouteUUIDs(s);

       return new Route(ids.get(0), ids.get(1));

   }

    public List<Route> deseriliazeRoutes(String routesString) throws IOException {
        ObjectMapper mapper = new ObjectMapper();

        List<Route> routes = new ArrayList<Route>();
        List<String> stringList = mapper.readValue(
                routesString,
                mapper.getTypeFactory().constructCollectionType(List.class, String.class));

        for (String s : stringList) {
            routes.add(this.deseriliazeRoute(s));
        }

       return routes;

    }



    public String serializeRouteUUIDs(List<UUID> ids) throws IOException {
        List<String> stringList = new ArrayList<String>();
        ObjectMapper mapper = new ObjectMapper();

        for (UUID id : ids) {
            String idString = this.serializeRouteID(mapper, id);
            stringList.add(idString);
        }

        return mapper.writeValueAsString(stringList);


    }

    public List<UUID> deserializeRouteUUIDs(String routeUUIDs) throws IOException {

        ObjectMapper mapper = new ObjectMapper();

        List<String> stringList = mapper.readValue(
                routeUUIDs,
                mapper.getTypeFactory().constructCollectionType(List.class, String.class));

        List<UUID> listUUIDs = new ArrayList<UUID>();

         for (String s: stringList){
             UUID id = this.deserializeUUID(mapper, s);
             listUUIDs.add(id);

         }


        return listUUIDs;
    }






    protected String serializeRouteID(ObjectMapper mapper, UUID UUID) throws IOException {

        return mapper.writeValueAsString(UUID);
    }

    protected UUID deserializeUUID(ObjectMapper mapper, String stringUUID) throws IOException {

        return mapper.readValue(stringUUID, UUID.class);
    }
}
