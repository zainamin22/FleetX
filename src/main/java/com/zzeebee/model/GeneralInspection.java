package com.zzeebee.model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.zzeebee.databasemodel.Driver;
import com.zzeebee.databasemodel.Inspection;
import com.zzeebee.databasemodel.Vehicle;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GeneralInspection {

    private Integer inspectionId;
    private Integer driverId;
    private Integer vehicleId;
    private Integer odometerReading;
    private Long endingTime;
    private Long startingTime;
    private String istatus;
    private String statusColor;
    private String ititle;
    private String idescription;
    private Long ilastPerformed;
    private String lastPerformedText;
    private Integer total;
    private Integer checked;
    private ArrayList<Part> parts;
    private List<String> names;
    private List<String> ids;
    private String partsJson;
    private String template;
    private Integer dateCheck;
    private Long dummyTime;
    private Integer reolved;
    private Integer unresolved;
    private String driver_name;
    private String vehicle_name;
    private Double percentage;

    public GeneralInspection() {
    }

    /**
     * @return the inspectionId
     */
    public Integer getInspectionId() {
        return inspectionId;
    }

    /**
     * @param inspectionId the inspectionId to set
     */
    public void setInspectionId(Integer inspectionId) {
        this.inspectionId = inspectionId;
    }

    /**
     * @return the driverId
     */
    public Integer getDriverId() {
        return driverId;
    }

    /**
     * @param driver the driverId to set
     */
    public void setDriverId(Integer driver) {
        this.driverId = driver;
    }

    /**
     * @return the vehicleId
     */
    public Integer getVehicleId() {
        return vehicleId;
    }

    /**
     * @param vehicle the vehicleId to set
     */
    public void setVehicleId(Integer vehicle) {
        this.vehicleId = vehicle;
    }

    /**
     * @return the odometerReading
     */
    public Integer getOdometerReading() {
        return odometerReading;
    }

    /**
     * @param odometerReading the odometerReading to set
     */
    public void setOdometerReading(Integer odometerReading) {
        this.odometerReading = odometerReading;
    }

    /**
     * @return the endingTime
     */
    public Long getEndingTime() {
        return endingTime;
    }

    /**
     * @param endingTime the endingTime to set
     */
    public void setEndingTime(Long endingTime) {
        this.endingTime = endingTime;
    }

    /**
     * @return the startingTime
     */
    public Long getStartingTime() {
        return startingTime;
    }

    /**
     * @param startingTime the startingTime to set
     */
    public void setStartingTime(Long startingTime) {
        this.startingTime = startingTime;
    }

    /**
     * @return the istatus
     */
    public String getIstatus() {
        return istatus;
    }

    /**
     * @param istatus the istatus to set
     */
    public void setIstatus(String istatus) {
        this.istatus = istatus;
    }

    public static Inspection getInspection(GeneralInspection ins) {
        Inspection i = new Inspection();
        i.setInspectionId(ins.getInspectionId());
        Driver d = new Driver();
        d.setDriverId(ins.getDriverId());
        i.setDriver(d);
        i.setEndingTime(ins.getEndingTime());
        i.setIstatus(ins.getIstatus());
        i.setOdometerReading(ins.getOdometerReading());
        i.setStartingTime(ins.getStartingTime());
        Vehicle v = new Vehicle();
        v.setVehicleId(ins.getVehicleId());
        i.setVehicle(v);
        i.setIlastPerformed(ins.getIlastPerformed());
        i.setItitle(ins.getItitle());
        i.setIdescription(ins.getIdescription());
        i.setIparts(ins.getPartsJson());

        return i;
    }

    public static GeneralInspection getGeneralInspection(Inspection ins) {
        GeneralInspection i = new GeneralInspection();
        i.setInspectionId(ins.getInspectionId());
        i.setDriverId(ins.getDriver().getDriverId());
        i.setEndingTime(ins.getEndingTime());
        i.setIstatus(ins.getIstatus());
        i.setOdometerReading(ins.getOdometerReading());
        i.setStartingTime(ins.getStartingTime());
        i.setVehicleId(ins.getVehicle().getVehicleId());
        i.setIlastPerformed(ins.getIlastPerformed());
        i.setItitle(ins.getItitle());
        i.setIdescription(ins.getIdescription());
        i.setPartsJson(ins.getIparts());

        return i;
    }

    public static Map<String, String> getInspectionItems() {
        Map<String, String> items = new HashMap<>();

        items.put("iengine", "Engine");
        items.put("itransmission", "Transmission");
        items.put("iclutch", "Clutch");
        items.put("isteeringMechanism", "Steering Mechanism");
        items.put("ihorn", "Horn");
        items.put("itires", "Tires");
        items.put("iwheelRims", "Wheel Rims");
        items.put("iparkingBrake", "Parking Brake");
        items.put("iserviceBrake", "Service Brake");
        items.put("icouplingDevice", "Coupling Device");
        items.put("iwindsheildWipers", "Wind Sheild Wipers");
        items.put("irearVisionMirror", "Rear Vision Mirror");
        return items;

    }

    /**
     * @return the ititle
     */
    public String getItitle() {
        return ititle;
    }

    /**
     * @param ititle the ititle to set
     */
    public void setItitle(String ititle) {
        this.ititle = ititle;
    }

    /**
     * @return the idescription
     */
    public String getIdescription() {
        return idescription;
    }

    /**
     * @param idescription the idescription to set
     */
    public void setIdescription(String idescription) {
        this.idescription = idescription;
    }

    /**
     * @return the ilastPerformed
     */
    public Long getIlastPerformed() {
        return ilastPerformed;
    }

    /**
     * @param ilastPerformed the ilastPerformed to set
     */
    public void setIlastPerformed(Long ilastPerformed) {
        this.ilastPerformed = ilastPerformed;
    }

    /**
     * @return the total
     */
    public Integer getTotal() {
        return total;
    }

    /**
     * @param total the total to set
     */
    public void setTotal(Integer total) {
        this.total = total;
    }

    public void setTotal() {
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();
        Gson gson = builder.create();
        Type type = new TypeToken<List<Part>>() {
        }.getType();
        parts = gson.fromJson(getPartsJson(), type);

        total = parts.size();

    }

    /**
     * @return the checked
     */
    public Integer getChecked() {
        return checked;
    }

    /**
     * @param checked the checked to set
     */
    public void setChecked(Integer checked) {
        this.checked = checked;
    }

    public void setChecked() {
        checked = 0;

        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();
        Gson gson = builder.create();

        Type type = new TypeToken<List<Part>>() {
        }.getType();
        parts = gson.fromJson(getPartsJson(), type);
        parts.forEach((item) -> {
            if (InspectionStatus.YES_STATUS.equals(item.getStatus()) || InspectionStatus.NO_STATUS.equals(item.getStatus())) {
                checked++;
            }
        });

    }

    public void setResolved() {
        reolved = 0;

        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();
        Gson gson = builder.create();

        Type type = new TypeToken<List<Part>>() {
        }.getType();
        parts = gson.fromJson(getPartsJson(), type);
        parts.forEach((item) -> {
            if (InspectionStatus.YES_STATUS.equals(item.getStatus())) {
                reolved++;
            }
        });

    }

    public void setUnResolved() {
        unresolved = 0;

        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();
        Gson gson = builder.create();

        Type type = new TypeToken<List<Part>>() {
        }.getType();
        parts = gson.fromJson(getPartsJson(), type);
        parts.forEach((item) -> {
            if (InspectionStatus.NO_STATUS.equals(item.getStatus())) {
                unresolved++;
            }
        });

    }
    
    public void setParts (){        
         GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();
        Gson gson = builder.create();

        Type type = new TypeToken<List<Part>>() {
        }.getType();
        parts = gson.fromJson(getPartsJson(), type);
        
    }
    

    /**
     * @return the parts
     */
    public ArrayList<Part> getParts() {
        return parts;
    }

    /**
     * @param parts the parts to set
     */
    public void setParts(ArrayList<Part> parts) {
        this.parts = parts;
    }

    /**
     * @return the names
     */
    public List<String> getNames() {
        return names;
    }

    /**
     * @param names the names to set
     */
    public void setNames(List<String> names) {
        this.names = names;
    }

    /**
     * @return the ids
     */
    public List<String> getIds() {
        return ids;
    }

    /**
     * @param ids the ids to set
     */
    public void setIds(List<String> ids) {
        this.ids = ids;
    }

    /**
     * @return the partsJson
     */
    public String getPartsJson() {
        return partsJson;
    }

    /**
     * @param partsJson the partsJson to set
     */
    public void setPartsJson(String partsJson) {
        this.partsJson = partsJson;
    }

    /**
     * @return the template
     */
    public String getTemplate() {
        return template;
    }

    /**
     * @param template the template to set
     */
    public void setTemplate(String template) {
        this.template = template;
    }

    /**
     * @return the dateCheck
     */
    public Integer getDateCheck() {
        return dateCheck;
    }

    /**
     * @param dateCheck the dateCheck to set
     */
    public void setDateCheck(Integer dateCheck) {
        this.dateCheck = dateCheck;
    }

    /**
     * @return the dummyTime
     */
    public Long getDummyTime() {
        return dummyTime;
    }

    /**
     * @param dummyTime the dummyTime to set
     */
    public void setDummyTime(Long dummyTime) {
        this.dummyTime = dummyTime;
    }

    /**
     * @return the reolved
     */
    public Integer getReolved() {
        return reolved;
    }

    /**
     * @param reolved the reolved to set
     */
    public void setReolved(Integer reolved) {
        this.reolved = reolved;
    }

    /**
     * @return the unresolved
     */
    public Integer getUnresolved() {
        return unresolved;
    }

    /**
     * @param unresolved the unresolved to set
     */
    public void setUnresolved(Integer unresolved) {
        this.unresolved = unresolved;
    }

    /**
     * @return the lastPerformedText
     */
    public String getLastPerformedText() {
        return lastPerformedText;
    }

    /**
     * @param lastPerformedText the lastPerformedText to set
     */
    public void setLastPerformedText(String lastPerformedText) {
        this.lastPerformedText = lastPerformedText;
    }

    /**
     * @return the statusColor
     */
    public String getStatusColor() {
        return statusColor;
    }

    /**
     * @param statusColor the statusColor to set
     */
    public void setStatusColor(String statusColor) {
        this.statusColor = statusColor;
    }

    /**
     * @return the driver_name
     */
    public String getDriver_name() {
        return driver_name;
    }

    /**
     * @param driver_name the driver_name to set
     */
    public void setDriver_name(String driver_name) {
        this.driver_name = driver_name;
    }

    /**
     * @return the vehicle_name
     */
    public String getVehicle_name() {
        return vehicle_name;
    }

    /**
     * @param vehicle_name the vehicle_name to set
     */
    public void setVehicle_name(String vehicle_name) {
        this.vehicle_name = vehicle_name;
    }

    /**
     * @return the percentage
     */
    public Double getPercentage() {
        return percentage;
    }

    /**
     * @param percentage the percentage to set
     */
    public void setPercentage(Double percentage) {
        this.percentage = percentage;
    }
    
    
     public void setPercentage() {
      setChecked();
      setTotal();
      percentage= (double)getPercentage(checked,total);
     
         
    }
     
     
      public static float getPercentage(int n, int total) {
    float proportion = ((float) n) / ((float) total);
    return proportion * 100;
}
    
    
    

}
