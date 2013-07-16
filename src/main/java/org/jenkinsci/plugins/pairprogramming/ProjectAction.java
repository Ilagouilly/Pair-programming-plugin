
package org.jenkinsci.plugins.pairprogramming;
import hudson.model.ProminentProjectAction;
import hudson.model.AbstractProject;

/**
 * @author Ismail Lagouilly
 */
public class ProjectAction implements ProminentProjectAction{

    private AbstractProject<?, ?> project;

	public ProjectAction(AbstractProject<?,?> project) {
    	this.project=project;
    }

    public final String getIconFileName() {
        return "graph.png";
    }

    public final String getDisplayName() {
        return "Pair programming plugin";
    }

    public final String getUrlName() {
        return "pair-programming";
    }
    
    public AbstractProject<?,?> getProject(){
		return this.project;
	}

}
