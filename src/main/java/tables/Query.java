package tables;

/**
 * Created by jesa on 25.02.2016.
 */

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="QUERY")
public class Query extends AbstractIdentifiable {
    @Column(name = "TEXT")
    private String text;

    //connection to tables
    private Set<QueryParam> queryParams = new HashSet<QueryParam>(0);
    @OneToMany
    @JoinTable(name = "id")
    public Set<QueryParam> getQueryParams(){
        return queryParams;
    }

    private Set<QueryExecution> queryExecutions = new HashSet<QueryExecution>(0);
    @OneToMany
    @JoinTable(name = "id")
    public Set<QueryExecution> getQueryExecutions(){
        return queryExecutions;
    }

    private Category category;
    @ManyToOne
    @JoinTable(name = "id")
    public Category getCategory(){
        return category;
    }

    public Query() {
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
