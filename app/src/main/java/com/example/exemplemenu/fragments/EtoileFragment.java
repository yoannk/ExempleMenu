package com.example.exemplemenu.fragments;

import android.os.Bundle;

import android.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.exemplemenu.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class EtoileFragment extends Fragment {

    public EtoileFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_etoile, container, false);
    }
}
