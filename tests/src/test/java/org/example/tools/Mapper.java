package org.example.tools;

import java.util.Collection;
import org.example.data.dto.GroupDto;
import org.example.data.dto.UserDto;
import org.example.data.entity.Group;
import org.example.data.entity.User;

public interface Mapper {

    UserDto mapSingleObject(User user);

    Collection<UserDto> mapCollection(Collection<User> users);

    GroupDto mapNestedCollection(Group group);
}
