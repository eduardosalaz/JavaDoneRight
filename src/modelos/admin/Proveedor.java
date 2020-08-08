package modelos.admin;

import java.sql.Date;

public class Proveedor {
    private int id_prov;
    private String nom_prov;
    private Date ultima_prov;

    public Proveedor(int id_prov, String nom_prov) {
        this.id_prov = id_prov;
        this.nom_prov = nom_prov;
    }
    public Proveedor(){

    }

    public int getId_prov() {
        return id_prov;
    }

    public void setId_prov(int id_prov) {
        this.id_prov = id_prov;
    }

    public String getNom_prov() {
        return nom_prov;
    }

    public void setNom_prov(String nom_prov) {
        this.nom_prov = nom_prov;
    }

    public Date getUltima_prov() {
        return ultima_prov;
    }

    public void setUltima_prov(Date ultima_prov) {
        this.ultima_prov = ultima_prov;
    }
}
