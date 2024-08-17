package application;

//Start 
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
public class DiscountCalculatorApp extends Application {
private TextField originalPriceField;
private TextField customDiscountField;
private RadioButton predefined10;
private RadioButton predefined20;
private RadioButton predefined30;
private RadioButton customDiscount;
private Button calculateButton;
private TextArea resultTextArea;

@Override
//Priary stage of Discount Calculater After Applying the Coupon Code
public void start(Stage primaryStage) {
primaryStage.setTitle("Discount Calculator");

//Entering  the Orginal Price Label

Label originalPriceLabel = new Label("Enter the original price:");
originalPriceField = new TextField();
Label discountLabel = new Label("Select the discount percentage:");
predefined10 = new RadioButton("GET10OFF");
predefined20 = new RadioButton("GET20OFF");
predefined30 = new RadioButton("GET30OFF");

//Custom Discount Code

customDiscount = new RadioButton("Custom discount code");
customDiscountField = new TextField();
calculateButton = new Button("Calculate");
resultTextArea = new TextArea();
resultTextArea.setEditable(false);

//Discount toogle group

ToggleGroup discountToggleGroup = new ToggleGroup();
predefined10.setToggleGroup(discountToggleGroup);
predefined20.setToggleGroup(discountToggleGroup);
predefined30.setToggleGroup(discountToggleGroup);
customDiscount.setToggleGroup(discountToggleGroup);

//New Grid Pane

GridPane root = new GridPane();
root.setHgap(10);
root.setVgap(10);
root.setPadding(new Insets(10, 10, 10, 10));
root.add(originalPriceLabel, 0, 0);
root.add(originalPriceField, 1, 0);
root.add(discountLabel, 0, 1);
root.add(predefined10, 1, 1);
root.add(predefined20, 2, 1);
root.add(predefined30, 3, 1);
root.add(customDiscount, 4, 1);
root.add(customDiscountField, 5, 1);
root.add(calculateButton, 0, 2);
root.add(resultTextArea, 0, 3, 6, 1);
calculateButton.setOnAction(event -> calculateDiscount());
Scene scene = new Scene(root, 500, 300);
primaryStage.setScene(scene);
primaryStage.show();
}

//Calculating the Discount 

private void calculateDiscount() {
try {
double originalPrice = Double.parseDouble(originalPriceField.getText());
double discountPercentage;
if (predefined10.isSelected()) {
discountPercentage = 0.1;
} else if (predefined20.isSelected()) {
discountPercentage = 0.2;
} else if (predefined30.isSelected()) {
discountPercentage = 0.3;
} else if (customDiscount.isSelected()) {
discountPercentage =
Double.parseDouble(customDiscountField.getText()) / 100.0;
} else {
resultTextArea.setText("Your cost of order after discount.");
return;
}
double discountAmount = originalPrice * discountPercentage;
double discountedPrice = originalPrice - discountAmount;
String result = "Discounted Price: $" + discountedPrice + "\n";
result += "Amount Saved: $" + discountAmount;
resultTextArea.setText(result);
} catch (NumberFormatException e) {
resultTextArea.setText("Invalid input. Please enter valid numbers.");
}
}
public static void main(String[] args) {
launch(args);
}
}
//ENd