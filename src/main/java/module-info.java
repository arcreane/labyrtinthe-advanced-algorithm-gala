module me.loule.maze {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;

    opens me.loule.maze to javafx.fxml;
    exports me.loule.maze;
    exports me.loule.maze.controller;
    opens me.loule.maze.controller to javafx.fxml;
}