package entities;

import config.PersistenceEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class Article extends PersistenceEntity<Long> {

    private String title;
    private String brief;
    private String content;
    private Date createDate;
    private Date lastUpdateDate;
    private Date publishDate;
    private boolean isPublished;
    @ManyToOne
    @ToString.Exclude
    private Category category;

    @ManyToOne
    @ToString.Exclude
    private User user;

    @ManyToMany
    private List<Tag> tags=new ArrayList<>();

}
