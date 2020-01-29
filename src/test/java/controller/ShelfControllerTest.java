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

import service.StoreService;
import service.ShelfService;

import entity.Director;
import entity.Seller;
import entity.Store;
import entity.Shelf;
import static org.mockito.Mockito.doNothing;

/**
 *
 * @author laste
 */
public class ShelfControllerTest {

    private MockMvc mockMvc;

    private MockHttpSession session;

    @InjectMocks
    private ShelfController controllerUnderTest;

    @Mock
    private StoreService storeService;

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
    public void get_listShelf_with_director_shouldReturnList() throws Exception {
        List<Shelf> shelves = new ArrayList<>();
        when(shelfService.getShelves()).thenReturn(shelves);
        session.setAttribute("user", director);
        this.mockMvc.perform(get("/shelves/list/").session(session))
                .andExpect(status().isOk())
                .andExpect(view().name("list-shelves"))
                .andExpect(model().attributeExists("date"))
                .andExpect(model().attributeExists("time"))
                .andExpect(model().attributeExists("shelves"))
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }

    @Test
    public void get_listShelf_with_seller_shouldReturnList() throws Exception {
        List<Shelf> shelves = new ArrayList<>();
        when(shelfService.getShelves()).thenReturn(shelves);
        session.setAttribute("user", seller);
        this.mockMvc.perform(get("/shelves/list/").session(session))
                .andExpect(status().isOk())
                .andExpect(view().name("list-shelves"))
                .andExpect(model().attributeExists("date"))
                .andExpect(model().attributeExists("time"))
                .andExpect(model().attributeExists("shelves"))
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }

    @Test
    public void get_liststores_with_anonymous_shouldRedirectlogin() throws Exception {
        this.mockMvc.perform(get("/shelves/list/"))
                .andExpect(status().isFound())
                .andExpect(view().name("redirect:/login"))
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }

    @Test
    public void get_detailShelf_with_director_shouldReturnDetail() throws Exception {
        int id = 1;
        Shelf shelf = new Shelf();
        when(shelfService.getById(id)).thenReturn(shelf);
        session.setAttribute("user", director);
        this.mockMvc.perform(get("/shelves/shelf").session(session)
                .param("idShelf", "1"))
                .andExpect(status().isOk())
                .andExpect(view().name("detail-shelf"))
                .andExpect(model().attributeExists("date"))
                .andExpect(model().attributeExists("time"))
                .andExpect(model().attributeExists("shelf"))
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }

    @Test
    public void get_detailShelf_with_seller_shouldReturnDetail() throws Exception {
        int id = 1;
        Shelf shelf = new Shelf();
        when(shelfService.getById(id)).thenReturn(shelf);
        session.setAttribute("user", seller);
        this.mockMvc.perform(get("/shelves/shelf").session(session)
                .param("idShelf", "1"))
                .andExpect(status().isOk())
                .andExpect(view().name("detail-shelf"))
                .andExpect(model().attributeExists("date"))
                .andExpect(model().attributeExists("time"))
                .andExpect(model().attributeExists("shelf"))
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }

    @Test
    public void get_detailShelf_with_anonymous_shouldRedirectDetail() throws Exception {
        int id = 1;
        Shelf shelf = new Shelf();
        when(shelfService.getById(id)).thenReturn(shelf);
        this.mockMvc.perform(get("/shelves/shelf")
                .param("idShelf", "1"))
                .andExpect(status().isFound())
                .andExpect(view().name("redirect:/login"))
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }

    @Test
    public void get_addForm_with_director_shouldReturnForm() throws Exception {
        List<Store> stores = new ArrayList<>();
        when(storeService.getStores()).thenReturn(stores);
        session.setAttribute("user", director);
        this.mockMvc.perform(get("/shelves/addForm").session(session))
                .andExpect(status().isOk())
                .andExpect(view().name("form-shelf"))
                .andExpect(model().attributeExists("date"))
                .andExpect(model().attributeExists("time"))
                .andExpect(model().attributeExists("message"))
                .andExpect(model().attributeExists("shelf"))
                .andExpect(model().attributeExists("stores"))
                .andExpect(model().attributeExists("user"))
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }

    @Test
    public void get_addForm_with_seller_shouldRedirectHome() throws Exception {
        session.setAttribute("user", seller);
        this.mockMvc.perform(get("/shelves/addForm").session(session))
                .andExpect(status().isFound())
                .andExpect(view().name("redirect:/home"))
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }

    @Test
    public void get_addForm_with_anonymous_shouldRedirectLogin() throws Exception {
        this.mockMvc.perform(get("/shelves/addForm").session(session))
                .andExpect(status().isFound())
                .andExpect(view().name("redirect:/login"))
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }

    @Test
    public void get_updateForm_with_director_shouldReturnForm() throws Exception {
        int id =1;
        Shelf shelf = new Shelf();
        List<Store> stores = new ArrayList<>();
        when(shelfService.getById(id)).thenReturn(shelf);
        when(storeService.getStores()).thenReturn(stores);
        session.setAttribute("user", director);
        this.mockMvc.perform(get("/shelves/updateForm").session(session)
                .param("idShelf", "1"))
                .andExpect(status().isOk())
                .andExpect(view().name("form-shelf"))
                .andExpect(model().attributeExists("date"))
                .andExpect(model().attributeExists("time"))
                .andExpect(model().attributeExists("message"))
                .andExpect(model().attributeExists("shelf"))
                .andExpect(model().attributeExists("stores"))
                .andExpect(model().attributeExists("user"))
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }

    @Test
    public void get_updateForm_with_seller_shouldRedirectHome() throws Exception {
        session.setAttribute("user", seller);
        this.mockMvc.perform(get("/shelves/updateForm").session(session)
                .param("idShelf", "1"))
                .andExpect(status().isFound())
                .andExpect(view().name("redirect:/home"))
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }

    @Test
    public void get_updatedForm_with_anonymous_shouldRedirectLogin() throws Exception {
        this.mockMvc.perform(get("/shelves/updateForm").session(session)
                .param("idShelf", "1"))
                .andExpect(status().isFound())
                .andExpect(view().name("redirect:/login"))
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }

    @Test
    public void post_saveShelf_shouldRedirectList() throws Exception {
        Shelf shelf = new Shelf();
        session.setAttribute("user", director);
        this.mockMvc.perform(post("/shelves/saveShelf").session(session)
                .param("shelf", "shelf"))
                .andExpect(status().isFound())
                .andExpect(view().name("redirect:/shelves/list"))
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }

    @Test
    public void get_deleteShelf_shouldRedirectList() throws Exception {
        session.setAttribute("user", director);
        this.mockMvc.perform(get("/shelves/delete").session(session)
                .param("idShelf", "1"))
                .andExpect(status().isFound())
                .andExpect(view().name("redirect:/shelves/list"))
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }

    @Test
    public void get_randomUrl_shouldReturn404() throws Exception {
        this.mockMvc.perform(get("/shelves/test"))
                .andExpect(status().isNotFound())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }
}
