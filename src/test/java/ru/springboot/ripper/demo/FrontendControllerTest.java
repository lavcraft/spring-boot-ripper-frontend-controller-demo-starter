package ru.springboot.ripper.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@SpringJUnitConfig
@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = RANDOM_PORT,
        classes = FrontendControllerTest.TestFrontendControllerConfiguraiton.class
)
public class FrontendControllerTest {
    //for webflux
    //@Autowired WebTestClient webTestClient;

    //for mvc
    @Autowired MockMvc mvc;

    @Test
    public void should_wrap_controller_response() throws Exception {
        //for mvc
        mvc.perform(get("/unusual/hero"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(jsonPath("$.result.name", equalTo("-")));

        //for webflux
        //webTestClient.get()
        //        .uri("/unusual/hero")
        //        .exchange()
        //        .expectStatus().isOk()
        //        .expectBody().jsonPath("$.result.name", equalTo("-"));
    }

    @Test
    public void should_not_wrap_controller_response() throws Exception {
        mvc.perform(get("/hero"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(jsonPath("$.name", equalTo("-")));
    }

    @SpringBootApplication
    public static class TestFrontendControllerConfiguraiton {

        @RestController
        public static class UsualController {
            @RequestMapping("/hero")
            public HeroResponse heroResponse() {
                return new HeroResponse().setName("-");
            }
        }


        @FrontendController
        public static class UnusualController {
            @RequestMapping("/unusual/hero")
            public HeroResponse heroResponse() {
                return new HeroResponse().setName("-");
            }
        }
    }
}
