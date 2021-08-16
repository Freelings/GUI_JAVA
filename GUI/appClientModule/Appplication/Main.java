package Appplication;

import FileChooser.FileChooser;

public class Main {
	
	public static void main(String[] args) {
		FileChooser fileChosed = new FileChooser();
		System.out.println("*************************");
		System.out.println(fileChosed.getFolderChoosed());
		System.out.println(fileChosed.getFileChoosed()); 
	}
}