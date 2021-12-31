package br.com.controleservico.doa;

import br.com.controleservico.infra.ConnectionFactory;
import br.com.controleservico.model.Categoria;
import br.com.controleservico.model.OrdemServico;

import java.sql.*;
import java.util.List;
import java.util.Optional;

public class OrdemServicoDAO implements IOrdemServicoDAO{

    @Override
    public OrdemServico save(OrdemServico ordemServico) {

        try (Connection connection = ConnectionFactory.getConnection()) {
            String sql = "INSERT INTO ordemservico (descricao, data, categoria) VALUES (?, ?, ?)";

            PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, ordemServico.getDescricao());
            preparedStatement.setDate(2, java.sql.Date.valueOf(ordemServico.getData()));
            preparedStatement.setString(3, ordemServico.getCategoria().toString());

            preparedStatement.executeUpdate();

            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            resultSet.next();

            Long generatedId = resultSet.getLong("id");
            ordemServico.setId(generatedId);


        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

        return ordemServico;
    }

    @Override
    public OrdemServico update(OrdemServico ordemServico) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List<OrdemServico> findAll() {



        return null;
    }

    @Override
    public Optional<OrdemServico> findById() {
        return Optional.empty();
    }

    @Override
    public List<OrdemServico> findByCategoria(Categoria categoria) {
        return null;
    }
}
