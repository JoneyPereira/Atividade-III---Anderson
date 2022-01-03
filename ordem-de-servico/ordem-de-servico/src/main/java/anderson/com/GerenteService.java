package anderson.com;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class GerenteService {

    public List<Gerente> list(){
        return Gerente.listAll();
    }

    @Transactional
    public void novoGerente(InserirGerenteDTO dto){
        Gerente gerente = new Gerente();
        gerente.nomeGerente = dto.getNomeGerente();
        gerente.persist();
    }
}
