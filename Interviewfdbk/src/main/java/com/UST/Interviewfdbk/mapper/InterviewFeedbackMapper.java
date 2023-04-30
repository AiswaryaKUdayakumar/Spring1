package com.UST.Interviewfdbk.mapper;

import com.UST.Interviewfdbk.dto.InterviewFeedbackDTO;
import com.UST.Interviewfdbk.entity.InterviewFeedback;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface InterviewFeedbackMapper extends GenericMapper<InterviewFeedback, InterviewFeedbackDTO> {
    @Override
    @Mapping(target = "id", ignore = false)
    InterviewFeedback asEntity(InterviewFeedbackDTO dto);
}