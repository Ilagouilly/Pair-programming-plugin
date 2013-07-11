
package org.jenkinsci.plugins.pairprogramming;
import hudson.Launcher;
import hudson.Extension;
import hudson.util.FormValidation;
import hudson.model.AbstractBuild;
import hudson.model.BuildListener;
import hudson.model.AbstractProject;
import hudson.tasks.Builder;
import hudson.tasks.BuildStepDescriptor;
import net.sf.json.JSONObject;
import org.kohsuke.stapler.DataBoundConstructor;
import org.kohsuke.stapler.StaplerRequest;
import org.kohsuke.stapler.QueryParameter;

import javax.servlet.ServletException;
import java.io.IOException;

/**
 * @author Ismail Lagouilly
 */
public class ProjectBuilder extends Builder {

    private final String name;
    private final float age;
    private final String adresse;

    @DataBoundConstructor
    public ProjectBuilder(String name, float age, String adresse) {
        this.name = name;
	this.age = age;
	this.adresse = adresse; 
    }

    public String getName() {
        return name;
    }
    public float getAge() {
        return age;
    }
    public String getAddress() {
        return adresse;
    }

    @Override
    public boolean perform(AbstractBuild build, Launcher launcher, BuildListener listener) {
	if (getDescriptor().getUseFrench())
		listener.getLogger().println("Bonjour, "+name+", votre age est "+age+" et vous habitez au "+adresse+" !!");
	else
		listener.getLogger().println("Hello, "+name+", your age is "+age+" & you live in :"+adresse+" !!");
        return true;
    }

    @Override
    public DescriptorImpl getDescriptor() {
        return (DescriptorImpl)super.getDescriptor();
    }

    @Extension
    public static final class DescriptorImpl extends BuildStepDescriptor<Builder> {

        private boolean useFrench;

        public FormValidation doCheckName(@QueryParameter String value)
                throws IOException, ServletException {
            if (value.length() == 0)
                return FormValidation.error("Veuillez entrer un nom");
            if (value.length() < 4)
                return FormValidation.warning("Attention : Nom trop court !");
            return FormValidation.ok();
        }

        public boolean isApplicable(Class<? extends AbstractProject> aClass) {
            return true;
        }

        public String getDisplayName() {
            return "Lancer le plugin show informations";
        }

        @Override
        public boolean configure(StaplerRequest req, JSONObject formData) throws FormException {

            useFrench = formData.getBoolean("useFrench");

            save();
            return super.configure(req,formData);
        }

        public boolean getUseFrench() {
            return useFrench;
        }
    }
}
