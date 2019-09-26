package com.common.common.service.review;

import com.common.common.dao.review.ReviewDao;
import com.common.common.dao.user.UserDao;
import com.common.common.dto.base.BaseDto;
import com.common.common.dto.base.ErrorDto;
import com.common.common.dto.base.ListDto;
import com.common.common.dto.base.SuccessDto;
import com.common.common.model.review.Review;
import com.common.common.model.sportActivity.SportActivity;
import com.common.common.request.review.ReviewRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ReviewService {

    @Autowired
    ReviewDao reviewDao;
    @Autowired
    UserDao userDao;

    public BaseDto getAllReviewsByToId(String toId) {
        BaseDto baseDto;

        try {
            List<Review> reviewList  = this.reviewDao.findAllByToId(UUID.fromString(toId));

            baseDto = new ListDto<>(reviewList);
            baseDto.setMessage("All Reviews Successfully Listed");
            baseDto.setStatus(200);

        } catch (Exception ex) {
            baseDto = new ErrorDto();
            baseDto.setMessage(ex.getMessage());
            baseDto.setStatus(500);
        }

        return baseDto;
    }

    public BaseDto saveReview(ReviewRequest reviewRequest){
        BaseDto baseDto;

        try {

            Review review = new Review();
            review.setUser(userDao.findById(UUID.fromString(reviewRequest.getUserId())));
            review.setTo(userDao.findById(UUID.fromString(reviewRequest.getToId())));
            review.setRating(reviewRequest.getRating());
            review.setAttended(reviewRequest.isAttended());
            review.setComment(reviewRequest.getComment());

            this.reviewDao.save(review);

            baseDto = new SuccessDto();
            baseDto.setMessage("Review successfully created");
            baseDto.setStatus(200);
        } catch (Exception ex) {
            baseDto = new ErrorDto();
            baseDto.setMessage(ex.getMessage());
            baseDto.setStatus(500);
        }

        return baseDto;
    }

}
