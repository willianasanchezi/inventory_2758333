// co/app/endpoint/AsignacionEndpoint.java
package co.app.endpoint;  
  
import co.app.dao.AsignacionDAO;  
import co.app.model.Asignacion;  
import jakarta.ws.rs.*;  
import jakarta.ws.rs.core.MediaType;  
import jakarta.ws.rs.core.Response;  
  
import java.sql.Timestamp;  
import java.text.SimpleDateFormat;  
import java.text.ParseException;  
import java.util.List;  
  
@Path("/asignaciones")  
@Produces(MediaType.APPLICATION_JSON)  
@Consumes(MediaType.APPLICATION_JSON)  
public class AsignacionEndpoint {  
    private AsignacionDAO asignacionDAO = new AsignacionDAO();  
  
    @GET  
    public List<Asignacion> getAllAsignaciones() {  
        return asignacionDAO.obtenerTodasLasAsignaciones();  
    }  
  
    @GET  
    @Path("/{id}")  
    public Response getAsignacion(@PathParam("id") int id) {  
        Asignacion asignacion = asignacionDAO.obtenerAsignacionPorId(id);  
        if (asignacion != null) {  
            return Response.ok(asignacion).build();  
        }  
        return Response.status(Response.Status.NOT_FOUND).build();  
    }  
  
    @POST  
    public Response createAsignacion(Asignacion asignacion) {  
        asignacionDAO.insertarAsignacion(asignacion);  
        return Response.status(Response.Status.CREATED).entity(asignacion).build();  
    }  
  
    @PUT  
    @Path("/{id}")  
    public Response updateAsignacion(@PathParam("id") int id, Asignacion asignacion) {  
        asignacion.setIdAsignacion(id);  
        if (asignacionDAO.actualizarAsignacion(asignacion)) {  
            return Response.ok(asignacion).build();  
        }  
        return Response.status(Response.Status.NOT_FOUND).build();  
    }  
  
    @DELETE  
    @Path("/{id}")  
    public Response deleteAsignacion(@PathParam("id") int id) {  
        if (asignacionDAO.eliminarAsignacion(id)) {  
            return Response.noContent().build();  
        }  
        return Response.status(Response.Status.NOT_FOUND).build();  
    }  
}  
