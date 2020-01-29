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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.beans.factory.annotation.Autowired;

import Exception.ObjectNotFoundException;

import service.ItemService;
import service.ShelfService;

import entity.Item;
import entity.Shelf;
import entity.Director;
import entity.Seller;

/**
 *
 * @author laste
 */
@Controller
@RequestMapping("/items")
public class ItemController {

    private static final Logger LOG = LoggerFactory.getLogger(ItemController.class);

    @Autowired
    private ItemService itemService;

    @Autowired
    private ShelfService shelfService;

    DateFormat dflf = DateFormat.getDateInstance(DateFormat.FULL);
    DateFormat dfls = DateFormat.getTimeInstance(DateFormat.SHORT);

    @GetMapping("/item")
    public String detailItem(HttpServletRequest request, @RequestParam("idItem") int id, ModelMap map) throws ObjectNotFoundException {
        if (request.getSession().getAttribute("user") == null) {
            return "redirect:/login";
        }
        String date = dflf.format(new Date());
        String time = dfls.format(new Date());
        map.addAttribute("date", date);
        map.addAttribute("time", time);
        Item item = itemService.getById(id);
        map.addAttribute("item", item);
        map.addAttribute("user", request.getSession().getAttribute("user"));
        return "detail-item";
    }

    @GetMapping("/addForm")
    public String showAddForm(HttpServletRequest request, @RequestParam("idShelf") int id, ModelMap map) throws ObjectNotFoundException {
        if (request.getSession().getAttribute("user") == null) {
            return "redirect:/login";
        }
        if (request.getSession().getAttribute("user").getClass() == Director.class) {
            String date = dflf.format(new Date());
            String time = dfls.format(new Date());
            map.addAttribute("date", date);
            map.addAttribute("time", time);
            map.addAttribute("message", "Ajout d'un nouvel article");
            Item item = new Item();
            Shelf shelf = shelfService.getById(id);
            map.addAttribute("item", item);
            map.addAttribute("shelf", shelf);
            map.addAttribute("user", request.getSession().getAttribute("user"));
            LOG.info("returning item update view with " + item);
            return "form-item";
        }
        if (request.getSession().getAttribute("user").getClass() == Seller.class) {
            Seller seller = (Seller) request.getSession().getAttribute("user");
            if (seller.isIsAdmin() && seller.getBelongsTo().getIdShelf() == id) {
                String date = dflf.format(new Date());
                String time = dfls.format(new Date());
                map.addAttribute("date", date);
                map.addAttribute("time", time);
                map.addAttribute("message", "Ajout d'un nouvel article");
                Item item = new Item();
                Shelf shelf = shelfService.getById(id);
                map.addAttribute("item", item);
                map.addAttribute("shelf", shelf);
                map.addAttribute("user", request.getSession().getAttribute("user"));
                LOG.info("returning item update view with " + item);
                return "form-item";
            }
        }
        return "redirect:/home";
    }

    @GetMapping("/updateForm")
    public String showUpdateForm(HttpServletRequest request, @RequestParam("idShelf") int idShelf, @RequestParam("idItem") int idItem, ModelMap map) throws ObjectNotFoundException {
        if (request.getSession().getAttribute("user") == null) {
            return "redirect:/login";
        }
        if (request.getSession().getAttribute("user").getClass() == Director.class) {
            String date = dflf.format(new Date());
            String time = dfls.format(new Date());
            map.addAttribute("date", date);
            map.addAttribute("time", time);
            map.addAttribute("message", "Modification de l'article n°" + idItem);
            Item item = itemService.getById(idItem);
            Shelf shelf = shelfService.getById(idShelf);
            map.addAttribute("item", item);
            map.addAttribute("shelf", shelf);
            map.addAttribute("user", request.getSession().getAttribute("user"));
            LOG.info("returning item update view with " + item);
            return "form-item";
        }
        if (request.getSession().getAttribute("user").getClass() == Seller.class) {
            Seller seller = (Seller) request.getSession().getAttribute("user");
            if (seller.isIsAdmin() && seller.getBelongsTo().getIdShelf() == idShelf) {
                String time = dfls.format(new Date());
                String date = dflf.format(new Date());
                map.addAttribute("date", date);
                map.addAttribute("time", time);
                map.addAttribute("message", "Modification de l'article n°" + idItem);
                Item item = itemService.getById(idItem);
                Shelf shelf = shelfService.getById(idShelf);
                map.addAttribute("item", item);
                map.addAttribute("shelf", shelf);
                map.addAttribute("user", request.getSession().getAttribute("user"));
                LOG.info("returning item update view with " + item);
                return "form-item";
            }
        }
        return "redirect:/home";
    }

    @PostMapping("/saveItem")
    public String saveCustomer(HttpServletRequest request, @ModelAttribute("item") Item item) {
        if (request.getSession().getAttribute("user") == null) {
            return "redirect:/login";
        }
        itemService.saveItem(item);
        LOG.info("saving item and returning shelves list view with " + item);
        return "redirect:/shelves/list";
    }

    @GetMapping("/delete")
    public String deleteCustomer(HttpServletRequest request, @RequestParam("idItem") int id) throws ObjectNotFoundException {
        if (request.getSession().getAttribute("user") == null) {
            return "redirect:/login";
        }
        itemService.deleteItem(id);
        return "redirect:/shelves/list";
    }
}
