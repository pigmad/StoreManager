package controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.beans.factory.annotation.Autowired;

import service.StoreService;
import service.SellerService;
import service.ShelfService;

import entity.Store;
import entity.Seller;
import entity.Shelf;

/**
 *
 * @author laste
 */
@Controller
@RequestMapping("/stores")
public class StoreController {

    private static final Logger LOG = LoggerFactory.getLogger(StoreController.class);

    @Autowired
    private StoreService storeService;

    @Autowired
    private SellerService sellerService;

    @Autowired
    private ShelfService shelfService;

    @GetMapping("/list")
    public String listStores(HttpServletRequest request, ModelMap map) {
        if (request.getSession().getAttribute("user") == null) {
            return "redirect:/login";
        }
        DateFormat dfl = DateFormat.getDateInstance(DateFormat.FULL);
        String date = dfl.format(new Date());
        dfl = DateFormat.getTimeInstance(DateFormat.SHORT);
        String time = dfl.format(new Date());
        map.addAttribute("date", date);
        map.addAttribute("time", time);
        List<Store> stores = storeService.getStores();
        map.addAttribute("stores", stores);
        List<Seller> sellers = sellerService.getSellers();
        map.addAttribute("sellers", sellers);
        List<Shelf> shelves = shelfService.getShelves();
        map.addAttribute("shelves", shelves);
        map.addAttribute("user", request.getSession().getAttribute("user"));
        return "list-stores";
    }

//    @GetMapping("/updateForm")
//    public String showFormForUpdate(@RequestParam("customerId") int theId,
//        Model theModel) throws ResourceNotFoundException {
//        Customer theCustomer = customerService.getCustomer(theId);
//        theModel.addAttribute("customer", theCustomer);
//        return "customer-form";
//    }
//    
//    @PostMapping("/saveStore")
//    public String saveCustomer(@ModelAttribute("store") Store store) {
//        storeService.saveStore(store);
//        return "redirect:/store";
//    }
//    
//    @GetMapping("/delete")
//    public String deleteCustomer(@RequestParam("customerId") int theId) throws ResourceNotFoundException {
//        storeService.deleteStore(theId);
//        return "redirect:/customer/list";
//    }
}
