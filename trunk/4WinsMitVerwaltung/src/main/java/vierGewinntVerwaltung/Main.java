package main.java.vierGewinntVerwaltung;

import static main.java.tictactoe.Game.*;
import static main.java.tictactoe.Field.*;

import java.util.Scanner;

import main.java.addressManagement.Address;
import main.java.addressManagement.Datenbank;
import main.java.addressManagement.Person;
import main.java.addressManagement.Verwaltung;
import main.java.tictactoe.Field;
import main.java.tictactoe.Game;
import main.java.tictactoe.Enum.ChipColor;

import static main.java.addressManagement.Person.*;
import static main.java.addressManagement.Address.*;
import static main.java.addressManagement.Datenbank.*;
import static main.java.addressManagement.Verwaltung.*; 

public class Main {
	
	public static void spielerVerwaltungStart(){
		Datenbank aktuelleDatenbank = new Datenbank(10, 10);		
		Verwaltung aktuelleVerwaltung = new Verwaltung(aktuelleDatenbank);
		
		Address dietersAddresse = new Address("Mannheim");
		Person dieter = new Person("dieter");
		dieter.setAdress(dietersAddresse);
		
		aktuelleVerwaltung.personAnlegen(dieter);
	}
	
	public static void fourWinsGame(){
		//4wins
				Game game = new Game();
				Field field = new Field();
				int x = 0;
				int y = 0;
				int p = 0;
				Scanner sc = new Scanner(System.in);
				
				System.out.println("wer startet ??? Player ( 1 (RED) || 2 (YELLOW) )");
				p = sc.nextInt();
				
				if(p == 1){
					System.out.println("Player RED");
				}else if(p == 2){
					System.out.println("Player YELLOW:");
				}else{
					System.out.println("bitte 1 oder 2 eingeben");
				}
				
				while(game.check(field) == ChipColor.NONE){
					
					System.out.println("X");
					x = sc.nextInt();
					System.out.println("Y");
					y = sc.nextInt();
					
					if(p == 1){
						field.addChip(x, y, ChipColor.RED);
						System.out.println("Player YELLOW: ");
						p=2;
					}else if(p == 2){
						field.addChip(x, y, ChipColor.YELLOW);
						System.out.println("Player RED: ");
						p=1;
					}
				}
				
				System.out.println("Player: "+game.check(field)+" hat gewonnen !!!");
				
	}


	public static void main(String[] args) {
		fourWinsGame();
		spielerVerwaltungStart();
	}	
}
