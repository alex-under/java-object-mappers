package org.example.tools;

import java.util.Collection;
import java.util.Iterator;
import java.util.function.BiConsumer;
import org.example.data.SampleData;
import org.example.data.dto.GroupDto;
import org.example.data.dto.UserDto;
import org.example.data.entity.Group;
import org.example.data.entity.User;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public abstract class DefaultTest {

    private final Mapper mapper;
    private final SampleData sampleData;
    private final User sampleUser;


    protected DefaultTest(Mapper mapper) {
        this.mapper = mapper;
        this.sampleData = new SampleData();
        this.sampleUser = sampleData.getUsers().get(0);
    }

    @Test
    public void testSingleMapping() {
        UserDto userDto = mapper.mapSingleObject(sampleUser);
        checkUserDto(sampleUser, userDto);
    }

    @Test
    public void testCollectionMapping() {
        Collection<UserDto> dtos = mapper.mapCollection(sampleData.getUsers());
        checkUserDtoCollection(sampleData.getUsers(), dtos);
    }

    @Test
    public void testNestedObjectMapping() {
        GroupDto groupDto = mapper.mapNestedCollection(sampleData.getGroup());
        checkGroupDto(sampleData.getGroup(), groupDto);
    }

    public UserDto benchmarkSingleMapping() {
        return mapper.mapSingleObject(sampleUser);
    }

    public Collection<UserDto> benchmarkCollectionMapping() {
        return mapper.mapCollection(sampleData.getUsers());
    }

    public GroupDto benchmarkNestedObjectMapping() {
        return mapper.mapNestedCollection(sampleData.getGroup());
    }


    private static void checkUserDto(User expectedEntity, UserDto actualDto) {
        assertEquals(expectedEntity.getName(), actualDto.getTitle());
        assertEquals(expectedEntity.getId(), actualDto.getId());
        assertEquals(expectedEntity.getUid(), actualDto.getUid());
    }

    private static void checkUserDtoCollection(Collection<User> expectedEntityCollection,
                                               Collection<UserDto> actualDtoCollection) {
        checkCollection(expectedEntityCollection, actualDtoCollection, DefaultTest::checkUserDto);
    }

    private static void checkGroupDto(Group expectedEntity, GroupDto actualDto) {
        assertEquals(expectedEntity.getId(), actualDto.getId());
        assertEquals(expectedEntity.getName(), actualDto.getTitle());
        checkUserDtoCollection(expectedEntity.getUsers(), actualDto.getUsers());
    }

    private static <Entity, DTO> void checkCollection(Collection<Entity> expectedEntities,
                                                      Collection<DTO> actualDtos,
                                                      BiConsumer<Entity, DTO> checker) {

        assertEquals("Collection size differs", expectedEntities.size(), actualDtos.size());

        Iterator<DTO> actualDtoIt = actualDtos.iterator();
        Iterator<Entity> expectedEntityIt = expectedEntities.iterator();

        while (expectedEntityIt.hasNext() && actualDtoIt.hasNext()) {
            DTO actualDto = actualDtoIt.next();
            Entity expectedEntity = expectedEntityIt.next();
            checker.accept(expectedEntity, actualDto);
        }
    }
}
