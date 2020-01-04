package config;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

@MappedSuperclass
@Data
public class PersistenceEntity<T extends Serializable> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private T id;
}
