package com.evacuationapp.finalevacuationapp;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ListFragmentNearestEvacuation#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ListFragmentNearestEvacuation extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ListFragmentNearestEvacuation() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ListFragmentNearestEvacuation.
     */
    // TODO: Rename and change types and number of parameters
    public static ListFragmentNearestEvacuation newInstance(String param1, String param2) {
        ListFragmentNearestEvacuation fragment = new ListFragmentNearestEvacuation();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }
    DatabaseReference databaseReference;
    FirebaseDatabase firebaseDatabase;
    List<Places> placesList = new ArrayList<>();
    Places places;
    ListView listView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View view=inflater.inflate(R.layout.fragment_list_nearest_evacuation, container, false);
        listView = view.findViewById(R.id.listview);
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference("evacuation");
        placesList.clear();
        databaseReference.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                placesList.add(snapshot.getValue(Places.class));
                MyAdapter myAdapter = new MyAdapter(getActivity(), placesList);
                listView.setAdapter(myAdapter);
            }


            @Override
            public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot snapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }


        });

        return view;
    }


    public class MyAdapter extends BaseAdapter {
        Context context;
        List<Places> stringList;
        TextView txtPlace;
        ImageView imgPlace;

        public MyAdapter(Context context, List<Places> stringList) {
            this.context = context;
            this.stringList = stringList;
        }

        @Override
        public int getCount() {
            return stringList.size();
        }

        @Override
        public Object getItem(int i) {
            return i;
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        Latitude lt = new Latitude();

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            view = LayoutInflater.from(context).inflate(R.layout.places_layout_nearest, viewGroup, false);
            txtPlace = view.findViewById(R.id.txtCity);
            imgPlace = view.findViewById(R.id.imgPlace);

            txtPlace.setText(
                     " Name : " + stringList.get(i).getEvacuationName() +
                    "\n Number : " + stringList.get(i).getEvacuationNumber() +
                    "\n Evacuation Barangay : " + stringList.get(i).getEvacuationBarangay() +
                    "\n Evacuation Calamity Type : " + stringList.get(i).getEvacuationCalamityType() +
                    "\n City : " + stringList.get(i).getStreetAddress() +
                    "\n State: " + stringList.get(i).getState() +
                    "\n Country: " + stringList.get(i).getCountry()+
                    "\n Distance KM : " +   String.valueOf(String.format("%.02f",(haversine(lt.getuserLatitude(),lt.getuserLongitude(),placesList.get(i).getLatitude(), placesList.get(i).getLongitude())))));

            try {

                byte[] imageAsByte = Base64.decode(placesList.get(i).getImage().getBytes(), Base64.DEFAULT);
                Bitmap bitmap = BitmapFactory.decodeByteArray(imageAsByte, 0, imageAsByte.length);
                imgPlace.setImageBitmap(bitmap);

            }catch (Exception e){}
            return view;
        }
    }

    public static double haversine(double lat1, double lon1,
                                   double lat2, double lon2) {
        // distance between latitudes and longitudes
        double dLat = Math.toRadians(lat2 - lat1);
        double dLon = Math.toRadians(lon2 - lon1);

        // convert to radians
        lat1 = Math.toRadians(lat1);
        lat2 = Math.toRadians(lat2);

        // apply formulae
        double a = Math.pow(Math.sin(dLat / 2), 2) +
                Math.pow(Math.sin(dLon / 2), 2) *
                        Math.cos(lat1) *
                        Math.cos(lat2);
        double rad = 6371;
        double c = 2 * Math.asin(Math.sqrt(a));
        return rad * c;

    }

}