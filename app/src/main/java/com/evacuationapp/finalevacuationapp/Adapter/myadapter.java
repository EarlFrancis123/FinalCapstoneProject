package com.evacuationapp.finalevacuationapp.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.evacuationapp.finalevacuationapp.R;
import com.evacuationapp.finalevacuationapp.Model.model;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;


public class myadapter extends FirebaseRecyclerAdapter<model,myadapter.myviewholder>
{
    public myadapter(@NonNull FirebaseRecyclerOptions<model> options)
    {
        super(options);
    }


    @Override
    protected void onBindViewHolder(@NonNull final myviewholder holder, final int position, @NonNull final model model) {
        holder.name.setText("Name: "+model.getFirstName() + " "+ model.getLastName());
        holder.middleName.setText("Middle Name: "+model.getMiddleName());
        holder.contactNum.setText("Contact Number: "+model.getContactInfo());
        holder.address.setText("Address: "+model.getStreetAddress()+", "+model.getState()+",");
        holder.country.setText("                 "+model.getCountry());
        holder.gender.setText("Gender: "+model.getGender());
        holder.headFamily.setText("Head of Family: "+model.getHeadOfFamily());
        holder.evacuation.setText("Evacuation: "+model.getEvacuationName());

    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.singlerow,parent,false);
        return new myviewholder(view);
    }


    class myviewholder extends RecyclerView.ViewHolder
    {
        TextView name,middleName,contactNum, address,country, gender,headFamily, evacuation,imageview;
        public myviewholder(@NonNull View itemView)
        {
            super(itemView);

            name=(TextView)itemView.findViewById(R.id.nameTV);
            middleName =(TextView)itemView.findViewById(R.id.middleTV);
            contactNum=(TextView)itemView.findViewById(R.id.contactTV);
            address=(TextView)itemView.findViewById(R.id.addressTV);
            country=(TextView)itemView.findViewById(R.id.countryTV);
            gender=(TextView)itemView.findViewById(R.id.genderTV);
            headFamily=(TextView)itemView.findViewById(R.id.headTV);
            evacuation=(TextView)itemView.findViewById(R.id.evacuationTV);


        }
    }
}
