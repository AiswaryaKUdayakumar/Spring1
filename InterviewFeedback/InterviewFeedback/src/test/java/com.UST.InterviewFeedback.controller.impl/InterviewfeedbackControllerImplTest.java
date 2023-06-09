package com.UST.InterviewFeedback.controller.impl;

import com.UST.InterviewFeedback.entity.Interviewfeedback;
import com.UST.InterviewFeedback.mapper.InterviewfeedbackMapper;
import com.UST.InterviewFeedback.service.InterviewfeedbackService;
import org.hamcrest.Matchers;
import org.hamcrest.core.Is;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@SpringBootTest
@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
public class InterviewfeedbackControllerImplTest {
    //TODO: create the data Test generator class InterviewfeedbackBuilder
    private static final String ENDPOINT_URL = "/interviewfeedbacks";
    @MockBean
    private ReferenceMapper referenceMapper;
    @InjectMocks
    private InterviewfeedbackControllerImpl interviewfeedbackController;
    @MockBean
    private InterviewfeedbackService interviewfeedbackService;
    @MockBean
    private InterviewfeedbackMapper interviewfeedbackMapper;
    @Autowired
    private MockMvc mockMvc;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(this.interviewfeedbackController).build();
    }

    @Test
    public void getAll() throws Exception {
        Mockito.when(interviewfeedbackMapper.asDTOList(ArgumentMatchers.any())).thenReturn(InterviewfeedbackBuilder.getListDTO());

        Mockito.when(interviewfeedbackService.findAll()).thenReturn(InterviewfeedbackBuilder.getListEntities());
        mockMvc.perform(MockMvcRequestBuilders.get(ENDPOINT_URL))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content()
                        .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.hasSize(2)));

    }

    @Test
    public void getById() throws Exception {
        Mockito.when(interviewfeedbackMapper.asDTO(ArgumentMatchers.any())).thenReturn(InterviewfeedbackBuilder.getDTO());

        Mockito.when(interviewfeedbackService.findById(ArgumentMatchers.anyLong())).thenReturn(java.util.Optional.of(InterviewfeedbackBuilder.getEntity()));

        mockMvc.perform(MockMvcRequestBuilders.get(ENDPOINT_URL + "/1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content()
                        .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.jsonPath("$.id", Is.is(1)));
        Mockito.verify(interviewfeedbackService, Mockito.times(1)).findById(1L);
        Mockito.verifyNoMoreInteractions(interviewfeedbackService);
    }

    @Test
    public void save() throws Exception {
        Mockito.when(interviewfeedbackMapper.asEntity(ArgumentMatchers.any())).thenReturn(InterviewfeedbackBuilder.getEntity());
        Mockito.when(interviewfeedbackService.save(ArgumentMatchers.any(Interviewfeedback.class))).thenReturn(InterviewfeedbackBuilder.getEntity());

        mockMvc.perform(
                        MockMvcRequestBuilders.post(ENDPOINT_URL)
                                .contentType(MediaType.APPLICATION_JSON_UTF8)
                                .content(CustomUtils.asJsonString(InterviewfeedbackBuilder.getDTO())))
                .andExpect(MockMvcResultMatchers.status().isCreated());
        Mockito.verify(interviewfeedbackService, Mockito.times(1)).save(ArgumentMatchers.any(Interviewfeedback.class));
        Mockito.verifyNoMoreInteractions(interviewfeedbackService);
    }

    @Test
    public void update() throws Exception {
        Mockito.when(interviewfeedbackMapper.asEntity(ArgumentMatchers.any())).thenReturn(InterviewfeedbackBuilder.getEntity());
        Mockito.when(interviewfeedbackService.update(ArgumentMatchers.any(), ArgumentMatchers.anyLong())).thenReturn(InterviewfeedbackBuilder.getEntity());

        mockMvc.perform(
                        MockMvcRequestBuilders.put(ENDPOINT_URL + "/1")
                                .contentType(MediaType.APPLICATION_JSON_UTF8)
                                .content(CustomUtils.asJsonString(InterviewfeedbackBuilder.getDTO())))
                .andExpect(MockMvcResultMatchers.status().isOk());
        Mockito.verify(interviewfeedbackService, Mockito.times(1)).update(ArgumentMatchers.any(Interviewfeedback.class), ArgumentMatchers.anyLong());
        Mockito.verifyNoMoreInteractions(interviewfeedbackService);
    }

    @Test
    public void delete() throws Exception {
        Mockito.doNothing().when(interviewfeedbackService).deleteById(ArgumentMatchers.anyLong());
        mockMvc.perform(
                        MockMvcRequestBuilders.delete(ENDPOINT_URL + "/1"))
                .andExpect(MockMvcResultMatchers.status().isOk());
        Mockito.verify(interviewfeedbackService, Mockito.times(1)).deleteById(Mockito.anyLong());
        Mockito.verifyNoMoreInteractions(interviewfeedbackService);
    }