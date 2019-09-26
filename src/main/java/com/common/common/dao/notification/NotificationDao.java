package com.common.common.dao.notification;

import com.common.common.model.notification.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;

public interface NotificationDao  extends JpaRepository<Notification, Serializable> {

}
