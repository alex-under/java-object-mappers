package org.example.mappers;

import java.util.Collection;
import java.util.List;
import org.example.data.dto.GroupDto;
import org.example.data.dto.UserDto;
import org.example.data.entity.Group;
import org.example.data.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MapStructUserMapper {

    MapStructUserMapper INSTANCE = Mappers.getMapper(MapStructUserMapper.class);

    @Mapping(source = "name", target = "title")
    UserDto userToDto(User user);

    @Mapping(source = "name", target = "title")
    GroupDto groupToDto(Group group);

    List<UserDto> usersToDtos(Collection<User> users);
}
