package com.example.carloancalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonCalculate.setOnClickListener(){
            val carPrice = editTextCarPrice.text.toString()
            val downPayment =  editTextDownPayment.text.toString()
            val loanPeriod = editTextLoanPeriod.text.toString()
            val interestRate = editTextInterestRate.text.toString()

            val loan:Double = carPrice.toDouble() - downPayment.toDouble()
            val interest:Double = loan * (interestRate.toDouble() / 100) * loanPeriod.toDouble()
            val repayment:Double = (loan + interest) / loanPeriod.toDouble() / 12

            textViewLoan.text = "%.2f".format(loan)
            textViewInterest.text = "%.2f".format(interest)
            textViewMonthlyRepayment.text = "%.2f".format(repayment)
        }

        buttonReset.setOnClickListener(){
            editTextCarPrice.setText(null)
            editTextDownPayment.setText(null)
            editTextLoanPeriod.setText(null)
            editTextInterestRate.setText(null)
            textViewLoan.text = ""
            textViewInterest.text = ""
            textViewMonthlyRepayment.text = ""
        }
    }


}
