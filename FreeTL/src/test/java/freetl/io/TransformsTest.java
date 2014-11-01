package freetl.io;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class TransformsTest {

    @Test
    public void WhenfilesAreLoadedFromADirectoryTheNumberShouldMatchTheNumberofFilesInTheDirectory () {

        List<String> fileNames = Transforms.getTransformFilenames("src/test/resources");
        Assert.assertEquals(fileNames.size(), 4);

    }
}
