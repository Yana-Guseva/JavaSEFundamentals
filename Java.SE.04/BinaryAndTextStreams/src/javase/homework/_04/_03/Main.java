package javase.homework._04._03;


import java.io.*;


/**
 * Created by Yana on 31.10.2015.
 */

public class Main {
    
	public static void main(String[] args) {
        
		String inputFileName = "C:\\Users\\Yana\\IdeaProject\BinaryAndTextStreams\\src\\javase\\homework\\_04\\_03\\input.txt";

        	String outputFileName = "C:\\Users\\Yana\\IdeaProjects\\BinaryAndTextStreams\\src\\javase\\homework\\_04\\_03\\output.txt";


        	StringBuilder text = read(inputFileName);

        	write(outputFileName, text);

    	}


    	public static StringBuilder read(String fileName) {

        	StringBuilder strBuilder = new StringBuilder();

        	try (Reader reader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName), "UTF-8"))) {

        	int next;

            	while ((next = reader.read()) != -1) {

                	strBuilder.append((char) next);

            	}
        
	} catch (FileNotFoundException e) {

            	System.out.println("Файл " + fileName + " не найден");

        } catch (IOException e) {

            	System.out.println("Ошибка ввода/вывода " + e.toString());

        }

        System.out.println(strBuilder);

        return strBuilder;

    }

    
public static void write(String fileName, StringBuilder result) {

        try (Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName), "UTF-16"))) {

            writer.write(result.toString());

        } catch (FileNotFoundException e) {

            System.out.println("Файл " + fileName + " не найден");

        } catch (IOException e) {

            System.out.println("Ошибка ввода/вывода " + e.toString());

        }
    
    }

}
