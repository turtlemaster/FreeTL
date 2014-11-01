package freetl.io;

import au.com.bytecode.opencsv.CSVWriter;
import freetl.operation.Transform;

import java.io.IOException;
import java.io.PrintWriter;

public class SaveFeature {

    public void saveFileToDisk (Transform transform, String filename) throws IOException {

        TransformSeriliazer seriliazer = new TransformSeriliazer();
        String transformString = seriliazer.serializeTransform(transform);


        PrintWriter out = new PrintWriter("src/test/resources/" + filename);
        out.write(transformString);
        out.flush();
        out.close();
    }




}
