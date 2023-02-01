package mx.com.pqtx.datos.dto;

public class BranchPkgCostDTO {
    private String branch;
    private String pkg;
    private float cost;

    public BranchPkgCostDTO() {
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
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
