import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class Zork {
    public static void main(String[] args) {

        int counter = 0;
        int roomNumber = 1;
        int ghost = 1;
        boolean rich = false;
        String direction = "yes";
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        int rand = 1 + random.nextInt(4);
        int[] gold = new int[8];
        String[] items = new String[8];


        for (int i = 0; i < gold.length; i++) {
            gold[i] = random.nextInt(1001);
        }

        int userGold = 0;
        int randomGold = random.nextInt(8);
        gold[randomGold] = 0;
        String goldAmount = "There are %d coins in this room! Do you want to take it? (y/n) ";

        while (!direction.equalsIgnoreCase("q")) {
            if (roomNumber == randomGold) {
                System.out.println("Oh no! You stumble across the path of the giant troll that lives in the mountain. He takes all your money and runs away laughing at you. Now you don't have any gold.");
                userGold = 0;
            }
            System.out.printf("You have %d gold! \n", userGold);

            switch (roomNumber) {
                case 1:
                    System.out.println(foyer());
                    if (gold[0] > 0) {
                        System.out.printf(goldAmount, gold[0]);
                        if (sc.nextLine().charAt(0) == 'y') {
                            userGold += gold[0];
                            gold[0] = 0;
                        }
                    }
                    items[0] = "Dead scorpion";
                    System.out.println("Exit north to the front room. \n Exit the Game Q.");

                    direction = sc.nextLine().toLowerCase();
                    if (direction.equals("north") || direction.equals("front room")) {
                        roomNumber = 2;
                    } else if (direction.equals("q")) {
                        System.out.println(quit());
                        return;
                    }
                    break;

                case 2:
                    System.out.println(frontRoom());
                    if (gold[1] > 0) {
                        System.out.printf(goldAmount, gold[1]);
                        if (sc.nextLine().charAt(0) == 'y') {
                            userGold += gold[1];
                            gold[1] = 0;
                        }
                    }
                    items[1] = "Piano";
                    System.out.println("Exit west to the library. \n Exit east to the kitchen. \nExit south to the foyer. \nExit the game Q");
                    direction = sc.nextLine().toLowerCase();
                    if (direction.equals("west") || direction.equals("library")) {
                        roomNumber = 3;
                    } else if (direction.equals("east") || direction.equals("kitchen")) {
                        roomNumber = 4;
                    } else if (direction.equals("south") || direction.equals("foyer")) {
                        roomNumber = 1;
                    } else if (direction.equals("q")) {
                        System.out.println(quit());
                        return;
                    }
                    break;
                case 3:
                    System.out.println(library());
                    if (gold[2] > 0) {
                        System.out.printf(goldAmount, gold[2]);
                        if (sc.nextLine().charAt(0) == 'y') {
                            userGold += gold[2];
                            gold[2] = 0;
                        }
                    }
                    items[2] = "Crawling spiders";
                    System.out.println("Exit east to the from room. \nExit north to the dining room. \nExit the Game Q");
                    direction = sc.nextLine().toLowerCase();

                    if (direction.equals("east") || direction.equals("front door")) {
                        roomNumber = 2;
                    } else if (!direction.equals("east") || direction.equals("dining room")) {
                        roomNumber = 5;
                    } else if (direction.equals("q")) {
                        System.out.println(quit());
                        return;
                    }
                    break;
                case 4:
                    System.out.println(kitchen());
                    if (gold[3] > 0) {
                        System.out.printf(goldAmount, gold[3]);
                        if (sc.nextLine().charAt(0) == 'y') {
                            userGold += gold[3];
                            gold[3] = 0;
                        }
                    }
                    items[3] = "Bats";
                    System.out.println("Exit west to the front room. \nExit north to the parlor \nExit the game Q");
                    direction = sc.nextLine().toLowerCase();

                    if (direction.equals("west") || direction.equals("front door")) {
                        roomNumber = 2;
                    } else if (direction.equals("north") || direction.equals("parlor")) {
                        roomNumber = 7;
                    } else if (direction.equals("q")) {
                        System.out.println(quit());
                        return;
                    }
                    break;
                case 5:
                    System.out.println(diningRoom());
                    if (gold[4] > 0) {
                        System.out.printf(goldAmount, gold[4]);
                        if (sc.nextLine().charAt(0) == 'y') {
                            userGold += gold[4];
                            gold[4] = 0;
                        }
                    }
                    items[4] = "Dust and an empty box";
                    System.out.println("Exit south to the library. \nExit the Game Q.");
                    direction = sc.nextLine().toLowerCase();
                    if (direction.equals("south") || direction.equals("library")) {
                        roomNumber = 3;
                    } else if (direction.equals("q")) {
                        System.out.println(quit());
                        return;
                    }
                    break;
                case 6:
                    System.out.println(vault());
                    if (gold[5] > 0) {
                        System.out.printf(goldAmount, gold[5]);
                        if (sc.nextLine().charAt(0) == 'y') {
                            userGold += gold[5];
                            gold[5] = 0;
                        }
                    }
                    items[5] = "3 skeletons";
                    if (rich) {
                        System.out.println("Exit east to the parlor. \n Exit east to the secret room. \nExit the Gage Q");
                    } else {
                        System.out.println("Exit east to the parlor. \n Exit the Game Q");
                    }
                    direction = sc.nextLine().toLowerCase();

                    if ((direction.equals("east") || direction.equals("parlor")) && !rich) {
                        if (rand == 2) {
                            roomNumber = 8;
                            rich = true;
                        } else {
                            rand = 1 + random.nextInt(4);
                            roomNumber = 7;
                        }
                    } else if (direction.equals("parlor")) {
                        roomNumber = 7;
                    } else if (direction.equals("secret room")) {
                        roomNumber = 8;
                    } else if (direction.equals("q")) {
                        System.out.println(quit());
                        return;
                    }
                    break;

                case 7:
                    System.out.println(parlor());
                    if (gold[6] > 0) {
                        System.out.printf(goldAmount, gold[6]);
                        if (sc.nextLine().charAt(0) == 'y') {
                            userGold += gold[6];
                            gold[6] = 0;
                        }
                    }
                    items[6] = "Treasure chest";
                    System.out.println("Exit west to the vault. \nExit south to the kitchen. \nExit the game Q.");

                    direction = sc.nextLine().toLowerCase();

                    if (direction.equals("south") || direction.equals("kitchen")) {
                        roomNumber = 4;
                    } else if (direction.equals("west") || direction.equals("vault")) {
                        roomNumber = 6;
                    } else if (direction.equals("q")) {
                        System.out.println(quit());
                        return;
                    }
                    break;

                case 8:
                    System.out.println(secretRoom());
                    if (gold[7] > 0) {
                        System.out.printf(goldAmount, gold[7]);
                        if (sc.nextLine().charAt(0) == 'y') {
                            userGold += gold[7];
                            gold[7] = 0;
                        }
                    }

                    items[7] = "Piles of gold";
                    System.out.println("Exit west to the vault. \nExit the Game Q");
                    direction = sc.nextLine().toLowerCase();

                    if (direction.equals("west") || direction.equals("vault")) {
                        roomNumber = 6;
                        System.out.println("Why would anyone leave this amazing room?");
                    } else if (direction.equals("q")) {
                        System.out.println(quit());
                        return;
                    }
                    break;
            }
            counter++;
        }

        ghost = 1 + random.nextInt(4);
        if (ghost == 3) {
            System.out.println("There is a ghost that follows you out the door of the house");
        }

        System.out.println("Today you visited " + counter + "room(s). We are going to be waiting for you. Please come again soon!");
        System.out.println("You found the following items ");
        for (int i = 0; i < items.length; i++) {
            if (items[i] != null) {
                System.out.println(items[i]);
            }
        }
        System.out.printf("You left with %d coins. Congratulations!!", userGold);
    }


    public static String foyer(){
         return "You are standing in foyer.\n There is a dead scorpion in here";
    }
    public static String frontRoom(){
        return "You are standing in the front room.\n There is a piano in here";
    }
    public static String library(){
        return "You are standing in the library.\n There are spiders crawling on the bookshelves.";
    }
    public static String kitchen(){
        return "You are now in the kitchen. \n You found a hidden colony of bats";
    }
    public static String diningRoom(){
        return  "You just enter the dining room. \n You can see a small box resting on the table and that the walls are made of dust";
    }
    public static String vault(){
   return "No you are standing inside a vault. \nThere are 3 scary walking skeletons";
    }
    public static String parlor(){
      return "You are now entering the old parlor. \nThere is a treasure chest in this room. \nDo you have the key";
    }
    public static String secretRoom(){
      return "Congratulations! You found the secret room! \nPiles of gold awaits for you!";
    }
    public static String quit(){
        return "Oh no! You were about to get into piles of gold. Now you are dead and without money.Best luck next time.";
    }

}


















