package com.example.demo.pooling_system.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.pooling_system.Models.Options;
import com.example.demo.pooling_system.Models.Polls;
import com.example.demo.pooling_system.Models.Votes;
import com.example.demo.pooling_system.Repositories.OptionRepository;
import com.example.demo.pooling_system.Repositories.PollsRepository;
import com.example.demo.pooling_system.Repositories.VoteRepository;

@Service
public class VoteService {

    @Autowired
    private VoteRepository voteRepository;

    @Autowired
    private PollsRepository pollRepository;

    @Autowired
    private OptionRepository optionRepository;

    public void submitVote(Integer pollId, Integer optionId, Integer voteId)
    {

        Polls poll = pollRepository.findById(pollId)
                .orElseThrow();

        Options option = optionRepository.findById(optionId)
                .orElseThrow();

        Votes vote = new Votes();

        if (voteRepository.findById(voteId).isPresent()) {
            throw new RuntimeException("Vote with this id already exists");
        }
        vote.setPolls(poll);
        vote.setOption(option);
        vote.setVote_id(voteId);
        voteRepository.save(vote);
    }
}