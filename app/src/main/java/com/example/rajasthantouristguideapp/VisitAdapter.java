package com.example.rajasthantouristguideapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class VisitAdapter  extends ArrayAdapter<Visit> {
    Context context;


    public VisitAdapter(@NonNull Context context, @NonNull List<Visit> objects) {
        super(context, 0, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View gridView = convertView;
        if (gridView == null) {
            gridView = LayoutInflater.from(getContext()).inflate(R.layout.grid, parent, false);
        }
        Visit currentVisit = getItem(position);

        TextView city = (TextView) gridView.findViewById(R.id.cityTV);
        city.setText(currentVisit.getCityname());
      //  Toast.makeText(context, , Toast.LENGTH_SHORT).show();

        ImageView imageView = (ImageView) gridView.findViewById(R.id.imagePV);
        imageView.setImageResource(currentVisit.getImage());

//     //   ImageView imageView1 = (ImageView)gridView.findViewById(R.id.imagePV);
//        imageView.setOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View v) {
//                if (city.equals("JAIPUR")){
//               getContext().startActivity(new Intent(getContext(),Jaipur.class));
//            }
//}
//        });
  //  ImageView imageView1 = (ImageView)gridView.findViewById(R.id.imagePV);
    imageView.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (currentVisit.getCityname().equals("JAIPUR")) {
              //  Intent intent = new Intent(getContext(), Jaipur.class);
                getContext().startActivity(new Intent(getContext(), Jaipur.class));
                //   getContext().startActivity(intent);
            }
            else if (currentVisit.getCityname().equals("UDAIPUR")){
                getContext().startActivity(new Intent(getContext(),Udaipur.class));
            }
            else if (currentVisit.getCityname().equals("JODHPUR")){
                getContext().startActivity(new Intent(getContext(),Jodhpur.class));
            }
            else if (currentVisit.getCityname().equals("JAISALMER")){
                getContext().startActivity(new Intent(getContext(),Jaislamer.class));
            }
            else if (currentVisit.getCityname().equals("BARMER")){
                getContext().startActivity(new Intent(getContext(),Barmer.class));
            }
            else if (currentVisit.getCityname().equals("CHITTORGARH")){
                getContext().startActivity(new Intent(getContext(),Chittorgarh.class));
            }
            else if (currentVisit.getCityname().equals("BIKANER")){
                getContext().startActivity(new Intent(getContext(),Bikaner.class));
            }
            else{
                getContext().startActivity(new Intent(getContext(),Montabu.class));
            }
        }
    });
        return gridView;
    }
    }

