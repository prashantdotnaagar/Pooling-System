package com.example.demo.pooling_system.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.pooling_system.Service.VoteService;

@RestController
@RequestMapping("/polls/{pollId}/vote")
public class VoteController {

    @Autowired
    private VoteService voteService;

    @PostMapping
    public ApiResponse submitVote(@PathVariable Integer pollId, @RequestBody VoteRequest voteRequest)
    {
        voteService.submitVote(pollId, voteRequest.getOptionId(), voteRequest.getVoteId());
        return new ApiResponse("Vote submitted successfully!");
    }
}