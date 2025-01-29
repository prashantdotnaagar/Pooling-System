package com.example.demo.pooling_system.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.pooling_system.Models.Votes;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface VoteRepository extends JpaRepository<Votes,Integer>{
    @Query("SELECT v.option.option_title, COUNT(v) FROM Votes v WHERE v.polls.poll_id = :pollId GROUP BY v.option.option_id")
    List<Object[]> getPollResults(Integer pollId);

}