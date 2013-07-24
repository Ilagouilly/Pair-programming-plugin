package org.jenkinsci.plugins.pairprogramming;

import java.io.IOException;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.DefaultXYDataset;
import org.kohsuke.stapler.StaplerRequest;
import org.kohsuke.stapler.StaplerResponse;

import hudson.model.AbstractBuild;
import hudson.util.Graph;



public class ProjectGraph extends Graph {

	private String nameGraph;
	private AbstractBuild<?, ?> build;
	
	protected ProjectGraph(long timestamp, int defaultW, int defaultH, 
			AbstractBuild<?,?> build, String nameGraph) {
		super(timestamp, defaultW, defaultH);
		this.build=build;
		this.nameGraph=nameGraph;
	}
				// This function should definitely exist when the class extends the class "Graph"
	@Override
	protected JFreeChart createGraph() {
		return ChartFactory.createXYLineChart(nameGraph, "", "",
				new DefaultXYDataset(), PlotOrientation.HORIZONTAL, false, false, false);
	}
				// Convert the graph into a .png image
	@Override
	public void doPng(StaplerRequest req, StaplerResponse res) throws IOException{
		super.doPng(req, res);
	}
	
}