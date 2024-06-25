package ar.edu.utn.frc.tup.lciii.controllers;

import ar.edu.utn.frc.tup.lciii.config.MappersConfig;
import ar.edu.utn.frc.tup.lciii.dtos.UserDto;
import ar.edu.utn.frc.tup.lciii.helpers.UserHelper;
import ar.edu.utn.frc.tup.lciii.models.User;
import ar.edu.utn.frc.tup.lciii.services.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.Mockito.when;
import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8;
import static org.springframework.mock.http.server.reactive.MockServerHttpRequest.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(UserController.class)
@Import(MappersConfig.class)
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private ModelMapper modelMapper;

    @Test
    void createUser() throws Exception {
        User user = modelMapper.map(UserHelper.getUser(UserHelper.USERNAME, UserHelper.EMAIL_OK), User.class);
        UserDto userDto = modelMapper.map(UserHelper.getUser(UserHelper.USERNAME, UserHelper.EMAIL_OK), UserDto.class);
        when(userService.createUser(userDto.getUserName(), userDto.getEmail())).thenReturn(user);
        this.mockMvc.perform(MockMvcRequestBuilders.post("/guess-number/users").contentType(APPLICATION_JSON_UTF8)
                        .content(objectMapper.writeValueAsString(userDto)))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("$.userName").value(UserHelper.USERNAME))
                .andExpect(jsonPath("$.email").value(UserHelper.EMAIL_OK))
        ;

    }


}
