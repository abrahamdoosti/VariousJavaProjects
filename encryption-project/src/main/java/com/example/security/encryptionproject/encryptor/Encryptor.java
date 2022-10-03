package com.example.security.encryptionproject.encryptor;

import java.io.File;
import java.util.Scanner;

public class Encryptor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String key;
		//File inputFile = new File("D:\\Imported from C\\infos.txt");
		String encryptedFilePath = "C:\\Users\\abrah\\Desktop\\document.encrypted";
		String encryptedBackupFilePath = "C:\\Users\\abrah\\Desktop\\document.encrypted";
		String decryptedFilePath = "C:\\Users\\abrah\\Desktop\\document.decrypted";
		File encryptedFile = new File(encryptedFilePath);
		File decryptedFile = new File(decryptedFilePath);
		File encryptedBackupFile = new File(encryptedBackupFilePath);
		

		Scanner sc = new Scanner(System.in);
		Scanner scChoise = new Scanner(System.in);
		int choice;
		do {
			System.out.println("Press 1 for encrypt or 2 for decrypt");
			choice = sc.nextInt();
			try {
				switch (choice) {
				case 1:
					System.out.println("Enter your key");
					key = scChoise.nextLine();
					System.out.println("Encryption started...");
					CryptoUtils.encrypt(key, decryptedFile, encryptedFile);
					CryptoUtils.encrypt(key, decryptedFile, encryptedBackupFile);
					System.out.println("Encryption Finished.\n File is located at " + encryptedFilePath);
					//
					break;
				case 2:
					//
					System.out.println("Enter your key");
					key = scChoise.nextLine();
					System.out.println("Decryption started...");
					CryptoUtils.decrypt(key, encryptedFile, decryptedFile);
					System.out.println("Decryption Finished.\n File is located at " + decryptedFilePath);
					break;
				default:
					// do nothing
					System.out.println("nothing done!");
				}
				// CryptoUtils.encrypt(key, inputFile, encryptedFile);
				// CryptoUtils.decrypt(key, encryptedFile, decryptedFile);
			} catch (CryptoException ex) {
				System.out.println(ex.getMessage());
				ex.printStackTrace();
			}
		} while (choice == 1 || choice == 2);
	}

}
