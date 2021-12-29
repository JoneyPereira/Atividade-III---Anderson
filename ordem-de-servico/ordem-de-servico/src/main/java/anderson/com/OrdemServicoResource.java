package anderson.com;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.time.LocalDate;
import java.util.List;

@Path("/ordemservico")
public class OrdemServicoResource {

    @Inject
    OrdemServicoService ordemServicoService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<OrdemServico> list(){
        return ordemServicoService.list();
    }

    @POST
    @Transactional
    public void novaOrdemServico(InserirOrdemServicoDTO inserirOrdemServicoDTO){
        OrdemServico ordenServico = new OrdemServico();
        ordemServicoService.novaOrdemServico();
    }
}