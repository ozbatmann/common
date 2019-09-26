package com.common.common.service.sportActivityAttendee;

import com.common.common.dao.sportActivity.SportActivityDao;
import com.common.common.dao.sportActivityAttendee.SportActivityAttendeeDao;
import com.common.common.dto.base.BaseDto;
import com.common.common.dto.base.ErrorDto;
import com.common.common.dto.base.SuccessDto;
import com.common.common.model.sportActivity.SportActivity;
import com.common.common.model.sportActivityAttendee.SportActivityAttendee;
import com.common.common.model.user.User;
import com.common.common.service.sportActivity.SportActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class SportActivityAttendeeService {


    @Autowired
    SportActivityAttendeeDao sportActivityAttendeeDao;
    SportActivityService sportActivityService;

    public BaseDto addAttendeeToSportActivity(User attendeed, SportActivity sportActivity) {
        BaseDto baseDto;

        try {
            SportActivityAttendee sportActivityAttendee = new SportActivityAttendee();
            sportActivityAttendee.setAttendee(attendeed);
            sportActivityAttendee.setSportActivity(sportActivity);

            this.sportActivityAttendeeDao.save(sportActivityAttendee);
            this.sportActivityService.decrementRemainingSlotAndUpdate(sportActivity);
            baseDto = new SuccessDto();
            baseDto.setMessage("User successfully attend to the sport activity");
            baseDto.setStatus(200);

        } catch (Exception ex) {
            baseDto = new ErrorDto();
            baseDto.setMessage(ex.getMessage());
            baseDto.setStatus(500);
        }

        return baseDto;
    }

    public BaseDto cancelSportActivity(String sportActivityAttendeeId){
        BaseDto baseDto;

        try {
            SportActivityAttendee sportActivityAttendee = sportActivityAttendeeDao.findById(UUID.fromString(sportActivityAttendeeId));

            this.sportActivityAttendeeDao.delete(sportActivityAttendee);

            baseDto = new SuccessDto();
            baseDto.setMessage("User successfully canceled the sport activity request");
            baseDto.setStatus(200);

        } catch (Exception ex) {
            baseDto = new ErrorDto();
            baseDto.setMessage(ex.getMessage());
            baseDto.setStatus(500);
        }

        return baseDto;
    }
}
