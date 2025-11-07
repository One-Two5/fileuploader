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
        foreignAgentRepository.save("Example", "Example", "Причина", LocalDate.now());
        return "index";
    }




    }
}

