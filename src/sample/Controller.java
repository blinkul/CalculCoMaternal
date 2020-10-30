package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;

import java.time.LocalDate;

public class Controller {

    @FXML
    public Button calculeazaId;

    @FXML
    public DatePicker preconizareNastereId;

    @FXML
    public DatePicker coPrenatalId;

    @FXML
    public TextArea responseId;

    private Calculator calculator;
    private LocalDate coPrenatal;
    private LocalDate preconizareNastere;

    public Controller() {
    }

    public void calculate() {
        if (coPrenatal != null && preconizareNastere != null) {
            calculator = new Calculator(preconizareNastere, coPrenatal);
            responseId.setText(calculator.calculate());
        } else {
            responseId.clear();
        }
    }

    public void getPreconizareNastere() {
        preconizareNastere = preconizareNastereId.getValue();
    }

    public void getCoPrenatal() {
        coPrenatal = coPrenatalId.getValue();
    }
}