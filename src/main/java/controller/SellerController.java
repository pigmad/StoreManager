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

import service.SellerService;
import service.ShelfService;

import entity.Seller;
import entity.Director;
import entity.Shelf;

/**
 *
 * @author laste
 */
@Controller
@RequestMapping("/sellers")
public class SellerController {
    private static final Logger LOG = LoggerFactory.getLogger(SellerController.class);
    
    @Autowired
    private SellerService sellerService;
    
    @Autowired
    private ShelfService shelfService;
    
    DateFormat dflf = DateFormat.getDateInstance(DateFormat.FULL);
    DateFormat dfls = DateFormat.getTimeInstance(DateFormat.SHORT);
    
    @GetMapping("/list")
    public String listSellers(HttpServletRequest request, ModelMap map) {
        if (request.getSession().getAttribute("user") == null)
            return "redirect:/login";
        if(request.getSession().getAttribute("user").getClass() == Director.class){
            String date = dflf.format(new Date());
            String time = dfls.format(new Date());
            map.addAttribute("date", date);
            map.addAttribute("time", time); 
            List<Seller> sellers = sellerService.getSellers();
            map.addAttribute("sellers", sellers);
            map.addAttribute("user", request.getSession().getAttribute("user"));
            LOG.info("returning seller list view with " + date + time); 
            return "list-sellers";
        }
        else{
            return "redirect:/home";
        }
    }
    
    @GetMapping("/seller")
    public String detailSeller(HttpServletRequest request, @RequestParam("idSeller") int id, ModelMap map) throws ObjectNotFoundException {
        if (request.getSession().getAttribute("user") == null)
            return "redirect:/login";
        if(request.getSession().getAttribute("user").getClass() == Director.class){
            String date = dflf.format(new Date());
            String time = dfls.format(new Date());
            map.addAttribute("date", date);
            map.addAttribute("time", time);
            Seller seller = sellerService.getById(id);
            map.addAttribute("seller", seller);
            map.addAttribute("user", request.getSession().getAttribute("user"));
            return "detail-seller";
        }
        else{
            return "redirect:/home";
        }
    }
    
    @GetMapping("/addForm")
    public String AddSeller(HttpServletRequest request, ModelMap map) throws ObjectNotFoundException {
        if (request.getSession().getAttribute("user") == null)
            return "redirect:/login";
        if(request.getSession().getAttribute("user").getClass() == Director.class){
            String date = dflf.format(new Date());
            String time = dfls.format(new Date());
            map.addAttribute("date", date);
            map.addAttribute("time", time);
            Seller seller = new Seller();
            map.addAttribute("message", "Ajout d'un nouveau vendeur");
            List<Shelf> shelves = shelfService.getShelves();
            map.addAttribute("seller", seller);
            map.addAttribute("shelves", shelves);
            map.addAttribute("user", request.getSession().getAttribute("user"));
            return "form-seller";
        }
        else{
            return "redirect:/home";
        }
    }

    @GetMapping("/updateForm")
    public String UpdateSeller(HttpServletRequest request, @RequestParam("idSeller") int id, ModelMap map) throws ObjectNotFoundException {
        if (request.getSession().getAttribute("user") == null)
            return "redirect:/login";
        if(request.getSession().getAttribute("user").getClass() == Director.class){
            String date = dflf.format(new Date());
            String time = dfls.format(new Date());
            map.addAttribute("date", date);
            map.addAttribute("time", time);
            map.addAttribute("message", "Modification du vendeur n°" + id);
            Seller seller = sellerService.getById(id);
            List<Shelf> shelves = shelfService.getShelves();
            map.addAttribute("seller", seller);
            map.addAttribute("shelves", shelves);
            map.addAttribute("user", request.getSession().getAttribute("user"));
            return "form-seller";
        }
        else{
            return "redirect:/home";
        }
    }
    
    @PostMapping("/saveSeller")
    public String saveSeller(HttpServletRequest request, @ModelAttribute("seller") Seller seller) {
        if (request.getSession().getAttribute("user") == null)
            return "redirect:/login";
        sellerService.saveSeller(seller);
        return "redirect:/sellers/list";
    }
    
    @GetMapping("/delete")
    public String deleteSeller(HttpServletRequest request, @RequestParam("idSeller") int id) throws ObjectNotFoundException {
        if (request.getSession().getAttribute("user") == null)
            return "redirect:/login";
        sellerService.deleteSeller(id);
        return "redirect:/sellers/list";
    }
}
