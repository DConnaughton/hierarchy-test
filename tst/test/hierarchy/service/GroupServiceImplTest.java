package test.hierarchy.service;

import org.junit.Before;
import org.junit.Test;
import test.hierarchy.dao.FakeGroupDaoImpl;
import test.hierarchy.domain.Group;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GroupServiceImplTest {
    private static final int CHILD_ID = 1;
    private static final String CHILD_NAME = "CHILD";
    private static final int PARENT_ID = 2;
    private static final String PARENT_NAME = "PARENT";

    public Group childGroup = new Group();
    public Group parentGroup = new Group();
    public Group nullGroup = new Group();
    public FakeGroupDaoImpl fakeGroupDao = new FakeGroupDaoImpl();
    public GroupServiceImpl groupService = new GroupServiceImpl();

    @Before
    public void initialise() {
        childGroup.setId(CHILD_ID);
        childGroup.setName(CHILD_NAME);
        childGroup.setParentId(PARENT_ID);

        parentGroup.setId(PARENT_ID);
        parentGroup.setName(PARENT_NAME);
        parentGroup.setParentId(null);

        fakeGroupDao.addGroup(parentGroup);
        fakeGroupDao.addGroup(childGroup);

        groupService.setGroupDao(fakeGroupDao);
    }

    @Test
    public void testGetGroupById() {
        assertEquals(null, groupService.getGroupById(null));
        assertEquals(parentGroup, groupService.getGroupById(PARENT_ID));
        assertEquals(childGroup, groupService.getGroupById(CHILD_ID));
    }

    @Test
    public void testGetTopLevelGroupId() {
        assertEquals(null, groupService.getTopLevelGroupId(null));
        assertEquals(PARENT_ID, groupService.getTopLevelGroupId(PARENT_ID));
        assertEquals(PARENT_ID, groupService.getTopLevelGroupId(CHILD_ID));

    }

    @Test
    public void testGetTopLevelGroup() {
        assertEquals(null, groupService.getTopLevelGroup(nullGroup));
        assertEquals(parentGroup, groupService.getTopLevelGroup(parentGroup));
        assertEquals(parentGroup, groupService.getTopLevelGroup(childGroup));
    }
}