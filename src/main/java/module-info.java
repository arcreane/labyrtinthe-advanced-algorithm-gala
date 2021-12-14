module me.loule.labyrtintheadvancedalgorithmgala {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;

    opens me.loule.labyrtintheadvancedalgorithmgala to javafx.fxml;
    exports me.loule.labyrtintheadvancedalgorithmgala;
}