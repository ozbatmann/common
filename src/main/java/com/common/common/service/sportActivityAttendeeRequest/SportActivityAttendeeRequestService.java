package com.common.common.service.sportActivityAttendeeRequest;

import com.common.common.dao.sportActivity.SportActivityDao;
import com.common.common.dao.sportActivityAttendeeRequest.SportActivityAttendeeRequestDao;
import com.common.common.dao.user.UserDao;
import com.common.common.dto.base.BaseDto;
import com.common.common.dto.base.ErrorDto;
import com.common.common.dto.base.SuccessDto;
import com.common.common.enums.ActivityRequestType;
import com.common.common.model.sportActivity.SportActivity;
import com.common.common.model.sportActivityAttendee.SportActivityAttendee;
import com.common.common.model.sportActivityAttendeeRequest.SportActivityAttendeeRequest;
import com.common.common.request.sportActivity.SportActivityAttendeeReqRequest;
import com.common.common.service.notification.NotificationService;
import com.common.common.service.sportActivity.SportActivityService;
import com.common.common.service.sportActivityAttendee.SportActivityAttendeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

@Service
public class SportActivityAttendeeRequestService {

    @Autowired
    SportActivityAttendeeRequestDao sportActivityAttendeeRequestDao;
    @Autowired
    UserDao userDao;
    @Autowired
    SportActivityDao sportActivityDao;
    @Autowired
    SportActivityAttendeeService sportActivityAttendeeService;
    @Autowired
    NotificationService notificationService;

    public BaseDto attendToSportActivity(SportActivityAttendeeReqRequest sportActivityAttendeeReqRequest) {
        BaseDto baseDto;

        try {
            SportActivityAttendeeRequest sportActivityAttendeeRequest = new SportActivityAttendeeRequest();
            sportActivityAttendeeRequest.setRequestOwner(userDao.findById(UUID.fromString(sportActivityAttendeeReqRequest.getRequestOwnerId())));
            sportActivityAttendeeRequest.setActivityOwner(userDao.findById(UUID.fromString(sportActivityAttendeeReqRequest.getActivityOwnerId())));
            sportActivityAttendeeRequest.setSportActivity(sportActivityDao.findById(UUID.fromString(sportActivityAttendeeReqRequest.getActivityId())));
            sportActivityAttendeeRequest.setActivityRequestType(ActivityRequestType.REQUESTED);

            this.sportActivityAttendeeRequestDao.save(sportActivityAttendeeRequest);

            baseDto = new SuccessDto();
            baseDto.setMessage("User successfully requested to attend to the sport activity");
            baseDto.setStatus(200);

            notificationService.sendNotification(userDao.findById(UUID.fromString(sportActivityAttendeeReqRequest.getActivityOwnerId())), new Date(), ActivityRequestType.REQUESTED, sportActivityDao.findById(UUID.fromString(sportActivityAttendeeReqRequest.getActivityId())));
        } catch (Exception ex) {
            baseDto = new ErrorDto();
            baseDto.setMessage(ex.getMessage());
            baseDto.setStatus(500);
        }

        return baseDto;
    }

    public BaseDto acceptAttentionToTheSportActivity(String sportActivityAttendeeRequestId) {
        BaseDto baseDto;

        try {
            SportActivityAttendeeRequest sportActivityAttendeeRequest = sportActivityAttendeeRequestDao.findById(UUID.fromString(sportActivityAttendeeRequestId));
            sportActivityAttendeeRequest.setActivityRequestType(ActivityRequestType.ACCEPTED);

            this.sportActivityAttendeeRequestDao.save(sportActivityAttendeeRequest);

            baseDto = new SuccessDto();
            baseDto.setMessage("User successfully accept the activity request");
            baseDto.setStatus(200);

            sportActivityAttendeeService.addAttendeeToSportActivity(sportActivityAttendeeRequest.getRequestOwner(),sportActivityAttendeeRequest.getSportActivity());
            notificationService.sendNotification(sportActivityAttendeeRequest.getRequestOwner(), new Date(), ActivityRequestType.ACCEPTED, sportActivityAttendeeRequest.getSportActivity());
        } catch (Exception ex) {
            baseDto = new ErrorDto();
            baseDto.setMessage(ex.getMessage());
            baseDto.setStatus(500);
        }

        return baseDto;
    }
    public BaseDto declineAttentionToTheSportActivity(String sportActivityAttendeeRequestId) {
        BaseDto baseDto;

        try {
            SportActivityAttendeeRequest sportActivityAttendeeRequest = sportActivityAttendeeRequestDao.findById(UUID.fromString(sportActivityAttendeeRequestId));
            sportActivityAttendeeRequest.setActivityRequestType(ActivityRequestType.DECLINED);

            this.sportActivityAttendeeRequestDao.save(sportActivityAttendeeRequest);

            baseDto = new SuccessDto();
            baseDto.setMessage("User successfully accept the activity request");
            baseDto.setStatus(200);

            notificationService.sendNotification(sportActivityAttendeeRequest.getRequestOwner(), new Date(), ActivityRequestType.DECLINED, sportActivityAttendeeRequest.getSportActivity());
        } catch (Exception ex) {
            baseDto = new ErrorDto();
            baseDto.setMessage(ex.getMessage());
            baseDto.setStatus(500);
        }

        return baseDto;
    }

}
