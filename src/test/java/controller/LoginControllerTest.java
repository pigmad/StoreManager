package controller;

import org.junit.Before;
import org.junit.Test;
import static junit.framework.TestCase.assertNotNull;

import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.mock.web.MockHttpSession;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.when;

import service.StoreService;
import service.DirectorService;
import service.SellerService;

import entity.Director;
import entity.Seller;
import org.springframework.test.web.servlet.ResultMatcher;

/**
 *
 * @author laste
 */
public class LoginControllerTest {

    private MockMvc mockMvc;

    private MockHttpSession session;

    @InjectMocks
    private LoginController controllerUnderTest;

    @Mock
    private StoreService storeService;

    @Mock
    private SellerService sellerService;

    @Mock
    private DirectorService directorService;

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
    public void get_login_shouldReturnLogin() throws Exception {
        this.mockMvc.perform(get("/login"))
                .andExpect(status().isOk())
                .andExpect(view().name("loginpage"))
                .andExpect(model().attributeExists("date"))
                .andExpect(model().attributeExists("time"))
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }

    @Test
    public void get_login_loggedDirector_shouldRedirectHome() throws Exception {
        session.setAttribute("user", director);
        this.mockMvc.perform(get("/login").session(session))
                .andExpect(status().isFound())
                .andExpect(view().name("redirect:/home"))
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }

    @Test
    public void get_login_loggedSeller_shouldRedirectHome() throws Exception {
        session.setAttribute("user", seller);
        this.mockMvc.perform(get("/login").session(session))
                .andExpect(status().isFound())
                .andExpect(view().name("redirect:/home"))
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }

    @Test
    public void post_login_seller_success_shouldRedirectHome() throws Exception {
        String mail = "seller@magasin.fr";
        String password = "seller";
        when(storeService.login(mail, password)).thenReturn(true);
        when(sellerService.getByMail(mail)).thenReturn(seller);
        this.mockMvc.perform(post("/login")
                .param("inputMail", mail)
                .param("inputPassword", password))
                .andExpect(status().isFound())
                .andExpect(view().name("redirect:/home"))
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }

    @Test
    public void post_login_director_success_shouldRedirectHome() throws Exception {
        String mail = "director@magasin.fr";
        String password = "director";
        when(storeService.login(mail, password)).thenReturn(true);
        when(sellerService.getByMail(mail)).thenReturn(null);
        this.mockMvc.perform(post("/login")
                .param("inputMail", mail)
                .param("inputPassword", password)
                .session(session))
                .andExpect(status().isFound())
                .andExpect(view().name("redirect:/home"))
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }

    @Test
    public void post_login_failure_shouldReturnLogin() throws Exception {
        String mail = "seller@magasin.fr";
        String password = "seller";
        when(storeService.login(mail, password)).thenReturn(false);
        this.mockMvc.perform(post("/login")
                .param("inputMail", mail)
                .param("inputPassword", password))
                .andExpect(status().isOk())
                .andExpect(view().name("loginpage"))
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }

    @Test
    public void get_logout_loggedDirector_shouldRedirectIndex() throws Exception {
        session.setAttribute("user", director);
        this.mockMvc.perform(get("/logout").session(session))
                .andExpect(status().isFound())
                .andExpect(view().name("redirect:/"))
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }

    @Test
    public void get_logout_loggedSeller_shouldRedirectIndex() throws Exception {
        session.setAttribute("user", seller);
        this.mockMvc.perform(get("/logout").session(session))
                .andExpect(status().isFound())
                .andExpect(view().name("redirect:/"))
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }

    @Test
    public void get_logout_notLogged_shouldRedirectLogin() throws Exception {
        this.mockMvc.perform(get("/logout"))
                .andExpect(status().isFound())
                .andExpect(view().name("redirect:/login"))
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }

    @Test
    public void get_randomUrl_shouldReturn404() throws Exception {
        this.mockMvc.perform(get("/login/test"))
                .andExpect(status().isNotFound())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }
}
