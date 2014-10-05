package com.calhacksproject.teamfunkybeefwrapthings.movietrak;

import android.app.Activity;
import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by nick on 10/4/14.
 */
public class RequestTask extends AsyncTask<String, String, String>
{
    // make a request to the specified url
    public JSONObject publicJsonResponse = new JSONObject();

    private ListView listView;
    private Activity activity;

    public RequestTask(ListView listView, Activity act) {
        this.listView = listView;
        this.activity = act;
    }

    @Override
    protected String doInBackground(String... uri)
    {
        // BROKEN encode url
        String url = uri[0];

        Log.d("uri", url);
        HttpClient httpclient = new DefaultHttpClient();
        HttpResponse response;
        String responseString = null;
        try
        {
            // make a HTTP request
            response = httpclient.execute(new HttpGet(url));
            StatusLine statusLine = response.getStatusLine();
            if (statusLine.getStatusCode() == HttpStatus.SC_OK)
            {
                // request successful - read the response and close the connection
                ByteArrayOutputStream out = new ByteArrayOutputStream();
                response.getEntity().writeTo(out);
                out.close();
                responseString = out.toString();
            }
            else
            {
                // request failed - close the connection
                response.getEntity().getContent().close();
                throw new IOException(statusLine.getReasonPhrase());
            }
        }
        catch (Exception e)
        {
            System.out.println(e);
            Log.d("Test", "Couldn't make a successful request!");
        }
        return responseString;
    }


    // if the request above completed successfully, this method will
    // automatically run so you can do something with the response
    //@Override
    protected void onPostExecute(String response)
    {
        super.onPostExecute(response);

        if (response != null)
        {
            try
            {
                // convert the String response to a JSON object,
                // because JSON is the response format Rotten Tomatoes uses
                JSONObject jsonResponse = new JSONObject(response);

                // fetch the array of movies in the response
                JSONArray movies = jsonResponse.getJSONArray("movies");

                //list to hold movie names
                ArrayList<Movie> movieContainer = new ArrayList<Movie>();
                // add each movie's title to an array
                String[] movieTitles = new String[movies.length()];
                for (int i = 0; i < movies.length(); i++)
                {
                    JSONObject movie = movies.getJSONObject(i);
                    movieTitles[i] = movie.getString("title");
                    Movie m = new Movie();
                    m.setTitle((String) movie.get("title"));
                    Object release_dates = movie.get("release_dates");
                    System.out.println(release_dates);
                     Class<?> clazz = release_dates.getClass();

                        String dvd = null;
                        try {
                            System.out.println("CLAZZ");
                            System.out.println(clazz);
                            Field field = clazz.getField("dvd"); //Note, this can throw an exception if the field doesn't exist.m.setDateDVD((String) ((Object) movie.get("release_dates")).get("dvd"));

                           // dvd = field.get(release_dates).toString();
                            dvd = release_dates.toString().split("\"")[3];
                        }



                         catch (NoSuchFieldException e) {
                            e.printStackTrace();
                        }
                        if ( dvd == null) {
                            m.setDateDVD("None");
                        }
                        else {
                            m.setDateDVD(dvd);
                        }


                    movieContainer.add(m);
                    Log.d("This is the date", m.getDateDVD());
                }
                publicJsonResponse = jsonResponse;
                //Log.d("json" , jsonResponse.toString());

                OurAdapter adapter1 = new OurAdapter(movieContainer, activity );

                listView.setAdapter(adapter1);


                listView.invalidate();


//                listView.getAdapter().getView(0, tv,/**/ null);
//                listView. deferNotifyDataSetChanged();

//                listView.addView(tv);

                //refreshMoviesList(movieTitles);
                //ArrayList<String> modeAdapter = new ArrayList<String>(this, android.R.layout.simple_list_item_1, android.R.id.text1, movieTitles);

            }
            catch (JSONException e)
            {
                System.out.println(e);

                Log.d("Test", "Failed to parse the JSON response!");
            }
        }
    }
}

    //Actual app code begins here


