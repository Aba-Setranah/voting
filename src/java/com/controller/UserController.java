/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.dao.UserDao;
import com.model.User;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {

    @Autowired
    UserDao ud;

    @RequestMapping("/addUser")
    public String addUser(Model m) {
        m.addAttribute("command", new User());
        return "adduserform";
    }

    @RequestMapping(value = "/addUserAction", method = RequestMethod.POST)
    public String saveUser(@ModelAttribute("u") User u) {
        ud.save(u);
        return "redirect:/viewUser";
    }

    @RequestMapping(value = "/viewUser")
    public String viewUser(Model m) throws SQLException {
        List<User> list = ud.getUser();
        m.addAttribute("list", list);
        return "viewUser";
    }
}
