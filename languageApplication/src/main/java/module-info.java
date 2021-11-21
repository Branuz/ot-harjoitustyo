module com.poussu.studymate {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;

    opens com.poussu.studymate to javafx.fxml;
    exports com.poussu.studymate;
}