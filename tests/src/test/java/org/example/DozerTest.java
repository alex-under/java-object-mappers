package org.example;

import java.util.Collection;
import org.example.data.dto.GroupDto;
import org.example.data.dto.UserDto;
import org.example.mappers.DozerMapper;
import org.example.tools.DefaultTest;
import org.openjdk.jmh.annotations.GenerateMicroBenchmark;
import org.openjdk.jmh.annotations.State;

@State
public class DozerTest extends DefaultTest {

    public DozerTest() {
        super(new DozerMapper());
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
