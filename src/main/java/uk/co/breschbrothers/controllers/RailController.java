package uk.co.breschbrothers.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import uk.co.breschbrothers.daos.RailDao;
import uk.co.breschbrothers.entity.Rail;

import javax.validation.ConstraintViolation;
import javax.validation.Valid;
import javax.validation.Validator;
import java.util.List;
import java.util.Set;

@Controller
@RequestMapping(value = "/admin/rail", produces = "text/plain;charset=utf-8")
public class RailController {
    private final RailDao railDao;
    private final Validator validator;

    @Autowired
    public RailController(RailDao railDao, Validator validator) {
        this.railDao = railDao;
        this.validator = validator;
    }

    @GetMapping("/add")
    public String addRail(Model model) {
        model.addAttribute("rail", new Rail());
        return "rail-form";
    }

    @PostMapping("/add")
    public String validateRail (@ModelAttribute @Valid Rail rail) {

        Set<ConstraintViolation<@Valid Rail>> violations = validator.validate(rail);

        if (violations.isEmpty()) {
            if (rail.getId() > 0) {
                rail.setPricePerPiece();
                railDao.update(rail);
            } else {
                rail.setPricePerPiece();
                railDao.save(rail);
            }

            return "redirect: /admin/rail/list";
        } else {
            violations.forEach(System.out::println);
            return "redirect:" + ((rail.getId() > 0) ? "/admin/rail/edit/" + rail.getId() : "admin/rail/add");
        }
    }

    @RequestMapping("/edit/{id}")
    public String editRail(@PathVariable long id, Model model) {
        Rail rail = railDao.findById(id);
        model.addAttribute("rail", rail);
        return "rail-form";
    }

    @GetMapping("/list")
    public String listRails(Model model) {
        List<Rail> railList = railDao.findAll();
        model.addAttribute("railList", railList);
        return "rail-list";
    }

    @RequestMapping("/delete/{id}")
    public String deleteRail(@PathVariable long id) {
        Rail rail = railDao.findById(id);
        railDao.delete(rail);
        return "redirect:/admin/rail/list";
    }

}
