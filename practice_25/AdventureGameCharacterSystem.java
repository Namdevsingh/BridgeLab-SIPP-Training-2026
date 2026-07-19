public class AdventureGameCharacterSystem {

    static class GameCharacter {
        String characterName;

        GameCharacter(String characterName) {
            this.characterName = characterName;
        }

        void performAttack() {
            System.out.print(characterName + " attacks");
        }

        String getType() {
            return "Unknown";
        }
    }

    static class Warrior extends GameCharacter {
        Warrior(String characterName) {
            super(characterName);
        }

        void performAttack() {
            System.out.print(characterName + " swings sword!\n");
        }

        String getType() {
            return "Warrior";
        }
    }

    static class Mage extends GameCharacter {
        Mage(String characterName) {
            super(characterName);
        }

        void performAttack() {
            System.out.print(characterName + " casts spell!\n");
        }

        String getType() {
            return "Mage";
        }
    }

    static class Archer extends GameCharacter {
        Archer(String characterName) {
            super(characterName);
        }

        void performAttack() {
            System.out.print(characterName + " shoots arrow!\n");
        }

        String getType() {
            return "Archer";
        }
    }

    static void startBattle(GameCharacter[] characters) {
        int warriors = 0;
        int mages = 0;
        int archers = 0;

        for (GameCharacter c : characters) {
            c.performAttack();
            String t = c.getType();
            if (t.equals("Warrior")) warriors++;
            else if (t.equals("Mage")) mages++;
            else if (t.equals("Archer")) archers++;
        }

        System.out.print("Warriors: " + warriors + "\nMages: " + mages + "\nArchers: " + archers);
    }

    public static void main(String[] args) {
        GameCharacter[] characters = new GameCharacter[6];
        characters[0] = new Warrior("W1");
        characters[1] = new Mage("M1");
        characters[2] = new Archer("A1");
        characters[3] = new Warrior("W2");
        characters[4] = new Mage("M2");
        characters[5] = new Archer("A2");

        startBattle(characters);
    }
}

