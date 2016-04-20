package org.example.mappers;

import org.example.data.dto.GroupDto;
import org.example.data.dto.UserDto;
import org.example.data.entity.Group;
import org.example.data.entity.User;
import org.example.tools.Mapper;
import java.util.Collection;

public class MapStructMapper implements Mapper {


    @Override
    public UserDto mapSingleObject(User user) {
        return MapStructUserMapper.INSTANCE.userToDto(user);
    }

    @Override
    public Collection<UserDto> mapCollection(Collection<User> users) {
        return MapStructUserMapper.INSTANCE.usersToDtos(users);
    }

    @Override
    public GroupDto mapNestedCollection(Group group) {
        return MapStructUserMapper.INSTANCE.groupToDto(group);
    }
}
