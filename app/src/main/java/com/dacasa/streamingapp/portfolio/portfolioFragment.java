package com.dacasa.streamingapp.portfolio;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dacasa.streamingapp.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link portfolioFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class portfolioFragment extends Fragment {


    List<portfolioItem> mdata;
    RecyclerView rv_portfolio;
    portfolioAdapter portfolioAdapter;


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public portfolioFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment portfolioFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static portfolioFragment newInstance(String param1, String param2) {
        portfolioFragment fragment = new portfolioFragment();
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
        return inflater.inflate(R.layout.fragment_portfolio, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        rv_portfolio = view.findViewById(R.id.rv_portfolio);
        // create  a list of portfolio items

        mdata = new ArrayList<>();
        mdata.add(new portfolioItem());
        mdata.add(new portfolioItem());
        mdata.add(new portfolioItem());
        mdata.add(new portfolioItem());
        mdata.add(new portfolioItem());
        mdata.add(new portfolioItem());
        mdata.add(new portfolioItem());

        portfolioAdapter = new portfolioAdapter(mdata);

        //setup grid recyclerview
        rv_portfolio.setLayoutManager(new GridLayoutManager(getActivity(),3));
        rv_portfolio.setAdapter(portfolioAdapter);


    }
}