package modelos.admin.users;

import java.io.Serializable;
import java.sql.Date;

public class Usuario implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private int ID_Usuario;
    private boolean Admin;
    private String Pass;
    private String Nombre;
    private String Telefono;
    private Date Fecha_Alta;
    private Date Ultima_Sesion;



    public int getID_Usuario() {
        return ID_Usuario;
    }

    public void setID_Usuario(int iD_Usuario) {
        ID_Usuario = iD_Usuario;
    }

    public boolean isAdmin() {
        return Admin;
    }

    public void setAdmin(boolean admin) {
        Admin = admin;
    }

    public String getPass() {
        return Pass;
    }

    public void setPass(String pass) {
        Pass = pass;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String telefono) {
        Telefono = telefono;
    }

    public Date getFecha_Alta() {
        return Fecha_Alta;
    }

    public void setFecha_Alta(Date fecha_Alta) {
        Fecha_Alta = fecha_Alta;
    }

    public Date getUltima_Sesion() {
        return Ultima_Sesion;
    }

    public void setUltima_Sesion(Date ultima_Sesion) {
        Ultima_Sesion = ultima_Sesion;
    }

    public Usuario() {

    }

    public Usuario(int ID_Usuario, boolean admin, String pass, String nombre, String telefono, Date fecha_Alta, Date ultima_Sesion) {
        this.ID_Usuario = ID_Usuario;
        Admin = admin;
        Pass = pass;
        Nombre = nombre;
        Telefono = telefono;
        Fecha_Alta = fecha_Alta;
        Ultima_Sesion = ultima_Sesion;
    }
}
