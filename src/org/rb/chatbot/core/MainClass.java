package org.rb.chatbot.core;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import org.rb.chatbot.preprocessing.StoryTree;
import org.rb.gamebot.datastructures.StoryNode;


/**
 * This is the glue that sticks the webhandler functions together.
 * 
 * @author RB
 * 
 */
public class MainClass {

	/**
	 * A starting point for the code. Nothing much in here. Move along
	 * 
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		Boolean isOwnerPresent = true;
		ArrayList<String> topics = new ArrayList<String>(Arrays.asList("game","games", "fun", "help", "laugh", "sad","video games"));
		GameBot.startJokeBotChat(isOwnerPresent, topics);
	}
	
	public static void textVersion(){
		Scanner userInput = new Scanner(System.in);
		StoryNode storyNode = null;
		StoryTree storyTree = new StoryTree();
		int answer = 0;
		String input = "";
		storyTree.startStory();
		while (true) {
			storyNode = storyTree.getCurrentStoryNode();
			System.out.println(storyNode.getContent());
			if (storyNode.getNodeType() != 1) {
				break;
			}
			int cnt = 1;
			for (String option : storyNode.getOptions()) {
				System.out.println(cnt + ". " + option);
				cnt++;
			}
			while (true) {
				System.out.print("\nYour choice :");
				input = userInput.next();
				input = input.replaceAll("[^0-9]", "").trim();
				if (input.equals("")) {
					System.out.println("Invalid option. Enter the number of the option you wish to choose.");
					continue;
				}
				answer = Integer.parseInt(input);
				if (answer > storyNode.getNumberOfOptions()) {
					System.out
							.println("Invalid input. Enter a valid option number.");
					continue;
				}
				break;
			}
			storyTree.advanceStory(answer - 1);
		}
		if (storyNode.getNodeType() == 2) {
			System.out.println("Happy Ending !");
		} else {
			System.out.println("Bad Ending !");
		}
		userInput.close();
	}

}
