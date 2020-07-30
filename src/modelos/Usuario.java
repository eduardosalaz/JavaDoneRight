package modelos;

import java.sql.Date;

public class Usuario {
    public int ID_Usuario;
    public boolean Admin;
    public String Pass;
    public String Nombre;
    public String Telefono;
    public Date Fecha_Alta;
    public Date Ultima_Sesion;

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
