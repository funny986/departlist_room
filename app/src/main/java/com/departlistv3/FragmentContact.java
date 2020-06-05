package com.departlistv3;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.*;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import utils.*;

import static com.departlistv3.MainActivity.lstContact;

public class FragmentContact extends Fragment {
    View v;
    public static RecyclerView mrecycle;

    public FragmentContact() {
    }

    @SuppressLint("StaticFieldLeak")
    public static RecycleViewAdapter recycleViewAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.contact_fragment, container, false);
        mrecycle = v.findViewById(R.id.contact_recyclerview);
        mrecycle.setLayoutManager(new LinearLayoutManager(getActivity()));
        recycleViewAdapter = new RecycleViewAdapter(getContext(), lstContact);
        mrecycle.setAdapter(recycleViewAdapter);
        registerForContextMenu(mrecycle);
        return v;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}

