package uk.co.breschbrothers.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import uk.co.breschbrothers.daos.FencyDao;
import uk.co.breschbrothers.entity.Fency;

import java.util.List;

@Controller
public class CalculatorController {

    private final FencyDao fencyDao;

    @Autowired
    public CalculatorController(FencyDao fencyDao) {
        this.fencyDao = fencyDao;
    }

    @GetMapping("/calculator")
    public String calculator(Model model) {
        List<Fency> fencyList = fencyDao.findAll();
        model.addAttribute("fencyList", fencyList);
        return "calculator";
    }
}
