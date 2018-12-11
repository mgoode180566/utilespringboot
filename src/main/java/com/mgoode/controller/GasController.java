package com.mgoode.controller;

import com.mgoode.model.Gas;
import com.mgoode.service.GasService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;


@Controller
public class GasController {

    @Value("${gas-per-page}")
    int gasLinesPerPage;

    @Autowired
    private GasService gasService;

    Logger log = LoggerFactory.getLogger(this.getClass());

    // Gas management
    @RequestMapping(value = "/gases", method= RequestMethod.GET)
    public ModelAndView listGases(@RequestParam(value="pageNo", required = false, defaultValue = "0") int pageNo) throws IOException {
        log.info("Gases");
        ModelAndView modelAndView = new ModelAndView();
        Page<Gas> gasesPage = gasService.findAll(pageNo, gasLinesPerPage);
        modelAndView.addObject("page", gasesPage);
        modelAndView.addObject("lastPageNo", gasesPage.getTotalPages());
        modelAndView.setViewName("gas/gaslist");
        return modelAndView;
    }

    @RequestMapping(value="/deletegas/{id}", method = RequestMethod.GET)
    public String deleteGas(@PathVariable Long id) {
        log.info("delete gas " + id);
        gasService.deleteGas(id);
        return "redirect:/gases";
    }

    @RequestMapping(value="/updategas/{id}", method = RequestMethod.GET)
    public ModelAndView updateGas(@PathVariable Long id) {
        log.info("update gas " + id);
        Gas gas = gasService.findById(id);
        ModelAndView model = new ModelAndView();
        model.setViewName("gas/gasform");
        model.addObject("gas", gas);
        model.addObject("title","Edit gas");
        return model;
    }

    @RequestMapping(value = "addgas", method = RequestMethod.GET)
    public ModelAndView showForm() {
        log.info("addgas");
        ModelAndView model = new ModelAndView();
        model.setViewName("gas/gasform");
        model.addObject( "gas", new Gas() );
        model.addObject("title","Add a new gas");
        return model;
    }

    @RequestMapping(value = "savegas", method = RequestMethod.POST)
    public String submit(@ModelAttribute("gas") Gas gas, BindingResult result, Model model) {
        log.info("save gas " + gas.toString());
        gasService.save(gas);
        return "redirect:/gases";
    }
}
