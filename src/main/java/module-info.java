module csc213.ottplatfrom {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.base;
    requires java.desktop;

    opens csc213.ottplatfrom to javafx.fxml;
    opens csc213.ottplatfrom.rajmee to javafx.fxml;

    exports csc213.ottplatfrom;
    exports csc213.ottplatfrom.rajmee;
}