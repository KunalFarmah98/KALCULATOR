package com.example.kunalfarmah.kalculator;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.Toast;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class UsageFragment extends Fragment {

    MainActivity var;
    RecyclerView rec;

            FrameLayout frag;
    Button extra;

    public UsageFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_usage, container, false);

        rec = view.findViewById(R.id.Rv);
        RecyclerAdapter rvadapter = new RecyclerAdapter();

        rec.setAdapter(rvadapter);
        rec.setLayoutManager(new LinearLayoutManager(getContext()));

        return view;

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        frag=getActivity().findViewById(R.id.frag);
        extra =getActivity().findViewById(R.id.sci1);

        if(extra != null)
            extra.setVisibility(View.GONE);
        Toast.makeText(getContext(), "onCreate_frag", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Toast.makeText(getContext(), "onActivityCreated", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onStart() {
        super.onStart();
        Toast.makeText(getContext(), "onStart_frag", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onResume() {
        super.onResume();
        Toast.makeText(getContext(), "onResume_frag", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onPause() {
        super.onPause();
        frag.setVisibility(View.GONE);
        extra.setVisibility(View.VISIBLE);
        Toast.makeText(getContext(), "onPause_frag", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onStop() {
        super.onStop();
        Toast.makeText(getContext(), "onStop_frag", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Toast.makeText(getContext(), "onAttatch", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Toast.makeText(getContext(), "onDestroy_frag", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Toast.makeText(getContext(), "onDestroyView", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Toast.makeText(getContext(), "onDetach", Toast.LENGTH_SHORT).show();
    }

}
