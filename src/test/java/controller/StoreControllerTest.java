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

public class StoreControllerTest {

    private MockMvc mockMvc;

    private MockHttpSession session;

    @InjectMocks
    private StoreController controllerUnderTest;

    @Mock
    private StoreService storeService;

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
    public void get_listStores_withDirector_shouldReturnListStores() throws Exception {
        List<Store> stores = new ArrayList<>();
        List<Seller> sellers = new ArrayList<>();
        List<Shelf> shelves = new ArrayList<>();
        when(storeService.getStores()).thenReturn(stores);
        when(sellerService.getSellers()).thenReturn(sellers);
        when(shelfService.getShelves()).thenReturn(shelves);
        session.setAttribute("user", director);
        this.mockMvc.perform(get("/stores/list/").session(session))
                .andExpect(status().isOk())
                .andExpect(view().name("list-stores"))
                .andExpect(model().attributeExists("date"))
                .andExpect(model().attributeExists("time"))
                .andExpect(model().attributeExists("stores"))
                .andExpect(model().attributeExists("sellers"))
                .andExpect(model().attributeExists("shelves"))
                .andExpect(model().attributeExists("user"))
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }

    @Test
    public void get_listStores_withSeller_shouldReturnListStores() throws Exception {
        List<Store> stores = new ArrayList<>();
        List<Seller> sellers = new ArrayList<>();
        List<Shelf> shelves = new ArrayList<>();
        when(storeService.getStores()).thenReturn(stores);
        when(sellerService.getSellers()).thenReturn(sellers);
        when(shelfService.getShelves()).thenReturn(shelves);
        session.setAttribute("user", seller);
        this.mockMvc.perform(get("/stores/list/").session(session))
                .andExpect(status().isOk())
                .andExpect(view().name("list-stores"))
                .andExpect(model().attributeExists("date"))
                .andExpect(model().attributeExists("time"))
                .andExpect(model().attributeExists("stores"))
                .andExpect(model().attributeExists("sellers"))
                .andExpect(model().attributeExists("shelves"))
                .andExpect(model().attributeExists("user"))
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }

    @Test
    public void get_listStores_with_anonymous_shouldRedirectLogin() throws Exception {
        this.mockMvc.perform(get("/stores/list/"))
                .andExpect(status().isFound())
                .andExpect(view().name("redirect:/login"))
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }

    @Test
    public void get_randomUrl_shouldReturn404() throws Exception {
        this.mockMvc.perform(get("/stores/test"))
                .andExpect(status().isNotFound())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }
}
