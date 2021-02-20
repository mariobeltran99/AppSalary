package app.appcount.appsalary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private EditText named, salary, anti;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        configView();
    }
    private void configView(){
        named = findViewById(R.id.etname);
        salary = findViewById(R.id.etsalary);
        anti = findViewById(R.id.ethour);
    }
    public void executeAmount(View v){
        Double salar = Double.valueOf(salary.getText().toString());
        Double year = Double.valueOf(anti.getText().toString());
        if(salar < 100){
            Toast.makeText(this,"No pueden ser salarios menores a $100.00",Toast.LENGTH_LONG).show();
        }else if( year < 0){
            Toast.makeText(this,"No pueden ser números negativos en el campo de años",Toast.LENGTH_LONG).show();
        }else{
            Intent i = new Intent(this,SalaryDetails.class);
            Double aument = 0.0;
            Double mountaument = 0.0;
            Double salaryFinal = 0.0;
            DecimalFormat sf = new DecimalFormat("0.00");
            if(salar < 500 &&  year >= 10){
                aument = 0.20;
                mountaument = salar * aument;
                salaryFinal = salar + mountaument;
            }else if(salar < 500 && year < 10){
                aument = 0.05;
                mountaument = salar * aument;
                salaryFinal = salar + mountaument;
            }else{
                aument = 0.0;
                mountaument = salar * aument;
                salaryFinal = salar + mountaument;
            }
            i.putExtra("txname",named.getText().toString());
            i.putExtra("txyear", anti.getText().toString());
            i.putExtra("txsalarybase", String.valueOf(sf.format(salar)));
            i.putExtra("txaument", String.valueOf(aument*100));
            i.putExtra("txaumentmount", String.valueOf(sf.format(mountaument)));
            i.putExtra("txsalaryfinal", String.valueOf(sf.format(salaryFinal)));
            startActivity(i);
        }

    }
}