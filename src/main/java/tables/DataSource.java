package tables;

/**
 * Created by jesa on 25.02.2016.
 */
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="DATASOURCE")
public class DataSource extends AbstractIdentifiable{
    @Column(name = "DESCRIPTION")
    private String description;
    @Column(name = "NAME")
    private String name;
    @Column(name = "TYPE")
    private String type;

    //connection to tables
    private Set<DataSourceProperties> dataSourceProperties = new HashSet<DataSourceProperties>(0);
    @OneToMany
    @JoinTable(name = "id")
    public Set<DataSourceProperties> getDataSourceProperties(){
        return dataSourceProperties;
    }

    private QueryExecution queryExecution;
    @OneToOne(mappedBy = "dataSource")
    @JoinTable(name = "id")
    public QueryExecution queryExecution(){
        return queryExecution;
    }

    public DataSource() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}