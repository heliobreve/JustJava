package com.example.user.justjava;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.widget.CheckBox;
import android.widget.TextView;
import android.view.View;
import java.text.NumberFormat;


/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    int quantity = 0 ;
    boolean hasWhippedCream = false;
    boolean hasChocolate = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    /**
     * This method creates a summary of the order
     * @param price is the number of cups of coffee ordered
     *
     */
    private String createOrderSummary(int price) {
        String priceMessage = "Name: Helio";
        priceMessage = priceMessage + "\nWhipped Cream: " + hasWhippedCream;
        priceMessage = priceMessage + "\nChocolate: " + hasChocolate;
        priceMessage = priceMessage + "\nQuantity: " + quantity;
        priceMessage = priceMessage + "\nTotal: $" + calculatePrice();
        priceMessage = priceMessage + "\nThank you!";
        return priceMessage;
    }


    /**
     * Calculates the price of the order.
     *
     * @return total price
     */
    private int calculatePrice() {
        int price = quantity * 5;
        return price;
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        final CheckBox whipperCreamCheckBox = (CheckBox) findViewById(R.id.Whipped_Cream_Checkbox);
        hasWhippedCream = whipperCreamCheckBox.isChecked();
        final CheckBox chocolateCheckBox = (CheckBox) findViewById(R.id.Chocolate_Checkbox);
        hasChocolate = chocolateCheckBox.isChecked();

        int price = calculatePrice();
        String priceMessage = createOrderSummary(price);
        displayMessage(priceMessage);
    }
    /**
     * This method is called when the increment button is clicked.
     */
    public void increment(View view) {
        quantity = quantity + 1;
        display(quantity);
    }
    /**
     * This method is called when the decrement button is called
     */
    public void decrement (View view) {
        quantity = quantity - 1 ;
        display(quantity);
    }

    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message) {
        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(message);
    }
    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number){
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }




}
