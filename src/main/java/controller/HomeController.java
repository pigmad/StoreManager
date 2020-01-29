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

/**
 *
 * @author laste
 */
@Controller
public class HomeController {

    private static final Logger LOG = LoggerFactory.getLogger(HomeController.class);

    DateFormat dflf = DateFormat.getDateInstance(DateFormat.FULL);
    DateFormat dfls = DateFormat.getTimeInstance(DateFormat.SHORT);

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(ModelMap map) {
        String date = dflf.format(new Date());
        String time = dfls.format(new Date());
        map.addAttribute("date", date);
        map.addAttribute("time", time);
        LOG.info("returning index view with " + date + time);
        return "index";
    }

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String home(HttpServletRequest request, ModelMap map) {
        if (request.getSession().getAttribute("user") == null) {
            return "redirect:/login";
        }
        String date = dflf.format(new Date());
        String time = dfls.format(new Date());
        map.addAttribute("date", date);
        map.addAttribute("time", time);
        map.addAttribute("user", request.getSession().getAttribute("user"));
        LOG.info("returning home view with " + date + time);
        return "homepage";
    }
}
