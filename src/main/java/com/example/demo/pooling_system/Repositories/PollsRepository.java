package com.example.demo.pooling_system.Repositories;

import com.example.demo.pooling_system.Models.Polls;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PollsRepository extends JpaRepository<Polls,Integer> {
}
