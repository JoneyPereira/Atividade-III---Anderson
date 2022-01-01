package anderson.com;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Entity;
import java.time.LocalDate;
import java.util.Date;

@Entity
public class OrdemServico extends PanacheEntity {

    public String descricao;
    public LocalDate data = LocalDate.now();
    public String categoria;
    @CreationTimestamp
    private LocalDate dataCriacao;
    @UpdateTimestamp
    private LocalDate dataAtualizacao;



}
