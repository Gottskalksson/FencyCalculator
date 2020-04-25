package uk.co.breschbrothers.controllers;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import uk.co.breschbrothers.daos.AdminDao;
import uk.co.breschbrothers.entity.Admin;

import javax.servlet.http.HttpServletRequest;

@Controller
@SessionAttributes("username")
public class AdminController {

    private final AdminDao adminDao;

    @Autowired
    public AdminController(final AdminDao adminDao) {
        this.adminDao = adminDao;
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/login")
    public String validateLogin(HttpServletRequest request, Model model) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        if (adminDao.checkAdminData(username, password)) {
            model.addAttribute("username", username);
            return "redirect:/admin";
        } else {
            return "login";
        }
    }

    @GetMapping("/admin")
    public String adminDashboard() {
        return "admin";
    }
}
