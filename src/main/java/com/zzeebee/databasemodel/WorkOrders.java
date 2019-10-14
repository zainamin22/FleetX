package com.zzeebee.databasemodel;




import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="work_orders"
    ,catalog="iefleetx"
)
public class WorkOrders  implements java.io.Serializable {


     private Integer workOrdersId;
     private Admin admin;
     private Vehicle vehicle;
     private Vendor vendor;
     private Integer odometerReading;
     private String wstatus;
     private Long startTime;
     private Long endTime;
     private Long lastPerformed;
     private String wlabels;
     private String wissues;
     private String serviceTasks;
     private String description;
     private String comments;
     private String wtitle;
     
     

    public WorkOrders() {
    }

    public WorkOrders(Admin admin, Vehicle vehicle, Vendor vendor, Integer odometerReading, String wstatus, Long startTime, Long endTime, Long lastPerformed, String wlabels, String wissues, String serviceTasks, String description, String comments,String wtitle) {
       this.admin = admin;
       this.vehicle = vehicle;
       this.vendor = vendor;
       this.odometerReading = odometerReading;
       this.wstatus = wstatus;
       this.startTime = startTime;
       this.endTime = endTime;
       this.lastPerformed = lastPerformed;
       this.wlabels = wlabels;
       this.wissues = wissues;
       this.serviceTasks = serviceTasks;
       this.description = description;
       this.comments = comments;
       this.wtitle=wtitle;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="work_orders_id", unique=true, nullable=false)
    public Integer getWorkOrdersId() {
        return this.workOrdersId;
    }
    
    public void setWorkOrdersId(Integer workOrdersId) {
        this.workOrdersId = workOrdersId;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="admin_id")
    public Admin getAdmin() {
        return this.admin;
    }
    
    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="vehicle_id")
    public Vehicle getVehicle() {
        return this.vehicle;
    }
    
    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="vender_id")
    public Vendor getVendor() {
        return this.vendor;
    }
    
    public void setVendor(Vendor vendor) {
        this.vendor = vendor;
    }

    
    @Column(name="odometer_reading")
    public Integer getOdometerReading() {
        return this.odometerReading;
    }
    
    public void setOdometerReading(Integer odometerReading) {
        this.odometerReading = odometerReading;
    }

    
    @Column(name="wstatus", length=250)
    public String getWstatus() {
        return this.wstatus;
    }
    
    public void setWstatus(String wstatus) {
        this.wstatus = wstatus;
    }

    
    @Column(name="start_time")
    public Long getStartTime() {
        return this.startTime;
    }
    
    public void setStartTime(Long startTime) {
        this.startTime = startTime;
    }

    
    @Column(name="end_time")
    public Long getEndTime() {
        return this.endTime;
    }
    
    public void setEndTime(Long endTime) {
        this.endTime = endTime;
    }

    
    @Column(name="last_performed")
    public Long getLastPerformed() {
        return this.lastPerformed;
    }
    
    public void setLastPerformed(Long lastPerformed) {
        this.lastPerformed = lastPerformed;
    }

    
    @Column(name="wlabels", length=1000)
    public String getWlabels() {
        return this.wlabels;
    }
    
    public void setWlabels(String wlabels) {
        this.wlabels = wlabels;
    }

    
    @Column(name="wissues", length=3000)
    public String getWissues() {
        return this.wissues;
    }
    
    public void setWissues(String wissues) {
        this.wissues = wissues;
    }

    
    @Column(name="service_tasks", length=3000)
    public String getServiceTasks() {
        return this.serviceTasks;
    }
    
    public void setServiceTasks(String serviceTasks) {
        this.serviceTasks = serviceTasks;
    }

    
    @Column(name="description", length=1000)
    public String getDescription() {
        return this.description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }

    
    @Column(name="comments", length=1500)
    public String getComments() {
        return this.comments;
    }
    
    public void setComments(String comments) {
        this.comments = comments;
    }

    /**
     * @return the wtitle
     */
    @Column(name="wtitle", length=500)
    public String getWtitle() {
        return wtitle;
    }

    /**
     * @param wtitle the wtitle to set
     */
    public void setWtitle(String wtitle) {
        this.wtitle = wtitle;
    }




}


