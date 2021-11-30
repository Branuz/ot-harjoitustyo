module com.poussu.studymate {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;
    
    requires java.sql;
    opens com.poussu.studymate to javafx.fxml;
    opens com.poussu.studymate.dictionaryUI to javafx.fxml, javafx.base;
    opens com.poussu.studymate.startUI to javafx.fxml;
    exports com.poussu.studymate;
    
}
