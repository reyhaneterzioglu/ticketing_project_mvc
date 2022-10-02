package com.cydeo.controller;

import com.cydeo.dto.ProjectDTO;
import com.cydeo.enums.Status;
import com.cydeo.service.ProjectService;
import com.cydeo.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.stream.Collectors;

@AllArgsConstructor
@Controller
@RequestMapping("/project")
public class ProjectController {

    private final UserService userService;
    private final ProjectService projectService;

    @GetMapping("/create")
    public String createProject(Model model) {


        model.addAttribute("project", new ProjectDTO());
        model.addAttribute("managers", userService.findAll()); //.stream().filter(user -> user.getRole().getId() == 2L).collect(Collectors.toList()));
        model.addAttribute("projects", projectService.findAll());

        return "project/create";

    }

    @PostMapping("/create")
    public String insertProject(@ModelAttribute("project") ProjectDTO project){


        project.setProjectStatus(Status.OPEN);

        projectService.save(project);

        return "redirect:/project/create";
    }
}
