package com.UST.InterviewFeedback.controller;

import com.UST.InterviewFeedback.dto.InterviewfeedbackDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Api(tags = "Interviewfeedback API")
public interface InterviewfeedbackController {
    @ApiOperation("Add new data")
    public InterviewfeedbackDTO save(@RequestBody InterviewfeedbackDTO interviewfeedback);

    @ApiOperation("Find by Id")
    public InterviewfeedbackDTO findById(@PathVariable("id") Long id);

    @ApiOperation("Delete based on primary key")
    public void delete(@PathVariable("id") Long id);

    @ApiOperation("Find all data")
    public List<InterviewfeedbackDTO> list();

    @ApiOperation("Pagination request")
    public Page<InterviewfeedbackDTO> pageQuery(Pageable pageable);

    @ApiOperation("Update one data")
    public InterviewfeedbackDTO update(@RequestBody InterviewfeedbackDTO dto, @PathVariable("id") Long id);
}