package com.university.departmentmanagement.service;

import com.university.departmentmanagement.model.Department;
import com.university.departmentmanagement.model.DepartmentNews;
import com.university.departmentmanagement.model.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DepartmentService {

    private final SubjectService subjectService;

    private final List<Department> departments = new ArrayList<>();
    private List<Subject> subjects = new ArrayList<>();
    private long ID = 0;

    public DepartmentService(@Autowired SubjectService subjectService) {
        this.subjectService = subjectService;
        departments.add(new Department(++ID, "ІНЖЕНЕРІЇ ПРОГРАМНОГО ЗАБЕЗПЕЧЕННЯ", "ІПЗ", "249-25-96", "315 (кім. 3, 4)", new ArrayList<Subject>(), new ArrayList<DepartmentNews>()));
        departments.add(new Department(++ID, "КОМП'ЮТЕРНОЇ ІНЖЕНЕРІЇ", "КІ", "(097)-527-49-26", "218", new ArrayList<Subject>(), new ArrayList<DepartmentNews>()));
    }


    public List<Department> listDepartments() {
        return departments;
    }

    public void addDepartment(Department department) {
        department.setId(++ID);
        departments.add(department);
    }

    public void deleteDepartment(Long id) {
        departments.removeIf(department -> department.getId().equals(id));
    }

    public Department getDepartmentById(Long id) {
        for (Department department : departments) {
            if (department.getId().equals(id)) return department;
        }
        return null;
    }
    public void addSubjectsToDepartment(Long departmentId, List<Long> subjectIds) {
        Department department = getDepartmentById(departmentId);
        if (department != null) {
            List<Subject> departmentSubjects = department.getSubjects();

            subjects = subjectService.listSubjects();

            subjectIds.forEach(id -> subjects.stream()
                    .filter(subject -> subject.getId().equals(id))
                    .filter(subject -> !departmentSubjects.contains(subject))
                    .findFirst()
                    .ifPresent(departmentSubjects::add));
        }

    }}
