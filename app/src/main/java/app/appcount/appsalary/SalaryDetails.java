package app.appcount.appsalary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class SalaryDetails extends AppCompatActivity {

    private TextView name, year, salary, auments, mountAument, salaryFinal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_salary_details);
        configView();
        Bundle st = getIntent().getExtras();
        name.setText("Nombre: " + st.getString("txname"));
        year.setText("Años trabajados: "+ st.getString("txyear"));
        salary.setText("Salario Base: $" + st.getString("txsalarybase"));
        auments.setText("Aumento: " + st.getString("txaument") + "%");
        mountAument.setText("Monto del Aumento: $" + st.getString("txaumentmount"));
        salaryFinal.setText("Salario Neto: $" + st.getString("txsalaryfinal"));
    }
    private void configView(){
        name = findViewById(R.id.txname);
        year = findViewById(R.id.txyear);
        salary = findViewById(R.id.txsalbase);
        auments = findViewById(R.id.txaumet);
        mountAument = findViewById(R.id.txaumentmount);
        salaryFinal = findViewById(R.id.txsuelneto);
    }
    public void back(View v){
        Intent j = new Intent(this,MainActivity.class);
        startActivity(j);
    }
}