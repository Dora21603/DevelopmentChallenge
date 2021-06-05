package com.oracle.devops.dropwizard.healthcheck;

import com.codahale.metrics.health.HealthCheck;
import com.oracle.devops.dropwizard.data.HelloWorld;

public class DevelopmentChallengeHealthCheck  extends HealthCheck {

    private final String version;

    public DevelopmentChallengeHealthCheck(String version) {
        this.version = version;
    }

    @Override
    protected Result check() throws Exception {
    //        if (PersonDB.getCount() == 0) {
    //            return Result.unhealthy("No persons in DB! Version: " +
    //                    this.version);
    //        }
        return Result.healthy("OK with version: " + this.version +
                ". Persons count: ");
    }
}
