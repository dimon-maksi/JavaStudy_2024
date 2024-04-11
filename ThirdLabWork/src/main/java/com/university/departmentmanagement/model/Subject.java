package com.university.departmentmanagement.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Subject {
    private Long id;
    private String name;
    private String description;
}

