package com.university.departmentmanagement.controller;

import com.university.departmentmanagement.model.Department;
import com.university.departmentmanagement.service.DepartmentService;
import com.university.departmentmanagement.service.SubjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/departments")
public class DepartmentController {

    private final DepartmentService departmentService;
    private final SubjectService subjectService;

    @GetMapping
    public String departments(Model model) {
        model.addAttribute("departments", departmentService.listDepartments());
        return "departments";
    }


    @GetMapping("/{id}")
    public String departmentInfo(@PathVariable Long id, Model model) {
        Department department = departmentService.getDepartmentById(id);
        if (department != null) {
            model.addAttribute("department", department);
            model.addAttribute("allSubjects", subjectService.listSubjects());
            return "department-info";
        }
        return "redirect:/departments";
    }

    @PostMapping("/create")
    public String createDepartment(Department department) {
        departmentService.addDepartment(department);
        return "redirect:/departments";
    }


    @PostMapping("/{id}")
    public String addSubjectsToDepartment(@PathVariable Long id, @RequestParam List<Long> subjectIds) {
        departmentService.addSubjectsToDepartment(id, subjectIds);
        return "redirect:/departments/" + id;
    }

    @PostMapping("/delete/{id}")
    public String deleteDepartment(@PathVariable Long id) {
        departmentService.deleteDepartment(id);
        return "redirect:/departments";
    }
}
