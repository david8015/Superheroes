package com.GA.Superheroes;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        files to be read from and written into
        String fileToRead = "/Users/david/IdeaProjects/foundational-java/java-basics/SuperHeroes/src/read.txt";
        String fileToWrite = "/Users/david/IdeaProjects/foundational-java/java-basics/SuperHeroes/src/write.txt";
        String score;

        List<Superhero> superheroes = null;
        try {
            superheroes = readFile(fileToRead);
        } catch (IOException e) {
            e.printStackTrace();
        }

       String [] gameInfo = startGame(superheroes);

        try {
            writeToFile(fileToWrite, gameInfo);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static String [] startGame(List<Superhero> superheroes){
        String [] playerAndScore = new String [2];
        int correctScore = 0;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your name: ");
        String name = scanner.nextLine();

        for (Superhero superhero: superheroes
             ) {
            System.out.println(name + ", In what city does " + superhero.getName() + " fight crime?");
            String answer = scanner.nextLine();
            if(answer.equalsIgnoreCase(superhero.getPatrolsCity())){
                System.out.println("You know your superhero!");
                correctScore++;
            }
            else{
                System.out.println("wrong. Need to do more research");
            }

            System.out.println(name + ", What is " + superhero.getName() + "'s real name?");
            String answer1 = scanner.nextLine();
            if(answer1.equalsIgnoreCase(superhero.getRealName())){
                System.out.println("You know your superhero!");
                correctScore++;
            }
            else{
                System.out.println("wrong. Need to do more research");
            }
            playerAndScore[0] = name;
            playerAndScore[1] = Integer.toString(correctScore);

        }

//        print out game results
        System.out.println(correctScore > 3? ("congratulations you did well!") : ("Do better next time!"));
        return playerAndScore;
    }



//    throws IO exception to be handled in main
    public static List<Superhero> readFile(String file) throws IOException {
        List<Superhero> superheroes = new ArrayList<>();

//        initialize a reader object
            BufferedReader reader = new BufferedReader(new FileReader(file));

//            read until end of file (current line does not equal null)
            String currentLine = null;
            while( (currentLine = reader.readLine()) != null) {
                String [] arr = currentLine.split(",");
                Superhero superhero = createSuperhero(arr);
                superheroes.add(superhero);
            }
            //        close the IO streams
            reader.close();
            return superheroes;
    }

//throws IO exception to be handled in main
    public static void writeToFile(String file, String [] gameInfo) throws IOException {
        String name = gameInfo[0];
        String score = gameInfo[1];

//      initialize a writer object
        BufferedWriter writer = new BufferedWriter(new FileWriter(file));

//        write to file
        writer.append(name + "," + score);

//        close the IO stream
        writer.close();

    }

//    template to create superheroes
    public static Superhero createSuperhero(String [] arr){
        Superhero superhero = new Superhero();
        superhero.setName(arr[0]);
        superhero.setPatrolsCity(arr[1]);
        superhero.setRealName(arr[2]);

        return superhero;
    }

}
