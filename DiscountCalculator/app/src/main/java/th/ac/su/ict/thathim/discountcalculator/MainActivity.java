package th.ac.su.ict.thathim.discountcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText edtPriceOriginal;
    EditText edtPercentOff;
    CheckBox cbTax;
    TextView tvPrice;
    Button btCal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtPriceOriginal = findViewById(R.id.edtPriceOriginal);
        edtPercentOff = findViewById(R.id.edtPercentOff);
        cbTax = findViewById(R.id.cbTax);
        tvPrice = findViewById(R.id.tvPrice);
        btCal = findViewById(R.id.btCal);

        btCal.setOnClickListener(listener);

    }

    View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            if(v == btCal) {
                float originalPrice = 0;
                originalPrice = Float.parseFloat(edtPriceOriginal.getText().toString());

                float percentOff = 0;
                percentOff = Float.parseFloat(edtPercentOff.getText().toString());

                float discount = 0;
                discount = (percentOff/100)*originalPrice;

                float finalPrice = 0;
                float tax = 0;

                if (cbTax.isChecked()){
                    finalPrice = originalPrice - discount;
                    tax = (float)0.07 * finalPrice;

                    finalPrice += tax;
                }
                else{
                    finalPrice = originalPrice - discount;
                }
                tvPrice.setText(Float.toString(finalPrice));
            }
        }
    };
}
