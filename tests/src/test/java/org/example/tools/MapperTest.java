package org.example.tools;

import java.util.List;
import org.example.data.dto.UserDto;

public interface MapperTest {

    void testSingleMapping();

    void testCollectionMapping();

    void testNestedObjectMapping();

    UserDto benchmarkSingleMapping();

    List<UserDto> benchmarkCollectionMapping();

    void benchmarkNestedObjectMapping();
}
