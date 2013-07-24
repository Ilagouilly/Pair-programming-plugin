
package org.jenkinsci.plugins.pairprogramming;

import java.io.IOException;

import org.kohsuke.stapler.StaplerRequest;
import org.kohsuke.stapler.StaplerResponse;

import hudson.model.ProminentProjectAction;
import hudson.model.AbstractBuild;
import hudson.model.AbstractProject;

/**
 * @author Ismail Lagouilly
 */
public class ProjectAction implements ProminentProjectAction{

    private AbstractProject<?, ?> project;
    public AbstractBuild<?, ?> build;

    			// Constructor of the class ProjectAction
	public ProjectAction(AbstractProject<?,?> project, AbstractBuild<?, ?> build) {
    	this.project=project;
    	this.build=build;
    }
				// Overload the constructor of the class ProjectAction
	public ProjectAction(AbstractProject<?,?> project) {
    	this.project=project;
    }
				// Indicates the link of the logo of the plugin
    public final String getIconFileName() {
        return "/plugin/pairprogramming/img/Pairprogramming.jpg";
    }
    			// Displays the name of the plugin (in a job)
    public final String getDisplayName() {
        return "Pair programming plugin";
    }
    			// Create a link of the main page of the plugin
    public final String getUrlName() {
        return "pair-programming";
    }
    			// Getter of the project
    public AbstractProject<?,?> getProject(){
		return this.project;
	}
    			// Getter of the build
    public AbstractBuild<?,?> getBuild() {
        return this.build;
    }
    			// Creates the graph
    public ProjectGraph getMyGraph(){
		return new ProjectGraph(-1,600,300, this.getBuild(), "");
	}
    			// Displays the graph created by getMyplugin
    public void doGraph(StaplerRequest req, StaplerResponse rsp) throws IOException {
    	getMyGraph().doPng(req, rsp);
    }

}
