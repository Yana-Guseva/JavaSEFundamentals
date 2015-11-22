package javase.homework._05._01;

import java.io.*;
import java.util.Scanner;

/**
 * Created by Yana on 02.11.2015.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("To view contents of the current folder/file enter: ls");
        System.out.println("To go to a new folder enter: cd folder_name");
        System.out.println("To return enter: cd..");
        System.out.println("To create/append a text file enter: append folder_name");
        System.out.println("To delete file enter: del folder_name");
        System.out.println("To exit enter: q");
        File currentDir = new File(System.getProperty("user.dir"));
        System.out.print(currentDir.getPath() + ">");

        Scanner sc = new Scanner(System.in);
        String command;

        while (!(command = sc.next()).equals("q")) {
            switch (command) {
                case "ls":
                    try {
                        printFilesInDir(currentDir);
                    } catch (NullPointerException e) {
                        System.out.println(e.getMessage());
                    }
                    System.out.print(currentDir.getPath() + ">");
                    break;
                case "cd":
                    String name = sc.findInLine(" .*");
                    try {
                        currentDir = moveToDir(currentDir, name.trim());
                    } catch (FileNotFoundException e) {
                        System.out.println(e.getMessage());
                    } catch (NullPointerException e) {
                        System.out.println("Enter the name of folder.");
                    }
                    System.out.print(currentDir.getPath() + ">");
                    break;
                case "cd..":
                    try {
                        currentDir = new File(currentDir.getParent());
                    } catch (NullPointerException e) {
                        System.out.println("This is the root directory.");
                    }
                    System.out.print(currentDir.getPath() + ">");
                    break;
                case "append":
                    name = sc.findInLine(" .*");
                    try {
                        writeFile(currentDir, name);
                    } catch (FileNotFoundException e) {
                        System.out.println(e.getMessage());
                    }
                    System.out.print(currentDir.getPath() + ">");
                    break;
                case "del":
                    name = sc.findInLine(" .*");
                    try {
                        File file = new File(currentDir + "\\" + name.trim());
                        if (file.delete()) {
                            System.out.println("File deleted.");
                        } else {
                            System.out.println("Error deleting the file.");
                        }
                    } catch (NullPointerException e) {
                        System.out.println("Enter the name of folder.");
                    }
                    System.out.print(currentDir.getPath() + ">");
                    break;
                default:
                    System.out.println("This command not found.");
                    System.out.print(currentDir.getPath() + ">");
            }
        }
        sc.close();
    }

    private static void writeFile(File currentDir, String name) throws FileNotFoundException {
        if (currentDir.isDirectory()) {
            try (FileWriter fileWriter = new FileWriter(currentDir.getPath() + "\\" + name.trim(), true)) {
                System.out.println("Input text:");
                Scanner sc = new Scanner(System.in);
                fileWriter.write(sc.nextLine());
            } catch (IOException e) {
                System.out.println("Access denied.");
            }
        } else {
            throw new FileNotFoundException("Can't create new file in this file");
        }
    }

    private static File moveToDir(File dir, String name) throws FileNotFoundException {
        File newFile = new File(dir + "\\" + name);
        if (newFile.exists()) {
            return newFile;
        } else {
            throw new FileNotFoundException("No such file or directory");
        }
    }

    public static void printFilesInDir(File file) throws NullPointerException {
        if (file.isDirectory()) {
            if (file.listFiles() == null) {
                throw new NullPointerException("listFile is empty");
            }
            for (File item : file.listFiles()) {
                System.out.println(item.getName());
            }
        } else {
            try (FileReader fileReader = new FileReader(file.getPath())) {
                if (!file.canRead()) {
                    throw new FileNotFoundException("Access denied.");
                }
                int next;
                while ((next = fileReader.read()) != -1) {
                    System.out.print((char) next);
                }
                System.out.println();
            } catch (IOException e) {
                System.out.println("Input/output error.");
            }
        }
    }
}