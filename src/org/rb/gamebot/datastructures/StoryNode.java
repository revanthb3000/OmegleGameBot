package org.rb.gamebot.datastructures;

import java.util.ArrayList;

public class StoryNode {
	
	private String content;
	
	private String question;
	
	private ArrayList<String> options;
	
	private ArrayList<StoryNode> childrenNodes;
	
	/**
	 * 1 - normal node
	 * 2 - happy ending
	 * 3 - bad ending
	 */
	private int nodeType;
	
	/**
	 * 1 - normal, multiple choice
	 * 2 - user input based
	 */
	private int optionAnswerType;
	
	public StoryNode(String matter, int type, int answerType){
		content = matter;
		nodeType = type;
		optionAnswerType = answerType;
		childrenNodes = new ArrayList<StoryNode>();
		options = new ArrayList<String>();
	}
	
	public void addChild(StoryNode node, String option){
		options.add(option);
		childrenNodes.add(node);
	}

	public String getContent() {
		return content;
	}

	public ArrayList<StoryNode> getChildren() {
		return childrenNodes;
	}
	
	public StoryNode getParticularChild(int index){
		if(index>=childrenNodes.size()){
			return null;
		}
		else{
			return childrenNodes.get(index);
		}
	}
	
	public ArrayList<String> getOptions() {
		return options;
	}
	
	public int getNumberOfOptions(){
		return options.size();
	}
	
	public String getParticularOption(int index){
		if(index>=options.size()){
			return null;
		}
		else{
			return options.get(index);
		}
	}

	public String getQuestion() {
		return question;
	}

	public int getNodeType() {
		return nodeType;
	}

	public int getOptionAnswerType() {
		return optionAnswerType;
	}

}
