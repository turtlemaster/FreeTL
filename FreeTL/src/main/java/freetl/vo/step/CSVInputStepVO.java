package freetl.vo.step;


import freetl.vo.step.StepVO;

import javax.persistence.*;

@Entity
@DiscriminatorValue("csv_input")
@Table(name="ft_Step_CSV_Input")
public class CSVInputStepVO extends StepVO {
    @Column
    private String filename;

    @Column
    private boolean hasHeader;

    public String getFilename() {
        return filename;
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


}
