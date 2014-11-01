package freetl.test;

import freetl.util.*;

import javax.persistence.*;
import javax.persistence.Persistence;
import java.util.List;

@Entity
@Table(name="ft_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String name;




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


}
