package com.kargo.transporter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MockDataProvider {
    public List<JobData> getJobs() {
        List<JobData> jobs = new ArrayList<JobData>();
        jobs.add(new JobData(new Date(2019, 3, 14), "Jakarta", "Bandung", 1000000));
        jobs.add(new JobData(new Date(2019, 3, 14), "Jakarta", "Medan", 8000000));
        jobs.add(new JobData(new Date(2019, 3, 14), "Bandung", "Jakarta", 1000002));
        jobs.add(new JobData(new Date(2019, 3, 14), "Medan", "Jakarta", 1000001));
        jobs.add(new JobData(new Date(2019, 3, 14), "Jakarta", "Surabaya", 1050000));
        jobs.add(new JobData(new Date(2019, 3, 14), "Surabaya", "Jakarta", 1000000));
        jobs.add(new JobData(new Date(2019, 3, 14), "Surabaya", "Bandung", 3000000));
        jobs.add(new JobData(new Date(2019, 3, 14), "Bandung", "Surabaya", 1000070));
        jobs.add(new JobData(new Date(2019, 3, 14), "Jakarta", "Semarang", 1060000));
        jobs.add(new JobData(new Date(2019, 3, 14), "Semarang", "Jakarta", 4000000));

        return jobs;
    }
}
