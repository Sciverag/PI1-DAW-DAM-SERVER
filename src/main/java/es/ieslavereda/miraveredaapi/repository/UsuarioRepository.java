package es.ieslavereda.miraveredaapi.repository;

import es.ieslavereda.miraveredaapi.repository.model.OracleDataSourceDB;
import es.ieslavereda.miraveredaapi.repository.model.Usuario;
import oracle.jdbc.datasource.impl.OracleDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UsuarioRepository implements IUsuarioRepository{

    @Autowired
    @Qualifier("BBDD")
    private OracleDataSource dataSource;


    @Override
    public List<Usuario> getUsuarios() throws SQLException {
        List<Usuario> usuarios = new ArrayList<>();
        String query = "SELECT * FROM USUARIO";

        try (Connection connection = dataSource.getConnection();
             Statement statement = connection.createStatement()){
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                usuarios.add(Usuario.builder()
                        .nombreUsuario(rs.getString(1))
                        .contrasenya(rs.getString(2))
                        .domicilio(rs.getString(3))
                        .CP(rs.getInt(4))
                        .email(rs.getString(5))
                        .fechaNacimiento(rs.getDate(6))
                        .nombre(rs.getString(7))
                        .apellido(rs.getString(8))
                        .num_tarjeta(rs.getInt(9))
                        .changedTs(rs.getDate(10)).build());
            }
        }
        return usuarios;
    }
}
