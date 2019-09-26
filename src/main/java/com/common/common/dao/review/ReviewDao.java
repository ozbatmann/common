package com.common.common.dao.review;


import com.common.common.model.review.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

public interface ReviewDao extends JpaRepository<Review, Serializable> {
    List<Review> findAllByToId(UUID toID);
}
