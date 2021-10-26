package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;


public class Controller {

    Alert alert = new Alert(Alert.AlertType.WARNING);

    @FXML
    private Button seven;

    @FXML
    private Button eight;

    @FXML
    private Button nine;

    @FXML
    private Button four;

    @FXML
    private Button five;

    @FXML
    private Button six;

    @FXML
    private Button one;

    @FXML
    private Button two;

    @FXML
    private Button three;

    @FXML
    private Button plus;

    @FXML
    private Button minus;

    @FXML
    private Button multiply;

    @FXML
    private Button plusMinus;

    @FXML
    private Button zero;

    @FXML
    private Button point;

    @FXML
    private Button equals;

    @FXML
    private Button clean;

    @FXML
    private Button parentheses;

    @FXML
    private Button percent;

    @FXML
    private Button division;

    @FXML
    private TextField textBox;

    @FXML
    private ChoiceBox<?> choice;

    @FXML
    private Button back;

    @FXML
    public void initialize() {

        clean.setOnAction(event -> textBox.clear());

        one.setOnAction(event -> textBox.appendText("1"));
        two.setOnAction(event -> textBox.appendText("2"));
        three.setOnAction(event -> textBox.appendText("3"));
        four.setOnAction(event -> textBox.appendText("4"));
        five.setOnAction(event -> textBox.appendText("5"));
        six.setOnAction(event -> textBox.appendText("6"));
        seven.setOnAction(event -> textBox.appendText("7"));
        eight.setOnAction(event -> textBox.appendText("8"));
        nine.setOnAction(event -> textBox.appendText("9"));
        zero.setOnAction(event -> textBox.appendText("0"));

        equals.setOnAction(event -> {
            int parenthesesR = 0;
            int parenthesesL = 0;
            for (char i : textBox.getText().toCharArray()) {
                if (i == '(')
                    parenthesesR++;
                if (i == ')')
                    parenthesesL++;
            }
            if (parenthesesL != parenthesesR) {
                alert.setTitle("Warning");
                alert.setHeaderText(null);
                alert.setContentText("Количество скобок не совпадает");
                alert.showAndWait();
            } else
                textBox.setText(Calculator.calculate(textBox.getText()));
        });
        back.setOnAction(event -> {
            if (textBox.getText().length() != 0)
                textBox.setText(textBox.getText().substring(0, textBox.getText().length() - 1));
        });
        plus.setOnAction(event -> {
            if (textBox.getText().length() != 0 && !textBox.getText().substring(textBox.getText().length() - 1).matches("[+\\-*/(?]"))
                textBox.appendText("+");
        });
        minus.setOnAction(event -> {
            if (textBox.getText().length() != 0 && !textBox.getText().substring(textBox.getText().length() - 1).matches("[+\\-*/(?]"))
                textBox.appendText("-");
        });
        multiply.setOnAction(event -> {
            if (textBox.getText().length() != 0 && !textBox.getText().substring(textBox.getText().length() - 1).matches("[+\\-*/(?]"))
                textBox.appendText("*");
        });
        division.setOnAction(event -> {
            if (textBox.getText().length() != 0 && !textBox.getText().substring(textBox.getText().length() - 1).matches("[+\\-*/(?]"))
                textBox.appendText("/");
        });
        percent.setOnAction(event -> {
            if (textBox.getText().length() != 0 && !textBox.getText().substring(textBox.getText().length() - 1).matches("[+\\-*/%?]"))
                textBox.appendText("%");
        });
        parentheses.setOnAction(event -> {
            if (textBox.getText().length() == 0 || textBox.getText().substring(textBox.getText().length() - 1).matches("[+\\-*/%(?]")) {
                textBox.appendText("(");
            } else {
                textBox.appendText(")");
            }
        });
    }

}
