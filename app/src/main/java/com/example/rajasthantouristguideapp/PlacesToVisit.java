package com.example.rajasthantouristguideapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class PlacesToVisit extends AppCompatActivity {
    private static final String LOG_TAG = MainActivity.class.getName();

    public static final String JAIPUR_INFORMATION_URL = "https://traveltriangle.com/blog/tourist-places-in-jaipur/";

    private VisitAdapter visitAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_places_to_visit);

        ArrayList<Visit> visits = new ArrayList<>();
        // visitAdapter
        visits.add(new Visit("JAIPUR", R.drawable.jaipur));
        visits.add(new Visit("UDAIPUR", R.drawable.udaipur));
        visits.add(new Visit("JODHPUR", R.drawable.jodhpur));
        visits.add(new Visit("JAISALMER", R.drawable.jaisalmerfort));
        visits.add(new Visit("BARMER", R.drawable.barmercityguide));
        visits.add(new Visit("CHITTORGARH", R.drawable.chittorgarh));
        visits.add(new Visit("BIKANER", R.drawable.bikaner));
        visits.add(new Visit("MOUNTABU", R.drawable.mountabu));

        visitAdapter = new VisitAdapter(PlacesToVisit.this, new ArrayList<Visit>());
        GridView gridView = (GridView) findViewById(R.id.gridview);
        gridView.setAdapter(visitAdapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Visit visit = visitAdapter.getItem(position);

                Uri jaipurUri = Uri.parse(JAIPUR_INFORMATION_URL);

                Intent websiteIntent = new Intent(Intent.ACTION_VIEW, jaipurUri);

                startActivity(websiteIntent);

            }
        });
        TouristAsyncTask touristAsyncTask = new TouristAsyncTask();
        touristAsyncTask.execute(JAIPUR_INFORMATION_URL);

    }

    private class TouristAsyncTask extends AsyncTask<String, Void, List<Visit>> {


        @Override
        protected List<Visit> doInBackground(String... urls) {
            // Don't perform the request if there are no URLs, or the first URL is null
            if (urls.length < 1 || urls[0] == null) {
                return null;
            }

            List<Visit> result = TouristUtil.fetchTouristData(urls[0]);
            return result;
        }


        @Override
        protected void onPostExecute(List<Visit> data) {


            // If there is a valid list of {@link Earthquake}s, then add them to the adapter's
            // data set. This will trigger the ListView to update.
            if (data != null && !data.isEmpty()) {
                visitAdapter.addAll(data);

            }
        }
    }
}