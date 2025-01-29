package com.example.demo.pooling_system.Service;


import com.example.demo.pooling_system.Models.Polls;
import com.example.demo.pooling_system.Repositories.PollsRepository;
import com.example.demo.pooling_system.Repositories.VoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ResultService {
    @Autowired
    private VoteRepository voteRepository;

    @Autowired
    private PollsRepository pollsRepository;

    public Map<String, Object> calculatePollResults(int pollId) {
        Optional<Polls> pollOptional = pollsRepository.findById(pollId);

        if (!pollOptional.isPresent()) {
            throw new RuntimeException("Poll not found with ID: " + pollId);
        }

        Polls poll = pollOptional.get();
        List<Object[]> results = voteRepository.getPollResults(pollId);
        List<Map<String, Object>> resultList = new ArrayList<>();
        int totalVotes = 0;

        for (Object[] result : results) {
            String optionTitle = (String) result[0];
            Integer voteCount = ((Number) result[1]).intValue();
            totalVotes = totalVotes + voteCount;

            Map<String, Object> optionResult = new HashMap<>();
            optionResult.put("option", optionTitle);
            optionResult.put("votes", voteCount);
            resultList.add(optionResult);
        }

        Map<String, Object> response = new HashMap<>();
        response.put("pollId", poll.getPoll_id());
        response.put("title", poll.getPoll_title());
        response.put("results", resultList);
        response.put("totalVotes", totalVotes);

        return response;
    }
}