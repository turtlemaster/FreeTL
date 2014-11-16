package freetl.vo.input;


import freetl.util.FieldInfo;
import freetl.vo.FieldInfoVO;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="ft_constant_value_input")

public class ConstantValueInputVO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String name;


    private List<List<String>> inputData;
    private List<FieldInfoVO> fieldInfoVOs;



}
