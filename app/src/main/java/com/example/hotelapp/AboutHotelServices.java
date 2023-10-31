package com.example.hotelapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class AboutHotelServices extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_hotel_services);

        RecyclerView recyclerView = findViewById(R.id.recyclerview_hotel);

        List<HotelServices> servicesOffered = new ArrayList<HotelServices>();
        servicesOffered.add(new HotelServices(R.drawable.foodimage2,"",""));
        servicesOffered.add(new HotelServices(R.drawable.foodimage,"Food", "GrandView Hotel's premier Michelin-starred dining destination serves Modern European cuisine paired with breathtaking views of the Bund, Huangpu River and Pudong skyline. Awarded one Michelin star by The Michelin Guide Shanghai 2023"));
        servicesOffered.add(new HotelServices(R.drawable.swimmingpool1,"", ""));
        servicesOffered.add(new HotelServices(R.drawable.swimmingpool2,"", ""));
        servicesOffered.add(new HotelServices(R.drawable.swimmingpool3,"Swimming pool", "Breathtaking is the only word to describe The GrandView hotels indoor heated swimming pool, complete with an Art Deco fireplace. The pool and surrounding area, with doors to the outdoor terrace, are clad in intense navy blue and white tiling.  At 82 ft (25m) long, 24.6 ft (7.5m) wide and 4.4 ft (1.35 m) deep, the pool is large enough for swimming laps. Additional facilities include a steam room and sauna. After a dip, wind down on the terrace and enjoy a Naturally Peninsula meal, specially designed to be healthy, nutritious and low in fat and cholesterol, while overlooking the lush green landscape of the garden."));
        servicesOffered.add(new HotelServices(R.drawable.gym1,"", ""));
        servicesOffered.add(new HotelServices(R.drawable.gym2,"", ""));
        servicesOffered.add(new HotelServices(R.drawable.gym3,"Gym", "Professional personal trainers are at guests’ disposal to offer expert advice and guidance at The Fitness Centre, which is fully equipped with the latest Life Fitness gym equipment, comprehensive free weights, treadmills, cardiovascular equipment and exercise balls. All machines have built-in TV and audio facilities."));

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new AboutAdapter(getApplicationContext(), servicesOffered));
    }
}