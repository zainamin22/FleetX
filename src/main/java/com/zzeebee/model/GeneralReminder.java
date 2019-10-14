package com.zzeebee.model;

import com.zzeebee.databasemodel.Reminders;

public class GeneralReminder {
      private Integer reminderId;
      private String reminderType;
      private String reminderTitle;
      private String reminderDescription;
      private String issuedTo;
      private Long issuedTime;
      private String issuedType;
      private Integer issuedToId;

    /**
     * @return the reminderId
     */
    public Integer getReminderId() {
        return reminderId;
    }

    /**
     * @param reminderId the reminderId to set
     */
    public void setReminderId(Integer reminderId) {
        this.reminderId = reminderId;
    }

    /**
     * @return the reminderType
     */
    public String getReminderType() {
        return reminderType;
    }

    /**
     * @param reminderType the reminderType to set
     */
    public void setReminderType(String reminderType) {
        this.reminderType = reminderType;
    }

    /**
     * @return the reminderTitle
     */
    public String getReminderTitle() {
        return reminderTitle;
    }

    /**
     * @param reminderTitle the reminderTitle to set
     */
    public void setReminderTitle(String reminderTitle) {
        this.reminderTitle = reminderTitle;
    }

    /**
     * @return the reminderDescription
     */
    public String getReminderDescription() {
        return reminderDescription;
    }

    /**
     * @param reminderDescription the reminderDescription to set
     */
    public void setReminderDescription(String reminderDescription) {
        this.reminderDescription = reminderDescription;
    }

    /**
     * @return the issuedTo
     */
    public String getIssuedTo() {
        return issuedTo;
    }

    /**
     * @param issuedTo the issuedTo to set
     */
    public void setIssuedTo(String issuedTo) {
        this.issuedTo = issuedTo;
    }

    /**
     * @return the issuedTime
     */
    public Long getIssuedTime() {
        return issuedTime;
    }

    /**
     * @param issuedTime the issuedTime to set
     */
    public void setIssuedTime(Long issuedTime) {
        this.issuedTime = issuedTime;
    }

    /**
     * @return the issuedType
     */
    public String getIssuedType() {
        return issuedType;
    }

    /**
     * @param issuedType the issuedType to set
     */
    public void setIssuedType(String issuedType) {
        this.issuedType = issuedType;
    }

    /**
     * @return the issuedToId
     */
    public Integer getIssuedToId() {
        return issuedToId;
    }

    /**
     * @param issuedToId the issuedToId to set
     */
    public void setIssuedToId(Integer issuedToId) {
        this.issuedToId = issuedToId;
    }
    
    
    public static GeneralReminder getGeneralReminder (Reminders r){
        GeneralReminder gen=new GeneralReminder();
        gen.setIssuedTime(r.getIssuedTime());
        gen.setIssuedTo(r.getIssuedTo());
        gen.setIssuedToId(r.getIssuedToId());
        gen.setIssuedType(r.getIssuedType());
        gen.setReminderDescription(r.getReminderDescription());
        gen.setReminderId(r.getReminderId());
        gen.setReminderTitle(r.getReminderTitle());
        gen.setReminderType(r.getReminderType());
        
        return gen;
        
    }
    
    public static Reminders getReminder (GeneralReminder r){
        Reminders gen=new Reminders();
        gen.setIssuedTime(r.getIssuedTime());
        gen.setIssuedTo(r.getIssuedTo());
        gen.setIssuedToId(r.getIssuedToId());
        gen.setIssuedType(r.getIssuedType());
        gen.setReminderDescription(r.getReminderDescription());
        gen.setReminderId(r.getReminderId());
        gen.setReminderTitle(r.getReminderTitle());
        gen.setReminderType(r.getReminderType());
        
        return gen;
        
    }
    
    
    
}
