package com.common.common.controller.sportActivityAttendeeRequest;

import com.common.common.dto.base.BaseDto;
import com.common.common.request.sportActivity.SportActivityAttendeeReqRequest;
import com.common.common.service.sportActivityAttendeeRequest.SportActivityAttendeeRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/activities")
public class SportActivityAttendeeRequestController {

    @Autowired
    SportActivityAttendeeRequestService sportActivityAttendeeRequestService;

    @RequestMapping(value="/attend", method = RequestMethod.POST, produces = {"application/json"})
    public BaseDto attend(@RequestBody SportActivityAttendeeReqRequest sportActivityAttendeeReqRequest) {
        return this.sportActivityAttendeeRequestService.attendToSportActivity(sportActivityAttendeeReqRequest);
    }

    @RequestMapping(value="/accept", method = RequestMethod.GET, produces = {"application/json"})
    public BaseDto accept(@RequestParam String sportActivityAttendeeRequestId) {
        return this.sportActivityAttendeeRequestService.acceptAttentionToTheSportActivity(sportActivityAttendeeRequestId);
    }

    @RequestMapping(value="/decline", method = RequestMethod.GET, produces = {"application/json"})
    public BaseDto decline(@RequestParam String sportActivityAttendeeRequestId) {
        return this.sportActivityAttendeeRequestService.declineAttentionToTheSportActivity(sportActivityAttendeeRequestId);
    }

}
