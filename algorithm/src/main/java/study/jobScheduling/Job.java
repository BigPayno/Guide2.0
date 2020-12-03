package study.jobScheduling;

import lombok.Data;

@Data
public class Job {
    long arrivalTime;
    long costTime;
    long startTime;
    long endTime;
    JobStatus jobStatus;

    public long turnoverTime(){
        return endTime-arrivalTime;
    }

    public static Job of(long arrivalTime,long costTime){
        Job job = new Job();
        job.setArrivalTime(arrivalTime);
        job.setCostTime(costTime);
        job.setJobStatus(JobStatus.WAIT);
        return job;
    }

    enum JobStatus{
        WAIT,EXEC,FINISH
    }
}
