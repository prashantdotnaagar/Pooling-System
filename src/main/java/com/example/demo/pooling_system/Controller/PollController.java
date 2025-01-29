package com.example.demo.pooling_system.Controller;


import com.example.demo.pooling_system.Models.Polls;
import com.example.demo.pooling_system.Service.PollService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/polls")
public class PollController {
    private PollService pollService;

    @PostMapping("/add")
    public ResponseEntity<Polls> createPoll(@RequestBody Polls poll){
        return ResponseEntity.ok(pollService.createPoll(poll));
    }

    @GetMapping("/all")
    public List<Polls> getAllPolls(){
        return pollService.allpolls();
    }

    @GetMapping("id/{id}")
    public Optional<Polls> getPollById(@PathVariable Integer id){

        return pollService.findById(id);
    }

    public PollController(PollService pollService) {
        this.pollService = pollService;
    }
}
