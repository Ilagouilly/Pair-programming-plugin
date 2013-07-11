
import hudson.tasks.Recorder;
import hudson.tasks.BuildStepMonitor;

/**
 * @author Ismail Lagouilly
 */
public class ProjectRecorderImpl extends Recorder{

    public BuildStepMonitor getRequiredMonitorService() {
	return BuildStepMonitor.BUILD;
    }

}

