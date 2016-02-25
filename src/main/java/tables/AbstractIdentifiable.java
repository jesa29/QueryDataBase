package tables;

/**
 * Created by jesa on 25.02.2016.
 */
import javax.persistence.*;


@MappedSuperclass
public class AbstractIdentifiable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = " QueryLibSeqGenerator")
    @SequenceGenerator(name="QueryLibSeqGenerator",sequenceName="QUERY_LIB_SEQUENCE", allocationSize=1)
    @Column(name = "ID")
    private Long id;

    public AbstractIdentifiable() {
    }

    public AbstractIdentifiable(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
