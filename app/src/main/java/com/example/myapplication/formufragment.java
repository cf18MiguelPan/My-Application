package com.example.myapplication;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myapplication.db.Contact;
import com.example.myapplication.db.ContactsContract;
import com.example.myapplication.db.ContactsDBHelper;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link formufragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class formufragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private ContactsDBHelper dbHelper;
    private SQLiteDatabase db;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    //Create the instance of dbHelper


    public formufragment() {
        // Required empty public constructor
    }

    public formufragment(ContactsDBHelper dbHelper, SQLiteDatabase db) {
        this.dbHelper = dbHelper;
        this.db = db;
    }



    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment formufragment.
     */
    // TODO: Rename and change types and number of parameters
    public static formufragment newInstance(String param1, String param2) {
        formufragment fragment = new formufragment();
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
        View viewForm = inflater.inflate(R.layout.fragment_formufragment, container, false);

        Button save = viewForm.findViewById(R.id.fragbutton);               //BUTTON GUARDAR
        save.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                EditText name = viewForm.findViewById(R.id.nombre);         //EDITTEXT NOMBRE

                Contact c = new Contact(name.getText().toString());
                dbHelper.insertContact(db, c);
            }
        });


        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setTitle("Borrar todos los datos");
        builder.setMessage("¿Estas seguro que quieres borrar todos los datos de la lista?")
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    //delete list
                    public void onClick(DialogInterface dialog, int id) {
                        dbHelper.delete();
                    }
                })
                .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        //when canceled it just does nothing
                    }
                });
        AlertDialog dialog = builder.create();

        Button borrar = viewForm.findViewById(R.id.delete);               //BUTTON DELETE
        borrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.show();
            }
        });


        return viewForm;
    }

}