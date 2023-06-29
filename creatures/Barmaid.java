package creatures;

import dialogue.BarmaidDialog;

public class Barmaid extends Actor implements INpc, java.io.Serializable {

    public Barmaid(String name, String description, String race) {
        super(name, description, race);
    }

    public void startDialogue() {
        BarmaidDialog.start(getName(), getFirstDialogue());
        this.setFirstDialogue(false);
    }
}
