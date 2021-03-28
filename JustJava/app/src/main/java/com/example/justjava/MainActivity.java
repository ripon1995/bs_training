package com.example.justjava;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {
    int numberOfCoffee=2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void submitOrder(View view) {
        display(numberOfCoffee);
        displayPrice(numberOfCoffee*10);
    }

    private void display(int i) {
        TextView textView=findViewById(R.id.quantity_Text_View);
        textView.setText(""+i);
    }
    private void displayPrice(int number)
    {
        TextView textView=findViewById(R.id.price_Text_View);
        textView.setText("Total: "+NumberFormat.getCurrencyInstance().format(number)+"\n Thank You!");
    }

    public void increment(View view) {
        numberOfCoffee++;
        display(numberOfCoffee);
    }

    public void decrement(View view) {
        numberOfCoffee--;
        display(numberOfCoffee);
    }
}