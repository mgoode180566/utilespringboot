package com.mgoode.controller;

import com.mgoode.model.Duty;
import com.mgoode.model.Machine;
import com.mgoode.service.MachineService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;


/**
 * Created by michaelgoode on 08/11/2016.
 */

@Controller
public class UtileController {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    @RequestMapping(value = "/", method= RequestMethod.GET)
    public ModelAndView home() {
        log.info("home");
        return new ModelAndView("home");
    }

    @RequestMapping(value = "/about", method= RequestMethod.GET)
    public ModelAndView about() {
        log.info("About");
        return new ModelAndView("about");
    }

//    @RequestMapping(value="/utile/machines")
//    String allMachines() {
//        Iterable<Machine> machines = this.machineService.getMachines();
//
//        StringBuilder stringBuilder = new StringBuilder();
//
//        Iterator<Machine> machineIter = machines.iterator();
//        while (machineIter.hasNext()) {
//            Machine machine = (Machine) machineIter.next();
//            stringBuilder.append(machine.getName() + "/n");
//        }
//        return stringBuilder.toString();
//    }

//    @RequestMapping(value = "/machines", method= RequestMethod.GET)
//    public ModelAndView listMachines(ModelAndView model) throws IOException {
//        Iterable<Machine> list = machineService.getMachines(0);
//        model.addObject("list", list);
//        model.setViewName("machine/machinelist");
//        return model;
//    }

    // -------------------- Duty Search related --------------------


}
