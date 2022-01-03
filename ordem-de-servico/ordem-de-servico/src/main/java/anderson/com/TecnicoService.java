package anderson.com;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class TecnicoService {

    public List<Tecnico> list(){
        return Tecnico.listAll();
    }

    @Transactional
    public void novoTecnico(InserirTecnicoDTO dto){
        Tecnico tecnico = new Tecnico();
        tecnico.nomeTecnico = dto.getNomeTecnico();
        tecnico.persist();
    }
}
