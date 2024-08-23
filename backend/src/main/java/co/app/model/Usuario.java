    // co/app/model/Usuario.java
    package co.app.model;

    import java.sql.Timestamp;

    public class Usuario {

        private int idUsuario;
        private Timestamp fechaCreacion;
        private String nombreCompleto;
        private String identificacion;
        private String correoElectronico;
        private String contrasena;
        private int codigoRol;
        private String estadoUsuario;
        private String userCreoRegistro;

        // Constructor sin parámetros
        public Usuario() {}

        // Constructor con cinco parámetros
        public Usuario(String nombreCompleto, String identificacion, String correoElectronico, String contrasena, int codigoRol) {
            this.nombreCompleto = nombreCompleto;
            this.identificacion = identificacion;
            this.correoElectronico = correoElectronico;
            this.contrasena = contrasena;
            this.codigoRol = codigoRol;
        }

        // Constructor con seis parámetros
        public Usuario(int idUsuario, String nombreCompleto, String identificacion, String correoElectronico, String contrasena, int codigoRol) {
            this.idUsuario = idUsuario;
            this.nombreCompleto = nombreCompleto;
            this.identificacion = identificacion;
            this.correoElectronico = correoElectronico;
            this.contrasena = contrasena;
            this.codigoRol = codigoRol;
        }

        // Constructor con todos los parámetros
        public Usuario(int idUsuario, Timestamp fechaCreacion, String nombreCompleto, String identificacion, String correoElectronico, String contrasena, int codigoRol, String estadoUsuario, String userCreoRegistro) {
            this.idUsuario = idUsuario;
            this.fechaCreacion = fechaCreacion;
            this.nombreCompleto = nombreCompleto;
            this.identificacion = identificacion;
            this.correoElectronico = correoElectronico;
            this.contrasena = contrasena;
            this.codigoRol = codigoRol;
            this.estadoUsuario = estadoUsuario;
            this.userCreoRegistro = userCreoRegistro;
        }

        // Getters y Setters

        public int getIdUsuario() {
            return idUsuario;
        }

        public void setIdUsuario(int idUsuario) {
            this.idUsuario = idUsuario;
        }

        public Timestamp getFechaCreacion() {
            return fechaCreacion;
        }

        public void setFechaCreacion(Timestamp fechaCreacion) {
            this.fechaCreacion = fechaCreacion;
        }

        public String getNombreCompleto() {
            return nombreCompleto;
        }

        public void setNombreCompleto(String nombreCompleto) {
            this.nombreCompleto = nombreCompleto;
        }

        public String getIdentificacion() {
            return identificacion;
        }

        public void setIdentificacion(String identificacion) {
            this.identificacion = identificacion;
        }

        public String getCorreoElectronico() {
            return correoElectronico;
        }

        public void setCorreoElectronico(String correoElectronico) {
            this.correoElectronico = correoElectronico;
        }

        public String getContrasena() {
            return contrasena;
        }

        public void setContrasena(String contrasena) {
            this.contrasena = contrasena;
        }

        public int getCodigoRol() {
            return codigoRol;
        }

        public void setCodigoRol(int codigoRol) {
            this.codigoRol = codigoRol;
        }

        public String getEstadoUsuario() {
            return estadoUsuario;
        }

        public void setEstadoUsuario(String estadoUsuario) {
            this.estadoUsuario = estadoUsuario;
        }

        public String getUserCreoRegistro() {
            return userCreoRegistro;
        }

        public void setUserCreoRegistro(String userCreoRegistro) {
            this.userCreoRegistro = userCreoRegistro;
        }
    }

