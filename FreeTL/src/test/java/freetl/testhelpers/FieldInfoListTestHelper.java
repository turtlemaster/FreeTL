package freetl.testhelpers;

import freetl.util.FieldInfo;

import java.util.ArrayList;
import java.util.List;

public class FieldInfoListTestHelper {

    public static List<FieldInfo> employeeFieldInfoList() {
        List<FieldInfo> fieldInfos = new ArrayList<FieldInfo>();
        fieldInfos.add(new FieldInfo("First Name", String.class, false, null));
        fieldInfos.add(new FieldInfo("Wage", Integer.class, false, null));
        fieldInfos.add(new FieldInfo("Raise", Integer.class, false, null));
        fieldInfos.add(new FieldInfo("New Wage", Integer.class, false, null));

        fieldInfos.add(new FieldInfo("Hours", Double.class, false, null));
        fieldInfos.add(new FieldInfo("Days", Double.class, false, null));
        fieldInfos.add(new FieldInfo("Total Hours", Double.class, false, null));
        //fieldTypes.add(new FieldType("Product", Double.class, false, null));

         return fieldInfos;

    }

    public static List<FieldInfo> threeItemFieldTypeList() {

        List<FieldInfo> fieldInfos = new ArrayList<FieldInfo>();
        fieldInfos.add(new FieldInfo("First Name", String.class, false, null));
        fieldInfos.add(new FieldInfo("Wage", Integer.class, false, null));
        fieldInfos.add(new FieldInfo("Raise", Integer.class, false, null));
        return fieldInfos;

    }
}
