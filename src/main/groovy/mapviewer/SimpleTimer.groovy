package mapviewer

import org.springframework.stereotype.Component;
import static io.micrometer.core.instrument.Timer.Sample;

@Component
public class SimpleTimer {

    private static final InheritableThreadLocal<Sample> threadLocal = new InheritableThreadLocal<>();

    public void set(Sample sample) {
        threadLocal.set(sample);
    }

    public Sample get() {
        return threadLocal.get();
    }
}