package br.com.controleservico.infra;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    private ConnectionFactory(){}

    public static Connection getConnection()  {

         try {
            return DriverManager.getConnection("jdbc:postgresql://localhost/OrdemServico", "postgres", "joney");
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

    }


}
