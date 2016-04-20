package org.example;

import org.openjdk.jmh.output.OutputFormatType;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

public class BenchmarksMain {

    private BenchmarksMain() {
    }

    public static void main(String[] args) throws RunnerException {
        Options opts = new OptionsBuilder()
                .include(".*")
                .warmupIterations(5)
                .measurementIterations(5)
                .jvmArgs("-server")
                .forks(1)
                .outputFormat(OutputFormatType.TextReport)
                .build();
        new Runner(opts).run();
    }

}
