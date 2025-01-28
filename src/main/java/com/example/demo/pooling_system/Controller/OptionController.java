package com.example.demo.pooling_system.Controller;

import com.example.demo.pooling_system.Models.Options;
import com.example.demo.pooling_system.Service.OptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/polls/options")
public class OptionController
{
    @Autowired
    private OptionService optionService;

    @PostMapping("/{pollId}")
    public List<Options> createOptions(@PathVariable int pollId, @RequestBody OptionRequest request) {
        return optionService.createOptions(pollId, request.getOptionTexts());
    }

}
