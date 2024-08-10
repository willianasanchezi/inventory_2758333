package co.app.config;

import co.app.security.CORSFilter;
import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;
  
@ApplicationPath("api")
public class ApplicationConfig extends Application {
    /*
    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> classes = new HashSet<>();
        // Registra el filtro CORS
        classes.add(CORSFilter.class);
        return classes;
    }*/
}