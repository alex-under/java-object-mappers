package org.example.mappers;

import org.example.data.dto.GroupDto;
import org.example.data.dto.UserDto;
import org.example.data.entity.Group;
import org.example.data.entity.User;
import org.example.tools.Mapper;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.TypeToken;

public class ModelMapperMapper implements Mapper {

    private final ModelMapper modelMapper;
    private final Type listType;

    public ModelMapperMapper() {
        listType = new TypeToken<List<UserDto>>() {}.getType();
        modelMapper = new ModelMapper();
        modelMapper.addMappings(new PropertyMap<User, UserDto>() {
            @Override
            protected void configure() {
                map().setTitle(source.getName());
            }
        });
        modelMapper.addMappings(new PropertyMap<Group, GroupDto>() {
            @Override
            protected void configure() {
                map().setTitle(source.getName());
            }
        });
    }

    @Override
    public UserDto mapSingleObject(User user) {
        return modelMapper.map(user, UserDto.class);
    }

    @Override
    public Collection<UserDto> mapCollection(Collection<User> users) {
        return modelMapper.map(users, listType);
    }

    @Override
    public GroupDto mapNestedCollection(Group group) {
        return modelMapper.map(group, GroupDto.class);
    }
}
