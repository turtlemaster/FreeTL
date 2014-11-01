package freetl.util;


import java.util.ArrayList;
import java.util.List;

public class ListUtil {

    public static List<String> trimElements (List<String> inputList) {
         List<String> trimmedList = new ArrayList<String>();

        for (String s : inputList) {
            String trimmedString = s.trim();
            trimmedList.add(trimmedString);
        }

        return trimmedList;

    }
}
