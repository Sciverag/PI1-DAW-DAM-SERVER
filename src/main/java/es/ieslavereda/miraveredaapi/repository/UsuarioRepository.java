package es.ieslavereda.miraveredaapi.repository;

import es.ieslavereda.miraveredaapi.repository.model.OracleDataSourceDB;
import es.ieslavereda.miraveredaapi.repository.model.Usuario;
import oracle.jdbc.datasource.impl.OracleDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase que implementa la interfaz IUsuarioRepository y proporciona acceso a los datos de usuario en la base de datos.
 */
@Repository
public class UsuarioRepository implements IUsuarioRepository{

    /**
     * Fuente de datos Oracle que se utilizará para acceder a la base de datos.
     */
    @Autowired
    @Qualifier("BBDD")
    private OracleDataSource dataSource;


    /**
     * Obtiene la lista de usuarios.
     * @return La lista de usuarios.
     * @throws SQLException Si ocurre un error al obtener la lista de usuarios.
     */
    @Override
    public List<Usuario> getUsuarios() throws SQLException {
        List<Usuario> usuarios = new ArrayList<>();
        String query = "SELECT * FROM USUARIO";

        try (Connection connection = dataSource.getConnection();
             CallableStatement cs = connection.prepareCall(query)){
            ResultSet rs = cs.executeQuery();
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
                        .changedTs(rs.getDate(10))
                        .url_imagen(rs.getString(11)).build());
            }
        }
        return usuarios;
    }

    @Override
    public int deleteUsuario(String tag) throws SQLException {
        int resultado = 0;
        String query = "{? = call eliminar_usuario(?)}";

        try (Connection connection = dataSource.getConnection();
        CallableStatement cs = connection.prepareCall(query)){
            cs.registerOutParameter(1, Types.INTEGER);
            cs.setString(2, tag);
            cs.execute();

            resultado = cs.getInt(1);
        }
        return resultado;
    }

    @Override
    public int actualizarUsuario(Usuario usuario) throws SQLException {
        int resultado = 0;
        String query = "{?= call actualizar_usuario(?,?,?,?,?,?,?,?,?)}";
        try (Connection connection = dataSource.getConnection();
        CallableStatement cs = connection.prepareCall(query)){
            cs.registerOutParameter(1, Types.INTEGER);
            cs.setString(2, usuario.getNombreUsuario());
            cs.setString(3, usuario.getContrasenya());
            cs.setString(4, usuario.getDomicilio());
            cs.setInt(5, usuario.getCP());
            cs.setString(6, usuario.getEmail());
            cs.setDate(7, usuario.getFechaNacimiento());
            cs.setString(8, usuario.getNombre());
            cs.setString(9, usuario.getApellido());
            cs.setInt(10, usuario.getNum_tarjeta());

            resultado = cs.executeUpdate();
        }
        return resultado;
    }

    @Override
    public Usuario getUsuarioByTag(String tag) throws SQLException {
        Usuario usuario = new Usuario();
        String query = "SELECT * FROM USUARIO WHERE TAG_USUARIO = ?";

        try (Connection connection = dataSource.getConnection();
        PreparedStatement ps = connection.prepareStatement(query)){
            ps.setString(1, tag);

            ResultSet rs = ps.executeQuery();
            rs.next();
            usuario.setNombreUsuario(rs.getString(1));
            usuario.setContrasenya(rs.getString(2));
            usuario.setDomicilio(rs.getString(3));
            usuario.setCP(rs.getInt(4));
            usuario.setEmail(rs.getString(5));
            usuario.setFechaNacimiento(rs.getDate(6));
            usuario.setNombre(rs.getString(7));
            usuario.setApellido(rs.getString(8));
            usuario.setNum_tarjeta(rs.getInt(9));
        }
        return usuario;
    }


}
