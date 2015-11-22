package javase.homework._01._6;

import java.util.ArrayList;

/**
 * Created by Yana on 06.10.2015.
 */
public class Main {
    public static void main(String[] args) {
        Notepad notepad = new Notepad();
        notepad.addRecord(new RecordInNotepad("record 1"));
        notepad.addRecord(new RecordInNotepad("record 2"));
        notepad.addRecord(new RecordInNotepad("record 3"));
        ArrayList<RecordInNotepad> allRecords = notepad.getRecords();
        printAllRecords(allRecords);

        notepad.editRecord(2, new RecordInNotepad("Edit record 2"));
        allRecords = notepad.getRecords();
        printAllRecords(allRecords);

        notepad.deleteRecord(1);
        allRecords = notepad.getRecords();
        printAllRecords(allRecords);
    }

    /**
     * Вывод на консоль всех записей из блокнота
     * @param allRecords массив записей
     */
    private static void printAllRecords(ArrayList<RecordInNotepad> allRecords) {
        int i = 0;
        for(RecordInNotepad record : allRecords) {
            System.out.println(++i + ". " + record.getRecord());
        }
        System.out.println();
    }
}
