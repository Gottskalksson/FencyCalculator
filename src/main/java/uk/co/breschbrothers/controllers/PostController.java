package uk.co.breschbrothers.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import uk.co.breschbrothers.daos.PostDao;
import uk.co.breschbrothers.entity.Post;

import javax.validation.ConstraintViolation;
import javax.validation.Valid;
import javax.validation.Validator;
import java.util.List;
import java.util.Set;

@Controller
@RequestMapping(value = "/admin/post", produces = "text/plain;charset=utf-8")
public class PostController {
    private final PostDao postDao;
    private final Validator validator;

    @Autowired
    public PostController(PostDao postDao, Validator validator) {
        this.postDao = postDao;
        this.validator = validator;
    }

    @GetMapping("/add")
    public String addPost(Model model) {
        model.addAttribute("post", new Post());
        return "post-form";
    }

    @PostMapping("/add")
    public String validatePost (@ModelAttribute @Valid Post post) {

        Set<ConstraintViolation<@Valid Post>> violations = validator.validate(post);

        if (violations.isEmpty()) {
            if (post.getId() > 0) {
                post.setPricePerPiece();
                postDao.update(post);
            } else {
                post.setPricePerPiece();
                postDao.save(post);
            }

            return "redirect: /admin/post/list";
        } else {
            violations.forEach(System.out::println);
            return "redirect:" + ((post.getId() > 0) ? "/admin/post/edit/" + post.getId() : "admin/post/add");
        }
    }

    @RequestMapping("/edit/{id}")
    public String editPost(@PathVariable long id, Model model) {
        Post post = postDao.findById(id);
        model.addAttribute("post", post);
        return "post-form";
    }

    @GetMapping("/list")
    public String listPosts(Model model) {
        List<Post> postList = postDao.findAll();
        model.addAttribute("postList", postList);
        return "post-list";
    }

    @RequestMapping("/delete/{id}")
    public String deletePost(@PathVariable long id) {
        Post post = postDao.findById(id);
        postDao.delete(post);
        return "redirect:/admin/post/list";
    }

}
