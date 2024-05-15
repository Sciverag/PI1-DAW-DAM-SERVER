package es.ieslavereda.miraveredaapi.repository;

import es.ieslavereda.miraveredaapi.repository.model.OracleDataSourceDB;
import oracle.jdbc.datasource.impl.OracleDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

/**
 * Clase que implementa la interfaz ICarroCompraRepository y proporciona acceso a los datos del carro de compra en la base de datos.
 */
@Repository
public class CarroCompraRepository implements ICarroCompraRepository{

    /**
     * Fuente de datos Oracle que se utilizará para acceder a la base de datos.
     */
    @Autowired
    @Qualifier("BBDD")
    private OracleDataSource dataSource;
}
