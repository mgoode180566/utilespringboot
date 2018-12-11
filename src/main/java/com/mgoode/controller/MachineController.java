package com.mgoode.controller;


import com.mgoode.model.Gas;
import com.mgoode.model.Machine;
import com.mgoode.service.MachineService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;

@Controller
public class MachineController {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Value("${machine-per-page}")
    int machineLinesPerPage;

    @Autowired
    MachineService machineService;

    @RequestMapping(value = "/machines", method= RequestMethod.GET)
    public ModelAndView listMachines(@RequestParam(value="pageNo", required = false, defaultValue = "0") int pageNo) throws IOException {
        log.info("list machines");
        ModelAndView modelAndView = new ModelAndView();
        Page<Machine> machinePage = machineService.getMachines(pageNo, machineLinesPerPage);
        log.debug("List machines");
        modelAndView.addObject("page", machinePage);
        modelAndView.addObject("lastPageNo", machinePage.getTotalPages());
        modelAndView.setViewName("machine/machinelist");
        return modelAndView;
    }

    // Machine management
    @RequestMapping(value = "machine", method= RequestMethod.GET)
    public ModelAndView machine() {
        return new ModelAndView("machine/machine");
    }

    @RequestMapping(value="/addmachine", method = RequestMethod.GET)
    public ModelAndView addMachine() {
        log.info("Add new machine ");
        ModelAndView model = new ModelAndView();
        model.setViewName("machine/machineform");
        model.addObject( "machine", new Machine() );
        model.addObject("title","Add a new machine");
        return model;
    }

    @RequestMapping(value="/updatemachine/{id}", method = RequestMethod.GET)
    public ModelAndView updateMachine(@PathVariable Long id) {
        Machine machine = machineService.findMachine(id);
        ModelAndView model = new ModelAndView();
        model.setViewName("machine/machineform");
        model.addObject("machine", machine);
        model.addObject("title","Edit machine");
        return model;
    }

}
