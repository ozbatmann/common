package com.common.common.dao.sportActivityAttendeeRequest;

import com.common.common.model.sportActivity.SportActivity;
import com.common.common.model.sportActivityAttendeeRequest.SportActivityAttendeeRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;
import java.util.UUID;

public interface SportActivityAttendeeRequestDao extends JpaRepository<SportActivityAttendeeRequest, Serializable> {

    SportActivityAttendeeRequest findById(UUID sportActivityAttendeeRequest);
}
