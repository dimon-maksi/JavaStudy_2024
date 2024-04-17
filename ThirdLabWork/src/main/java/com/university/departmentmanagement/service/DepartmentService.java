package com.university.departmentmanagement.service;

import com.university.departmentmanagement.model.Department;
import com.university.departmentmanagement.model.DepartmentNews;
import com.university.departmentmanagement.model.Subject;
import com.university.departmentmanagement.repository.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DepartmentService {

    private final SubjectService subjectService;

    private final DepartmentRepository departmentRepository;
    public List<Department> listDepartments() {
        return departmentRepository.findAll();
    }

    public void addDepartment(Department department) {
        departmentRepository.save(department);
    }


    public void deleteDepartment(Long id) {
        departmentRepository.deleteById(id);
    }

    public Department getDepartmentById(Long id) {
        return departmentRepository.findById(id).orElseThrow(() -> new RuntimeException("not found"));
    }

    public void addSubjectsToDepartment(Long departmentId, List<Long> subjectIds) {
        Department department = getDepartmentById(departmentId);
        if (department != null) {
            List<Subject> departmentSubjects = department.getSubjects();

            List<Subject> subjects = subjectService.listSubjects();

            subjectIds.forEach(id -> subjects.stream()
                    .filter(subject -> subject.getId().equals(id))
                    .filter(subject -> !departmentSubjects.contains(subject))
                    .findFirst()
                    .ifPresent(departmentSubjects::add));
        }

    }}
