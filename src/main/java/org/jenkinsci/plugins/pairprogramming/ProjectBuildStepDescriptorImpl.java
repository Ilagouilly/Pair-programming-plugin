
package org.jenkinsci.plugins.pairprogramming;

import hudson.Extension;
import hudson.FilePath;
import hudson.model.AbstractProject;
import hudson.model.Hudson;
import hudson.tasks.BuildStepDescriptor;
import hudson.tasks.Publisher;
import hudson.util.FormValidation;

import java.io.IOException;
import java.util.ArrayList;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.kohsuke.stapler.AncestorInPath;
import org.kohsuke.stapler.QueryParameter;
import org.kohsuke.stapler.StaplerRequest;

/**
 * @author Ismail Lagouilly
 */
@Extension
public final class ProjectBuildStepDescriptorImpl extends BuildStepDescriptor {
	
	/*public ProjectBuildStepDescriptorImpl(){
	    super(ProjectRecorderImpl.class);
	}*/

	@Override
        public boolean isApplicable(Class type) {
            return true;
        }
	
	@Override
	public String getDisplayName() {
		return "Pair programming";
	}
}
