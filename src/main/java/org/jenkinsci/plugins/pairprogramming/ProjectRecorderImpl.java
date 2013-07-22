
package org.jenkinsci.plugins.pairprogramming;

import java.io.IOException;
import java.util.Collection;
import java.util.Collections;

import org.kohsuke.stapler.DataBoundConstructor;

import hudson.Launcher;
import hudson.model.Action;
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
    		// Displays the link giving access to the plugin in job main page
    @Override
    public Collection<? extends Action> getProjectActions(AbstractProject<?,?> project){
		
		ProjectAction action = new ProjectAction(project);
		return Collections.singletonList(action);
	}
    		// Displays the link giving access to the plugin in each build
    @Override
	public boolean perform(AbstractBuild<?,?>build, Launcher launcher, BuildListener listener) 
			throws InterruptedException, IOException {
    	
    	AbstractProject<?, ?> projectResult = null;
    	build.addAction(new ProjectAction(projectResult, build));
		return true;
	}
    		// Getter of the variable message
    public final String getMessage(String message) {
        return message;
    }

}

