package com.UST.InterviewFeedback.controller.impl;

import com.UST.InterviewFeedback.controller.InterviewfeedbackController;
import com.UST.InterviewFeedback.dto.InterviewfeedbackDTO;

import com.UST.InterviewFeedback.mapper.InterviewfeedbackMapper;
import com.UST.InterviewFeedback.service.InterviewfeedbackService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequestMapping("/api/interviewfeedback")
@RestController
public class InterviewfeedbackControllerImpl implements InterviewfeedbackController {
    private final InterviewfeedbackService interviewfeedbackService;
    private final InterviewfeedbackMapper interviewfeedbackMapper;

    public InterviewfeedbackControllerImpl(InterviewfeedbackService interviewfeedbackService, InterviewfeedbackMapper interviewfeedbackMapper) {
        this.interviewfeedbackService = interviewfeedbackService;
        this.interviewfeedbackMapper = interviewfeedbackMapper;
    }

    @Override
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public InterviewfeedbackDTO save(@RequestBody InterviewfeedbackDTO interviewfeedbackDTO) {
        Interviewfeedback interviewfeedback = interviewfeedbackMapper.asEntity(interviewfeedbackDTO);
        return interviewfeedbackMapper.asDTO(interviewfeedbackService.save(interviewfeedback));
    }

    @Override
    @GetMapping("/{id}")
    public InterviewfeedbackDTO findById(@PathVariable("id") Long id) {
        Interviewfeedback interviewfeedback = interviewfeedbackService.findById(id).orElse(null);
        return interviewfeedbackMapper.asDTO(interviewfeedback);
    }

    @Override
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        interviewfeedbackService.deleteById(id);
    }

    @Override
    @GetMapping
    public List<InterviewfeedbackDTO> list() {
        return interviewfeedbackMapper.asDTOList(interviewfeedbackService.findAll());
    }

    @Override
    @GetMapping("/page-query")
    public Page<InterviewfeedbackDTO> pageQuery(Pageable pageable) {
        Page<Interviewfeedback> interviewfeedbackPage = interviewfeedbackService.findAll(pageable);
        List<InterviewfeedbackDTO> dtoList = interviewfeedbackPage
                .stream()
                .map(interviewfeedbackMapper::asDTO).collect(Collectors.toList());
        return new PageImpl<>(dtoList, pageable, interviewfeedbackPage.getTotalElements());
    }

    @Override
    @PutMapping("/{id}")
    public InterviewfeedbackDTO update(@RequestBody InterviewfeedbackDTO interviewfeedbackDTO, @PathVariable("id") Long id) {
        Interviewfeedback interviewfeedback = interviewfeedbackMapper.asEntity(interviewfeedbackDTO);
        return interviewfeedbackMapper.asDTO(interviewfeedbackService.update(interviewfeedback, id));
    }
}