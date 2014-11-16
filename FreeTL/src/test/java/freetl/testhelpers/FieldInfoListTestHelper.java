package freetl.testhelpers;

import freetl.util.FieldInfo;
import freetl.vo.FieldInfoVO;
import freetl.vo.type.DataType;

import java.util.ArrayList;
import java.util.List;

public class FieldInfoListTestHelper {



    public static  List<FieldInfoVO>  employeeFieldInfoList() {

        List<FieldInfoVO> fieldInfoVOs = new ArrayList<FieldInfoVO>();
        fieldInfoVOs.add(new FieldInfoVO("First Name", DataType.STRING, false, null));
        fieldInfoVOs.add(new FieldInfoVO("Wage", DataType.INTEGER, false, null));
        fieldInfoVOs.add(new FieldInfoVO("Raise", DataType.INTEGER, false, null));
        fieldInfoVOs.add(new FieldInfoVO("New Wage", DataType.INTEGER, false, null));

        fieldInfoVOs.add(new FieldInfoVO("Hours", DataType.DOUBLE, false, null));
        fieldInfoVOs.add(new FieldInfoVO("Days", DataType.DOUBLE, false, null));
        fieldInfoVOs.add(new FieldInfoVO("Total Hours", DataType.DOUBLE, false, null));
        //fieldTypes.add(new FieldType("Product", Double.class, false, null));

        return fieldInfoVOs;

    }
}
