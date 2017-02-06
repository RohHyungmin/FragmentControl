package com.hyugnmin.android.fragmentcontrol;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class ListFragment extends Fragment {

    MainActivity activity;

    public void setActivity(MainActivity activity) {
        this.activity = activity;
    }

    public ListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_list, container, false);

        Button btnGoDetail = (Button) view.findViewById(R.id.btnGoDetail);

        btnGoDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //메인의 goDetail()을 호출
                activity.goDetail();

            }
        });
        return view;
    }

}
