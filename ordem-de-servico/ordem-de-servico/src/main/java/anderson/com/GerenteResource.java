package anderson.com;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.Optional;

@Path("gerente")

@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class GerenteResource {

    @Inject
    GerenteService gerenteService;

    @GET
    public List<Gerente> list(){
        return gerenteService.list();
    }

    /* metodo para teste do get por id
    @GET
    @Path("/{id}")
    Response get(@PathParam("id")Long id) {
        return gerenteService.find(id)
                .map(Response::ok)
                .orElse(Response.status(Response.Status.NOT_FOUND))
                .build();
    }
    */


    @POST
    @Transactional
    public void Gerente(InserirGerenteDTO dto) {
        Gerente gerente = new Gerente();
        gerente.nomeGerente= dto.getNomeGerente();
        gerente.persist();

    }

    @PUT
    @Path("{id}")
    @Transactional
    public void Gerente(@PathParam("id") long id, InserirGerenteDTO dto) {
        Optional<Gerente> gerenteOp = Gerente.findByIdOptional(id);
        if (gerenteOp.isPresent()){
            Gerente gerente = gerenteOp.get();
            gerente.nomeGerente= dto.getNomeGerente();
            gerente.persist();

        }else {
            throw new NotFoundException("Gerente não existe!");
        };
    }

    @DELETE
    @Path("{id}")
    @Transactional
    public void Gerente(@PathParam("id") long id) {
        Optional<Gerente> gerenteOp = Gerente.findByIdOptional(id);
        gerenteOp.ifPresentOrElse(Gerente::delete,
                ()->{throw new NotFoundException("Não existe este gerente!");
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