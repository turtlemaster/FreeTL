package freetl.vo.step;

import freetl.util.FieldInfo;
import freetl.vo.FieldInfoVO;
import freetl.vo.TransformVO;
import freetl.vo.type.DataType;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "step_type")
@Table(name="ft_Step")
public abstract class StepVO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String name;

    @ManyToOne
    @JoinColumn(name = "transform_id", insertable = true, updatable = false)
    TransformVO transform;

    @OneToMany(mappedBy = "step", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    List<FieldInfoVO> fieldInfoList;

    protected StepVO() {
        //FIX LATER
        List<FieldInfoVO> fieldInfoVOs = new ArrayList<FieldInfoVO>();
        fieldInfoVOs.add(new FieldInfoVO("First Name", DataType.STRING, false, null));
        fieldInfoVOs.add(new FieldInfoVO("Colour", DataType.STRING, false, null));
        fieldInfoVOs.add(new FieldInfoVO("Candy", DataType.STRING, false, null));
        fieldInfoVOs.add(new FieldInfoVO("Houses", DataType.INTEGER, false, null));
        fieldInfoVOs.add(new FieldInfoVO("Date", DataType.DATE, true, "MMM dd, yyyy"));
        fieldInfoVOs.add(new FieldInfoVO("Number", DataType.NUMBER, true, "#.##"));
        fieldInfoList = fieldInfoVOs;

      //  fieldInfoList = new ArrayList<FieldInfoVO>();
    }

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

    public String getStepType() {
        return getClass().getSimpleName();
    }

    public TransformVO getTransform() {
        return transform;
    }

    public void setTransform(TransformVO transform) {
        this.transform = transform;
    }

    public void addFieldInfoVO(FieldInfoVO fieldInfo){

       fieldInfo.setStep(this);
       fieldInfoList.add(fieldInfo); }

    public void removeFieldInfoVO(FieldInfoVO fieldInfo) { fieldInfoList.remove(fieldInfo); }

    public List<FieldInfoVO> getFieldInfoList() {
        // return fieldInfoList;
        List<FieldInfoVO> list = new ArrayList<FieldInfoVO>();
        list.add(new FieldInfoVO());
        return list;

    }

    public void setFieldInfoList(List<FieldInfoVO> fieldInfoList) {
        this.fieldInfoList = fieldInfoList;
    }
}
