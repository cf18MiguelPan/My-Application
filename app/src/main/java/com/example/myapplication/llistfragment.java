package com.example.myapplication;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link llistfragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class llistfragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public llistfragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment llistfragment.
     */
    // TODO: Rename and change types and number of parameters
    public static llistfragment newInstance(String param1, String param2) {
        llistfragment fragment = new llistfragment();
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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View viewList = inflater.inflate(R.layout.fragment_llistfragment,container,false);

        ArrayList<String> array_noms = new ArrayList<String>();
        //List of String
        array_noms.add(new String("1"));
        array_noms.add(new String("2"));
        array_noms.add(new String("3"));
        array_noms.add(new String("4"));
        array_noms.add(new String("5"));
        array_noms.add(new String("6"));
        array_noms.add(new String("7"));
        array_noms.add(new String("8"));
        array_noms.add(new String("9"));
        array_noms.add(new String("10"));
        array_noms.add(new String("11"));
        array_noms.add(new String("12"));
        array_noms.add(new String("13"));
        array_noms.add(new String("14"));
        array_noms.add(new String("15"));

        RecyclerView recyclerView = viewList.findViewById(R.id.recyclerView);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(array_noms);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        return viewList;

    }
}