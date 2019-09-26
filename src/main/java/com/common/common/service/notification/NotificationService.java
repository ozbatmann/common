package com.common.common.service.notification;

import com.common.common.dao.notification.NotificationDao;
import com.common.common.dto.base.BaseDto;
import com.common.common.dto.base.ErrorDto;
import com.common.common.dto.base.SuccessDto;
import com.common.common.enums.ActivityRequestType;
import com.common.common.model.notification.Notification;
import com.common.common.model.sportActivity.SportActivity;
import com.common.common.model.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class NotificationService {

    @Autowired
    NotificationDao notificationDao;

    public BaseDto sendNotification(User notificationReceiver, Date createdDate, ActivityRequestType activityRequestType, SportActivity sportActivity) {
        BaseDto baseDto;

        try {
            Notification notification = new Notification();
            notification.setNotificationReceiver(notificationReceiver);
            notification.setCreatedDate(createdDate);
            notification.setActivityRequestType(activityRequestType);
            notification.setSportActivity(sportActivity);

            notificationDao.save(notification);

            baseDto = new SuccessDto();
            baseDto.setMessage("Notification successfully sent");
            baseDto.setStatus(200);

        } catch (Exception ex) {
            baseDto = new ErrorDto();
            baseDto.setMessage(ex.getMessage());
            baseDto.setStatus(500);
        }

        return baseDto;
    }
}
