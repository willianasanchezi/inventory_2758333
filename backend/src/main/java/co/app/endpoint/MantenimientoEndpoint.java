package co.app.endpoint;

import co.app.dao.MantenimientoDAO;
import co.app.model.Mantenimiento;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/mantenimientos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class MantenimientoEndpoint {

    private MantenimientoDAO mantenimientoDAO = new MantenimientoDAO();

    @GET
    public List<Mantenimiento> getAllMantenimientos() {
        return mantenimientoDAO.obtenerTodosLosMantenimientos();
    }

    @GET
    @Path("/{id}")
    public Response getMantenimiento(@PathParam("id") int id) {
        Mantenimiento mantenimiento = mantenimientoDAO.obtenerMantenimientoPorId(id);
        if (mantenimiento != null) {
            return Response.ok(mantenimiento).build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @POST
    public Response createMantenimiento(Mantenimiento mantenimiento) {
        mantenimientoDAO.insertarMantenimiento(mantenimiento);
        return Response.status(Response.Status.CREATED).entity(mantenimiento).build();
    }

    @PUT
    @Path("/{id}")
    public Response updateMantenimiento(@PathParam("id") int id, Mantenimiento mantenimiento) {
        mantenimiento.setIdMantenimiento(id);
        if (mantenimientoDAO.actualizarMantenimiento(mantenimiento)) {
            return Response.ok(mantenimiento).build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteMantenimiento(@PathParam("id") int id) {
        if (mantenimientoDAO.eliminarMantenimiento(id)) {
            return Response.noContent().build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }
}
