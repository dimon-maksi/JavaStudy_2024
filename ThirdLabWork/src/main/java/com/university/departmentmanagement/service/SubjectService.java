package com.university.departmentmanagement.service;

import com.university.departmentmanagement.model.Subject;
import com.university.departmentmanagement.repository.SubjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SubjectService {

    private final SubjectRepository subjectRepository;

    // Додавання предмету
    public void addSubject(Subject subject) {
        subjectRepository.save(subject);
    }

    // Видалення предмету
    public void deleteSubject(Long id) {
        subjectRepository.deleteById(id);
    }

    // Отримання списку предметів
    public List<Subject> listSubjects() {
        return subjectRepository.findAll();
    }
}

