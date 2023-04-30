package com.UST.Interviewfdbk.dao;

import com.UST.Interviewfdbk.entity.InterviewFeedback;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InterviewFeedbackRepository extends PagingAndSortingRepository<InterviewFeedback, Long> {
}