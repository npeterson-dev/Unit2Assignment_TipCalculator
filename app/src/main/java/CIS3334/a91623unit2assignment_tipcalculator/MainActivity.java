package CIS3334.a91623unit2assignment_tipcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    Button buttonCalculateTip;
    EditText editTextBillAmount, editTextNumberInParty;
    TextView textViewTotalTip, textViewTipPerPerson;
    CheckBox checkBoxOutstandingService;

    //update for testing push to github

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextBillAmount = findViewById(R.id.editTextBillAmount);
        editTextNumberInParty = findViewById(R.id.editTextNumberInParty);
        textViewTotalTip = findViewById(R.id.textViewTotalTip);
        textViewTipPerPerson = findViewById(R.id.textViewTipPerPerson);
        buttonCalculateTip = findViewById(R.id.buttonCalculateTip);
        checkBoxOutstandingService = findViewById(R.id.checkBoxOutstandingService);
        NumberFormat formatter = NumberFormat.getCurrencyInstance();

        buttonCalculateTip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Convert user entry and log
                String billAmount = editTextBillAmount.getText().toString();
                String partyNumber = editTextNumberInParty.getText().toString();
                Double bill = Double.parseDouble(billAmount);
                Double party = Double.parseDouble(partyNumber);

                Log.d("CIS3334", "Button has been clicked");

                //Check for outstanding service and calculate tip
                Boolean checkBoxState = checkBoxOutstandingService.isChecked();
                if(checkBoxState == true) {
                    Double tip1 = (bill * 0.20);
                    Double perPerson1 = tip1 / party;

                    String formattedTip1 = NumberFormat.getCurrencyInstance().format(tip1);
                    String formattedPerPerson1 = NumberFormat.getCurrencyInstance().format(perPerson1);
                    textViewTotalTip.setText(formattedTip1.toString());
                    textViewTipPerPerson.setText(formattedPerPerson1.toString());
                }else{
                    Double tip2 = (bill * 0.15);
                    Double perPerson2 = tip2 / party;

                    String formattedTip2 = NumberFormat.getCurrencyInstance().format(tip2);
                    String formattedPerPerson2 = NumberFormat.getCurrencyInstance().format(perPerson2);
                    textViewTotalTip.setText(formattedTip2.toString());
                    textViewTipPerPerson.setText(formattedPerPerson2.toString());
                }

            }
        });
    }
}