package anderson.com;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.Entity;
import java.time.LocalDate;
import java.util.Date;

@Entity
public class OrdemServico extends PanacheEntity {

    public String descricao;
    public LocalDate data;
    public String categoria;

}
