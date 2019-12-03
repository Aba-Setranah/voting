package com.controller;

import com.dao.CandidateDao;
import com.dao.VoteDao;
import com.model.Candidate;
import com.model.Election;
import com.model.User;
import com.model.Vote;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class VoterController {
    
    @RequestMapping("/addvote")
    public String addVote(Model model) throws SQLException
    {
        User user = new User("Dora", "Vondee", "dora", "1234", "voter");
        user.setId(1);
//        UserDao userdao = new UserDao();
//        List<User> user = userdao.getUser();
        
        Election e = new Election("General", 2019);
        e.setId(2);
        
        CandidateDao candidatedao = new CandidateDao();
        List<Candidate> candidates = candidatedao.getCandidate();
   
        model.addAttribute("user", user);
        model.addAttribute("election", e);
        model.addAttribute("candidates", candidates);
        return "addvote";
    }
    @RequestMapping("/addvoteaction")
    public String addVoteAction(Model model,
        HttpServletRequest request) throws SQLException
    {
        String election = request.getParameter("election_id");
        String candidate = request.getParameter("candidate"); 
        int user = Integer.parseInt(request.getParameter("user_id"));
        
        Vote vote= new Vote(Integer.parseInt(election), Integer.parseInt(candidate), null);
        VoteDao voteDao= new VoteDao();
        int result = voteDao.addvote(vote);
        
        System.out.println(election);
        System.out.println(candidate);
        System.out.println(user);
        return "redirect:/viewvotes";
    }
    @RequestMapping("/viewvotes")
    public String viewVotes(Model model) throws SQLException
    {
        model.addAttribute("votes", new VoteDao().getAllVotes());
        return "viewvotes";
    }
}
