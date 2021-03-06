package uk.co.breschbrothers.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import uk.co.breschbrothers.daos.FencyDao;
import uk.co.breschbrothers.daos.PostDao;
import uk.co.breschbrothers.entity.Fency;
import uk.co.breschbrothers.entity.Post;

import javax.validation.Valid;
import javax.validation.Validator;
import java.util.List;

@Controller
@RequestMapping(value = "/admin/fency", produces = "text/plain;charset=utf-8")
public class FencyController {

    private final FencyDao fencyDao;
    private final PostDao postDao;
    private final Validator validator;

    @Autowired
    public FencyController(FencyDao fencyDao, PostDao postDao, Validator validator) {
        this.fencyDao = fencyDao;
        this.postDao = postDao;
        this.validator = validator;
    }

    @GetMapping("/add")
    public String addFency(Model model) {
        model.addAttribute("fency", new Fency());
        return "fency-form";
    }

    @PostMapping("/add")
    public String validateFency (@ModelAttribute @Valid Fency fency, BindingResult result) {

        if (!result.hasErrors()) {
            if (fency.getId() > 0) {
                fency.setPricePerPiece();
                fencyDao.update(fency);
            } else {
                fency.setPricePerPiece();
                fencyDao.save(fency);
            }
            return "redirect: /admin/fency/list";
        } else {
            return "fency-form";
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

    @ModelAttribute("posts")
    public List<Post> posts() {return postDao.findAll();}


}
