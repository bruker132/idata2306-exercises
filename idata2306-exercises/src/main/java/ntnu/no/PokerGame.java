package ntnu.no;

import java.util.*;

class Card {
    String suit;
    String rank;
    int order;

    public Card(String suit, String rank, int order) {
        this.suit = suit;
        this.rank = rank;
        this.order = order;
    }

    @Override
    public String toString() {
        return suit + rank;
    }
}

public class PokerGame {
    public static void main(String[] args) {
        // Step 1: Generate 54 cards
        List<Card> deck = new ArrayList<>();
        String[] suits = {"♦", "♣", "♥", "♠"};
        String[] ranks = {"3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A", "2"};
        int order = 0;

        for (String suit : suits) {
            for (String rank : ranks) {
                deck.add(new Card(suit, rank, order++));
            }
        }

        // Add jokers
        deck.add(new Card("", "black joker", order++));
        deck.add(new Card("", "red joker", order++));

        // Print all cards
        System.out.println("Generated Cards:");
        for (Card card : deck) {
            System.out.print(card + " ");
        }
        System.out.println("\n");

        // Step 2: Shuffle the cards
        Collections.shuffle(deck);
        System.out.println("Shuffled Cards:");
        for (Card card : deck) {
            System.out.print(card + " ");
        }
        System.out.println("\n");

        // Step 3: Distribute the cards
        List<Card> playerA = new ArrayList<>();
        List<Card> playerB = new ArrayList<>();
        List<Card> playerC = new ArrayList<>();
        List<Card> leftover = new ArrayList<>();

        for (int i = 0; i < 51; i++) {
            if (i % 3 == 0) {
                playerA.add(deck.get(i));
            } else if (i % 3 == 1) {
                playerB.add(deck.get(i));
            } else {
                playerC.add(deck.get(i));
            }
        }

        // Add leftover cards
        leftover.add(deck.get(51));
        leftover.add(deck.get(52));
        leftover.add(deck.get(53));

        // Print each player's cards
        System.out.println("Player A's Cards:");
        for (Card card : playerA) {
            System.out.print(card + " ");
        }
        System.out.println("\n");

        System.out.println("Player B's Cards:");
        for (Card card : playerB) {
            System.out.print(card + " ");
        }
        System.out.println("\n");

        System.out.println("Player C's Cards:");
        for (Card card : playerC) {
            System.out.print(card + " ");
        }
        System.out.println("\n");

        System.out.println("Leftover Cards:");
        for (Card card : leftover) {
            System.out.print(card + " ");
        }
        System.out.println("\n");

        // Step 4: Sort and display the cards
        playerA.sort(Comparator.comparingInt(c -> c.order));
        playerB.sort(Comparator.comparingInt(c -> c.order));
        playerC.sort(Comparator.comparingInt(c -> c.order));
        leftover.sort(Comparator.comparingInt(c -> c.order));

        System.out.println("Sorted Player A's Cards:");
        for (Card card : playerA) {
            System.out.print(card + " ");
        }
        System.out.println("\n");

        System.out.println("Sorted Player B's Cards:");
        for (Card card : playerB) {
            System.out.print(card + " ");
        }
        System.out.println("\n");

        System.out.println("Sorted Player C's Cards:");
        for (Card card : playerC) {
            System.out.print(card + " ");
        }
        System.out.println("\n");

        System.out.println("Sorted Leftover Cards:");
        for (Card card : leftover) {
            System.out.print(card + " ");
        }
        System.out.println("\n");
    }
}