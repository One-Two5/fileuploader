package com.example.fileuploader.controller;

import com.example.fileuploader.entity.ForeignAgent;
import com.example.fileuploader.repository.ForeignAgentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;

@Controller
public class MainController {

    @Autowired
    private ForeignAgentRepository foreignAgentRepository;

    @GetMapping("/")
    public String index() {
        ForeignAgent agent = new ForeignAgent();
        agent.setFullName("Name");
        agent.setReason("Example");
        agent.setDateIncluded(LocalDate.now());
        agent.setDateExcluded(null);
        foreignAgentRepository.save(agent);

        return "index";
    }




    }
}

