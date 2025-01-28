package com.example.demo.pooling_system.Service;

import com.example.demo.pooling_system.Models.Options;
import com.example.demo.pooling_system.Models.Polls;
import com.example.demo.pooling_system.Repositories.OptionRepository;
import com.example.demo.pooling_system.Repositories.PollsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OptionService {
    @Autowired
    private OptionRepository optionRepository;

    @Autowired
    private PollsRepository pollRepository;

    public List<Options>createOptions(int id,List<String>optionTexts)
    {
        {
            Polls poll=pollRepository.findById(id).orElse(null);
            if(optionTexts.size()<=2)
            {
                throw new IllegalArgumentException("option required");
            }
            return optionTexts.stream().map(optionText ->
            {
                Options option=new Options();
                option.setPoll(poll);
                option.setOption_title(optionText);
                return optionRepository.save(option);
            }).toList();
        }
    }

}
