package com.example.test1;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link loginFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class loginFragment extends Fragment {

    private EditText email;
    private EditText Password;
    private EditText copassword;
    private Button btn;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public loginFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment loginFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static loginFragment newInstance(String param1, String param2) {
        loginFragment fragment = new loginFragment();
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
            connectcomponents();
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();
        connectcomponents();
    }

    private void connectcomponents() {
        email=getView().findViewById(R.id.email);
        Password=getView().findViewById(R.id.Password);
        copassword=getView().findViewById(R.id.copassword);
        btn=getView().findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email0= email.getText().toString();
                String password0= Password.getText().toString();
                String copassword0= copassword.getText().toString();
                if(email0.trim().isEmpty()|| password0.trim().isEmpty()|| copassword0.trim().isEmpty())
                {
                    Toast.makeText(getActivity(),"some fields are missing", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (!isEmailValid(email0))
                {
                    Toast.makeText(getActivity(), "this email is incorecct", Toast.LENGTH_SHORT).show();
                    return;

                }
                if(!isPasswordValid(Password))
                {
                    Toast.makeText(getActivity(), "this email is incorecct", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(!password0.equals(copassword0))
                {
                    Toast.makeText(getActivity(), "password is not identical", Toast.LENGTH_SHORT).show();
                    return;
                }



            }
        });


    }

    private boolean isPasswordValid(EditText password0)
    {
        Pattern pattern;
        Matcher matcher;
        final String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{4,}$";
        pattern = Pattern.compile(PASSWORD_PATTERN);
        matcher = pattern.matcher((CharSequence) password0);

        return matcher.matches();
    }

    public boolean isEmailValid(String email) {
        String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
        Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

}