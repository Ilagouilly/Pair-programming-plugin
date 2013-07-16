package org.jenkinsci.plugins.pairprogramming;

import hudson.Plugin;

/**
 * @author Ismail Lagouilly
 */
public class ProjectFinal extends Plugin {
 
	private String defaultName;

	public void start() throws Exception{
		super.start();
		load();
		System.out.println("Lancement du plugin");
	}
	
	
	public void setDefaultName(String defaultName){
		this.defaultName = defaultName;
	}
	
	public String getDefaultName(){
		return this.defaultName;
	}

}
