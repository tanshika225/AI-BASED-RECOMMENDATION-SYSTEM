package com.codtech.AIRecommendationSystem;


import java.util.Scanner;

public class App{

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("================================");
        System.out.println(" AI PRODUCT RECOMMENDATION APP ");
        System.out.println("================================");

        System.out.print("\nEnter User ID: ");

        long userId = sc.nextLong();

        RecommendationEngine.recommendProducts(userId);

        sc.close();
    }
}
