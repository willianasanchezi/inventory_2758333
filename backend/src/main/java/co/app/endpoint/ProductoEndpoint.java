// co/app/endpoint/ProductoEndpoint.java
package co.app.endpoint;

import co.app.dao.ProductoDAO;
import co.app.model.Producto;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.text.ParseException;

import java.util.List;

@Path("/productos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProductoEndpoint {

    private ProductoDAO productoDAO = new ProductoDAO();

    /*
    @GET
    public List<Producto> getAllProductos() {
        return productoDAO.obtenerTodosLosProductos();
    }
    */

    @GET
    public List<Producto> getAllProductos(@QueryParam("nombreProducto") String nombreProducto,
                                          @QueryParam("marca") String marca,
                                          @QueryParam("modelo") String modelo,
                                          @QueryParam("cantidadMemoria") String cantidadMemoria,
                                          @QueryParam("capacidadDisco") String capacidadDisco,
                                          @QueryParam("fechaRegistroInicio") String fechaRegistroInicio,
                                          @QueryParam("fechaRegistroFin") String fechaRegistroFin) {
        Timestamp inicio = null;
        Timestamp fin = null;
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        try {
            if (fechaRegistroInicio != null) {
                inicio = new Timestamp(dateFormat.parse(fechaRegistroInicio).getTime());
            }
            if (fechaRegistroFin != null) {
                fin = new Timestamp(dateFormat.parse(fechaRegistroFin).getTime());
            }
        } catch (ParseException e) {
            throw new BadRequestException("Formato de fecha inválido. Use 'yyyy-MM-dd HH:mm:ss'.");
        }

        return productoDAO.buscarProductosConFiltros(nombreProducto, marca, modelo, cantidadMemoria, capacidadDisco, inicio, fin);
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
