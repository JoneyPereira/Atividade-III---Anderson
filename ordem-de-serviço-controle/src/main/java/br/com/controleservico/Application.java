package br.com.controleservico;

import br.com.controleservico.doa.OrdemServicoDAO;
import br.com.controleservico.model.Categoria;
import br.com.controleservico.model.OrdemServico;

import java.time.LocalDate;

public class Application {
    public static void main(String[] args) {

        OrdemServicoDAO dao = new OrdemServicoDAO();

        OrdemServico ordemServico = new OrdemServico();
        ordemServico.setDescricao("Realizar troca de impressora.");
        ordemServico.setCategoria(Categoria.OUTRAS);
        ordemServico.setData(LocalDate.of(2021, 5, 12));

        dao.save(ordemServico);
        System.out.println("Foi inserido uma ordem de serviço com id: " + ordemServico.getId());



    }
}
