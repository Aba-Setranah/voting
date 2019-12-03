package com.controller;

import com.dao.CandidateDao;
import com.dao.UserDao;
import com.dao.VoteDao;
import com.dao.VoterelectionDao;
import com.model.Candidate;
import com.model.Election;
import com.model.User;
import com.model.Vote;
import com.model.Voterelection;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class VoterController {

    @Autowired
    UserDao userdao;

    @Autowired
    VoterelectionDao ved;

    @RequestMapping("/addvote")
    public String addVote(Model model, HttpSession s) throws SQLException {
        String userId = s.getAttribute("id").toString();
//        User user = new User("Dora", "Vondee", "dora", "1234", "voter");
//        user.setId(1);

        User user = userdao.getUserById(Integer.parseInt(userId));
        Voterelection voterelection = ved.getVoterelectionById(user.getId());

        if (voterelection != null) {
            return "redirect:/alreadyvoted";
        }

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
            HttpServletRequest request) throws SQLException {
        String election = request.getParameter("election_id");
        String candidate = request.getParameter("candidate");
        int user = Integer.parseInt(request.getParameter("user_id"));

        Vote vote = new Vote(Integer.parseInt(election), Integer.parseInt(candidate), null);
        VoteDao voteDao = new VoteDao();
        int result = voteDao.addvote(vote);

        Voterelection ve = new Voterelection();
        ve.setElectionId(Integer.parseInt(election));
        ve.setVoterId(user);
        int result2 = voteDao.addelectionvote(ve);

        System.out.println(election);
        System.out.println(candidate);
        System.out.println(user);
        return "successfullyvoted";
    }

    @RequestMapping("/viewvotes")
    public String viewVotes(Model model) throws SQLException {
        model.addAttribute("votes", new VoteDao().getAllVotes());
        return "viewvotes";
    }

    @RequestMapping("/alreadyvoted")
    public String alreadyvoted(Model model) throws SQLException {
        model.addAttribute("votes", new VoteDao().getAllVotes());
        return "alreadyvoted";
    }
}
