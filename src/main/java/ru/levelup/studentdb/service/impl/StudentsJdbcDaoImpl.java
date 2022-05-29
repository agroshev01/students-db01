package ru.levelup.studentdb.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.levelup.studentdb.model.Student;
import ru.levelup.studentdb.service.DaoService;

import java.util.Collection;
import java.util.Map;

@Repository
@RequiredArgsConstructor
public class StudentsJdbcDaoImpl implements DaoService<Student> {

    private final NamedParameterJdbcTemplate jdbcTemplate;
//    private final JdbcTemplate jdbctemplate;


    @Override
    public void save(Student student) {
        String insertSql = "insert into edu_schema.student (firstname, lastname) values (:firstname,:lastname)";
        String updateSql = "update edu_schema.student set firstname= :firstname, lastname= :lastname where id= :id";

        if(student.getId()== null){
            jdbcTemplate.update(insertSql, Map.of("firstname", student.getFirstName(),
                    "lastname", student.getLastName() )
            );
        } else{
            jdbcTemplate.update(updateSql, Map.of("firstname", student.getFirstName(),
                    "lastname", student.getLastName(),
                    "id", student.getId() )
            );
        }

    }

    @Override
    public Collection<Student> findAll() {
        String sql = "select id, firstname, lastname from  edu_schema.student";
        return jdbcTemplate.query(sql, (rs, rowNum) -> new Student(
                rs.getLong(1),
                rs.getString(2),
                rs.getString(3)
        ));
    }
}
