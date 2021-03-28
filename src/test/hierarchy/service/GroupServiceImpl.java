package test.hierarchy.service;

import test.hierarchy.dao.GroupDao;
import test.hierarchy.domain.Group;

public class GroupServiceImpl implements GroupService {

    private GroupDao groupDao;

    public GroupDao getGroupDao() {
        return groupDao;
    }

    public void setGroupDao(GroupDao groupDao) {
        this.groupDao = groupDao;
    }

    @Override
    public Group getGroupById(Integer groupId) {
        if (groupId == null) {
            return null;
        }

//        // Using the cache
//        GroupModel groupModel = getGroupModel();
//        return groupModel.getById(groupId);

        // Using the database
        return getGroupDao().getGroupById(groupId);
    }

    @Override
    public Integer getTopLevelGroupId(Integer groupId) {
        if (groupId == null) {
            // that means that the objectId is invalid or deleted!
            // we need to avoid an NPE to the caller.
            return null;
        }

        Group topGroup = getTopLevelGroup(getGroupById(groupId));
        return(topGroup != null ? topGroup.getId() : null);
    }

    public Group getTopLevelGroup(Group group) {
        if (group.getId() == null) {
            // that means that the objectId is invalid or deleted!
            // we need to avoid an NPE to the caller.
            return null;
        }

        Integer parentId = group.getParentId();

        if (parentId == null) {
            // that means that the objectId is invalid or deleted!
            // we need to avoid an NPE to the caller.
            return group;
        }

        return(getTopLevelGroup(getGroupDao().getGroupById(parentId)));
    }
}
