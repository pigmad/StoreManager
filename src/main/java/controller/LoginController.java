package controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;

import java.util.Date;
import java.text.DateFormat;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;

import service.StoreService;
import service.SellerService;
import service.DirectorService;

/**
 *
 * @author laste
 */
@Controller
public class LoginController {

    private static final Logger LOG = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private StoreService storeService;

    @Autowired
    private SellerService sellerService;

    @Autowired
    private DirectorService directorService;

    DateFormat dflf = DateFormat.getDateInstance(DateFormat.FULL);
    DateFormat dfls = DateFormat.getTimeInstance(DateFormat.SHORT);

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(HttpServletRequest request, ModelMap map) {
        if (request.getSession().getAttribute("user") != null) {
            return "redirect:/home";
        }
        String date = dflf.format(new Date());
        String time = dfls.format(new Date());
        map.addAttribute("date", date);
        map.addAttribute("time", time);
        LOG.info("returning login view with " + date + time);
        return "loginpage";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String checkLogin(@RequestParam("inputMail") String mail, @RequestParam("inputPassword") String password, HttpServletRequest request, ModelMap map) {
        LOG.info("Entring login post");
        if (storeService.login(mail, password)) {
            if (sellerService.getByMail(mail) == null) {
                LOG.info("director user logged, returning home view");
                request.getSession().setAttribute("user", directorService.getByMail(mail));
                return "redirect:/home";
            } else {
                LOG.info("seller user logged, returning home view");
                request.getSession().setAttribute("user", sellerService.getByMail(mail));
                return "redirect:/home";
            }
        } else {
            LOG.error("user failed to login, returning login");
            String date = dflf.format(new Date());
            String time = dfls.format(new Date());
            map.addAttribute("date", date);
            map.addAttribute("time", time);
            map.addAttribute("mail", mail);
            return "loginpage";
        }
    }

    /* Logout Servlets */
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(HttpServletRequest request, ModelMap map) {
        if (request.getSession().getAttribute("user") == null) {
            return "redirect:/login";
        }
        LOG.info("Entring logout get");
        request.getSession().setAttribute("user", null);
        return "redirect:/";
    }
}
