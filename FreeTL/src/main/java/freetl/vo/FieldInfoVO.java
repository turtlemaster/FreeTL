package freetl.vo;

import freetl.vo.step.StepVO;
import freetl.vo.type.DataType;

import javax.persistence.*;


@Entity
@Table(name="ft_fieldinfo")
public class FieldInfoVO {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String name;

    @Column
    @Enumerated(EnumType.STRING)
    private DataType type;

    @Column
    private Boolean usesFormat;
    @Column
    private String format;

    @ManyToOne
    @JoinColumn(name = "step_id", insertable = true, updatable = false)
    StepVO step;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DataType getType() {
        return type;
    }

    public void setType(DataType type) {
        this.type = type;
    }

    public Boolean getUsesFormat() {
        return usesFormat;
    }

    public void setUsesFormat(Boolean usesFormat) {
        this.usesFormat = usesFormat;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public StepVO getStep() {
        return step;
    }

    public void setStep(StepVO step) {
        this.step = step;
    }
}
