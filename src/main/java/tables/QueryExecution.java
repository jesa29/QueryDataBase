package tables;

/**
 * Created by jesa on 25.02.2016.
 */
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="QUERYEXECUTION")
public class QueryExecution extends AbstractIdentifiable {
    @Column(name = "USER")
    private String user;
    @Column(name = "STARTTIMESTAMP")
    private Long startTimestamp;
    @Column(name = "ENDTIMESTAMP")
    private Long endTimestamp;

    //connection to tables
    private Query query;
    @ManyToOne
    @JoinTable(name = "id")
    public Query getQuery(){
        return query;
    }

    private Set<QueryExecutionParam> queryExecutionParams = new HashSet<QueryExecutionParam>(0);
    @OneToMany
    @JoinTable(name = "id")
    public Set<QueryExecutionParam> getQueryExecutionParams(){
        return queryExecutionParams;
    }

    private DataSource dataSource;
    @OneToOne
    @JoinTable(name = "id")
    public DataSource dataSource(){
        return dataSource;
    }

    public QueryExecution() {
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public Long getStartTimestamp() {
        return startTimestamp;
    }

    public void setStartTimestamp(Long startTimestamp) {
        this.startTimestamp = startTimestamp;
    }

    public Long getEndTimestamp() {
        return endTimestamp;
    }

    public void setEndTimestamp(Long endTimestamp) {
        this.endTimestamp = endTimestamp;
    }
}
