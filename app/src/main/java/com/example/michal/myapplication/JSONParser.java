package com.example.michal.myapplication;


import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.CookieHandler;
import java.net.CookieManager;
import java.net.CookiePolicy;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by michal on 19.06.16.
 */
public class JSONParser{

    public JSONParser(){}

    public String getJSONFromUrl(String url){
        String stringResponse = null;
        try{
            InputStream response = getStreamFromUrl(url);
            stringResponse = getStringFromResponse(response);
            //responseObject = new JSONObject(stringResponse);
        }catch(IOException e){
            System.out.println("Wyjebalo w czasie HTTP requesta...");
            e.printStackTrace();
        }
        return stringResponse;
    }

    private InputStream getStreamFromUrl(String urlString){
        InputStream responseContent = null;
        HttpURLConnection urlConnection = null;
        CookieHandler.setDefault( new CookieManager( null, CookiePolicy.ACCEPT_ALL ) );
        try {
            URL url = new URL(urlString);
            urlConnection = (HttpURLConnection)url.openConnection();
            int responseCode = urlConnection.getResponseCode();
            Object object = urlConnection.getContent();
            //OutputStream os = urlConnection.getOutputStream();
            InputStream test = urlConnection.getInputStream();
            responseContent = new BufferedInputStream(urlConnection.getInputStream());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }finally {
           // urlConnection.disconnect();
        }
        return responseContent;
    }



    private String getStringFromResponse(InputStream stream) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(
                stream, "iso-8859-1"), 8);
        StringBuilder sb = new StringBuilder();
        String line = null;
        while ((line = reader.readLine()) != null) {
            sb.append(line + "n");
        }
        stream.close();
        return sb.toString();
    }


}
