
package org.jenkinsci.plugins.pairprogramming;

import hudson.Extension;
import hudson.model.AbstractProject;
import hudson.tasks.BuildStepDescriptor;
import hudson.tasks.Publisher;

/**
 * @author Ismail Lagouilly
 */
@Extension
public final class ProjectBuildStepDescriptorImpl extends BuildStepDescriptor<Publisher> {
		
				// Constructor of the class (calls ProjectRecorderImpl class)
	public ProjectBuildStepDescriptorImpl(){
	    super(ProjectRecorderImpl.class);
	}

	@Override	// Indicates that this builder can be used with all kinds of project types
    public boolean isApplicable(Class<? extends AbstractProject> buildType) {
        return true;
    }
	
	@Override	// Human readable name is used in the configuration screen
	public String getDisplayName() {
		return "Pair programming plugin";
	}
}
