
package org.jenkinsci.plugins.pairprogramming;
import hudson.model.AbstractProject;
import hudson.model.ProminentProjectAction;

/*
import hudson.model.Action;
import java.io.Serializable;
import org.kohsuke.stapler.StaplerProxy;
implements Action, Serializable, StaplerProxy {
*/

/**
 * @author Ismail Lagouilly
 */
public class ProjectAction implements ProminentProjectAction {

    private final AbstractProject<?,?> project;

    public ProjectAction(AbstractProject<?,?> project) {
	this.project=project;
    }

    public final String getIconFileName() {
        return "/webapp/img/Pairprogramming.jpg";
    }

    public final String getDisplayName() {
        return "Pair programming plugin";
    }

    public final String getUrlName() {
        return "pair-programming";
    }

    /*public final getTarget(){
    
    }*/

    public AbstractProject<?,?> getProject(){
		return this.project;
	}

}
