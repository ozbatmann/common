package com.common.common.controller.sportActivity;

import com.common.common.dto.base.BaseDto;
import com.common.common.model.sportActivity.SportActivity;
import com.common.common.request.sportActivity.SportActivityFilterRequest;
import com.common.common.request.sportActivity.SportActivityRequest;
import com.common.common.service.sportActivity.SportActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/sportActivity")
public class SportActivityController {

    @Autowired
    SportActivityService sportActivityService;

    @RequestMapping(value="/getAllSportActivities", method = RequestMethod.POST, produces = {"application/json"})
    public BaseDto get(@RequestBody SportActivityFilterRequest sportActivityFilterRequest) {
        return this.sportActivityService.getAllSportActivities(sportActivityFilterRequest);
    }

    @RequestMapping(method = RequestMethod.POST, produces = {"application/json"})
    public BaseDto save(@RequestBody SportActivityRequest sportActivityRequest, HttpServletRequest httpServletRequest) {
        return this.sportActivityService.saveSportActivity(sportActivityRequest,httpServletRequest.getHeader("Authorization").substring(7));
    }

    @RequestMapping(method = RequestMethod.PATCH, produces = {"application/json"})
    public BaseDto update(@RequestBody SportActivityRequest sportActivityRequest) throws Exception {
        return this.sportActivityService.updateSportActivity(sportActivityRequest);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public void updateById(@PathVariable("id") Long id, @RequestBody SportActivityRequest sportActivityRequest) {

    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = {"application/json"})
    public BaseDto delete(@PathVariable String id) {
        return this.sportActivityService.deleteSportActivity(id);
    }
}
