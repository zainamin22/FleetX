package com.zzeebee.repository;

import com.zzeebee.databasemodel.Reminders;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface ReminderRepository extends CrudRepository<Reminders, Integer> {

    @Query("Select COUNT(i) from Reminders i WHERE i.reminderType=:reminderType and i.issuedType=:issuedType")
    public Long findCountReminders(@Param("reminderType") String reminderType, @Param("issuedType") String issuedType);

    List<Reminders> findByIssuedToIdAndIssuedTo(Integer issuedToId, String issuedTo);

}
