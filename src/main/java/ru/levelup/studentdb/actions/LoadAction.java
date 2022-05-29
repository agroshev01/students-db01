package ru.levelup.studentdb.actions;


import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import ru.levelup.studentdb.model.Student;
import ru.levelup.studentdb.service.DaoService;
import ru.levelup.studentdb.service.StudentsService;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component("loadAction")
@Scope("prototype")
@RequiredArgsConstructor
public class LoadAction implements Action{

    public final JdbcTemplate jdbctemplate;
    public final StudentsService studentService;
    private final DaoService<Student> StudentsDaoService;

    @Override
    public void setParams(String... param) {

    }

    @Override
    public void execute() {
        StudentsDaoService.findAll().forEach(studentService::save);

    }

}
