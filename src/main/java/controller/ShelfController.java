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

import service.ShelfService;
import service.StoreService;

import entity.Shelf;
import entity.Store;
import entity.Director;

/**
 *
 * @author laste
 */
@Controller
@RequestMapping("/shelves")
public class ShelfController {

    private static final Logger LOG = LoggerFactory.getLogger(ShelfController.class);

    @Autowired
    private ShelfService shelfService;

    @Autowired
    private StoreService storeService;

    DateFormat dflf = DateFormat.getDateInstance(DateFormat.FULL);
    DateFormat dfls = DateFormat.getTimeInstance(DateFormat.SHORT);

    @GetMapping("/list")
    public String listShelves(HttpServletRequest request, ModelMap map) {
        if (request.getSession().getAttribute("user") == null) {
            return "redirect:/login";
        }
        String date = dflf.format(new Date());
        String time = dfls.format(new Date());
        map.addAttribute("date", date);
        map.addAttribute("time", time);
        List<Shelf> shelves = shelfService.getShelves();
        map.addAttribute("shelves", shelves);
        map.addAttribute("user", request.getSession().getAttribute("user"));
        LOG.info("returning seller list view with " + date + time);
        return "list-shelves";
    }

    @GetMapping("/shelf")
    public String detailShelf(HttpServletRequest request, @RequestParam("idShelf") int id, ModelMap map) throws ObjectNotFoundException {
        if (request.getSession().getAttribute("user") == null) {
            return "redirect:/login";
        }
        String date = dflf.format(new Date());
        String time = dfls.format(new Date());
        map.addAttribute("date", date);
        map.addAttribute("time", time);
        Shelf shelf = shelfService.getById(id);
        map.addAttribute("shelf", shelf);
        map.addAttribute("user", request.getSession().getAttribute("user"));
        return "detail-shelf";
    }

    @GetMapping("/addForm")
    public String addShelf(HttpServletRequest request, ModelMap map) throws ObjectNotFoundException {
        if (request.getSession().getAttribute("user") == null) {
            return "redirect:/login";
        }
        if (request.getSession().getAttribute("user").getClass() == Director.class) {
            String date = dflf.format(new Date());
            String time = dfls.format(new Date());
            map.addAttribute("date", date);
            map.addAttribute("time", time);
            map.addAttribute("message", "Ajout d'un nouveau rayon");
            Shelf shelf = new Shelf();
            List<Store> stores = storeService.getStores();
            map.addAttribute("shelf", shelf);
            map.addAttribute("stores", stores);
            map.addAttribute("user", request.getSession().getAttribute("user"));
            return "form-shelf";
        } else {
            return "redirect:/home";
        }
    }

    @GetMapping("/updateForm")
    public String updateShelf(HttpServletRequest request, @RequestParam("idShelf") int id, ModelMap map) throws ObjectNotFoundException {
        if (request.getSession().getAttribute("user") == null) {
            return "redirect:/login";
        }
        if (request.getSession().getAttribute("user").getClass() == Director.class) {
            String date = dflf.format(new Date());
            String time = dfls.format(new Date());
            map.addAttribute("date", date);
            map.addAttribute("time", time);
            map.addAttribute("message", "Modification du rayon n°" + id);
            Shelf shelf = shelfService.getById(id);
            List<Store> stores = storeService.getStores();
            map.addAttribute("shelf", shelf);
            map.addAttribute("stores", stores);
            map.addAttribute("user", request.getSession().getAttribute("user"));
            return "form-shelf";
        } else {
            return "redirect:/home";
        }
    }

    @PostMapping("/saveShelf")
    public String saveShelf(HttpServletRequest request, @ModelAttribute("shelf") Shelf shelf) {
        if (request.getSession().getAttribute("user") == null) {
            return "redirect:/login";
        }
        shelfService.saveShelf(shelf);
        return "redirect:/shelves/list";
    }

    @GetMapping("/delete")
    public String deleteShelf(HttpServletRequest request, @RequestParam("idShelf") int id) throws ObjectNotFoundException {
        if (request.getSession().getAttribute("user") == null) {
            return "redirect:/login";
        }
        shelfService.deleteShelf(id);
        return "redirect:/shelves/list";
    }
}
