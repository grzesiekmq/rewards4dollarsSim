package com.company;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    private static int balance = 0;

    static void addMoney(int amount) {
        balance += amount;
    }

    static void subtractMoney(int amount) {
        balance -= amount;
    }

    static void debugMultiplier(int headphones, int ssd, int laptop, int watchguard, int antminer) {
        System.out.println("1st multiplier: " + ssd / headphones + " times");
        System.out.println("2nd multiplier: " + laptop / ssd + " times");
        System.out.println("3rd multiplier: " + watchguard / laptop + " times");
        System.out.println("4th multiplier: " + antminer / watchguard + " times");
    }

    static void claimReward(boolean isDebug) {

        final int headphones = 25;
        final int ssd = 100;
        final int laptop = 500;
        final int watchguard = 2000;
        final int antminer = 10000;

        if (isDebug) {
            debugMultiplier(headphones, ssd, laptop, watchguard, antminer);
        }


        String product = switch (balance) {
            case headphones -> "headphones";
            case ssd -> "ssd";
            case laptop -> "laptop";
            case watchguard -> "watch guard";
            case antminer -> "ant miner";

            default -> "unknown product";

        };
        if (product.equals("unknown product")) {
            System.out.println(product);
        } else {
            System.out.println("Purchased: " + product);

        }

    }

    static void showBalance() {
        System.out.println("balance: $" + balance);
    }

    static void promptAmount() {
        System.out.print("Amount $ to send: ");
    }

    static void mainLogic(){
        while(true){

            try {
                Scanner input = new Scanner(System.in);
                promptAmount();
                int money = input.nextInt();
                addMoney(money);

                showBalance();
                claimReward(false);
                subtractMoney(money);
                showBalance();
                System.out.println("---------------------");
            }
            catch (InputMismatchException e){
                System.out.println("Invalid data try again: " + e);
            }
        }
    }

    public static void main(String[] args) {
       mainLogic();
    }
}
