package ru.levelup.studentdb.actions;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import ru.levelup.studentdb.model.Student;
import ru.levelup.studentdb.service.DaoService;
import ru.levelup.studentdb.service.StudentsService;
import ru.levelup.studentdb.service.impl.StudentsJdbcDaoImpl;

import java.util.List;
import java.util.Map;

@Component("saveAction")
@Scope("prototype")
@RequiredArgsConstructor
public class SaveAction implements Action {

//    public final JdbcTemplate jdbctemplate;
//    public final NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    private final StudentsService studentService;
    private final DaoService<Student> StudentsDaoService;

    @Override
    public void setParams(String... param) {
    }
// used with this dependency  and JdbcTemplate
//<!--        <dependency>-->
//<!--            <groupId>org.springframework.boot</groupId>-->
//<!--            <artifactId>spring-boot-starter-data-jdbc</artifactId>-->
//<!--        </dependency>-->
//    @Override
//    public void execute() {
//        String insertSql = "insert into edu_schema.students (firsname, lastname) values (?,?)";
//        String updateSql = "update edu_schema.students set firsname= ?, lastname= ? where id= ?";
//
//        List<Student> allStudent = studentService.findAll();
//        allStudent.forEach(student -> {
//            if(student.getId()== null){
//                jdbctemplate.update(insertSql, ps-> {
//                        ps.setString(1, student.getFirstName());
//                        ps.setString(1, student.getLastName());
//                });
//            } else{
//                jdbctemplate.update(updateSql, ps->{
//                    ps.setString(1, student.getFirstName());
//                    ps.setString(1, student.getLastName());
//                    ps.setLong(3, student.getId());
//                });
//            }
//        });
//        System.out.println("Save DB");
//    }


    // used with this dependency
//    <dependency>
//            <groupId>org.springframework.data</groupId>
//            <artifactId>spring-data-jdbc</artifactId>
//    </dependency>
    @Override
    public void execute() {
        String insertSql = "insert into edu_schema.students (firstname, lastname) values (:firstname,:lastname)";
        String updateSql = "update edu_schema.students set firsname= :firstname, lastname= :lastname where id= :id";

        List<Student> allStudent = studentService.findAll();
        allStudent.forEach(student -> {
            StudentsDaoService.save(student);
//            if(student.getId()== null){
//                namedParameterJdbcTemplate.update(insertSql, Map.of("firsname", student.getFirstName(),
//                        "lastname", student.getLastName() )
//                );
//            } else{
//                namedParameterJdbcTemplate.update(updateSql, Map.of("firsname", student.getFirstName(),
//                        "lastname", student.getLastName(),
//                        "id", student.getId() )
//                );
//            }
        });
        System.out.println("Save DB");
    }
}
