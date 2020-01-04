package entities;

import config.PersistenceEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
@ToString(callSuper = true)
public class User extends PersistenceEntity<Long> {
    private String userName;
    private String password;
    private String nationalCode;
    private Date birthday;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    @ToString.Exclude
    private List<Article> articles;
    @ManyToMany
    private List<Role> roles = new ArrayList<>();
}
