package hr.algebra.java2.bingoproject.model;

import javafx.scene.control.Button;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Ticket{

    private Integer NUMBER_OF_COLUMNS_AND_ROWS= 5;
    public List<Button> mainList;
    public List<Button> firstColumn;
    public List<Button> secondColumn;
    public List<Button> thirdColumn;
    public List<Button> fourthColumn;
    public List<Button> fifthColumn;

    public void setMainList(List<Button> mainList) {
        this.mainList = mainList;
        divisionIntoColumns();
    }

    public void fillMainList(Button button) {
        this.mainList.add(button);
    }

    public Ticket() {
        mainList = new ArrayList<>();
        firstColumn = new ArrayList<>();
        secondColumn = new ArrayList<>();
        thirdColumn = new ArrayList<>();
        fourthColumn = new ArrayList<>();
        fifthColumn = new ArrayList<>();
    }

    public void divisionIntoColumns(){
        for (int i=0; i<mainList.size(); i++){
            if (i<NUMBER_OF_COLUMNS_AND_ROWS) firstColumn.add(mainList.get(i));
            else if (i>=NUMBER_OF_COLUMNS_AND_ROWS && i<NUMBER_OF_COLUMNS_AND_ROWS*2) secondColumn.add(mainList.get(i));
            else if (i>=NUMBER_OF_COLUMNS_AND_ROWS*2 && i<NUMBER_OF_COLUMNS_AND_ROWS*3) thirdColumn.add(mainList.get(i));
            else if (i>=NUMBER_OF_COLUMNS_AND_ROWS*3 && i<NUMBER_OF_COLUMNS_AND_ROWS*4) fourthColumn.add(mainList.get(i));
            else if (i>=NUMBER_OF_COLUMNS_AND_ROWS*4 && i<NUMBER_OF_COLUMNS_AND_ROWS*NUMBER_OF_COLUMNS_AND_ROWS) fifthColumn.add(mainList.get(i));
        }
    }

    public int getMainListSize(){
        return mainList.size();
    }
}
