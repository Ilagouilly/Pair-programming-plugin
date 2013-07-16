
package org.jenkinsci.plugins.pairprogramming;

import java.io.IOException;

import org.kohsuke.stapler.DataBoundConstructor;

import hudson.Launcher;
import hudson.model.BuildListener;
import hudson.model.AbstractBuild;
import hudson.model.AbstractProject;
import hudson.tasks.BuildStepDescriptor;
import hudson.tasks.Recorder;
import hudson.tasks.BuildStepMonitor;
import hudson.tasks.Publisher;

/**
 * @author Ismail Lagouilly
 */
public class ProjectRecorderImpl extends Recorder{

	
	@DataBoundConstructor
	public ProjectRecorderImpl() {
	super();
	}
	
    public BuildStepMonitor getRequiredMonitorService() {
	return BuildStepMonitor.BUILD;
    }
    public BuildStepDescriptor<Publisher> getDescriptor(){
		return (ProjectBuildStepDescriptorImpl)super.getDescriptor();
	}
    @Override
	public boolean perform(AbstractBuild<?,?>build , Launcher launcher, BuildListener listener) 
			throws InterruptedException, IOException {
    	AbstractProject<?, ?> testResult = null;
		build.addAction(new ProjectAction(testResult));
		return true;
	}

}

