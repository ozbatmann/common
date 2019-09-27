package com.common.common.dao.sportActivity;

import com.common.common.model.sportActivity.SportActivity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

public interface SportActivityDao extends JpaRepository<SportActivity, Serializable> {

    SportActivity findById(UUID sportActivityId);

    @Query("SELECT sprtacts FROM SportActivity AS sprtacts WHERE " +
            "sprtacts.ageRangeMax <= :maxAge AND " +
            "sprtacts.ageRangeMin >= :minAge AND " +
            "sprtacts.activityType IN :activityTypes AND " +
            "sprtacts.pricingType IN :pricingTypes AND " +
            "sprtacts.startDate IN :dates AND " +
            "sprtacts.lat <= :lat AND " +
            "sprtacts.lon <= :lon")
    List<SportActivity> findFilteredSportActivities(float lat, float lon, double maxAge, double minAge, List dates);


    List<SportActivity> findAll();
}
