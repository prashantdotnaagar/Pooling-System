package com.example.demo.pooling_system.Controller;


import com.example.demo.pooling_system.Service.PollService;
import com.example.demo.pooling_system.Service.ResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
@RestController
@RequestMapping("/polls")
public class ResultController {
    @Autowired
    private ResultService resultService;
    @GetMapping("/results/{pollId}")
    public ResponseEntity<Map<String, Object>> getPollResults(@PathVariable int pollId) {
        return ResponseEntity.ok(resultService.calculatePollResults(pollId));
    }

}