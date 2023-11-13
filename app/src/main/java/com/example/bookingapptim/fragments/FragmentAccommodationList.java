package com.example.bookingapptim.fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.ListFragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.bookingapptim.R;
import com.example.bookingapptim.adapter.AccommodationListAdapter;
import com.example.bookingapptim.databinding.FragmentMainBinding;
import com.example.bookingapptim.models.Accommodation;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentAccommodationList#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentAccommodationList extends ListFragment {

    private AccommodationListAdapter adapter;
    private static final String ARG_PARAM = "param";
    private ArrayList<Accommodation> accommodations;
    private FragmentMainBinding binding;

    public static FragmentAccommodationList newInstance(ArrayList<Accommodation> amenities){
        FragmentAccommodationList fragment = new FragmentAccommodationList();
        Bundle args = new Bundle();
        args.putParcelableArrayList(ARG_PARAM, amenities);
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.i("BookingBaboon", "onCreateView Amenities List Fragment");
        binding = FragmentMainBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        return root;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("BookingBaboon", "onCreate Amenities List Fragment");
        if (getArguments() != null) {
            accommodations = getArguments().getParcelableArrayList(ARG_PARAM);
            adapter = new AccommodationListAdapter(getActivity(), accommodations);
            setListAdapter(adapter);
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    @Override
    public void onListItemClick(@NonNull ListView l, @NonNull View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        // Handle the click on item at 'position'
    }
}