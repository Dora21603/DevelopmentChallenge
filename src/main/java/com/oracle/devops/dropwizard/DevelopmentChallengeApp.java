package com.oracle.devops.dropwizard;

import com.oracle.devops.dropwizard.healthcheck.DevelopmentChallengeHealthCheck;
import com.oracle.devops.dropwizard.service.FibonacciService;
import com.oracle.devops.dropwizard.service.HelloWorldService;
import io.dropwizard.Application;
import io.dropwizard.setup.Environment;

public class DevelopmentChallengeApp extends Application<DevelopmentChallengeConfig> {
    public static void main(String[] args) throws Exception {
        new DevelopmentChallengeApp().run(args);
    }

    @Override
    public void run(DevelopmentChallengeConfig config, Environment env) {
        final HelloWorldService personService = new HelloWorldService();
        final FibonacciService fibonacciService = new FibonacciService();

        env.jersey().register(personService);
        env.jersey().register(fibonacciService);

        env.healthChecks().register("template",
                new DevelopmentChallengeHealthCheck(config.getVersion()));
    }

}
