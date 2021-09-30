package com.example.assignment;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.DebugUtils;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;

public class MainActivity extends AppCompatActivity {

    EditText phoneNumber, pinCode, datePickerEditText, fullName, address1, address2;
    Button buttonCheck, button2;
    TextView district, state;
    Spinner spinner;
    ImageView datePicker;
    ArrayAdapter<CharSequence> arrayAdapter;
    int year, month, day;
    String textGender, StringDistrict, StringState;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonCheck = findViewById(R.id.button);
        button2 = findViewById(R.id.button2);
        pinCode = findViewById(R.id.pinCode);
        district = findViewById(R.id.district);
        state = findViewById(R.id.state);
        datePickerEditText = findViewById(R.id.datepickerEditText);
        phoneNumber = findViewById(R.id.phoneNumber);
        fullName = findViewById(R.id.fullName);
        address1 = findViewById(R.id.address1);
        address2 = findViewById(R.id.address2);
        datePicker = findViewById(R.id.datepicker);
        spinner  = findViewById(R.id.spinner);
        district.setVisibility(View.INVISIBLE);
        state.setVisibility(View.INVISIBLE);


        arrayAdapter = ArrayAdapter.createFromResource(this, R.array.dropdown, android.R.layout.simple_spinner_item);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(arrayAdapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                textGender = adapterView.getItemAtPosition(i).toString();
                //Toast.makeText(getApplicationContext(), "" + text, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        Calendar c = Calendar.getInstance();
        datePicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                year = c.get(Calendar.YEAR);
                month = c.get(Calendar.MONTH);
                day = c.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog dialog = new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                        datePickerEditText.setText(i+"/" + i1 + "/" +i2);
                    }
                },year, month,day);
                dialog.show();
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editTextValidation();
            }
        });

        pinCode.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                String pin = pinCode.getText().toString().trim();
                buttonCheck.setEnabled(!pin.isEmpty());
                buttonCheck.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        process(pin);
                    }
                });
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

    }

    private void editTextValidation() {

        String phone = phoneNumber.getText().toString();
        String name = fullName.getText().toString();
        String dob = datePickerEditText.getText().toString();
        String addressLine1 = address1.getText().toString();
        String addressLine2 = address2.getText().toString();
        String pincodeEditText = pinCode.getText().toString();

        if (TextUtils.isEmpty(phone))
        {
            phoneNumber.setError("Phone number cannot be empty");
            phoneNumber.requestFocus();
        }
        else if (TextUtils.isEmpty(name))
        {
            fullName.setError("Please enter name");
            fullName.requestFocus();
        }
        else if (TextUtils.isEmpty(dob))
        {
            datePickerEditText.setError("DOB cannot be empty");
            datePickerEditText.requestFocus();
        }
        else if (TextUtils.isEmpty(addressLine1))
        {
            address1.setError("Address cannot be empty");
            address1.requestFocus();
        }
        else if (TextUtils.isEmpty(pincodeEditText))
        {
            pinCode.setError("Pincode cannot be empty");
            pinCode.requestFocus();
        }
        else {
            Intent intent = new Intent(MainActivity.this, HomeActivity.class);
            intent.putExtra("StringDistrict", StringDistrict);
            intent.putExtra("StringState", StringState);


            if (StringDistrict != null)
            {
                Toast.makeText(getApplicationContext(), "Registration Success", Toast.LENGTH_SHORT).show();
                startActivity(intent);
                finish();
            }
            else
            {
                Toast.makeText(getApplicationContext(), "Enter pin code then click check button", Toast.LENGTH_LONG).show();
            }

        }
    }

    private void process(String pin) {

        Call<List<Response>> call = ApiController.getInstance().apiSet()
                .getDataByPinCode(pin);
        call.enqueue(new Callback<List<Response>>() {
            @Override
            public void onResponse(Call<List<Response>> call, retrofit2.Response<List<Response>> response) {

                Response response1 = response.body().get(0);
                if (response1.getStatus().equals("Success"))
                {
                    List<PostOffice> postOfficeList = response1.getPostOffice();
                    StringDistrict = postOfficeList.get(0).getDistrict();
                    StringState = postOfficeList.get(0).getState();
                    //Toast.makeText(getApplicationContext(), "" + district, Toast.LENGTH_SHORT).show();
                    //Toast.makeText(getApplicationContext(), "" + state, Toast.LENGTH_SHORT).show();
                    district.setVisibility(View.VISIBLE);
                    district.setText(StringDistrict);
                    state.setVisibility(View.VISIBLE);
                    state.setText(StringState);
                }
                else{
                    Toast.makeText(getApplicationContext(), "PLease enter a valid Pincode", Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onFailure(Call<List<Response>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "" + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });



    }
}