package com.common.common.controller.review;

import com.common.common.dto.base.BaseDto;
import com.common.common.request.review.ReviewRequest;
import com.common.common.service.review.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/review")
public class ReviewController {

    @Autowired
    ReviewService reviewService;

    @RequestMapping(method = RequestMethod.GET, produces = {"application/json"})
    public BaseDto getAllReviewsByToId(@RequestParam String toId) {
        return this.reviewService.getAllReviewsByToId(toId);
    }

    @RequestMapping(method = RequestMethod.POST, produces = {"application/json"})
    public BaseDto save(@RequestBody ReviewRequest reviewRequest) {
        return this.reviewService.saveReview(reviewRequest);
    }
}

