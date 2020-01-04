package entities;


import config.PersistenceEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
@ToString(callSuper = true)
public class Role extends PersistenceEntity<Long> {

    private String title;
    @ManyToMany(mappedBy = "roles")
    @ToString.Exclude
    private List<User> users = new ArrayList<>();

}
