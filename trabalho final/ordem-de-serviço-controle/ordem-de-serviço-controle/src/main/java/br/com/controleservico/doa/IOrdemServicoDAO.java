package br.com.controleservico.doa;

import br.com.controleservico.model.Categoria;
import br.com.controleservico.model.OrdemServico;

import java.awt.*;
import java.util.List;
import java.util.Optional;

public interface IOrdemServicoDAO {

    OrdemServico save(OrdemServico ordemServico);
    OrdemServico update(OrdemServico ordemServico);
    void delete(Long id);
    List<OrdemServico> findAll();
    Optional<OrdemServico> findById();
    List<OrdemServico> findByCategoria(Categoria categoria);

}
