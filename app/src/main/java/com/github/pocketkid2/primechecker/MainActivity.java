package com.github.pocketkid2.primechecker;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public class MainActivity extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText inputBox = this.findViewById(R.id.prime_check_edit_text);

        Button checkButton = this.findViewById(R.id.prime_check_button);

        TextView answer = this.findViewById(R.id.prime_check_text_view);

        TextView factorization = this.findViewById(R.id.prime_check_factorization);

        checkButton.setOnClickListener(view -> {
            try {
                int number = Integer.parseInt(inputBox.getText().toString());

                List<String> factors = PrimeCheck.getFactorization(number).stream().map(Object::toString).collect(Collectors.toList());

                if (factors.size() == 0) {
                    answer.setText(R.string.yes);
                    factorization.setText(String.format(Locale.ENGLISH, "1 x %d", number));
                } else {
                    answer.setText(R.string.no);
                    factorization.setText(String.join(" x ", factors));
                }
            } catch (NumberFormatException e) {
                Toast.makeText(this, "Invalid number!", Toast.LENGTH_SHORT).show();
            }
            // Hide keyboard when we press the button
            if (view != null) {
                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
            }
        });
    }
}