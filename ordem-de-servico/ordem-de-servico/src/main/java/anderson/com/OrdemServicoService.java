package anderson.com;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class OrdemServicoService {

    public List<OrdemServico> list(){
        return OrdemServico.listAll();
    }

    @Transactional
    public void novaOrdemServico(InserirOrdemServicoDTO dto){
        OrdemServico ordenServico = new OrdemServico();
        ordenServico.descricao = dto.getDescricao();
        ordenServico.categoria = dto.getCategoria();
        ordenServico.persist();
    }
}
