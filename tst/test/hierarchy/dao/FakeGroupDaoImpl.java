package test.hierarchy.dao;

import test.hierarchy.domain.Group;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FakeGroupDaoImpl implements GroupDao {

    private List<Group> groups = new ArrayList<>();
    private Map<Integer, Integer> groupPositions = new HashMap<>();

    @Override
    public List<Group> getAllGroups() {
        return groups;
    }

    @Override
    public Group getGroupById(Integer groupId) {
        return groups.get(groupPositions.get(groupId));
    }

    public void addGroup(Group group) {
        groups.add(group);
        groupPositions.put(group.getId(), groups.indexOf(group));
    }

    public void removeGroup(Group group) {
        groupPositions.remove(group.getId());
        groups.remove(group);
    }
}