package org.example.mappers;

import org.example.data.dto.GroupDto;
import org.example.data.dto.UserDto;
import org.example.data.entity.Group;
import org.example.data.entity.User;
import org.example.tools.Mapper;
import java.util.Collection;
import ma.glasnost.orika.BoundMapperFacade;
import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;

public class OrikaBoundedMapper implements Mapper {

    private final BoundMapperFacade<User, UserDto> userMapperFacade;
    private final BoundMapperFacade<Group, GroupDto> groupMapperFacade;
    private final MapperFacade mapperFacade;


    public OrikaBoundedMapper() {
        MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();
        mapperFactory.classMap(User.class, UserDto.class)
                .field("name", "title")
                .byDefault()
                .register();
        mapperFactory.classMap(Group.class, GroupDto.class)
                .field("name", "title")
                .byDefault()
                .register();

        userMapperFacade = mapperFactory.getMapperFacade(User.class, UserDto.class, false);
        groupMapperFacade = mapperFactory.getMapperFacade(Group.class, GroupDto.class, false);
        mapperFacade = mapperFactory.getMapperFacade();
    }

    @Override
    public UserDto mapSingleObject(User user) {
        return userMapperFacade.map(user);
    }

    @Override
    public Collection<UserDto> mapCollection(Collection<User> users) {
        return mapperFacade.mapAsList(users, UserDto.class);
    }

    @Override
    public GroupDto mapNestedCollection(Group group) {
        return groupMapperFacade.map(group);
    }
}
