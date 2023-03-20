package com.example.a1181375_raneennaqeeti_todo4;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentContainerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FirstFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FirstFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public FirstFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FirstFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static FirstFragment newInstance(String param1, String param2) {
        FirstFragment fragment = new FirstFragment();
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
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false);
    }

    interface communicator {
        public void respond(String data);
    }
    public void changeData(String data){
        TextView textView = (TextView) getActivity().findViewById(R.id.output);
        textView.setText(data);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        final SecondFragment.communicator communicator = (SecondFragment.communicator)getActivity();
        final ThirdFragment.communicator communicator2 = (ThirdFragment.communicator)getActivity();
        Button button = (Button) getActivity().findViewById(R.id.button_summation_mul);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText PlainText1 = (EditText) getActivity().findViewById(R.id.plainText1);
                EditText PlainText2 = (EditText) getActivity().findViewById(R.id.plainText2);

                String n1 = PlainText1.getText().toString();
                String n2 = PlainText2.getText().toString();
                int number1 = Integer.parseInt(n1);
                int number2 = Integer.parseInt(n2);
                int sum = number1+number2;
                int mul = number1*number2;

                communicator.respond1( sum + "");
                communicator2.respond2( mul + "");
            }
        });
    }
}