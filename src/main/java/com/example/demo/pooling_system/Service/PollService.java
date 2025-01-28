package com.example.demo.pooling_system.Service;


import com.example.demo.pooling_system.Models.Polls;
import com.example.demo.pooling_system.Repositories.PollsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PollService {
    @Autowired
    private PollsRepository pollsRepository;

    public PollService(PollsRepository pollsRepository) {
        this.pollsRepository = pollsRepository;
    }
    public Polls createPoll(Polls poll){

        return pollsRepository.save(poll);
    }

    public List<Polls>allpolls(){
        return pollsRepository.findAll();
    }

    public Optional<Polls> findById(Integer id){
        return pollsRepository.findById(id);
    }

}
