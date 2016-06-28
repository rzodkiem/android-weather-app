package com.example.michal.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.michal.myapplication.model.WeatherApiResponse;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.concurrent.ExecutionException;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        WeatherApiCaller caller =new WeatherApiCaller();

        try{
            String response = caller.execute().get();
            ObjectMapper mapper = new ObjectMapper();
            mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            WeatherApiResponse weatherApiResponse = mapper.readValue(response, WeatherApiResponse.class);
        }catch(InterruptedException e){
            Log.i("Main", "Interrupted exception");
        }catch (ExecutionException e){
            Log.i("Main", "ExecutionException");

        }catch(IOException e){
            Log.i("Main", "IOException");
        }
    }
}
