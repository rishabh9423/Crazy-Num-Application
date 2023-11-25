package com.example.crazynum;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
    CheckBox cb1, cb2, cb3, cb4;
    TextView tv4;
    EditText et1;
    RadioButton rb1, rb2, rb3, rb4;
    RadioGroup rg;
    Button b1;

    String dtb(String f)
    {
        if(f.contains("."))
        {
            try
            {
                double decimal = Double.parseDouble(f);
                int intPart = (int) decimal;
                double fractionalPart = decimal - intPart;
                String binary = Integer.toBinaryString(intPart) + ".";

                int count = 0;
                while (fractionalPart > 0 && count < 32) {
                    fractionalPart = fractionalPart * 2;
                    binary += (int) fractionalPart;
                    fractionalPart = fractionalPart - (int) fractionalPart;
                    count++;
                }
                return binary;
            } catch (Exception e)
            {
                Toast.makeText(getApplicationContext(),
                        "Please enter a Valid Number!", Toast.LENGTH_SHORT).show();
            }
        }
        else
        {
           return (Integer.toBinaryString(Integer.parseInt(f)));
        }
        return ("");
    }

    String dto(String f)
    {
        if(f.contains(".")) {
            try {
                double decimal = Double.parseDouble(f);
                int intPart = (int) decimal;
                double fractionalPart = decimal - intPart;
                String octal = Integer.toOctalString(intPart) + ".";

                int count = 0;
                while (fractionalPart > 0 && count < 32) {
                    fractionalPart = fractionalPart * 8;
                    octal += (int) fractionalPart;
                    fractionalPart = fractionalPart - (int) fractionalPart;
                    count++;
                }
                return octal;
            } catch (Exception e) {
                Toast.makeText(getApplicationContext(),
                        "Please enter a Valid Number!", Toast.LENGTH_SHORT).show();
            }
        }
        else{
            return(Integer.toOctalString(Integer.parseInt(f)));
        }
        return ("");
    }

    String dth(String f)
    {
        if(f.contains("."))
        {
            try
            {
                String[] parts = f.split("\\.");
                String intPart = Integer.toHexString(Integer.parseInt(parts[0]));
                String fracd = parts[1];
                String hexa = "";
                double fractionalPart = Double.parseDouble("0." + fracd);
                int now = 0;

                while (fractionalPart > 0 && now < 8)
                {
                    fractionalPart = fractionalPart * 16;
                    int digit = (int) Math.floor(fractionalPart);
                    hexa += Integer.toHexString(digit);
                    fractionalPart = fractionalPart - digit;
                    now++;
                }
                return (intPart+"."+hexa);
            } catch(Exception e)
            {
                Toast.makeText(getApplicationContext(),
                        "Please enter a Valid Number!", Toast.LENGTH_SHORT).show();
            }
        }
        else
        {
            return (Integer.toHexString(Integer.parseInt(f)));
        }
        return ("");
    }

    String btd(String f)
    {
        if(f.contains("."))
        {
            try {
                String decimal = f.substring(0, f.indexOf("."));
                String str = f.substring(f.indexOf(".") + 1);
                double y = 0;
                double q = 0;
                int n = -1;
                int u = 0;
                for (int i = decimal.length() - 1; i >= 0; i--)
                {
                    double t = Math.pow(2, u);
                    char ch = decimal.charAt(i);
                    int a = Integer.parseInt(String.valueOf(ch));
                    q = q + (a * t);
                    u++;
                }
                for (int i = 0; i < str.length(); i++)
                {
                    double t = Math.pow(2, n);
                    char ch = str.charAt(i);
                    int a = Integer.parseInt(String.valueOf(ch));
                    y = y + (a * t);
                    n--;
                }
                return Double.toString(q + y);
            } catch(Exception e)
            {
                Toast.makeText(getApplicationContext(),
                        "Please enter a Valid Number!", Toast.LENGTH_SHORT).show();
            }
        } else
        {
            double q = 0;
            int u = 0;
            for (int i = f.length() - 1; i >= 0; i--)
            {
                double t = Math.pow(2, u);
                char ch = f.charAt(i);
                int a = Integer.parseInt(String.valueOf(ch));
                q = q + (a * t);
                u++;
            }
            return String.valueOf(q);
        }
        return("");
    }

    String otd(String f)
    {
        if(f.contains("."))
        {
            try
            {
                String octal = f.substring(0, f.indexOf("."));
                String str = f.substring(f.indexOf(".") + 1);
                double y = 0;
                double q = 0;
                int n = -1;
                int u = 0;
                for (int i = octal.length() - 1; i >= 0; i--)
                {
                    double t = Math.pow(8, u);
                    char ch = octal.charAt(i);
                    int a = Integer.parseInt(String.valueOf(ch));
                    q = q + (a * t);
                    u++;
                }
                for (int i = 0; i < str.length(); i++)
                {
                    double t = Math.pow(8, n);
                    char ch = str.charAt(i);
                    int a = Integer.parseInt(String.valueOf(ch));
                    y = y + (a * t);
                    n--;
                }
                return Double.toString(q + y);
            } catch (Exception e)
            {
                Toast.makeText(getApplicationContext(),
                "Please enter a Valid Number!", Toast.LENGTH_SHORT).show();
            }
        }
        else
        {
            double q = 0;
            int u = 0;
            for (int i = f.length() - 1; i >= 0; i--)
            {
                double t = Math.pow(8, u);
                char ch = f.charAt(i);
                int a = Integer.parseInt(String.valueOf(ch));
                q = q + (a * t);
                u++;
            }
            return Double.toString(q);
        }
        return ("");
    }

    String htd(String f) {
        if(f.contains(".")) {
            try {
                String decimal = f.substring(0, f.indexOf("."));
                String str = f.substring(f.indexOf(".") + 1);
                String digits = "0123456789ABCDEF";
                decimal = decimal.toUpperCase();
                str = str.toUpperCase();
                int val = 0;
                for (int i = 0; i < decimal.length(); i++) {
                    char c = decimal.charAt(i);
                    int d = digits.indexOf(c);
                    val = 16 * val + d;
                }
                int n = -1;
                double val1 = 0;
                for (int i = 0; i < str.length(); i++) {
                    double t = Math.pow(16, n);
                    n--;
                    char c = str.charAt(i);
                    int d = digits.indexOf(c);
                    val1 = val1 + (t * d);
                }
                return ((val + "." + Double.toString(val1).substring(Double.toString(val1).indexOf(".") + 1)));
            } catch (Exception e) {
                Toast.makeText(getApplicationContext(),
                        "Please enter a Valid Number!", Toast.LENGTH_SHORT).show();
            }
        }
        else
        {
            String digits = "0123456789ABCDEF";
            f = f.toUpperCase();
            int val = 0;
            for (int i = 0; i < f.length(); i++) {
                char c = f.charAt(i);
                int d = digits.indexOf(c);
                val = 16 * val + d;
            }
            return String.valueOf(val);
        }
        return("");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b1 = findViewById(R.id.b1);
        tv4 = findViewById(R.id.tv4);
        et1 = findViewById(R.id.et1);
        cb1 = findViewById(R.id.cb1);
        cb2 = findViewById(R.id.cb2);
        cb3 = findViewById(R.id.cb3);
        cb4 = findViewById(R.id.cb4);
        rb1 = findViewById(R.id.rb1);
        rb2 = findViewById(R.id.rb2);
        rb3 = findViewById(R.id.rb3);
        rb4 = findViewById(R.id.rb4);
        rg = findViewById(R.id.rg);

        b1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                String f = et1.getText().toString();
                String res = "";
                Boolean b = true;

                //Decimal RB
                if(rg.getCheckedRadioButtonId() == rb1.getId())
                {
                    if( et1.getText().toString().length() <= 0 )
                    {
                        Toast.makeText(getApplicationContext(),
                        "Please Enter a Decimal Number!", Toast.LENGTH_SHORT).show();
                        b = false;
                    }
                    else
                    {
                        for (int i = 0; i < f.length(); i++)
                        {
                            char A = f.charAt(i);
                            if (A == '0' || A == '1' || A == '2' || A == '3' || A == '4' || A == '5' || A == '6' || A == '7' || A == '8' || A == '9' || A == '.')
                            {
                                b = true;
                            } else
                            {
                                Toast.makeText(getApplicationContext(),
                                        "Please Enter a Decimal Number!", Toast.LENGTH_SHORT).show();
                                b = false;
                                break;
                            }
                        }
                        if (b)
                        {
                            //DTD Conversion
                            if (cb1.isChecked()) {
                                res = "Decimal: " + f + '\n';
                            }
                            //DTB Conversion
                            if (cb2.isChecked()) {
                                //(D)DTB Conversion
                                String binary = dtb(f);
                                res = res + "Binary: " + binary + '\n';
                            }
                            //DTO Conversion
                            if (cb3.isChecked()) {
                                //(D)DTO Conversion
                                String octal = dto(f);
                                res = res + "Octal: " + octal + '\n';
                            }
                            //DTH Conversion
                            if (cb4.isChecked()) {
                                //(D)DTH Conversion
                                res = res + "Hex: " + dth(f).toUpperCase();
                            }
                            if (!cb1.isChecked() && !cb2.isChecked() && !cb3.isChecked() && !cb4.isChecked()) {
                                Toast.makeText(getApplicationContext(),
                                        "Please select at least 1 checkbox!", Toast.LENGTH_SHORT).show();
                            }
                        }
                    }
                }

                //Binary RB
                else if(rg.getCheckedRadioButtonId() == rb2.getId())
                {
                    if( et1.getText().toString().length() <= 0 )
                    {
                        Toast.makeText(getApplicationContext(),
                                "Please Enter a Binary Number!", Toast.LENGTH_SHORT).show();
                        b = false;
                    }
                    else
                    {
                        //Check if the number entered is binary
                        for (int i = 0; i < f.length(); i++)
                        {
                            if (f.charAt(i) == '1' || f.charAt(i) == '0' || f.charAt(i) == '.') {
                                b = true;
                            } else {
                                b = false;
                                Toast.makeText(getApplicationContext(),
                                "Please Enter a Binary Number!", Toast.LENGTH_SHORT).show();
                                break;
                            }
                        }
                        if (b)
                        {
                            //BTD Conversion
                            if (cb1.isChecked()) {
                                //(B)BTD Conversion
                                String decimal = btd(f);
                                res = "Decimal: " + (decimal) + '\n';
                            }

                            //BTB Conversion
                            if (cb2.isChecked()) {
                                res = res + "Binary: " + f + '\n';
                            }

                            //BTO Conversion
                            if (cb3.isChecked()) {

                                //Step 1: Convert binary to decimal
                                //(B)BTD Conversion
                                String decimal = btd(f);

                                //Step 2: Convert decimal to octal
                                //(B)DTO Conversion
                                String octal = dto(decimal);
                                res = res + "Octal: " + octal + '\n';
                            }

                            //BTH Conversion
                            if (cb4.isChecked()) {
                                //Step 1: Convert Binary to Decimal
                                //(B)BTD Conversion
                                String d = btd(f);

                                //Step 2: Convert decimal to Hex
                                //(B)DTH Conversion
                                res = res + "Hex: " + dth(d).toUpperCase();
                            }
                            if (!cb1.isChecked() && !cb2.isChecked() && !cb3.isChecked() && !cb4.isChecked()) {
                                Toast.makeText(getApplicationContext(),
                                        "Please select at least 1 checkbox!", Toast.LENGTH_SHORT).show();
                            }
                        }
                    }
                }

                //Octal RB
                else if(rg.getCheckedRadioButtonId() == rb3.getId())
                {
                    if( et1.getText().toString().length() <= 0 )
                    {
                        Toast.makeText(getApplicationContext(),
                                "Please Enter a Octal Number!", Toast.LENGTH_SHORT).show();
                        b = false;
                    }
                    else
                    {
                        try
                        {
                            double number = Double.parseDouble(f);
                            while (number > 0) {
                                if (number % 10 <= 7) {
                                    b = true;
                                } else {
                                    b = false;
                                    break;
                                }
                                number /= 10;
                            }
                        } catch (Exception e) {
                            Toast.makeText(getApplicationContext(),
                                    "Please Enter an Octal Number!", Toast.LENGTH_SHORT).show();
                        }

                        if (b)
                        {
                            //OTD Conversion
                            if (cb1.isChecked())
                            {
                                res = "Decimal: " + otd(f) + '\n';
                            }
                            //OTB Conversion
                            if (cb2.isChecked()) {
                                //Step 1: Convert Octal to Decimal
                                //(O)OTD Conversion
                                String binary = otd(f);

                                //Step 2: Convert Decimal to Binary
                                //(O)DTB Conversion
                                res = res + "Binary: " + dtb(binary) + '\n';
                            }
                            //OTO Conversion
                            if (cb3.isChecked()) {
                                //OTO Conversion
                                res = res + "Octal: " + f + '\n';
                            }
                            //OTH Conversion
                            if (cb4.isChecked()) {
                                //Step 1: Convert Octal to Decimal
                                //(O)OTD Conversion
                                String hex = otd(f);

                                //Step 2: Convert Decimal to Binary
                                //(O)DTB Conversion
                                res = res + "Hex: " + dth(hex).toUpperCase();
                            }
                            if (!cb1.isChecked() && !cb2.isChecked() && !cb3.isChecked() && !cb4.isChecked()) {
                                Toast.makeText(getApplicationContext(),
                                        "Please select at least 1 checkbox!", Toast.LENGTH_SHORT).show();
                            }
                        }
                    }
                }

                //Hexa RB
                else if(rg.getCheckedRadioButtonId() == rb4.getId())
                {
                    if( et1.getText().toString().length() <= 0 )
                    {
                        Toast.makeText(getApplicationContext(),
                                "Please Enter a Hexadecimal Number!", Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        // Iterate over string
                        for (int i = 0; i < f.length(); i++) {
                            if ((f.charAt(i) >= '0' || f.charAt(i) <= '9') || (f.charAt(i) >= 'A' || f.charAt(i) <= 'F') || f.charAt(i) == '.')
                            {
                                b = true;
                            }
                            else
                            {
                                b = false;
                                Toast.makeText(getApplicationContext(),
                                        "Please Enter an Hexadecimal Number!", Toast.LENGTH_SHORT).show();
                                break;
                            }
                        }
                        if(b)
                        {
                            //HTD Conversion
                            if (cb1.isChecked()) {
                                //(H)HTD Conversion
                                res = "Decimal: "  + htd(f) + '\n';
                            }
                            //HTB Conversion
                            if (cb2.isChecked()) {
                                //Step 1: Convert Hex to Decimal
                                //(H)HTD Conversion
                                String binary = htd(f);

                                //Step 2: Convert Decimal to Binary
                                //(O)DTB Conversion
                                res = res + "Binary: " + dtb(binary) + '\n';
                            }
                            if (cb3.isChecked()) {
                                //Step 1: Convert Hex to Decimal
                                //(H)HTD Conversion
                                String octal = htd(f);

                                //Step 2: Convert Decimal to Octal
                                //(O)DTB Conversion
                                res = res + "Octal: " + dto(octal) + '\n';
                            }
                            if (cb4.isChecked()) {
                                res = res + "Hex: " + f;
                            }
                            if (!cb1.isChecked() && !cb2.isChecked() && !cb3.isChecked() && !cb4.isChecked()) {
                                Toast.makeText(getApplicationContext(),
                                        "Please select at least 1 checkbox!", Toast.LENGTH_SHORT).show();
                            }
                        }
                    }
                }
                else if(rg.getCheckedRadioButtonId() == -1)
                {
                    Toast.makeText(getApplicationContext(),
                    "Please select an Input Type!", Toast.LENGTH_SHORT).show();
                }
                tv4.setText(res);
            }
        });
    }
}