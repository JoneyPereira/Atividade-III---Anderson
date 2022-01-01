package anderson.com;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("ordemservico")

@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class OrdemServicoResource {

    @Inject
    OrdemServicoService ordemServicoService;

    @GET
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
    @Transactional
    public void OrdemServico(InserirOrdemServicoDTO dto) {
        OrdemServico ordemServico = new OrdemServico();
        ordemServico.categoria= dto.getCategoria();
        ordemServico.descricao= dto.getDescricao();
        ordemServico.persist();

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