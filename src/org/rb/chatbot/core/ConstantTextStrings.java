package org.rb.chatbot.core;

/**
 * This class basically holds constant strings that we'll use.
 * @author RB
 *
 */
public class ConstantTextStrings {
	
	/**
	 * The Stranger is typing message !
	 */
	public static final String STRANGER_TYPING = "Stranger is typing...";
	
	/**
	 * The Say Hi ! Message
	 */
	public static final String INTRO_MESSAGE = "You're now chatting with a random stranger";

	/**
	 * The URL
	 */
	public static final String WEBSITE_URL = "http://www.omegle.com/";
		
	/**
	 * The first thing the bot says once the chat starts.
	 */
	public static final String BOT_WELCOME_MESSAGE = "Hi ! I'm a bot, not a spam bot but a game bot. You can use me now to play an interactive text game. Instructions are simple. I will ask a question after each scenario and you provide a response which will cause further progress through the story. Reply to this and we'll start.";
	
	/**
	 * The message the bot hits when the human doesn't reply for a long time.
	 */
	public static final String BOT_WAITED_TOO_LONG = "I'm leaving. Bye !";

	/**
	 * The goodbye when I'm not around.
	 */
	public static final String BOT_GOODBYE = "Thanks for sticking around ! Hope you had fun ! Do you have feedback ? ";
	
	/**
	 * My twitter plug in.
	 */
	public static final String BOT_PUBLICITY = "You can also follow my owner(cheap publicity if you ask me) on twitter - @revanthb3000 Contact me if you know where to find an actually good story/can work on one.";
	
	/**
	 * Technical Info about the bot !
	 */
	public static final String BOT_TECH_STUFF = "(Technical Info: The bot was written in Java and Selenium was used to control the web browser. Source code's on GitHub)";
	
	/**
	 * Tells the user how to restart the bot.
	 */
	public static final String BOT_RESTART_INSTRUCTIONS = "If you want to restart this bot, just hit 'Restart'.";
	
	/**
	 * Just a reminder to tell the user that he can stop the bot.
	 */
	public static final String BOT_STOP_REMINDER = "(Just hit 'stop' to get me to stop talking.)";
	
	/**
	 * The rare case. All jokes have been exhausted.
	 */
	public static final String BOT_JOKES_EXHAUSTED = "All jokes exhausted ! Well done, human !! Hit \"stop\" to get me to stop.";
}
