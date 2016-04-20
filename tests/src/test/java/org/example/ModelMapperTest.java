package org.example;

import org.example.data.dto.GroupDto;
import org.example.data.dto.UserDto;
import org.example.mappers.ModelMapperMapper;
import org.example.tools.DefaultTest;
import java.util.Collection;
import org.openjdk.jmh.annotations.GenerateMicroBenchmark;
import org.openjdk.jmh.annotations.State;

@State
public class ModelMapperTest extends DefaultTest {

    public ModelMapperTest() {
        super(new ModelMapperMapper());
    }

    @GenerateMicroBenchmark
    @Override
    public UserDto benchmarkSingleMapping() {
        return super.benchmarkSingleMapping();
    }

    @GenerateMicroBenchmark
    @Override
    public Collection<UserDto> benchmarkCollectionMapping() {
        return super.benchmarkCollectionMapping();
    }

    @GenerateMicroBenchmark
    @Override
    public GroupDto benchmarkNestedObjectMapping() {
        return super.benchmarkNestedObjectMapping();
    }
}
