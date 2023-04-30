package com.UST.Interviewfdbk.controller;

import com.UST.Interviewfdbk.dto.InterviewFeedbackDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Api(tags = "InterviewFeedback API")
public interface InterviewFeedbackController {
    @ApiOperation("Add new data")
    public InterviewFeedbackDTO save(@RequestBody InterviewFeedbackDTO interviewFeedback);

    @ApiOperation("Find by Id")
    public InterviewFeedbackDTO findById(@PathVariable("id") Long id);

    @ApiOperation("Delete based on primary key")
    public void delete(@PathVariable("id") Long id);

    @ApiOperation("Find all data")
    public List<InterviewFeedbackDTO> list();

    @ApiOperation("Pagination request")
    public Page<InterviewFeedbackDTO> pageQuery(Pageable pageable);

    @ApiOperation("Update one data")
    public InterviewFeedbackDTO update(@RequestBody InterviewFeedbackDTO dto, @PathVariable("id") Long id);
}