package co.app.endpoint;

import co.app.dao.ProductoUsuarioDAO;
import co.app.model.ProductoUsuario;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
//import jakarta.ws.rs.core.Response;

//import java.sql.Timestamp;
//import java.text.SimpleDateFormat;
//import java.text.ParseException;

import java.util.List;
//import java.util.Map;

@Path("/productosusuarios")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProductoUsuarioEndpoint {

    private ProductoUsuarioDAO productoUsuarioDAO = new ProductoUsuarioDAO();

    @GET
    public List<ProductoUsuario> getAllProductsUsers() {
        return productoUsuarioDAO.obtenerTodosLosProductosUsuarios();
    }
}
