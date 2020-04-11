package uk.co.breschbrothers.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import uk.co.breschbrothers.daos.FencyDao;
import uk.co.breschbrothers.entity.Fency;

import javax.validation.ConstraintViolation;
import javax.validation.Valid;
import javax.validation.Validator;
import java.util.List;
import java.util.Set;

@Controller
@RequestMapping(value = "/admin/fency", produces = "text/plain;charset=utf-8")
public class FencyController {

    private final FencyDao fencyDao;
    private final Validator validator;

    @Autowired
    public FencyController(FencyDao fencyDao, Validator validator) {
        this.fencyDao = fencyDao;
        this.validator = validator;
    }

    @GetMapping("/add")
    public String addFency(Model model) {
        model.addAttribute("fency", new Fency());
        return "fency-form";
    }

    @PostMapping("/add")
    public String validateFency (@ModelAttribute @Valid Fency fency) {

        Set<ConstraintViolation<@Valid Fency>> violations = validator.validate(fency);

        if (violations.isEmpty()) {
            if (fency.getId() > 0) {
                fency.setPricePerPiece();
                fencyDao.update(fency);
            } else {
                fency.setPricePerPiece();
                fencyDao.save(fency);
            }

            return "redirect: /admin/fency/list";
        } else {
            violations.forEach(System.out::println);
            return "redirect:" + ((fency.getId() > 0) ? "/admin/fency/edit/" + fency.getId() : "admin/fency/add");
        }
    }

    @RequestMapping("/edit/{id}")
    public String editFency(@PathVariable long id, Model model) {
        Fency fency = fencyDao.findById(id);
        model.addAttribute("fency", fency);
        return "fency-form";
    }

    @GetMapping("/list")
    public String listFencies(Model model) {
        List<Fency> fencyList = fencyDao.findAll();
        model.addAttribute("fencyList", fencyList);
        return "fency-list";
    }

    @RequestMapping("/delete/{id}")
    public String deleteFency(@PathVariable long id) {
        Fency fency = fencyDao.findById(id);
        fencyDao.delete(fency);
        return "redirect:/admin/fency/list";
    }


}
