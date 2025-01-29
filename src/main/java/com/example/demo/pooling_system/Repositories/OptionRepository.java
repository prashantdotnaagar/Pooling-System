package com.example.demo.pooling_system.Repositories;

import com.example.demo.pooling_system.Models.Options;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OptionRepository extends JpaRepository<Options,Integer> {

}
