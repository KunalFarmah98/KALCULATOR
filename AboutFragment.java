package com.example.kunalfarmah.kalculator;


import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import static android.view.View.GONE;
import static android.view.View.getDefaultSize;


/**
 * A simple {@link Fragment} subclass.
 */
public class AboutFragment extends Fragment {

    MainActivity var;

    FrameLayout frag;
    Button extra;

    TextView email;
    TextView fb;
    TextView number;


    public AboutFragment() {
        // Required empty public constructor
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
//        Toast.makeText(getContext(), "onCreateview", Toast.LENGTH_SHORT).show();


        // Inflate the layout for this fragment


       View view =  inflater.inflate(R.layout.fragment_about, container, false);



        email= (TextView)view.findViewById(R.id.email);
        fb= (TextView)view.findViewById(R.id.fb);
        number = view.findViewById(R.id.extra1);

        email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SENDTO);
                intent.setData(Uri.parse("mailto:"));
                intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"kunalfarmah98@gmail.com"});
                try {
                    startActivity(intent);
                    getActivity().getSupportFragmentManager().popBackStack();
                }catch(ActivityNotFoundException e){
                   Toast.makeText(getContext(),"No Email Apps found on the device",Toast.LENGTH_SHORT).show();
                }
            }
        });

        fb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://www.facebook.com/kunal.farmah";
                Intent fb= new Intent(Intent.ACTION_VIEW);
                fb.setData(Uri.parse(url));
                try {
                    startActivity(fb);
                    getActivity().getSupportFragmentManager().popBackStack();
                }catch(ActivityNotFoundException e){
                    Toast.makeText(getContext(),"No Web Browsers found on the device",Toast.LENGTH_SHORT).show();
                }

            }
        });

        number.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:"+ "+919654211634"));

                startActivity(intent);
                getActivity().getSupportFragmentManager().popBackStack();
            }
        });


       return view;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        getActivity().setTitle("ABOUT ME");

        frag = getActivity().findViewById(R.id.frag);
        extra = getActivity().findViewById(R.id.sci1);


        extra.setVisibility(View.GONE);


    }


    @Override
    public void onStart() {
        super.onStart();
        getActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);



    }


    @Override
    public void onPause() {
        super.onPause();
        frag.setVisibility(GONE);
        extra.setVisibility(View.VISIBLE);
        getActivity().setTitle(R.string.app_name);

    }
}

