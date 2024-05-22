package es.ieslavereda.miraveredaapi.repository;

import es.ieslavereda.miraveredaapi.repository.model.*;
import oracle.jdbc.datasource.impl.OracleDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Clase que proporciona acceso a los datos de contenido en la base de datos.
 */
@Repository
public class ContenidoRepository implements IContenidoRepository{

    /**
     * Fuente de datos Oracle que se utilizará para acceder a la base de datos.
     */
    @Autowired
    @Qualifier("BBDD")
    private OracleDataSource dataSource;

    @Override
    public List<Contenido> getContenidos() throws SQLException {
        List<Contenido> contenidos = new ArrayList<>();

        contenidos.addAll(CapituloRepository.getCapitulos());
        contenidos.addAll(PeliculaRepository.getPeliculas());
        contenidos.addAll(CortoRepository.getCortos());

        return contenidos;
    }

    @Override
    public float getPrecio(int id) throws SQLException {
        String query = "SELECT TARIFA.PRECIO AS PRECIO_TARIFA " +
                "FROM CONTENIDO JOIN TARIFA ON CONTENIDO.ID_TARIFA = TARIFA.ID " +
                "WHERE CONTENIDO.ID = ?";
        float precio = 0;
        try (Connection connection = dataSource.getConnection();
             PreparedStatement ps = connection.prepareStatement(query)){
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();
            rs.next();
            precio = rs.getFloat(1);

        }
        return precio;
    }

    @Override
    public int updatePuntuacionById(int id, String tag, float punt) throws SQLException {
        String query = "{?= call actualizar_puntuacion(?,?,?)}";
        int resultado = 0;
        try (Connection connection = dataSource.getConnection();
        CallableStatement cs = connection.prepareCall(query)){
            cs.registerOutParameter(1, Types.INTEGER);
            cs.setInt(1, id);
            cs.setString(2, tag);
            cs.setFloat(3, punt);

            resultado = cs.executeUpdate();
        }
        return resultado;

    }

    @Override
    public int deleteContenido(int id, String tipo) throws SQLException {
        String query = "{?= call eliminar_contenido(?, ?)}";
        int resultado = 0;
        try (Connection connection = dataSource.getConnection();
        CallableStatement cs = connection.prepareCall(query)){
            cs.registerOutParameter(1, Types.INTEGER);
            cs.setInt(2, id);
            cs.setString(3, tipo);

            resultado = cs.executeUpdate();
        }
        return resultado;
    }

    @Override
    public float anyadirPuntuacion(int id, String tag, float punt) throws SQLException {
        String query = "{call añadir_puntuacion(?,?,?)}";
        try (Connection connection = dataSource.getConnection();
        PreparedStatement ps = connection.prepareStatement(query)){
            ps.setInt(1, id);
            ps.setString(2, tag);
            ps.setFloat(3, punt);

            ps.executeUpdate();

        }
        return punt;
    }

    @Override
    public Contenido getContenidoByIdLineaFactura(int id) throws SQLException {
        String query = "SELECT C.ID,C.TITULO,C.DESCRIPCION,C.URL_IMAGEN," +
                "C.ACTORES,C.PUNT_MEDIA,FECH_ESTRENO,C.DURACION,C.DIRECTOR," +
                "C.ID_GENERO,C.ID_TARIFA FROM CONTENIDO C JOIN ARTICULO_FACTURAS A " +
                "ON C.ID = A.ID_CONTENIDO WHERE A.ID_LINEA = ?";
        Contenido contenido = null;
        try (Connection connection = dataSource.getConnection();
        PreparedStatement ps = connection.prepareStatement(query)){
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            rs.next();
            contenido = new Corto(rs.getInt(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getString(5),
                    rs.getFloat(6),
                    rs.getDate(7),
                    rs.getFloat(8),
                    rs.getString(9),
                    rs.getInt(10),
                    rs.getInt(11));
        }
        return contenido;
    }


}
