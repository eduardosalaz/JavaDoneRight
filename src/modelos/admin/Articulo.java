package modelos.admin;

public class Articulo {
    private int cve_art, inv_art, cat_art, IDprov_art;
    private float pre_art;
    private String nom_art, nom_cat, nom_prov;

    public Articulo(int cve_art, int inv_art, String nom_cat, String nom_prov, float pre_art, String nom_art) {
        this.cve_art = cve_art;
        this.inv_art = inv_art;
        this.nom_cat = nom_cat;
        this.nom_prov = nom_prov;
        this.pre_art = pre_art;
        this.nom_art = nom_art;
    }

    public String getNom_cat() {
        return nom_cat;
    }

    public void setNom_cat(String nom_cat) {
        this.nom_cat = nom_cat;
    }

    public String getNom_prov() {
        return nom_prov;
    }

    public void setNom_prov(String nom_prov) {
        this.nom_prov = nom_prov;
    }

    public Articulo() {

    }

    public Articulo(int cve_art, String nom_art, float pre_art, int inv_art) {
        this.cve_art = cve_art;
        this.nom_art = nom_art;
        this.pre_art = pre_art;
        this.inv_art = inv_art;
    }

    public int getCve_art() {
        return cve_art;
    }

    public void setCve_art(int cve_art) {
        this.cve_art = cve_art;
    }

    public int getInv_art() {
        return inv_art;
    }

    public void setInv_art(int inv_art) {
        this.inv_art = inv_art;
    }

    public int getCat_art() {
        return cat_art;
    }

    public void setCat_art(int cat_art) {
        this.cat_art = cat_art;
    }

    public int getIDprov_art() {
        return IDprov_art;
    }

    public void setIDprov_art(int IDprov_art) {
        this.IDprov_art = IDprov_art;
    }

    public float getPre_art() {
        return pre_art;
    }

    public void setPre_art(float pre_art) {
        this.pre_art = pre_art;
    }

    public String getNom_art() {
        return nom_art;
    }

    public void setNom_art(String nom_art) {
        this.nom_art = nom_art;
    }
}
