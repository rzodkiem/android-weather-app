package com.example.michal.myapplication;


import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by michal on 19.06.16.
 */
public class JSONParser{

    public JSONParser(){}

    public JSONObject getJSONFromUrl(String url){
        JSONObject responseObject = null;
        try{
            InputStream response = getStreamFromUrl(url);
            String stringResponse = getStringFromResponse(response);
            responseObject = new JSONObject(stringResponse);
        }catch(IOException e){
            System.out.println("Wyjebalo w czasie HTTP requesta...");
            e.printStackTrace();
        }catch(JSONException e){
            System.out.println("Wyjebalo w czasie parsowania JSON'a...");
            e.printStackTrace();
        }
        return responseObject;
    }

    private InputStream getStreamFromUrl(String urlString){
        InputStream responseContent = null;
        HttpURLConnection urlConnection = null;
        try {
            URL url = new URL(urlString);
            urlConnection = (HttpURLConnection)url.openConnection();
            responseContent = new BufferedInputStream(urlConnection.getInputStream());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }finally {
            urlConnection.disconnect();
        }
        return responseContent;
    }

    /*private InputStream getStreamFromUrl(String url) throws IOException {
        InputStream responseContent = null;
        HttpEntity entity = createApiCall(url);
        responseContent = entity.getContent();
        return responseContent;

    }

    private HttpEntity createApiCall(String url) throws IOException {
        DefaultHttpClient defaultHttpClient = new DefaultHttpClient();
        HttpGet httpGet = new HttpGet(url);
        HttpResponse response = defaultHttpClient.execute(httpGet);
        HttpEntity httpEntity = response.getEntity();
        return httpEntity;

    }*/


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
