package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var myData:PremiumModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        myData= ViewModelProviders.of(this).get(PremiumModel::class.java)
        totalAmount.text="RM %.2f".format(myData.premiumAmount);
    calbutton.setOnClickListener(){
        myData.premiumAmount=getPremium();
        totalAmount.text="RM %.2f".format(myData.premiumAmount);
    }

        resetbutton.setOnClickListener()
        {
            spinnerAge.setSelection(0)

            radGroup.clearCheck()

            chkSmoker.setChecked(false)

            totalAmount.text=""
        }
    }
    fun getPremium():Double{
        return when(spinnerAge.selectedItemPosition){
            0->60.00
            1->70.00 + (if (male.isChecked)50.00 else 0.0) + (if(chkSmoker.isChecked)100.00 else 0.0)
            2->90.00 + (if (male.isChecked)100.00 else 0.0) + (if(chkSmoker.isChecked)150.00 else 0.0)
            3->120.00 + (if (male.isChecked)150.00 else 0.0) + (if(chkSmoker.isChecked)200.00 else 0.0)
            4->150.00 + (if (male.isChecked)200.00 else 0.0) + (if(chkSmoker.isChecked)250.00 else 0.0)
            else->150.00+ (if (male.isChecked)200.00 else 0.0) + (if(chkSmoker.isChecked)300.00 else 0.0)
        }
    }
}
