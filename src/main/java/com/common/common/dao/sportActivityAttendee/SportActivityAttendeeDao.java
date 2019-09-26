package com.common.common.dao.sportActivityAttendee;

import com.common.common.model.sportActivityAttendee.SportActivityAttendee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;
import java.util.UUID;

public interface SportActivityAttendeeDao extends JpaRepository<SportActivityAttendee, Serializable> {

    SportActivityAttendee findById(UUID sportActivityAttendeeId);
}
