package freetl.vo.step.operation.input;


import freetl.runner.operation.input.CSVInput;
import freetl.util.FieldInfo;
import freetl.vo.FieldInfoVO;
import freetl.vo.step.StepVO;
import freetl.vo.type.DataType;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@DiscriminatorValue("csv_input")
@Table(name="ft_Step_CSV_Input")
public class CSVInputStepVO extends StepVO {

    @Column
    private String filename;

    @Column
    private boolean hasHeader;

    public CSVInputStepVO() {


    }

    /*public CSVInputStepVO(String filename, boolean hasHeader, List<FieldInfoVO> fieldInfoVOList){
       this.filename = filename;
       this.hasHeader = hasHeader;
       this.setFieldInfoList(fieldInfoVOList);
   }*/

    public String getFilename() {
        return "/Users/turtlemaster/Programming/FreeTL/src/test/resources/simple.csv";
        /*return filename;
        * /Users/turtlemaster/Programming/FreeTL*/
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public boolean hasHeader() {
        return hasHeader;
    }

    public void setHasHeader(boolean hasHeader) {
        this.hasHeader = hasHeader;
    }

    public List<FieldInfoVO> getFieldInfoList(){
        //FIX LATER
        List<FieldInfoVO> fieldInfoVOs = new ArrayList<FieldInfoVO>();
        fieldInfoVOs.add(new FieldInfoVO("First Name", DataType.STRING, false, null));
        fieldInfoVOs.add(new FieldInfoVO("Colour", DataType.STRING, false, null));
        fieldInfoVOs.add(new FieldInfoVO("Candy", DataType.STRING, false, null));
        fieldInfoVOs.add(new FieldInfoVO("Houses", DataType.INTEGER, false, null));
        fieldInfoVOs.add(new FieldInfoVO("Date", DataType.DATE, true, "MMM dd, yyyy"));
        fieldInfoVOs.add(new FieldInfoVO("Number", DataType.NUMBER, true, "#.##"));
        return fieldInfoVOs;
    }


}
