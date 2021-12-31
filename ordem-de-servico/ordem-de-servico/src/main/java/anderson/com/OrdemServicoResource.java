package anderson.com;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
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

    /*
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    Response get(@PathParam("id")Long id) {
        return ordemServicoService.find(id)
                .map(Response::ok)
                .orElse(Response.status(Response.Status.NOT_FOUND))
                .build();
    }
    */

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public OrdemServico novaOrdemServico(OrdemServico ordemServico) {
        return ordemServico;
    }


    /*
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public void novaOrdemServico(){
        OrdemServico ordenServico = new OrdemServico();
        ordenServico.descricao = "Realizar troca de cpu.";
        ordenServico.data = LocalDate.now();
        ordenServico.categoria = "OUTRAS";
        ordenServico.persist();
    }
    */
}