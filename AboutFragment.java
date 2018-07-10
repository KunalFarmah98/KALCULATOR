package com.example.kunalfarmah.kalculator;


import android.content.Context;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.Toast;

import static android.view.View.GONE;


/**
 * A simple {@link Fragment} subclass.
 */
public class AboutFragment extends Fragment {

    MainActivity var;

    FrameLayout frag;
    Button extra;


    public AboutFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
//        Toast.makeText(getContext(), "onCreateview", Toast.LENGTH_SHORT).show();
        getActivity().setTitle("ABOUT ME");

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_about, container, false);
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {


        frag = getActivity().findViewById(R.id.frag);
        extra = getActivity().findViewById(R.id.sci1);

        extra.setVisibility(View.GONE);

        super.onCreate(savedInstanceState);
//        Toast.makeText(getContext(), "onCreate_frag", Toast.LENGTH_SHORT).show();
    }


    @Override
    public void onStart() {
        super.onStart();
        getActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        //  Toast.makeText(getContext(), "onStart_frag", Toast.LENGTH_SHORT).show();

    }

//    @Override
//    public void onResume() {
//        super.onResume();
//        Toast.makeText(getContext(), "onResume_frag", Toast.LENGTH_SHORT).show();
//    }
//
    @Override
    public void onPause() {
        super.onPause();
        frag.setVisibility(GONE);
        extra.setVisibility(View.VISIBLE);
        getActivity().setTitle(R.string.app_name);
//        Toast.makeText(getContext(), "onPause_frag", Toast.LENGTH_SHORT).show();
    }
}
//
//    @Override
//    public void onStop() {
//        frag.setVisibility(GONE);
//        super.onStop();
//        Toast.makeText(getContext(), "onStop_frag", Toast.LENGTH_SHORT).show();
//    }
//
//    @Override
//    public void onAttach(Context context) {
//        super.onAttach(context);
//        Toast.makeText(getContext(), "onAttatch", Toast.LENGTH_SHORT).show();
//    }
//
//    @Override
//    public void onDestroy() {
//        super.onDestroy();
//        Toast.makeText(getContext(), "onDestroy_frag", Toast.LENGTH_SHORT).show();
//    }
//
//    @Override
//    public void onDestroyView() {
//        super.onDestroyView();
//        Toast.makeText(getContext(), "onDestroyView", Toast.LENGTH_SHORT).show();
//    }
//
//    @Override
//    public void onDetach() {
//        super.onDetach();
//        Toast.makeText(getContext(), "onDetach", Toast.LENGTH_SHORT).show();
//    }
//
//}
