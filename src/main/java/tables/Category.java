package tables;

/**
 * Created by jesa on 25.02.2016.
 */
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="CATEGORY")
public class Category extends AbstractIdentifiable{
    @Column(name = "OWNER")
    private String owner;
    @Column(name = "TITLE")
    private String title;
    @Column(name = "DESCRIPTION")
    private String description;

    //connection to tables
    private Set<Query> queries = new HashSet<Query>(0);
    @OneToMany
    @JoinTable(name = "id")
    public Set<Query> getQueries(){
        return queries;
    }

    private Set<Category> categories = new HashSet<Category>(0);
    @OneToMany
    @JoinTable(name = "id")
    public Set<Category> getCategories(){
        return categories;
    }

    private Category category;
    @ManyToOne
    @JoinTable(name = "id")
    public Category getCategory(){
        return category;
    }

    public Category() {
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
