package com.university.departmentmanagement.controller;

import com.university.departmentmanagement.model.Subject;
import com.university.departmentmanagement.service.SubjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class SubjectController {
    private final SubjectService subjectService;

    @GetMapping("/subjects")
    public String listSubjects(Model model) {
        model.addAttribute("subjects", subjectService.listSubjects());
        return "subjects";
    }

    @PostMapping("/subjects")
    public String createSubject(Subject subject) {
        subjectService.addSubject(subject);
        return "redirect:/subjects";
    }
}

