package com.mgoode.controller;

import com.mgoode.model.Duty;
import com.mgoode.model.Machine;
import com.mgoode.service.MachineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;

@Controller
public class DutyController {

    @Autowired
    MachineService machineService;

    // duty criteria
    @RequestMapping(value = "duty/find", method = RequestMethod.GET)
    public ModelAndView findDuty() {
        return new ModelAndView("duty/duty", "command", new Duty());
    }

    // display the results of machines matching the criteria
    @RequestMapping(value = "duty/results", method = RequestMethod.POST)
    public ModelAndView searchDuty(@ModelAttribute Duty duty) {
        Iterable<Machine> list = machineService.searchByPressureOtherGas(duty);
        ModelAndView model = new ModelAndView();
        model.addObject("list", list);
        model.addObject("duty", duty);
        model.setViewName("duty/dutyresults");
        return model;
    }

    @RequestMapping(value = "newduty", method = RequestMethod.GET)
    public ModelAndView duty() {
        return new ModelAndView("duty/newduty", "command", new Machine(""));
    }


    @RequestMapping(value = "findmachine", method= RequestMethod.POST)
    public ModelAndView findMachine(@ModelAttribute Duty duty) throws IOException {
        try {
            String machineType = duty.getMachineType();
            String gasType = "Other";
            Iterable<Machine> list = null;
            //list = machineService.getMachines();
//            if (gasType.equalsIgnoreCase("OTHER")) {
//                list = machineService.searchByPressureOtherGas(true, false, duty.getCoolingType(), 0.00);
//            } else if (gasType.equalsIgnoreCase("NATURAL")) {
//                list = machineService.searchByPressureNaturalGas(true, false, "Water", 3.59f, 3.59f);
//            } else if (gasType.equalsIgnoreCase("BLOWER")) {
//                list = machineService.searchByPressureBlowerGas(true, false, "Water", 3.59f, 3.59f);
//            }


            list = machineService.searchByPressureOtherGas(duty);

            ModelAndView modelView = new ModelAndView();
            modelView.addObject("list", list);
            modelView.setViewName("duty/dutyresults");
            return modelView;
        } catch (Exception ex) {
            ex.getMessage();
            return null;
        }
    }

}
