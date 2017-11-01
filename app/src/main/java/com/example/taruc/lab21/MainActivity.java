package com.example.taruc.lab21;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public static final String MONTHLY_PAYMENT = "payment";
    public static final String LOAN_STATUS = "status";
    //Global variable
    private EditText editTextCarPrice;
    private EditText editTextDownPayment;
    private EditText editTextLoadPeriod;
    private EditText editTextInterestRate;
    private EditText editTextSalary;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void calculateLoan(View view){
        //Create Explicit intent
        Intent intent = new Intent(this, ResultActivity.class);

        //TODO: calculte monthly payment and determines
        //loan application status; approve or reject


        double vechiclePrice, downPayment,interestRate,rePayment,salary;
        double totalInterest;
        double totalLoan;
        double monthlyPayment;
        String status;
        editTextCarPrice = (EditText)findViewById(R.id.editTextCarPrice);
        editTextDownPayment = (EditText)findViewById(R.id.editTextDownPayment);
        editTextLoadPeriod = (EditText)findViewById(R.id.editTextLoadPeriod);
        editTextInterestRate = (EditText)findViewById(R.id.editTextInterestRate);
        editTextSalary = (EditText)findViewById(R.id.editTextSalary);

        vechiclePrice = Double.parseDouble(editTextCarPrice.getText().toString());
        downPayment = Double.parseDouble(editTextDownPayment.getText().toString());
        interestRate = Double.parseDouble(editTextLoadPeriod.getText().toString());
        rePayment = Double.parseDouble(editTextInterestRate.getText().toString());
        salary = Double.parseDouble(editTextSalary.getText().toString());


        totalInterest = (vechiclePrice - downPayment) * (interestRate/100) *(rePayment/12);
        totalLoan = (vechiclePrice - downPayment) + totalInterest;

        monthlyPayment = totalLoan/rePayment;

        if(monthlyPayment > (salary*30/100)){
            status = "Rejected";
        }
        else
            status = "approved";

        //Passing data using putExtra method
        //putExtra(TAG, value)

        intent.putExtra(MONTHLY_PAYMENT,monthlyPayment);
        intent.putExtra(LOAN_STATUS,status);

        startActivity(intent);


    }
}
