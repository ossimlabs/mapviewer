package mapviewer;

import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Timer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SimpleMetricsManager implements MetricsManager {

    @Autowired
    private MeterRegistry simpleMetricsManager;

    @Autowired
    private SimpleTimer simpleTimer;

    @Override
    public void trackTimerMetrics(String metricName, String... tags) {
        Timer timer = simpleMetricsManager.timer(metricName, tags);
        simpleTimer.get().stop(timer);

    }

    @Override
    public void trackCounterMetrics(String metricName, double value, String... tags) {
        simpleMetricsManager.counter(metricName, tags).increment(value);
    }
}