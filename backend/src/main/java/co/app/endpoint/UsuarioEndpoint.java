//UsuarioEndpoint.java
package co.app.resources;
  
import co.app.dao.UsuarioDAO;  
import co.app.model.Usuario;  
import jakarta.ws.rs.*;  
import jakarta.ws.rs.core.MediaType;  
import jakarta.ws.rs.core.Response;  
  
import java.util.List;  
  
@Path("usuarios")  
@Produces(MediaType.APPLICATION_JSON)  
@Consumes(MediaType.APPLICATION_JSON)  
public class UsuarioEndpoint {
  
    private UsuarioDAO usuarioDAO = new UsuarioDAO();  
  
    @GET  
    public List<Usuario> getAllUsers() {  
        return usuarioDAO.obtenerTodosLosUsuarios();  
    }  
  
    @GET  
    @Path("{id}")  
    public Response getUser(@PathParam("id") int id) {  
        Usuario usuario = usuarioDAO.obtenerUsuarioPorId(id);  
        if (usuario != null) {  
            return Response.ok(usuario).build();  
        }  
        return Response.status(Response.Status.NOT_FOUND).build();  
    }  
  
    @POST  
    public Response createUser(Usuario usuario) {  
        usuarioDAO.insertarUsuario(usuario);  
        return Response.status(Response.Status.CREATED).entity(usuario).build();  
    }  
  
    @PUT  
    @Path("{id}")  
    public Response updateUser(@PathParam("id") int id, Usuario usuario) {  
        usuario.setIdUsuario(id);  
        if (usuarioDAO.actualizarUsuario(usuario)) {  
            return Response.ok(usuario).build();  
        }  
        return Response.status(Response.Status.NOT_FOUND).build();  
    }  
  
    @DELETE  
    @Path("{id}")  
    public Response deleteUser(@PathParam("id") int id) {  
        if (usuarioDAO.eliminarUsuario(id)) {  
            return Response.noContent().build();  
        }  
        return Response.status(Response.Status.NOT_FOUND).build();  
    }  
}  
