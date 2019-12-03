/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.dao.VoteDao;
import java.sql.SQLException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminLoginController {

    @RequestMapping("/adminhome")
    public String adminhome(Model model) throws SQLException {
        model.addAttribute("votes", new VoteDao().getAllVotes());

        return "adminhome";
    }
}
