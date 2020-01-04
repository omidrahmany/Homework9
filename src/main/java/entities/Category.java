package entities;


import config.PersistenceEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table
public class Category extends PersistenceEntity<Long> {

    private String title;
    private String description;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "category")
    @ToString.Exclude
    private List<Article> articles = new ArrayList<>();
}
