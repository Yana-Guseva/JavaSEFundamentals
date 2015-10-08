package javase.homework._01._6;

import java.util.ArrayList;

/**
 * Created by Yana on 06.10.2015.
 */
public class Notepad {
    private ArrayList<RecordInNotepad> records;

    Notepad() {
        records = new ArrayList<>();
    }

    /**
     * Добавление новой записи в блокнот
     * @param newRecord новая запись
     */
    public void addRecord(RecordInNotepad newRecord) {
        records.add(newRecord);
    }

    /**
     * Удаление записи из блокнота
     * @param index номер удаляемой записи
     */
    public void deleteRecord(int index) {
        records.remove(index - 1);
    }

    /**
     * Редактирование записи
     * @param index номер редактируемой записи
     * @param newRecord новая запись
     */
    public void editRecord(int index, RecordInNotepad newRecord) {
        records.remove(index - 1);
        records.add(index - 1, newRecord);
    }

    public ArrayList<RecordInNotepad> getRecords() {
        return records;
    }
}
