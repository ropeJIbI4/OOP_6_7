package models;

import java.util.List;

public interface FailOperationNote {

    List<String> readAllLines();

    void saveAllLines(List<String> lines);
    
}