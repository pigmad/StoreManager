package controller;

import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.ArrayList;

import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.mock.web.MockHttpSession;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.when;

import service.StoreService;
import service.ShelfService;
import service.SellerService;

import entity.Director;
import entity.Seller;
import entity.Store;
import entity.Shelf;

/**
 *
 * @author laste
 */
public class HomeControllerTest {

    private MockMvc mockMvc;

    private MockHttpSession session;

    private HomeController controllerUnderTest = new HomeController();

    private Director director;

    private Seller seller;

    @Before
    public void setup() {
        director = new Director();
        seller = new Seller();

        session = new MockHttpSession();
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(controllerUnderTest).build();
    }

    @Test
    public void get_index_shouldReturn() throws Exception {
        this.mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("index"))
                .andExpect(model().attributeExists("date"))
                .andExpect(model().attributeExists("time"))
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }

    @Test
    public void get_home_loggedDirector_shouldReturnHome() throws Exception {
        session.setAttribute("user", director);
        this.mockMvc.perform(get("/home").session(session))
                .andExpect(status().isOk())
                .andExpect(view().name("homepage"))
                .andExpect(model().attributeExists("date"))
                .andExpect(model().attributeExists("time"))
                .andExpect(model().attributeExists("user"))
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }

    @Test
    public void get_home_loggedSeller_shouldReturnHome() throws Exception {
        session.setAttribute("user", seller);
        this.mockMvc.perform(get("/home").session(session))
                .andExpect(status().isOk())
                .andExpect(view().name("homepage"))
                .andExpect(model().attributeExists("date"))
                .andExpect(model().attributeExists("time"))
                .andExpect(model().attributeExists("user"))
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }

    @Test
    public void get_home_notLogged_shouldRedirectLogin() throws Exception {
        this.mockMvc.perform(get("/home"))
                .andExpect(status().isFound())
                .andExpect(view().name("redirect:/login"))
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }

    @Test
    public void get_randomUrl_shouldReturn404() throws Exception {
        this.mockMvc.perform(get("/home/test"))
                .andExpect(status().isNotFound())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }
}
