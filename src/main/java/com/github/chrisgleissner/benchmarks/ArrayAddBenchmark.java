package com.github.chrisgleissner.benchmarks;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class ArrayAddBenchmark extends AbstractBenchmark {

    @State(Scope.Thread)
    public static class MyState {
        Integer[] intWrappers;
        int[] ints;
        Long[] longWrappers;
        long[] longs;

        @Setup
        public void doSetup()  {
            intWrappers = IntStream.range(0, LOOPS_PER_INVOCATION).boxed().toArray(Integer[]::new);
            ints = IntStream.range(0, LOOPS_PER_INVOCATION).toArray();

            longWrappers = LongStream.range(0, LOOPS_PER_INVOCATION).boxed().toArray(Long[]::new);
            longs = LongStream.range(0, LOOPS_PER_INVOCATION).toArray();
        }
    }


    // int / Integer Array

    @Benchmark
    public int[] intArrayClone(MyState s) {
        return s.ints.clone();
    }

    @Benchmark
    public int[] intArrayCopyOf(MyState s) {
        return Arrays.copyOf(s.ints, LOOPS_PER_INVOCATION);
    }

    @Benchmark
    public int[] intArrayAdd(MyState s) {
        int[] ints = new int[LOOPS_PER_INVOCATION];
        for (int i = 0; i < LOOPS_PER_INVOCATION; i++)
            ints[i] = s.ints[i];
        return ints;
    }

    @Benchmark
    public Integer[] intWrapperArrayClone(MyState s) {
        return s.intWrappers.clone();
    }

    @Benchmark
    public Integer[] intWrapperArrayCopyOf(MyState s) {
        return Arrays.copyOf(s.intWrappers, LOOPS_PER_INVOCATION);
    }

    @Benchmark
    public Integer[] intWrapperArrayAdd(MyState s) {
        Integer[] ints = new Integer[LOOPS_PER_INVOCATION];
        for (int i = 0; i < LOOPS_PER_INVOCATION; i++)
            ints[i] = s.intWrappers[i];
        return ints;
    }


    // long / Long Array

    @Benchmark
    public long[] longArrayClone(MyState s) {
        return s.longs.clone();
    }

    @Benchmark
    public long[] longArrayCopyOf(MyState s) {
        return Arrays.copyOf(s.longs, LOOPS_PER_INVOCATION);
    }

    @Benchmark
    public long[] longArrayAdd(MyState s) {
        long[] longs = new long[LOOPS_PER_INVOCATION];
        for (int i = 0; i < LOOPS_PER_INVOCATION; i++)
            longs[i] = s.longs[i];
        return longs;
    }

    @Benchmark
    public Long[] longWrapperArrayClone(MyState s) {
        return s.longWrappers.clone();
    }

    @Benchmark
    public Long[] longWrapperArrayCopyOf(MyState s) {
        return Arrays.copyOf(s.longWrappers, LOOPS_PER_INVOCATION);
    }

    @Benchmark
    public Long[] longWrapperArrayAdd(MyState s) {
        Long[] longs = new Long[LOOPS_PER_INVOCATION];
        for (int i = 0; i < LOOPS_PER_INVOCATION; i++)
            longs[i] = s.longWrappers[i];
        return longs;
    }
}
