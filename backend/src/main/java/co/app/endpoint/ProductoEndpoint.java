package co.app.endpoint;

import co.app.dao.ProductoDAO;
import co.app.model.Producto;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/productos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProductoEndpoint {

    private ProductoDAO productoDAO = new ProductoDAO();

    @GET
    public List<Producto> getAllProductos() {
        return productoDAO.obtenerTodosLosProductos();
    }

    @GET
    @Path("/{id}")
    public Response getProducto(@PathParam("id") int id) {
        Producto producto = productoDAO.obtenerProductoPorId(id);
        if (producto != null) {
            return Response.ok(producto).build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @POST
    public Response createProducto(Producto producto) {
        productoDAO.insertarProducto(producto);
        return Response.status(Response.Status.CREATED).entity(producto).build();
    }

    @PUT
    @Path("/{id}")
    public Response updateProducto(@PathParam("id") int id, Producto producto) {
        producto.setIdProducto(id);
        if (productoDAO.actualizarProducto(producto)) {
            return Response.ok(producto).build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteProducto(@PathParam("id") int id) {
        if (productoDAO.eliminarProducto(id)) {
            return Response.noContent().build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }
}
