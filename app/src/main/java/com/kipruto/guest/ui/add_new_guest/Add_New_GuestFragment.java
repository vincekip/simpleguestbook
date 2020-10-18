package com.kipruto.guest.ui.add_new_guest;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.kipruto.guest.R;
import com.kipruto.guest.adapter.HomeAdapter;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;

public class Add_New_GuestFragment extends Fragment {
    EditText email, firstname, lastname, address, cell_no, comment;
    private HomeAdapter mMessageAdapter;
    private ListView mMessageListView;
    private FirebaseAuth auth;
    private static final String TAG = "RegisterActivity";
    private DatabaseReference reference;
    private FirebaseUser firebaseUser;
    private FirebaseDatabase mFirebaseDatabase;

    private Add_New_GuestViewModel dashboardViewModel;
    private static final int GET_FROM_GALLERY = 0;
    private ImageView profilepicset;
    private List<Adapter> mUSers;

    public Add_New_GuestFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        dashboardViewModel = ViewModelProviders.of(requireActivity()).get(Add_New_GuestViewModel.class);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mUSers = new ArrayList<>();
        /**dashboardViewModel = ViewModelProviders.of(this).get(Add_New_GuestViewModel.class);**/
        View root = inflater.inflate(R.layout.fragment_add_new_guest, container, false);

        return root;
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        profilepicset = view.findViewById(R.id.profielpic);

        firstname = view.findViewById(R.id.fname);
        lastname = view.findViewById(R.id.lname);
        email = view.findViewById(R.id.mail);
        cell_no = view.findViewById(R.id.cnumber);
        address = view.findViewById(R.id.mage);
        comment = view.findViewById(R.id.cmment);
       final TextView timeset = view.findViewById(R.id.timeset);
        Button saveBtn = view.findViewById(R.id.save_button);


        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //String user_id = auth.getCurrentUser().getUid();
                DatabaseReference current_user_db = FirebaseDatabase.getInstance().getReference().child("Visitors");

                String fname = firstname.getText().toString();
                String lname = lastname.getText().toString();
                String mail = email.getText().toString();
                String tellno = cell_no.getText().toString();
                String mage = address.getText().toString();
                String cmment = comment.getText().toString();
                String timsets = timeset.getText().toString();


                Map<String, String> newPost = new HashMap();
                //newPost.put("id", user_id);
                newPost.put("first_Name", fname);
                newPost.put("last_Name", lname);
                newPost.put("email", mail);
                newPost.put("cellphone", tellno);
                newPost.put("address", mage);
                newPost.put("comment", cmment);
                newPost.put("time",timsets);

                current_user_db.push().setValue(newPost).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if(task.isSuccessful()){
                            firstname.setText("");
                            lastname.setText("");
                            email.setText("");
                            cell_no.setText("");
                            address.setText("");
                            comment.setText("");

                        }else{}
                    }
                });
            }
        });

    }

    public static class TimeClass {
        @RequiresApi(api = Build.VERSION_CODES.O)
        public static void main(String[] args) {
            LocalDateTime myDateObj = LocalDateTime.now();
            System.out.println("Before formatting: " + myDateObj);
            DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

            String formattedDate = myDateObj.format(myFormatObj);
            System.out.println("After formatting: " + formattedDate);
        }
    }

    private void profilepicupload() {
        Intent intenter = new Intent();
        intenter.setType("image/*");
        intenter.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intenter, "Select Profile Picture"), GET_FROM_GALLERY);
    }

    @Override
    public void onActivityResult ( int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        //Detects request codes
        if (requestCode == GET_FROM_GALLERY && resultCode == Activity.RESULT_OK) {
            Uri imageUri = data.getData();
            profilepicset.setImageURI(imageUri);
        }
    }


}