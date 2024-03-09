package com.demo.controller;

import com.demo.model.FlashMessage;
import com.demo.model.Machine;
import com.demo.service.IMachineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/")
public class HomeController {

    private final IMachineService machineService;

    @Autowired
    public HomeController(IMachineService machineService) {
        this.machineService = machineService;
    }

    @GetMapping
    public String getHomePage(Model model) {
        model.addAttribute("machine", Machine.getInstance());
        return "index";
    }

    @GetMapping("insert")
    public String insert(@RequestParam(value = "coins", required = false, defaultValue = "0") int coins,
                         RedirectAttributes attributes) {
        if (coins != 5 && coins != 10 && coins != 25) {
            attributes.addFlashAttribute("message", new FlashMessage("danger", "Invalid coins"));
        } else {
            machineService.insertCoins(Machine.getInstance(), coins);
        }
        return "redirect:/";
    }

    @GetMapping("reset")
    public String reset() {
        machineService.resetMachine(Machine.getInstance());
        return "redirect:/";
    }
}
