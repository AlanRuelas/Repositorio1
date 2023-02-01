package mx.com.pqtx.datos.dto;


public class PkgDetailDTO {
    private Integer guia;
    private String pkg;
    private float cost;

    public PkgDetailDTO() {
    }

    public Integer getGuia() {
        return guia;
    }

    public void setGuia(Integer guia) {
        this.guia = guia;
    }

    public String getPkg() {
        return pkg;
    }

    public void setPkg(String pkg) {
        this.pkg = pkg;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    
}
