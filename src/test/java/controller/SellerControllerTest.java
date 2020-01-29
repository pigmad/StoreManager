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
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.when;

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
public class SellerControllerTest {

    private MockMvc mockMvc;

    private MockHttpSession session;

    @InjectMocks
    private SellerController controllerUnderTest;

    @Mock
    private SellerService sellerService;

    @Mock
    private ShelfService shelfService;

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
    public void get_listSeller_with_director_shouldReturnList() throws Exception {
        List<Seller> sellers = new ArrayList<>();
        when(sellerService.getSellers()).thenReturn(sellers);
        session.setAttribute("user", director);
        this.mockMvc.perform(get("/sellers/list/").session(session))
                .andExpect(status().isOk())
                .andExpect(view().name("list-sellers"))
                .andExpect(model().attributeExists("date"))
                .andExpect(model().attributeExists("time"))
                .andExpect(model().attributeExists("sellers"))
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }

    @Test
    public void get_listSeller_with_seller_shouldRedirectHome() throws Exception {
        session.setAttribute("user", seller);
        this.mockMvc.perform(get("/sellers/list/").session(session))
                .andExpect(status().isFound())
                .andExpect(view().name("redirect:/home"))
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }

    @Test
    public void get_liststores_with_anonymous_shouldRedirectlogin() throws Exception {
        this.mockMvc.perform(get("/sellers/list/"))
                .andExpect(status().isFound())
                .andExpect(view().name("redirect:/login"))
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }

    @Test
    public void get_detailSeller_with_director_shouldReturnDetail() throws Exception {
        int id = 1;
        when(sellerService.getById(id)).thenReturn(seller);
        session.setAttribute("user", director);
        this.mockMvc.perform(get("/sellers/seller").session(session)
                .param("idSeller", "1"))
                .andExpect(status().isOk())
                .andExpect(view().name("detail-seller"))
                .andExpect(model().attributeExists("date"))
                .andExpect(model().attributeExists("time"))
                .andExpect(model().attributeExists("seller"))
                .andExpect(model().attributeExists("user"))
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }

    @Test
    public void get_detailSeller_with_seller_shouldReturnDetail() throws Exception {
        session.setAttribute("user", seller);
        this.mockMvc.perform(get("/sellers/seller/").session(session)
                .param("idSeller", "1"))
                .andExpect(status().isFound())
                .andExpect(view().name("redirect:/home"))
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }

    @Test
    public void get_detailSeller_with_anonymous_shouldRedirectDetail() throws Exception {
        this.mockMvc.perform(get("/sellers/seller")
                .param("idSeller", "1"))
                .andExpect(status().isFound())
                .andExpect(view().name("redirect:/login"))
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }

    @Test
    public void get_addForm_with_director_shouldReturnForm() throws Exception {
        List<Shelf> shelves = new ArrayList<>();
        when(shelfService.getShelves()).thenReturn(shelves);
        session.setAttribute("user", director);
        this.mockMvc.perform(get("/sellers/addForm").session(session))
                .andExpect(status().isOk())
                .andExpect(view().name("form-seller"))
                .andExpect(model().attributeExists("date"))
                .andExpect(model().attributeExists("time"))
                .andExpect(model().attributeExists("message"))
                .andExpect(model().attributeExists("seller"))
                .andExpect(model().attributeExists("shelves"))
                .andExpect(model().attributeExists("user"))
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }

    @Test
    public void get_addForm_with_seller_shouldRedirectHome() throws Exception {
        session.setAttribute("user", seller);
        this.mockMvc.perform(get("/sellers/addForm").session(session))
                .andExpect(status().isFound())
                .andExpect(view().name("redirect:/home"))
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }

    @Test
    public void get_addForm_with_anonymous_shouldRedirectLogin() throws Exception {
        this.mockMvc.perform(get("/sellers/addForm").session(session))
                .andExpect(status().isFound())
                .andExpect(view().name("redirect:/login"))
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }

    @Test
    public void get_updateForm_with_director_shouldReturnForm() throws Exception {
        int id = 1;
        List<Shelf> shelves = new ArrayList<>();
        when(sellerService.getById(id)).thenReturn(seller);
        when(shelfService.getShelves()).thenReturn(shelves);
        session.setAttribute("user", director);
        this.mockMvc.perform(get("/sellers/updateForm").session(session)
                .param("idSeller", "1"))
                .andExpect(status().isOk())
                .andExpect(view().name("form-seller"))
                .andExpect(model().attributeExists("date"))
                .andExpect(model().attributeExists("time"))
                .andExpect(model().attributeExists("message"))
                .andExpect(model().attributeExists("seller"))
                .andExpect(model().attributeExists("shelves"))
                .andExpect(model().attributeExists("user"))
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }

    @Test
    public void get_updateForm_with_seller_shouldRedirectHome() throws Exception {
        session.setAttribute("user", seller);
        this.mockMvc.perform(get("/sellers/updateForm").session(session)
                .param("idSeller", "1"))
                .andExpect(status().isFound())
                .andExpect(view().name("redirect:/home"))
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }

    @Test
    public void get_updatedForm_with_anonymous_shouldRedirectLogin() throws Exception {
        this.mockMvc.perform(get("/sellers/updateForm").session(session)
                .param("idSeller", "1"))
                .andExpect(status().isFound())
                .andExpect(view().name("redirect:/login"))
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }

    @Test
    public void post_saveSeller_shouldRedirectList() throws Exception {
        session.setAttribute("user", director);
        this.mockMvc.perform(post("/sellers/saveSeller").session(session)
                .param("seller", "seller"))
                .andExpect(status().isFound())
                .andExpect(view().name("redirect:/sellers/list"))
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }

    @Test
    public void get_deleteSeller_shouldRedirectList() throws Exception {
        session.setAttribute("user", director);
        this.mockMvc.perform(get("/sellers/delete").session(session)
                .param("idSeller", "1"))
                .andExpect(status().isFound())
                .andExpect(view().name("redirect:/sellers/list"))
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }

    @Test
    public void get_randomUrl_shouldReturn404() throws Exception {
        this.mockMvc.perform(get("/sellers/test"))
                .andExpect(status().isNotFound())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }
}
