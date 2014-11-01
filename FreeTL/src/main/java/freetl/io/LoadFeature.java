package freetl.io;

import freetl.operation.Transform;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LoadFeature {

    public Transform loadTransformFromFile(String filename) throws IOException {
        FileReader fileReader = new FileReader(filename);
        BufferedReader reader = new BufferedReader(fileReader);

        StringBuilder builder = new StringBuilder();

        String line = reader.readLine();
        while(line != null) {

            builder.append(line);
            line = reader.readLine();
        }

        String transformString = builder.toString();
        TransformSeriliazer seriliazer = new TransformSeriliazer();

        return seriliazer.deserializeTransform(transformString);


    }
}
