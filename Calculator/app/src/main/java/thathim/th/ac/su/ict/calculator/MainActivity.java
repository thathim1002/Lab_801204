package thathim.th.ac.su.ict.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText text1;
    EditText text2;
    Button calbtn;
    Button clearbtn;
    TextView resulttv;

    RadioGroup rgOperator;
    RadioButton rbPlus;
    RadioButton rbMinus;
    RadioButton rbDivide;
    RadioButton rbMultiply;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); //inflate

        text1 = findViewById(R.id.text1);
        text2 = findViewById(R.id.text2);
        calbtn = findViewById(R.id.calbtn);
        clearbtn = findViewById(R.id.clearbtn);
        resulttv = findViewById(R.id.resulttv);

        rbPlus = findViewById(R.id.rbPlus);
        rbMinus = findViewById(R.id.rbMinus);
        rbMultiply = findViewById(R.id.rbMultiply);
        rbDivide = findViewById(R.id.rbDivide);

        rgOperator = findViewById(R.id.rgOperator);

        clearbtn.setOnClickListener(listener);
        calbtn.setOnClickListener(listener);

        //Anonymous Class
        /* calbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int v1 = Integer.parseInt(text1.getText().toString());
                int v2 = Integer.parseInt(text2.getText().toString());
                int result = v1+v2;

//                 Log.d("calculation", "result = "+result);
//                Toast.makeText(MainActivity.this,
//                        "result"+result,Toast.LENGTH_LONG).show();
                resulttv.setText(result+"");
            }
        }); */
    }

    View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(v == clearbtn) {
                resulttv.setText("0");
                text1.setText("");
                text2.setText("");

                Toast.makeText(MainActivity.this,
                        "clear", Toast.LENGTH_LONG).show();
            }
            if(v == calbtn) {
                int v1 = Integer.parseInt(text1.getText().toString());
                int v2 = Integer.parseInt(text2.getText().toString());
                int result = 0;

//                if (rbPlus.isChecked()){
//                    result = v1+v2;
//                }
//                 Log.d("calculation", "result = "+result);
//                Toast.makeText(MainActivity.this,
//                        "result"+result,Toast.LENGTH_LONG).show();
                switch (rgOperator.getCheckedRadioButtonId()){
                    case R.id.rbPlus:
                        result = v1+v2;
                        break;
                    case R.id.rbMinus:
                        result = v1-v2;
                        break;
                    case R.id.rbMultiply:
                        result = v1*v2;
                        break;
                    case R.id.rbDivide:
                        result = v1/v2;
                        break;
                }
                resulttv.setText(" = " +result);
            }
        }
    };
}
