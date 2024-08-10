package co.app.utils;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseConnection {
    private static final DataSource dataSource;

    // Bloque de inicialización estático para crear una única instancia de HikariDataSource
    static {
        Properties properties = new Properties();
        try {
            // Cargar las propiedades de conexión desde el archivo de configuración
            properties.load(DatabaseConnection.class.getClassLoader().getResourceAsStream("db.properties"));

            // Crear y configurar una instancia de HikariConfig
            HikariConfig config = new HikariConfig();
            config.setDriverClassName(properties.getProperty("db.driver"));
            config.setJdbcUrl(properties.getProperty("db.url"));
            config.setUsername(properties.getProperty("db.username"));
            config.setPassword(properties.getProperty("db.password"));

            // Configuraciones adicionales (opcionales)
            config.addDataSourceProperty("cachePrepStmts", "true");
            config.addDataSourceProperty("prepStmtCacheSize", "250");
            config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");
            config.addDataSourceProperty("useServerPrepStmts", "true");
            config.addDataSourceProperty("useLocalSessionState", "true");
            config.addDataSourceProperty("rewriteBatchedStatements", "true");
            config.addDataSourceProperty("cacheResultSetMetadata", "true");
            config.addDataSourceProperty("cacheServerConfiguration", "true");
            config.addDataSourceProperty("elideSetAutoCommits", "true");
            config.addDataSourceProperty("maintainTimeStats", "false");

            // Establecer el tiempo de vida máximo de una conexión en el pool
            config.setMaxLifetime(60000); // 60 segundos

            // Establecer tiempo de espera
            config.setConnectionTimeout(30000); // 30 segundos

            // Establecer el tamaño del pool de conexiones
            config.setMaximumPoolSize(10);

            // Crear el HikariDataSource con la configuración
            dataSource = new HikariDataSource(config);
        } catch (Exception e) {
            throw new RuntimeException("Error al inicializar el pool de conexiones", e);
        }
    }

    // Método público para obtener el DataSource
    public static DataSource getDataSource() {
        return dataSource;
    }
    // Método público para obtener la conexión
    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    // Constructor privado para prevenir instanciación
    private DatabaseConnection() {
        // Constructor privado para evitar creación de instancias
    }
}

