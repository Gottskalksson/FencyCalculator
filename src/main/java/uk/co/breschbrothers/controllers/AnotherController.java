package uk.co.breschbrothers.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import uk.co.breschbrothers.daos.AnotherDao;
import uk.co.breschbrothers.entity.Another;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping(value = "/admin/another", produces = "text/plain;charset=utf-8")
public class AnotherController {

    private final AnotherDao anotherDao;

    @Autowired
    public AnotherController(AnotherDao anotherDao) {
        this.anotherDao = anotherDao;
    }

    @GetMapping("/add")
    public String addExtra(Model model) {
        model.addAttribute("another", new Another());
        return "another-form";
    }

    @PostMapping("/add")
    public String validateExtra (@ModelAttribute @Valid Another another, BindingResult result) {

        if (!result.hasErrors()) {
            if (another.getId() > 0) {
                anotherDao.update(another);
            } else {
                anotherDao.save(another);
            }
            return "redirect:/admin/another/list";

        } else {
            return "another-form";
        }
    }

    @RequestMapping("/edit/{id}")
    public String editExtra(@PathVariable long id, Model model) {
        Another another = anotherDao.findById(id);
        model.addAttribute("another", another);
        return "another-form";
    }

    @GetMapping("/list")
    public String listExtras(Model model) {
        List<Another> anotherList = anotherDao.findAll();
        model.addAttribute("anotherList", anotherList);
        return "another-list";
    }

    @RequestMapping("/delete/{id}")
    public String deleteRail(@PathVariable long id) {
        Another another = anotherDao.findById(id);
        anotherDao.delete(another);
        return "redirect:/admin/another/list";
    }
}
