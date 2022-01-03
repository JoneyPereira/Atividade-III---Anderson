package anderson.com;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Entity;
import java.time.LocalDate;

@Entity
public class Tecnico extends PanacheEntity {

    public String nomeTecnico;
    @CreationTimestamp
    private LocalDate dataCriacao;
    @UpdateTimestamp
    private LocalDate dataAtualizacao;



}
