package com.UST.InterviewFeedback.dao;

import com.UST.InterviewFeedback.entity.Interviewfeedback;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InterviewfeedbackRepository extends PagingAndSortingRepository<Interviewfeedback, Long> {
}