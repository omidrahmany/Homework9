package entities;

import config.PersistenceEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class Tag extends PersistenceEntity<Long> {

    private String title;
    @ManyToMany(mappedBy = "tags")
    @ToString.Exclude
    private List<Article> articles=new ArrayList<>();
}