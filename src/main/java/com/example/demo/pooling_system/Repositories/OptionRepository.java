package com.example.demo.pooling_system.Repositories;

import com.example.demo.pooling_system.Models.Options;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OptionRepository extends JpaRepository<Options,Integer> {
}
