package com.example.landonbedell.massimo;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.RatingBar;

import com.example.landonbedell.massimo.R;

import java.util.ArrayList;


public class HomeFragment extends Fragment {

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);

        ArrayList<Ratable> ratables = getRatableList();
        ListView homelistView = (ListView) rootView.findViewById(R.id.home_list_view);
        homelistView.setAdapter(new RatableListViewAdapter(getActivity(),ratables));
        return rootView;
    }


    private ArrayList<Ratable> getRatableList(){
        CustomerModel cust = CustomerModel.getCurrentCustomer();

        return cust.getRecommendations();
    }

}
