package ticketflow.bookingservice.config;

import java.time.Duration;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "ticketflow.resilience.event-service")
public class EventServiceResilienceProperties {

    private int slidingWindowSize = 10;
    private int minimumNumberOfCalls = 5;
    private float failureRateThreshold = 50;
    private Duration waitInOpenState = Duration.ofSeconds(10);
    private int permittedCallsInHalfOpenState = 3;
    private Duration timeLimit = Duration.ofSeconds(4);

    public int getSlidingWindowSize() {
        return slidingWindowSize;
    }

    public void setSlidingWindowSize(int slidingWindowSize) {
        this.slidingWindowSize = slidingWindowSize;
    }

    public int getMinimumNumberOfCalls() {
        return minimumNumberOfCalls;
    }

    public void setMinimumNumberOfCalls(int minimumNumberOfCalls) {
        this.minimumNumberOfCalls = minimumNumberOfCalls;
    }

    public float getFailureRateThreshold() {
        return failureRateThreshold;
    }

    public void setFailureRateThreshold(float failureRateThreshold) {
        this.failureRateThreshold = failureRateThreshold;
    }

    public Duration getWaitInOpenState() {
        return waitInOpenState;
    }

    public void setWaitInOpenState(Duration waitInOpenState) {
        this.waitInOpenState = waitInOpenState;
    }

    public int getPermittedCallsInHalfOpenState() {
        return permittedCallsInHalfOpenState;
    }

    public void setPermittedCallsInHalfOpenState(int permittedCallsInHalfOpenState) {
        this.permittedCallsInHalfOpenState = permittedCallsInHalfOpenState;
    }

    public Duration getTimeLimit() {
        return timeLimit;
    }

    public void setTimeLimit(Duration timeLimit) {
        this.timeLimit = timeLimit;
    }
}
