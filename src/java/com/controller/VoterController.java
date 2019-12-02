package com.controller;

import com.dao.VoteDao;
import com.model.Candidate;
import com.model.Election;
import com.model.Party;
import com.model.User;
import com.model.Vote;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class VoterController {
    
    @RequestMapping("/addvote")
    public String addVote(Model model)
    {
        User user = new User("Dora", "Vondee", "dora", "1234", "voter");
        user.setId(1);
        Election e = new Election("General", 2019);
        e.setId(2);
        Candidate g = new Candidate();
        g.setId(1);
        g.setName("Gilbert");
        g.setParty(new Party("NPP"));
        
        Candidate s = new Candidate();
        s.setId(2);
        s.setName("Sam");
        s.setParty(new Party("PPP"));
        
        List<Candidate> candidates = new ArrayList<>();
        candidates.add(s);
        candidates.add(g);
        
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
        String user = request.getParameter("user_id");
        
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
