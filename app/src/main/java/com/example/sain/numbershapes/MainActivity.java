package com.example.sain.numbershapes;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View view) {
        EditText editText = findViewById(R.id.editText);

        if (editText.getText().toString().isEmpty()) {
            Toast.makeText(this, "Enter an integer greater than zero", Toast.LENGTH_SHORT).show();
        } else {
            int number = Integer.parseInt(editText.getText().toString());

            if (number > 0) {
                Number newNumber = new Number();
                newNumber.value = number;

                output(newNumber);
            } else {
                Toast.makeText(this, "Enter an integer greater than zero", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void output(Number newNumber) {
        boolean isTriangular = newNumber.isTriangular();
        boolean isSquare = newNumber.isSquare();
        String message;

        if (isTriangular && isSquare) {
            message = "The number is both triangular and square";
        } else if (isTriangular) {
            message = "The number is triangular";
        } else if (isSquare) {
            message = "The number is square";
        } else {
            message = "The number is neither triangular nor square";
        }

        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }

    class Number {
        int value;

        private boolean isTriangular() {
            int x = 1;
            int sum = 0;

            while (sum < value) {
                sum += x;

                if (sum == value) {
                    return true;
                }

                x++;
            }

            return false;
        }

        private boolean isSquare() {
            double sqrt = Math.sqrt(value);

            return (sqrt == Math.floor(sqrt));
        }
    }
}
