package ru.levelup.studentdb.service.impl;

import org.springframework.stereotype.Service;
import ru.levelup.studentdb.model.Group;
import ru.levelup.studentdb.service.DaoService;
import ru.levelup.studentdb.service.GroupService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class GroupServiceInMemoryImpl implements GroupService {

    private final List<Group> groups = new ArrayList<>();

    @Override
    public void save(Group group) {
    // check if group is already exist to avoid of doubleCreating
        if (groups.contains(group)){
            System.out.println(group + " is already exist");
        } else
        { groups.add(group);}
    }

    @Override
    public List<Group> findAll() {
        return Collections.unmodifiableList(groups);
    }
}
