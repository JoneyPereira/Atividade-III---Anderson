package anderson.com;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.Optional;

@Path("usuario")

@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class UsuarioResource {

    @Inject
    UsuarioService usuarioService;

    @GET
    public List<Usuario> list(){
        return usuarioService.list();
    }

    /* metodo para teste do get por id
    @GET
    @Path("/{id}")
    Response get(@PathParam("id")Long id) {
        return usuarioService.find(id)
                .map(Response::ok)
                .orElse(Response.status(Response.Status.NOT_FOUND))
                .build();
    }
    */


    @POST
    @Transactional
    public void Usuario(InserirUsuarioDTO dto) {
        Usuario usuario = new Usuario();
        usuario.nomeUsuario= dto.getNomeUsuario();
        usuario.persist();

    }

    @PUT
    @Path("{id}")
    @Transactional
    public void Usuario(@PathParam("id") long id, InserirUsuarioDTO dto) {
        Optional<Usuario> usuarioOp = Usuario.findByIdOptional(id);
        if (usuarioOp.isPresent()){
            Usuario usuario = usuarioOp.get();
            usuario.nomeUsuario= dto.getNomeUsuario();
            usuario.persist();

        }else {
            throw new NotFoundException("Usuario não existe!");
        };
    }

    @DELETE
    @Path("{id}")
    @Transactional
    public void Usuario(@PathParam("id") long id) {
        Optional<Usuario> usuarioOp = Usuario.findByIdOptional(id);
        usuarioOp.ifPresentOrElse(Usuario::delete,
                ()->{throw new NotFoundException("Não existe este usuário!");
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