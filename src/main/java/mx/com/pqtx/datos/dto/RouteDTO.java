package mx.com.pqtx.datos.dto;


public class RouteDTO {
    private String id;
    private Integer daysOfTravel;
    private String orgnBranch;
    private String destBranch;

    public RouteDTO() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getDaysOfTravel() {
        return daysOfTravel;
    }

    public void setDaysOfTravel(Integer daysOfTravel) {
        this.daysOfTravel = daysOfTravel;
    }

    public String getOrgnBranch() {
        return orgnBranch;
    }

    public void setOrgnBranch(String orgnBranch) {
        this.orgnBranch = orgnBranch;
    }

    public String getDestBranch() {
        return destBranch;
    }

    public void setDestBranch(String destBranch) {
        this.destBranch = destBranch;
    }

    

}
