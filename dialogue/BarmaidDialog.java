package dialogue;

import game.Game;

public class BarmaidDialog {

    static boolean thrownOut = false;

    public static boolean getThrownOut() {
        return thrownOut;
    }

    public static void start(String name, boolean firstDialogue) {

        String npcString;
        Dialogue dialogue;
        int choice;

        if (firstDialogue) {
            dialogue = new Dialogue("*The barmaid raises her head as you approach*.\n" +
                                                "'Ah! A traveler, I presume? You must be thirsty.'");
            dialogue.add("'As a matter of fact, I AM a traveler. How did you know?'", 1);
            dialogue.add("'I'll just have a beer.'", 2);
            dialogue.add("'Actually, I uhh... have to go.'", 7);
        } else {
            dialogue = new Dialogue("'Hi, there! What can I do for you?'");
            dialogue.add("'I'll just have a beer.'", 2);
            dialogue.add("'Actually, I uhh... have to go.'", 7);
        }

        while (true) {
            switch (dialogue.printDialogueReturnNext(name)) {
                case 1 -> {
                    dialogue = new Dialogue("*The barmaid eyes you up and down whith a serious frown.*\n" +
                                                        "'Well, you are quite filthy.'");
                    dialogue.add("'I most certainly am not! " +
                                           "How dare you make such a preposterous claim?'", 3);
                    dialogue.add("*You look down at your mud caked clothes.*\n" +
                                           "'Yes, I have been riding for several days, and my attire " +
                                           "has become somewhat... unkempt.\n" +
                                           "Is there any place I could wash up?'", 4);
                    dialogue.add("'Just give me a beer.'", 2);
                }
                case 2 -> {
                    dialogue = new Dialogue("'Yes, ofcourse.'\n" +
                            "*The barmaid reaches for a glass and fills it with the foamy goodness.*\n" +
                            "'That'll be eight coppers.'");
                    dialogue.add("'That's pretty expensive. I think I'll pass.'", 6);
                    dialogue.add("'That's pretty expensive. Here you go.'\n*You give her 8 coppers.*", 8);
                    dialogue.add("'That's fine. Here you go.'\n*you give her 8 coppers.*", 8);
                }
                case 3 -> {
                    dialogue = new Dialogue("'I'm sorry. I'didn't mean to offend you. Here, have a beer on the house.'");
                    dialogue.add("'Don't mind if I do.'", 6);
                }
                case 4 -> {
                    dialogue = new Dialogue("'You could go to the bathhouse.'");
                    dialogue.add("'Where is that?'", 5);
                    dialogue.add("'Nah, that sounds expensive.'", 6);
                }
                case 5 -> {
                    dialogue = new Dialogue("'It's all the way to the east. Over by the stables.'");
                    dialogue.add("'Aight, thanks!'", 6);
                }
                case 6 -> {
                    dialogue = new Dialogue("'So, what else can I do for you?'");
                    dialogue.add("'Not much. Bye.'", 7);
                }
                case 7 -> {
                    dialogue = new Dialogue("'That's too bad.'");
                    dialogue.add("*Leave conversation.*", 0);
                }
                case 8 -> {
                    if (Game.player.getCoppers() >= 8) {
                        dialogue = new Dialogue("*The barmaid reaches over the bar and hands you the beer.*");
                        dialogue.add("'Thanks.'", 6);
                        Game.player.setCoppers(-8);
                    } else {
                        dialogue = new Dialogue("*The barmaid gives a sympathetic shrug as you pull out " +
                                "a whole lotta nothing out of your pockets.*");
                        dialogue.add("'Damn!", 6);
                        dialogue.add("'Crap!", 6);
                        dialogue.add("'Is there anyway I can pay you in... you know, other means?'", 9);
                    }
                }
                case 9 -> {
                    dialogue = new Dialogue("'Like what?'");
                    dialogue.add("'I don't know. Like, do you need anything uh... taken care of?'", 10);
                    dialogue.add("'Never mind.'", 6);
                }
                case 10 -> {
                    dialogue = new Dialogue("'Do I need anything taken care of? Like what? My needs?\n" +
                            "Look, I don't know what you're getting at here, but if it is what I think it is-'");
                    dialogue.add("'Oh, god no! Nothing like that. I was just thinking maybe you have some\n" +
                                           "kind of job for me. Maybe you've got some rats that need some whacking?\n" +
                                           "You know, In your basement?'", 11);
                    dialogue.add("'You know damn well what I'm getting at here, lady,\n" +
                                           "and if I were you I'd think twice about denying me it.'", 15);
                }
                case 11 -> {
                    dialogue = new Dialogue("'In my basement?'");
                    dialogue.add("'Yeah, sure. Or attic, or whatever.'", 12);
                }
                case 12 -> {
                    dialogue = new Dialogue("'Hmmm. Well, I do have a basement. I don't know if there " +
                            "are any rats there, but it needs some cleaning, that's for sure.\n" +
                            "Tell you what, you clean my basement, and I'll give you that beer for free.'");
                    dialogue.add("'Uhh... that's not the kind of job I had in mind, but sure, I'll clean it.'", 13);
                    dialogue.add("'You kow what, keep the beer.'", 6);
                }
                case 13 -> {
                    dialogue = new Dialogue("'That's great! There's really not much of value in there. " +
                            "Whatever you find, you can keep.\n" +
                            "You can throw the rest of it out on the lawn.'");
                    dialogue.add("'On the lawn? That's kinda crazy, but you've got yourself a deal.'", 14);
                    dialogue.add("'On second thougths, I don't like cleaning. Keep the beer.'", 6);
                }
                case 14 -> {
                    dialogue = new Dialogue("'Okay then. My house is up north, on the other side of the river.\n" +
                            "The cellar door is open. Don't tell anyone. Make sure you throw everything out on the lawn, okay?'");
                    dialogue.add("'Sure thing.'", 6);
                }
                case 15 -> {
                    dialogue = new Dialogue("*The barmaid pulls a threatening scowl and leans over the bar.*\n" +
                            "'What the fuck do you think you're doing? One more nasty word from you and you're out of here.\n" +
                            "For good!'");
                    dialogue.add("'Yikes! Relax, I was just kidding.'", 16);
                    dialogue.add("'What's the matter? Did you wake up with a bad case of... ugly face?\n" +
                                           "Because that's what you have. An ugly face.'", 17);
                    dialogue.add("'You know what, fuck you!'", 17);
                }
                case 16 -> {
                    dialogue = new Dialogue("'Don't you ever do that again!'");
                    dialogue.add("'I won't.'", 6);
                }
                case 17 -> {
                    dialogue = new Dialogue("'That's it!'\n" +
                            "*The barmaid grabs a bottle, smashes it and starts climbing over the counter.\n" +
                            "Everyone in the establishment gets on their feet and starts forcing you out the door.*");
                    dialogue.add("'Damn!'", 0);
                    dialogue.add("'Crap!'", 0);
                    thrownOut = true;
                }
                case 0 -> {
                    return;
                }
            }
        }
    }
}
