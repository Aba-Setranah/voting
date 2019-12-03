package com.controller;

import com.dao.CandidateDao;
import com.dao.UserDao;
import com.dao.VoterelectionDao;
import com.model.Candidate;
import com.model.User;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class VoterLoginController {

    @Autowired
    UserDao ud;

    CandidateDao d = new CandidateDao();

    @RequestMapping("/usercheck")
    //public String usercheck(@ModelAttribute("u")User u, HttpSession s)
    public String usercheck(@ModelAttribute("u") User u, HttpSession s) {
        List<User> record = ud.checkUser(u);
        System.out.println("usercheck 1" + record);
        if (!record.isEmpty()) {
            s.setAttribute("id", u.getId());
            //ModelAndView m= new ModelAndView("addvote");
            ModelAndView m = new ModelAndView("addvote");

            User loguser = record.get(0);
            try {

                System.out.println("connection " + d);
                List<Candidate> p = d.getCandidate();
                m.addObject("candidates", p);
                System.out.println("!!!!!!!!!!!!!!!!" + p);
            } catch (Exception d2) {
                System.out.println(d2.getMessage());
            }

            if (loguser.getUsertype().equals("voter")) {
                return "redirect:/addvote";
            }
            else if(loguser.getUsertype().equals("admin")){
                return "redirect:/adminhome";
            }
            else
            {
                return "redirect:/redirect.jsp";
            }
        } else {
            ModelAndView m = new ModelAndView();
            return "redirect:/redirect.jsp";
            // return "redirect://redirect.jsp";
        }
    }

}
