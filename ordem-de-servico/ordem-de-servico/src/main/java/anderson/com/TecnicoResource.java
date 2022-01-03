package anderson.com;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.Optional;

@Path("tecnico")

@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class TecnicoResource {

    @Inject
    TecnicoService tecnicoService;

    @GET
    public List<Tecnico> list(){
        return tecnicoService.list();
    }

    /* metodo para teste do get por id
    @GET
    @Path("/{id}")
    Response get(@PathParam("id")Long id) {
        return tecnicoService.find(id)
                .map(Response::ok)
                .orElse(Response.status(Response.Status.NOT_FOUND))
                .build();
    }
    */


    @POST
    @Transactional
    public void Tecnico(InserirTecnicoDTO dto) {
        Tecnico tecnico = new Tecnico();
        tecnico.nomeTecnico= dto.getNomeTecnico();
        tecnico.persist();

    }

    @PUT
    @Path("{id}")
    @Transactional
    public void Tecnico(@PathParam("id") long id, InserirTecnicoDTO dto) {
        Optional<Tecnico> tecnicoOp = Tecnico.findByIdOptional(id);
        if (tecnicoOp.isPresent()){
            Tecnico tecnico = tecnicoOp.get();
            tecnico.nomeTecnico= dto.getNomeTecnico();
            tecnico.persist();

        }else {
            throw new NotFoundException("Tecnico não existe!");
        };
    }

    @DELETE
    @Path("{id}")
    @Transactional
    public void Tecnico(@PathParam("id") long id) {
        Optional<Tecnico> tecnicoOp = Tecnico.findByIdOptional(id);
        tecnicoOp.ifPresentOrElse(Tecnico::delete,
                ()->{throw new NotFoundException("Não existe este tecnico!");
        });
    }


    /* - metodo para teste da classe
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