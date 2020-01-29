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
import service.ItemService;

import entity.Director;
import entity.Seller;
import entity.Shelf;
import entity.Item;

/**
 *
 * @author laste
 */
public class ItemControllerTest {

    private MockMvc mockMvc;

    private MockHttpSession session;

    @InjectMocks
    private ItemController controllerUnderTest;

    @Mock
    private ShelfService shelfService;

    @Mock
    private ItemService itemService;

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
    public void get_detailItem_with_director_shouldReturnDetail() throws Exception {
        int id = 1;
        Item item = new Item();
        when(itemService.getById(id)).thenReturn(item);
        session.setAttribute("user", director);
        this.mockMvc.perform(get("/items/item").session(session)
                .param("idItem", "1"))
                .andExpect(status().isOk())
                .andExpect(view().name("detail-item"))
                .andExpect(model().attributeExists("date"))
                .andExpect(model().attributeExists("time"))
                .andExpect(model().attributeExists("item"))
                .andExpect(model().attributeExists("user"))
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }

    @Test
    public void get_detailItem_with_seller_shouldReturnDetail() throws Exception {
        int id = 1;
        Item item = new Item();
        when(itemService.getById(id)).thenReturn(item);
        session.setAttribute("user", seller);
        this.mockMvc.perform(get("/items/item").session(session)
                .param("idItem", "1"))
                .andExpect(status().isOk())
                .andExpect(view().name("detail-item"))
                .andExpect(model().attributeExists("date"))
                .andExpect(model().attributeExists("time"))
                .andExpect(model().attributeExists("item"))
                .andExpect(model().attributeExists("user"))
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }

    @Test
    public void get_detailItem_with_anonymous_shouldRedirectDetail() throws Exception {
        this.mockMvc.perform(get("/items/item")
                .param("idItem", "1"))
                .andExpect(status().isFound())
                .andExpect(view().name("redirect:/login"))
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }

    @Test
    public void get_addForm_with_director_shouldReturnForm() throws Exception {
        int id = 1;
        Shelf shelf = new Shelf();
        when(shelfService.getById(id)).thenReturn(shelf);
        session.setAttribute("user", director);
        this.mockMvc.perform(get("/items/addForm").session(session)
                .param("idShelf", "1"))
                .andExpect(status().isOk())
                .andExpect(view().name("form-item"))
                .andExpect(model().attributeExists("date"))
                .andExpect(model().attributeExists("time"))
                .andExpect(model().attributeExists("message"))
                .andExpect(model().attributeExists("item"))
                .andExpect(model().attributeExists("shelf"))
                .andExpect(model().attributeExists("user"))
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }

    @Test
    public void get_addForm_with_seller_admin_shouldReturnForm() throws Exception {
        int id = 1;
        Shelf shelf = new Shelf();
        shelf.setIdShelf(id);
        when(shelfService.getById(id)).thenReturn(shelf);
        seller.setIsAdmin(true);
        seller.setBelongsTo(shelf);
        session.setAttribute("user", seller);
        this.mockMvc.perform(get("/items/addForm").session(session)
                .param("idShelf", "1"))
                .andExpect(status().isOk())
                .andExpect(view().name("form-item"))
                .andExpect(model().attributeExists("date"))
                .andExpect(model().attributeExists("time"))
                .andExpect(model().attributeExists("message"))
                .andExpect(model().attributeExists("item"))
                .andExpect(model().attributeExists("shelf"))
                .andExpect(model().attributeExists("user"))
                .andDo(MockMvcResultHandlers.print())
                .andReturn();;
    }

    @Test
    public void get_addForm_with_seller_nonAdmin_shouldRedirectHome() throws Exception {
        seller.setIsAdmin(false);
        session.setAttribute("user", seller);
        this.mockMvc.perform(get("/items/addForm").session(session)
                .param("idShelf", "1"))
                .andExpect(status().isFound())
                .andExpect(view().name("redirect:/home"))
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }

    @Test
    public void get_addForm_with_anonymous_shouldRedirectLogin() throws Exception {
        this.mockMvc.perform(get("/items/addForm").session(session)
                .param("idShelf", "1"))
                .andExpect(status().isFound())
                .andExpect(view().name("redirect:/login"))
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }

    @Test
    public void get_updateForm_with_director_shouldReturnForm() throws Exception {
        int id = 1;
        Item item = new Item();
        Shelf shelf = new Shelf();
        when(itemService.getById(id)).thenReturn(item);
        when(shelfService.getById(id)).thenReturn(shelf);
        session.setAttribute("user", director);
        this.mockMvc.perform(get("/items/updateForm").session(session)
                .param("idShelf", "1")
                .param("idItem", "1"))
                .andExpect(status().isOk())
                .andExpect(view().name("form-item"))
                .andExpect(model().attributeExists("date"))
                .andExpect(model().attributeExists("time"))
                .andExpect(model().attributeExists("message"))
                .andExpect(model().attributeExists("item"))
                .andExpect(model().attributeExists("shelf"))
                .andExpect(model().attributeExists("user"))
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }

    @Test
    public void get_updateForm_with_seller_admin_shouldReturnForm() throws Exception {
        int id = 1;
        Item item = new Item();
        Shelf shelf = new Shelf();
        shelf.setIdShelf(id);
        when(itemService.getById(id)).thenReturn(item);
        when(shelfService.getById(id)).thenReturn(shelf);
        seller.setIsAdmin(true);
        seller.setBelongsTo(shelf);
        session.setAttribute("user", seller);;
        this.mockMvc.perform(get("/items/updateForm").session(session)
                .param("idShelf", "1")
                .param("idItem", "1"))
                .andExpect(status().isOk())
                .andExpect(view().name("form-item"))
                .andExpect(model().attributeExists("date"))
                .andExpect(model().attributeExists("time"))
                .andExpect(model().attributeExists("message"))
                .andExpect(model().attributeExists("item"))
                .andExpect(model().attributeExists("shelf"))
                .andExpect(model().attributeExists("user"))
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }

    @Test
    public void get_updateForm_with_seller_nonAdmin_shouldRedirectHome() throws Exception {
        seller.setIsAdmin(false);
        session.setAttribute("user", seller);
        this.mockMvc.perform(get("/items/updateForm").session(session)
                .param("idShelf", "1")
                .param("idItem", "1"))
                .andExpect(status().isFound())
                .andExpect(view().name("redirect:/home"))
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }

    @Test
    public void get_updatedForm_with_anonymous_shouldRedirectLogin() throws Exception {
        this.mockMvc.perform(get("/items/updateForm").session(session)
                .param("idShelf", "1")
                .param("idItem", "1"))
                .andExpect(status().isFound())
                .andExpect(view().name("redirect:/login"))
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }

    @Test
    public void post_saveItem_shouldRedirectList() throws Exception {
        session.setAttribute("user", director);
        this.mockMvc.perform(post("/items/saveItem").session(session)
                .param("item", "item"))
                .andExpect(status().isFound())
                .andExpect(view().name("redirect:/shelves/list"))
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }

    @Test
    public void get_deleteItem_shouldRedirectList() throws Exception {
        session.setAttribute("user", director);
        this.mockMvc.perform(get("/items/delete").session(session)
                .param("idItem", "1"))
                .andExpect(status().isFound())
                .andExpect(view().name("redirect:/shelves/list"))
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }

    @Test
    public void get_randomUrl_shouldReturn404() throws Exception {
        this.mockMvc.perform(get("/items/test"))
                .andExpect(status().isNotFound())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }
}
