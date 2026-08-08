module csc213.ottplatfrom {
    requires javafx.controls;
    requires javafx.fxml;


    opens csc213.ottplatfrom to javafx.fxml;
    exports csc213.ottplatfrom;

    opens csc213.ottplatfrom.NusratJahan to javafx.fxml;
    exports csc213.ottplatfrom.NusratJahan;
}