package dialogue;

public class DialogueMenu {

    String menuString;
    int nextDialogue = 0;

    public DialogueMenu(String menuString, int nextDialogue) {
        this.menuString = menuString;
        this.nextDialogue = nextDialogue;
    }

    public String getMenuString() {
        return menuString;
    }

    public void setMenuString(String menuString) {
        this.menuString = menuString;
    }

    public int getNextDialogue() {
        return nextDialogue;
    }

    public void setNextDialogue(int nextDialogue) {
        this.nextDialogue = nextDialogue;
    }
}