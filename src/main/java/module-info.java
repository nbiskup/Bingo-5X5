module hr.algebra.java2.bingoproject {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.rmi;
    requires java.naming;
    requires java.xml;


    opens hr.algebra.java2.bingoproject to javafx.fxml;
    exports hr.algebra.java2.bingoproject;
    exports hr.algebra.java2.bingoproject.rmiserver to java.rmi;
}