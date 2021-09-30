package com.example.assignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class HomeActivity extends AppCompatActivity {

    TextView textViewTempInCentigrade;
    TextView textViewTempInFahrenheit;
    TextView textViewLatitude;
    TextView textViewLongitude;
    Button buttonShowResult;
    EditText cityName;

    private static final String key = "35c9f92ac5bf4df0811144140212307";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        textViewTempInCentigrade = findViewById(R.id.textViewTemperatureCentigrade);
        textViewTempInFahrenheit = findViewById(R.id.textViewTemperatureFahrenheit);
        textViewLatitude = findViewById(R.id.textViewLatitude);
        textViewLongitude = findViewById(R.id.textViewLongitude);

        buttonShowResult = findViewById(R.id.buttonShowResult);
        cityName = findViewById(R.id.CityName);

        Intent intent = getIntent();

        String district = intent.getStringExtra("StringDistrict");
        //String state = intent.getStringExtra("StringState");

        if (district != null) {
            cityName.setText(district);
        }

        buttonShowResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String city = cityName.getText().toString();
                process(city);

            }
        });
    }

    private void process(String city) {

        Call<Example> call = ApiControllerForWhether.getInstance()
                .apiSetWhether().getLocation(key,city);
        call.enqueue(new Callback<Example>() {
            @Override
            public void onResponse(Call<Example> call, Response<Example> response) {
                Example example = response.body();
                if (response.isSuccessful())
                {
                    if (response.code()==200)
                    {
                        Location location = example.getLocation();
                        Current current = example.getCurrent();
                        String latitude = location.getLat();
                        String longitude = location.getLon();
                        String tempInC = current.getTemp_c();
                        String tempInF = current.getTemp_f();
                        textViewLatitude.setText(latitude);
                        textViewLongitude.setText(longitude);
                        textViewTempInCentigrade.setText(tempInC);
                        textViewTempInFahrenheit.setText(tempInF);

                        textViewLatitude.setVisibility(View.VISIBLE);
                        textViewLongitude.setVisibility(View.VISIBLE);
                        textViewTempInCentigrade.setVisibility(View.VISIBLE);
                        textViewTempInFahrenheit.setVisibility(View.VISIBLE);
                    }
                    else
                    {
                        Toast.makeText(getApplicationContext(), "Error 400", Toast.LENGTH_SHORT).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<Example> call, Throwable t) {
                Toast.makeText(getApplicationContext(), ""+t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(HomeActivity.this, MainActivity.class));
        finish();
    }
}