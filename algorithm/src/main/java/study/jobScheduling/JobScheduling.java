package study.jobScheduling;

import java.util.List;

public interface JobScheduling {
    interface JobSchedulingDetect{
        long averageTurnoverTime();
        long weightedTurnoverTime();
    }


    JobSchedulingDetect apply(List<Job> jobs);
}
