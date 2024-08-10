package co.app.resources;

import co.app.dao.PrestamoDAO;
import co.app.model.Prestamo;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/prestamos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PrestamoEndpoint {

    private PrestamoDAO prestamoDAO = new PrestamoDAO();

    @GET
    public List<Prestamo> getAllPrestamos() {
        return prestamoDAO.obtenerTodosLosPrestamos();
    }

    @GET
    @Path("/{id}")
    public Response getPrestamo(@PathParam("id") int id) {
        Prestamo prestamo = prestamoDAO.obtenerPrestamoPorId(id);
        if (prestamo != null) {
            return Response.ok(prestamo).build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @POST
    public Response createPrestamo(Prestamo prestamo) {
        prestamoDAO.insertarPrestamo(prestamo);
        return Response.status(Response.Status.CREATED).entity(prestamo).build();
    }

    @PUT
    @Path("/{id}")
    public Response updatePrestamo(@PathParam("id") int id, Prestamo prestamo) {
        prestamo.setIdPrestamo(id);
        if (prestamoDAO.actualizarPrestamo(prestamo)) {
            return Response.ok(prestamo).build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deletePrestamo(@PathParam("id") int id) {
        if (prestamoDAO.eliminarPrestamo(id)) {
            return Response.noContent().build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }
}
