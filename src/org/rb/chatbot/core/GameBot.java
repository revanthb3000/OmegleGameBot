package org.rb.chatbot.core;

import java.util.ArrayList;

import org.rb.chatbot.preprocessing.StoryTree;
import org.rb.gamebot.datastructures.StoryNode;

public class GameBot {

	/**
	 * This is the core function of the project. Starts firefox webdriver, goes
	 * to the website and initiates a chat. Runs in an infinite loop.
	 * 
	 * @param isOwnerPresent
	 * @throws Exception
	 */
	public static void startJokeBotChat(Boolean isOwnerPresent,
			ArrayList<String> topics) throws Exception {
		WebHandler webHandler = new WebHandler(ConstantTextStrings.WEBSITE_URL);
		webHandler.startBrowser();
		while (true) {
			String fileName = "convs/" + UtilityFunctions.getCurrentTimeStamp() + ".txt";
			String newMessage = "";

			webHandler.startNewChat(topics);
			webHandler.waitForChatStart();

			try {
				webHandler.sendMessage(ConstantTextStrings.BOT_WELCOME_MESSAGE);
				
				webHandler.waitForNewMessage();
				newMessage = webHandler.getNewMessage();
				webHandler.sendMessage("Good. Let's get started. The first choice is direct.");

				StoryNode storyNode = null;
				StoryTree storyTree = new StoryTree();
				int answer = 0;
				storyTree.startStory();
				
				//This loop is the course of the whole chat.
				while (true) {

					storyNode = storyTree.getCurrentStoryNode();
					webHandler.sendMessage(storyNode.getContent());

					if (storyNode.getNodeType() != 1) {
						Boolean shouldRestart = false;
						if (storyNode.getNodeType() == 2) {
							webHandler.sendMessage("Happy Ending ! Well done :)");
						} else {
							webHandler.sendMessage("Bad Ending ! Hard luck :/");
						}
						shouldRestart = stopGameBot(webHandler);
						if (shouldRestart) {
							storyTree.startStory();
							continue;
						}
						break;
					}
					
					int cnt = 1;
					for (String option : storyNode.getOptions()) {
						webHandler.sendMessage(cnt + ". " + option);
						cnt++;
					}
					
					while (true) {
						webHandler.sendMessage("Which option do you choose ?");
						webHandler.waitForNewMessage();
						newMessage = webHandler.getNewMessage();
						newMessage = newMessage.replaceAll("[^0-9]", "").trim();
						if (newMessage.equals("")) {
							webHandler.sendMessage("Invalid option. Enter the number of the option you wish to choose.");
							continue;
						}
						answer = Integer.parseInt(newMessage);
						if (answer > storyNode.getNumberOfOptions()) {
							webHandler.sendMessage("Invalid input. Enter a valid option number.");
							continue;
						}
						break;
					}
					storyTree.advanceStory(answer - 1);
				}

				if (!webHandler.hasDisconnected())
					webHandler.disconnect();

			} catch (Exception e) {
				System.out.println(e);
			}

			UtilityFunctions.writeToFile(webHandler.getTranscript(),fileName);
		}
	}

	/**
	 * This basically handles the situation when the user tells the bot to stop.
	 * 
	 * @param webHandler
	 * @param isOwnerPresent
	 * @return
	 * @throws InterruptedException
	 */
	public static Boolean stopGameBot(WebHandler webHandler) throws InterruptedException {
		Boolean shouldRestart = false;
		String chatTranscript = "";
		webHandler.sendMessage(ConstantTextStrings.BOT_GOODBYE);
		webHandler.sendMessage(ConstantTextStrings.BOT_PUBLICITY);
		webHandler.sendMessage(ConstantTextStrings.BOT_OTHER_SOCIAL_MEDIA);
		webHandler.sendMessage(ConstantTextStrings.BOT_RESTART_INSTRUCTIONS);
		chatTranscript = webHandler.getTranscript();
		int cnt = 0;
		while (true) {
			String newMessages = webHandler.getTranscript().replace(chatTranscript, "").trim();
			if (newMessages.toLowerCase().contains("restart")) {
				shouldRestart = true;
				break;
			}
			cnt += 5000;
			Thread.sleep(5000);
			if ((cnt >= 240000) || (webHandler.hasDisconnected())) {
				shouldRestart = false;
				break;
			}
		}
		return shouldRestart;
	}

}
