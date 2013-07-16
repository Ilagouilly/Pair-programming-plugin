
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
	
	public ProjectBuildStepDescriptorImpl(){
	    super(ProjectRecorderImpl.class);
	}

	@Override
    public boolean isApplicable(Class<? extends AbstractProject> jobType) {
        return true;
    }
	
	@Override
	public String getDisplayName() {
		return "Pair programming plugin";
	}
}
