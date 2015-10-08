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
     * ���������� ����� ������ � �������
     * @param newRecord ����� ������
     */
    public void addRecord(RecordInNotepad newRecord) {
        records.add(newRecord);
    }

    /**
     * �������� ������ �� ��������
     * @param index ����� ��������� ������
     */
    public void deleteRecord(int index) {
        records.remove(index - 1);
    }

    /**
     * �������������� ������
     * @param index ����� ������������� ������
     * @param newRecord ����� ������
     */
    public void editRecord(int index, RecordInNotepad newRecord) {
        records.remove(index - 1);
        records.add(index - 1, newRecord);
    }

    public ArrayList<RecordInNotepad> getRecords() {
        return records;
    }
}
