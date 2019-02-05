package sia.tacocloud.domain;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.hibernate.cache.spi.support.AbstractReadWriteAccess;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.*;

/**
 * Created by bvasilenko on 01.02.2019.
 */
@Data
//@RequiredArgsConstructor
//@NoArgsConstructor(access= AccessLevel.PRIVATE, force=true)
@Entity
public class Taco {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;


    @NotNull
    @Size(min=5, message="Name must be at least 5 characters long")
    private String name;

    @OneToMany(fetch = FetchType.LAZY, targetEntity = Ingredient.class)
//    @JoinColumn(name = "_ID")
//    @JoinColumn(name = "INGREDIENT_ID", referencedColumnName = "ID")
    private Set<Ingredient> ingredients = new HashSet<>();

    private Date createdAt;

//    @ManyToMany(targetEntity=Ingredient.class)
//    @Size(min=1, message="You must choose at least 1 ingredient")
//    private List<Ingredient> ingredients = new ArrayList<>();

    @PrePersist
    void createdAt() {
        this.createdAt = new Date();
    }
}
