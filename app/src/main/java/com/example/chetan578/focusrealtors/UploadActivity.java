package com.example.chetan578.focusrealtors;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

public class UploadActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    DatabaseReference databaseReference;
static  int i=0;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater=getMenuInflater();
        menuInflater.inflate(R.menu.main_menu,menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId())
        {
            case R.id.signout:
                FirebaseAuth.getInstance().signOut();
                Intent intent=new Intent(UploadActivity.this,LoginActivity.class);
                startActivity(intent);

        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload);
        int i=1;
        databaseReference = FirebaseDatabase.getInstance().getReference("restaurants");
        databaseReference.keepSynced(true);
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


    }
    @Override
    protected void onStart() {
        super.onStart();
        FirebaseRecyclerAdapter<restaurant, restaurantViewHolder> FirebaseRecyclerAdapter = new FirebaseRecyclerAdapter<restaurant, restaurantViewHolder>
                (restaurant.class, R.layout.restaurant_row,restaurantViewHolder.class , databaseReference) {
            @Override
            protected void populateViewHolder(restaurantViewHolder viewHolder, restaurant model, int position) {
        viewHolder.setName(model.getName());
        viewHolder.setImage(getApplicationContext(),model.getImage());
        viewHolder.setLocation(model.getLocation());
        viewHolder.setExpense(model.getExpense());
            }
        };
        recyclerView.setAdapter(FirebaseRecyclerAdapter);
    }
    public static class restaurantViewHolder extends RecyclerView.ViewHolder{
      View mView;

      public  restaurantViewHolder(View itemView)
      {
          super(itemView);
          mView=itemView;
      }
      public void setName(String name){
          TextView restaurant_name=mView.findViewById(R.id.restaurant_name);
          restaurant_name.setText(name);
      }

      public  void setImage(Context ctx, String Myimage)
      {
          ImageView restaurant_image=mView.findViewById(R.id.restaurant_image);
          Picasso.with(ctx).load(Myimage).into(restaurant_image);
      }
      public void setLocation(String location)
      {
          TextView restaurant_location=mView.findViewById(R.id.restaurant_location);
          restaurant_location.setText(location);
      }
        public void setExpense(String expense){
            TextView restaurant_expense=mView.findViewById(R.id.restaurant_price);
            restaurant_expense.setText(expense);
        }

    }

}