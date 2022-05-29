package ru.levelup.studentdb.actions;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ru.levelup.studentdb.model.Group;
import ru.levelup.studentdb.model.Student;
import ru.levelup.studentdb.service.GroupService;
import ru.levelup.studentdb.service.StudentsService;

@Component("addAction")
@Scope("prototype")
@RequiredArgsConstructor
public class AddStudentAction implements Action {
// add student to group(group will be created if it is not exist)

    private String firstName;
    private String lastName;
    private String groupName;

    private final StudentsService studentsService;
    private final GroupService groupService;

    @Override
    public void setParams(String... param) {
        this.firstName = param[0];
        this.lastName = param[1];
//        this.groupName = param[2];
    }

    @Override
    public void execute() {
        Student student = new Student(firstName, lastName);
        studentsService.save(student);

//        Group group = new Group(groupName);
//        groupService.save(group);
    }
}
