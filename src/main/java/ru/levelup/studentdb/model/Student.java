package ru.levelup.studentdb.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Student {
    private Long id;
    private String firstName;
    private String lastName;

    public Student(String firstname, String lastname){
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
