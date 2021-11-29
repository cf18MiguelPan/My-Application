package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import java.util.Locale;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link fragmentHome#newInstance} factory method to
 * create an instance of this fragment.
 */
public class fragmentHome extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public fragmentHome() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment fragmentHome.
     */
    // TODO: Rename and change types and number of parameters
    public static fragmentHome newInstance(String param1, String param2) {
        fragmentHome fragment = new fragmentHome();
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

        View viewForm = inflater.inflate(R.layout.fragment_home, container, false);

        Button btnes = viewForm.findViewById(R.id.btnEs);          //button to change spanish
        Button btnca = viewForm.findViewById(R.id.btnCa);          //button to change catalan

        btnes.setOnClickListener(new View.OnClickListener(){       //change to spanish
            public void onClick(View view){
                Toast.makeText(getContext(), "en------", Toast.LENGTH_LONG).show();
                Save("en-us"); }
        });

        btnca.setOnClickListener(new View.OnClickListener(){       //change to catala
            public void onClick(View view){
                Toast.makeText(getContext(), "ca------", Toast.LENGTH_LONG).show();
                Save("ca");
            }
        });
        return viewForm;
    }


    public void Save(String locale){
        Toast.makeText(getContext(), locale, Toast.LENGTH_LONG).show();
        SharedPreferences preferences = getActivity().getSharedPreferences("Preferencias", Context.MODE_PRIVATE);
        final Configuration config = new Configuration(getResources().getConfiguration());
        config.locale = new Locale(locale);
        getResources().updateConfiguration(config, getResources().getDisplayMetrics());
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("Idioma",locale );
        editor.commit();
        refresh();
    }

    public void refresh(){
        Intent intent = new Intent(getContext(),MainActivity.class);
        startActivity(intent);
    }

}