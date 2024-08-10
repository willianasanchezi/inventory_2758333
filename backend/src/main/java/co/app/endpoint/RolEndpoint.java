package co.app.endpoint;

import co.app.dao.RolDAO;
import co.app.model.Rol;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("roles")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class RolEndpoint {

    private RolDAO rolDAO = new RolDAO();

    @GET
    public List<Rol> getAllRoles() {
        return rolDAO.obtenerTodosLosRoles();
    }

    @GET
    @Path("{id}")
    public Response getRol(@PathParam("id") int id) {
        Rol rol = rolDAO.obtenerRolPorId(id);
        if (rol != null) {
            return Response.ok(rol).build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @POST
    public Response createRol(Rol rol) {
        rolDAO.insertarRol(rol);
        return Response.status(Response.Status.CREATED).entity(rol).build();
    }

    @PUT
    @Path("{id}")
    public Response updateRol(@PathParam("id") int id, Rol rol) {
        rol.setIdRol(id);
        if (rolDAO.actualizarRol(rol)) {
            return Response.ok(rol).build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @DELETE
    @Path("{id}")
    public Response deleteRol(@PathParam("id") int id) {
        if (rolDAO.eliminarRol(id)) {
            return Response.noContent().build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }
}
