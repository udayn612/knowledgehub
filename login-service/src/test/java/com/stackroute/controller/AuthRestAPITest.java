//package com.stackroute.controller;
//
//import com.stackroute.domain.User;
//import com.stackroute.repository.UserRepository;
//import com.stackroute.security.jwt.JwtAuthEntryPoint;
//import com.stackroute.security.jwt.JwtProvider;
//import com.stackroute.security.services.UserDetailsServiceImpl;
//import org.junit.After;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.MediaType;
//import org.springframework.security.test.context.support.WithMockUser;
//import org.springframework.security.test.context.support.WithUserDetails;
//import org.springframework.security.web.FilterChainProxy;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//import org.springframework.web.context.WebApplicationContext;
//
//import javax.annotation.Resource;
//
//import static org.junit.Assert.*;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//@RunWith(SpringRunner.class)
//@WebMvcTest
//@ContextConfiguration
//public class AuthRestAPITest {
//
//    @MockBean
//    private JwtAuthEntryPoint jwtAuthEntryPoint;
//    @Resource
//    private FilterChainProxy springSecurityFilterChain;
//
//    @Resource
//    private WebApplicationContext webApplicationContext;
//    @Autowired
//    private MockMvc mockMvc;
//    @MockBean
//    private User user;
//
//    @MockBean
//     private  UserRepository userRepository;
//    @MockBean
//    private JwtProvider jwtProvider;
//
//    @MockBean
//    private UserDetailsServiceImpl userService;
//
//    @InjectMocks
//    private AuthRestAPI authRestAPI;
//
//    @Before
//    public void setUp() throws Exception {
//        MockitoAnnotations.initMocks(this);
//        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext)
//                .addFilter(springSecurityFilterChain)
//                .build();
//    }
//
//
//    @After
//    public void tearDown() throws Exception {
//    }
//
//    @Test
//
//    public void authenticateUser() throws Exception{
//        mockMvc.perform(post("/api/auth/signin")
//                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
//                .param("username", "admin")
//                .param("password", "hub@123")
//        )
//                .andExpect(status().isOk());
//
//    }
//
//
//}