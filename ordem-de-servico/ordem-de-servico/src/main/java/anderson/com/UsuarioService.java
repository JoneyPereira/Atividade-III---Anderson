package anderson.com;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class UsuarioService {

    public List<Usuario> list(){
        return Usuario.listAll();
    }

    @Transactional
    public void novoUsuario(InserirUsuarioDTO dto){
        Usuario usuario = new Usuario();
        usuario.nomeUsuario = dto.getNomeUsuario();
        usuario.persist();
    }
}
