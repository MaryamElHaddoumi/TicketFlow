package ticketflow.bookingservice.config;

import feign.FeignException;

import io.github.resilience4j.circuitbreaker.CircuitBreakerConfig;
import io.github.resilience4j.timelimiter.TimeLimiterConfig;

import org.springframework.cloud.circuitbreaker.resilience4j.Resilience4JConfigBuilder;
import org.springframework.cloud.circuitbreaker.resilience4j.Resilience4JCircuitBreakerFactory;
import org.springframework.cloud.client.circuitbreaker.Customizer;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EventServiceCircuitBreakerConfig {

    private final EventServiceResilienceProperties properties;

    public EventServiceCircuitBreakerConfig(
            EventServiceResilienceProperties properties) {
        this.properties = properties;
    }

    @Bean
    public Customizer<Resilience4JCircuitBreakerFactory>
    resilience4jCustomizer() {

        CircuitBreakerConfig circuitBreakerConfig =
                CircuitBreakerConfig.custom()
                        .slidingWindowSize(
                                properties.getSlidingWindowSize())
                        .minimumNumberOfCalls(
                                properties.getMinimumNumberOfCalls())
                        .failureRateThreshold(
                                properties.getFailureRateThreshold())
                        .waitDurationInOpenState(
                                properties.getWaitInOpenState())
                        .permittedNumberOfCallsInHalfOpenState(
                                properties.getPermittedCallsInHalfOpenState())
                        .ignoreExceptions(
                                FeignException.NotFound.class,
                                FeignException.BadRequest.class)
                        .build();

        TimeLimiterConfig timeLimiterConfig =
                TimeLimiterConfig.custom()
                        .timeoutDuration(properties.getTimeLimit())
                        .build();

        return factory -> factory.configureDefault(id ->
                new Resilience4JConfigBuilder(id)
                        .circuitBreakerConfig(circuitBreakerConfig)
                        .timeLimiterConfig(timeLimiterConfig)
                        .build()
        );
    }
}
