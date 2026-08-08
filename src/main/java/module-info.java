module csc213.ottplatfrom {

    requires javafx.controls;
    requires javafx.fxml;

    opens csc213.ottplatfrom to javafx.fxml;
    opens csc213.ottplatfrom.Rajmee to javafx.fxml;

    exports csc213.ottplatfrom;
    exports csc213.ottplatfrom.Rajmee;
}