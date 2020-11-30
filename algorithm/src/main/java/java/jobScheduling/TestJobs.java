package java.jobScheduling;

import com.google.common.collect.Lists;

import java.util.List;

public abstract class TestJobs {
    public static List<Job> case1(){
        return Lists.newArrayList(
                Job.of(0,1),
                Job.of(1,100),
                Job.of(2,1),
                Job.of(3,100)
        );
    }

    public static List<Job> case2(){
        return Lists.newArrayList(
                Job.of(0,4),
                Job.of(1,3),
                Job.of(2,5),
                Job.of(3,2),
                Job.of(4,4)
        );
    }
}
