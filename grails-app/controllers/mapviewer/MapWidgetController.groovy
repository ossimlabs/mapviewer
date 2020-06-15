package mapviewer
import io.micrometer.core.instrument.Clock;
import io.micrometer.core.instrument.Timer;
import org.springframework.web.bind.annotation.GetMapping;

class MapWidgetController
{
    @Autowired TileRendererService tileRendererService
    @Autowired SimpleMetricsManager simpleMetricsManager
    @Autowired SimpleTimer SimpleTimer

    def index() { [
      mapParams: [:]
    ]}
    
    @GetMapping("/mapWidget/getTile")
    def getTile()
    {
        simpleTimer.set(Timer.start(Clock.SYSTEM));
        render tileRendererService.getTile(params)
        simpleMetricsManager.trackTimerMetrics("metric.transaction", "uri", "/mapWidget/getTile");
    }
}
