package org.rb.chatbot.preprocessing;

import java.util.ArrayList;

import org.rb.gamebot.datastructures.StoryNode;

public class StoryTree {
	
	private ArrayList<StoryNode> storyNodes;
	
	private StoryNode currentStoryNode;
	
	public StoryTree(){
		storyNodes = new ArrayList<StoryNode>();
		constructStoryTree();
	}
	
	public void startStory(){
		currentStoryNode = storyNodes.get(0);
	}
	
	public StoryNode getCurrentStoryNode() {
		return currentStoryNode;
	}
	
	public void constructStoryTree(){
		StoryNode node = null;
		
		node = new StoryNode("You just wake up and feel hazy. It's completely dark and you can barely see anything except a door in front of you (with the handle placed to the right). "
							+ "There's also a small window that seems to be connected to the other room from which you hear voices. They're probably the kidnappers. "
							+ "You can't move your feet. They seem to be tied up. Your hands are bound too but the rope doesn't seem to be that strong. What do you do ?	",1,1);
		storyNodes.add(node);
		
		node = new StoryNode("You use a bit of force and shake off the knot tying your hands down. Getting rid of the knot tying your legs to the chair is now straightforward. "
							+ "You do so and stand up. You move toward the door and try to open it. As expected, its locked. You observe what's in the room. "
							+ "On the right you see a switchboard with a single switch that probably controls the big lamp in the center of the room. "
							+ "On the left you see a briefcase. Which way will you go ?",1,1);
		storyNodes.add(node);

		node = new StoryNode("You move towards the switchboard and flip the switch. The lamp turns on. It dazzles you for a minute. It is brighter than you expected. "
							+ "You hear the kidnappers shout. They've noticed the light. You hear footsteps. They're coming !! What do you do ?",1,1);
		storyNodes.add(node);

		node = new StoryNode("You immediately switch off the light but by the time you get the chance to hide, they barge in and shoot. You get shot in the stomach and go down. "
							+ "The kidnappers argue for a while on what to do with you. They decide to lock the door and let you rot inside. You eventually die of blood loss.",3,1);
		storyNodes.add(node);
		
		node = new StoryNode("You go towards the briefcase in the corner. It appears familiar and seems to be something that belongs to you. You have to enter a three digit code to unlock it. "
							+ "You're woozy and can't remember exactly what the lock-code was. It's either 212 or 121. Your mind has thoughts - 'first..3 digits....drome'?! What do you enter ? ",1,1);
		storyNodes.add(node);

		node = new StoryNode("Excellent ! The code is correct and you are able to unlock the briefcase. To your horror, you find a revolver in it and nothing else.  "
							+ "This startles you causing you to drop the briefcase. The kidnappers hear it and are running towards the room. What do you do ?",1,1);
		storyNodes.add(node);
		
		node = new StoryNode("You enter the wrong code and the lock-systems makes a beep sound that startles you and causes you to drop the briefcase. "
							+ "The kidnappers hear it and are running towards the room. What do you do ?",1,1);
		storyNodes.add(node);
		
		node = new StoryNode("You stand your ground and wait for the kidnappers to come in. They open the door and you pull the trigger. Sadly, you forgot to reload and no bullet is fired. "
							+ "One of the kidnappers shoots you in the arm. You drop the revolver and clutch your arm. They approach you. One of the kidnappers kicks the revolver away. "
							+ "The other holds his pistol to your head. BOOM ! In one moment, you've lost your life. You are dead.",3,1);
		storyNodes.add(node);
		
		node = new StoryNode("You decide to hide near the door. Which side ?",1,1);
		storyNodes.add(node);
		
		node = new StoryNode("You go hide to the left of the door. The kidnappers push open the door and the toruque effect causes you to get hit by the door. "
							+ "You fall to the ground and almost lose consciousness. By the time you get up, the kidnappers have spotted you. "
							+ "One of the kidnappers smacks you with the butt of his pistol. You become woozy and fall down. Blood drips from your forehead. "
							+ "The kidnappers continue to assault you till you pass out and die due to blood loss. You are dead.",3,1);
		storyNodes.add(node);
		
		node = new StoryNode("You go to the right of the door. The kidnappers open the door and head towards the center of the room. "
							+ "They don't notice you. Now's your chance ! What do you do ?",1,1);
		storyNodes.add(node);
		
		node = new StoryNode("You try to jump on one of the kidnappers. You both fall to the ground and struggle. Sadly, the other kidnapper joins in and overpowers you, throwing you away. "
							+ "While you struggle to get up, he grabs his pistol and lands a headshot. You are dead.",3,1);
		storyNodes.add(node);

		node = new StoryNode("You manage to leave the room and lock the door. The kidnappers are trapped. They keep shouting and threaten you but its immaterial. They're the ones that are trapped now !",2,1);
		storyNodes.add(node);
		
		storyNodes.get(0).addChild(storyNodes.get(1), "Use a bit of force and try to untie your hands.");
		
		storyNodes.get(1).addChild(storyNodes.get(2), "Go to the switchboard.");
		storyNodes.get(1).addChild(storyNodes.get(4), "Go to the briefcase.");
		
		storyNodes.get(2).addChild(storyNodes.get(3), "Switch off the light and try to hide.");
		storyNodes.get(2).addChild(storyNodes.get(11), "Attack the kidnappers head on !");

		storyNodes.get(4).addChild(storyNodes.get(6), "212");
		storyNodes.get(4).addChild(storyNodes.get(5), "121");
		
		storyNodes.get(5).addChild(storyNodes.get(7), "Attack the kidnappers head on ! You have a gun !");
		storyNodes.get(5).addChild(storyNodes.get(8), "Hide near the door.");

		storyNodes.get(6).addChild(storyNodes.get(8), "Hide near the door.");
		storyNodes.get(6).addChild(storyNodes.get(11), "Attack the kidnappers head on !");
		
		storyNodes.get(8).addChild(storyNodes.get(9), "Left");
		storyNodes.get(8).addChild(storyNodes.get(10), "Right");
		
		storyNodes.get(10).addChild(storyNodes.get(11), "Jump on the kidnappers. They have their backs turned against you.");
		storyNodes.get(10).addChild(storyNodes.get(12), "Leave the room and try to lock the door.");
		
	}

	public void advanceStory(int answer){
		currentStoryNode = currentStoryNode.getParticularChild(answer);
	}
	
}
