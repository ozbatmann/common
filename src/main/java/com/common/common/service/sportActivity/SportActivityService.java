package com.common.common.service.sportActivity;

import com.common.common.dao.auth.AuthDao;
import com.common.common.dao.sportActivity.SportActivityDao;
import com.common.common.dao.user.UserDao;
import com.common.common.dto.base.BaseDto;
import com.common.common.dto.base.ErrorDto;
import com.common.common.dto.base.ListDto;
import com.common.common.dto.base.SuccessDto;
import com.common.common.enums.ActivityType;
import com.common.common.enums.PricingType;
import com.common.common.model.sportActivity.SportActivity;
import com.common.common.model.user.User;
import com.common.common.request.sportActivity.SportActivityFilterRequest;
import com.common.common.request.sportActivity.SportActivityRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.UUID;

@Service
public class SportActivityService {

    @Autowired
    SportActivityDao sportActivityDao;
    @Autowired
    UserDao userDao;
    @Autowired
    AuthDao authDao;

    private static final SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

    public BaseDto getAllSportActivities(SportActivityFilterRequest sportActivityFilterRequest) {
        BaseDto baseDto;

        try {
            System.out.println(sportActivityFilterRequest.getActivityTypes());
            System.out.println(sportActivityFilterRequest.getPricingTypes());

            List<SportActivity> sportActivityList  = this.sportActivityDao.findFilteredSportActivities(sportActivityFilterRequest.getLat(), sportActivityFilterRequest.getLon(),sportActivityFilterRequest.getMaxAge(),sportActivityFilterRequest.getMinAge(),sportActivityFilterRequest.getStartDates());

            baseDto = new ListDto<>(sportActivityList);
            baseDto.setMessage("All Sport Activities Successfully Listed");
            baseDto.setStatus(200);

        } catch (Exception ex) {
            baseDto = new ErrorDto();
            baseDto.setMessage(ex.getMessage());
            baseDto.setStatus(500);
        }

        return baseDto;
    }

    public BaseDto saveSportActivity(SportActivityRequest sportActivityRequest,String token){
        BaseDto baseDto;

        try {
            User user = authDao.findByToken(token).getAuthUser();

            SportActivity sportActivity = new SportActivity();
            sportActivity.setActivityType(ActivityType.valueOf(sportActivityRequest.getActivityType().name()));
            sportActivity.setPricingType(PricingType.valueOf(sportActivityRequest.getPricingType().name()));
            sportActivity.setOwner(user);
            sportActivity.setLat(sportActivityRequest.getLat());
            sportActivity.setLon(sportActivityRequest.getLon());
            sportActivity.setAgeRangeMin(sportActivityRequest.getAgeRangeMin());
            sportActivity.setAgeRangeMax(sportActivityRequest.getAgeRangeMax());
            sportActivity.setPrice(sportActivityRequest.getPrice());
            sportActivity.setRemainingSlot(sportActivityRequest.getRemainingSlot());
            sportActivity.setStartDate(formatter.parse(sportActivityRequest.getStartDate()));
            sportActivity.setEndDate(formatter.parse(sportActivityRequest.getEndDate()));

            this.sportActivityDao.save(sportActivity);

            baseDto = new SuccessDto();
            baseDto.setMessage("Sport activity successfully created");
            baseDto.setStatus(200);
        } catch (Exception ex) {
            baseDto = new ErrorDto();
            baseDto.setMessage(ex.getMessage());
            baseDto.setStatus(500);
        }

        return baseDto;
    }

    public BaseDto updateSportActivity(SportActivityRequest sportActivityRequest){
        BaseDto baseDto;

        try {

            SportActivity sportActivity = sportActivityDao.findById(UUID.fromString(sportActivityRequest.getId()));
            sportActivity.setActivityType(ActivityType.valueOf(sportActivityRequest.getActivityType().name()));
            sportActivity.setOwner(userDao.findById(UUID.fromString(sportActivityRequest.getOwnerId())));
            sportActivity.setLat(sportActivityRequest.getLat());
            sportActivity.setLon(sportActivityRequest.getLon());
            sportActivity.setAgeRangeMin(sportActivityRequest.getAgeRangeMin());
            sportActivity.setAgeRangeMax(sportActivityRequest.getAgeRangeMax());
            sportActivity.setPrice(sportActivityRequest.getPrice());
            sportActivity.setRemainingSlot(sportActivityRequest.getRemainingSlot());

            this.sportActivityDao.save(sportActivity);

            baseDto = new SuccessDto();
            baseDto.setMessage("Sport activity successfully updated");
            baseDto.setStatus(200);
        } catch (Exception ex) {
            baseDto = new ErrorDto();
            baseDto.setMessage(ex.getMessage());
            baseDto.setStatus(500);
        }

        return baseDto;
    }

    public BaseDto deleteSportActivity(String sportActivityId) {
        BaseDto baseDto;

        try {

            SportActivity sportActivity = this.sportActivityDao.findById(UUID.fromString(sportActivityId));

            this.sportActivityDao.delete(sportActivity);

            baseDto = new SuccessDto();
            baseDto.setMessage("Sport Activity Successfully Deleted");
            baseDto.setStatus(200);

        } catch (Exception ex) {
            baseDto = new ErrorDto();
            baseDto.setMessage(ex.getMessage());
            baseDto.setStatus(500);
        }

        return baseDto;
    }

    public void decrementRemainingSlotAndUpdate(SportActivity sportActivity){
        sportActivity.setRemainingSlot(sportActivity.getRemainingSlot() - 1);
        this.sportActivityDao.save(sportActivity);
    }

}
