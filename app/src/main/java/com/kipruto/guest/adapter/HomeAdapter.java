package com.kipruto.guest.adapter;

import android.app.Activity;
import android.content.Context;
import android.database.DataSetObserver;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;

import com.kipruto.guest.R;
import com.kipruto.guest.model.Home;
import com.kipruto.guest.ui.add_new_guest.Add_New_GuestFragment;

import java.util.ArrayList;
import java.util.List;

public class HomeAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements ListAdapter {

    Context context;
    List<Home> homes;

    public HomeAdapter(Context context, List<Home> homes) {
        this.context = context;
        this.homes = homes;
    }

    public HomeAdapter(Add_New_GuestFragment add_new_guestFragment, int fragment_home, List<Home> homess) {
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.user_item,parent,false);
        return new RecyclerViewViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Home home = homes.get(position);
       /**RecyclerViewViewHolder viewHolder= (RecyclerViewViewHolder) holder;
        viewHolder.txtView_username.setText(home.getFirstName());**/
    }

    @Override
    public int getItemCount() {
        return homes.size();
    }

    @Override
    public boolean areAllItemsEnabled() {
        return false;
    }

    @Override
    public boolean isEnabled(int i) {
        return false;
    }

    @Override
    public void registerDataSetObserver(DataSetObserver dataSetObserver) {

    }

    @Override
    public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {

    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        return null;
    }

    @Override
    public int getViewTypeCount() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    class RecyclerViewViewHolder extends RecyclerView.ViewHolder {
        private ImageView imgView_icon;
        private TextView txtView_username;
        TextView txtView_lname;

        public RecyclerViewViewHolder(@NonNull View itemView) {
            super(itemView);
            imgView_icon = itemView.findViewById(R.id.profile_image);
            txtView_username = itemView.findViewById(R.id.username);
        }
        public ImageView getImgView_icon(){
            return imgView_icon;
        }

        public TextView getTxtView_username() {
            return txtView_username;
        }
    }
}
