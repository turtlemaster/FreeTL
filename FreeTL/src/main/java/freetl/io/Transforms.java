package freetl.io;

import java.io.File;
import java.util.Arrays;
import java.util.List;

public class Transforms {


    public static List<String> getTransformFilenames(String directoryName) {
        File directory = new File(directoryName);
        return Arrays.asList(directory.list());
    }



}
