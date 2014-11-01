package freetl.util;

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;


public class ListUtilTest {

    @Test
    public void trimmedElementsShouldRemoveWhitespace() throws Exception {
        List<String> names = new ArrayList<String>();

        String name1 = "      Name";
        names.add(name1);
        String name2 = "   Candy";
        names.add(name2);

        names = ListUtil.trimElements(names);

        List<String> expected = new ArrayList<String>();
        expected.add("Name");
        expected.add("Candy");

        assertEquals(expected, names);

    }
}
