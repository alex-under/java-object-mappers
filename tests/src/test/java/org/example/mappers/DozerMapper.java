package org.example.mappers;

import org.example.data.dto.GroupDto;
import org.example.data.dto.UserDto;
import org.example.data.entity.Group;
import org.example.data.entity.User;
import org.example.tools.Mapper;
import java.util.ArrayList;
import java.util.Collection;
import org.dozer.DozerBeanMapper;
import org.dozer.loader.api.BeanMappingBuilder;

import static org.dozer.loader.api.FieldsMappingOptions.copyByReference;

public class DozerMapper implements Mapper {

    private final DozerBeanMapper mapper;


    public DozerMapper() {
        mapper = new DozerBeanMapper();
        BeanMappingBuilder builder = new BeanMappingBuilder() {
            @Override
            protected void configure() {
                mapping(User.class, UserDto.class)
                        .fields("name", "title")
                        .fields("uid", "uid", copyByReference());
                mapping(Group.class, GroupDto.class)
                        .fields("name", "title");
            }
        };
        mapper.addMapping(builder);
    }

    @Override
    public UserDto mapSingleObject(User user) {
        return mapper.map(user, UserDto.class);
    }

    @Override
    public Collection<UserDto> mapCollection(Collection<User> users) {
        Collection<UserDto> userDtos = new ArrayList<>(users.size());
        for (User user : users) {
            userDtos.add(mapper.map(user, UserDto.class));
        }
        return userDtos;
    }

    @Override
    public GroupDto mapNestedCollection(Group group) {
        return mapper.map(group, GroupDto.class);
    }
}
