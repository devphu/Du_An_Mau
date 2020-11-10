package com.example.du_an_mau.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.du_an_mau.Adapter.typeBookAdapter;
import com.example.du_an_mau.Dao.typeBookDao;
import com.example.du_an_mau.Fragment.DialogFragment.typeBook_dialogFragment;
import com.example.du_an_mau.MainActivity;
import com.example.du_an_mau.Model.typeBook;
import com.example.du_an_mau.R;

import java.util.ArrayList;

public class typeBookFragment extends Fragment {
    RecyclerView recyclerView;
    static typeBookAdapter adapter;
    static ArrayList<typeBook> arraylist;
    static typeBookDao dao;
    Button addData;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.type_book_fragment, container, false);
        recyclerView = view.findViewById(R.id.rcyview2);
        Context context;
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        arraylist = new ArrayList<>();
        dao = new typeBookDao(getContext());
        arraylist = dao.readAll();
        adapter = new typeBookAdapter((MainActivity) getActivity(), arraylist);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);
        addData = view.findViewById(R.id.btnOpenDiaLog);
        addData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                typeBook_dialogFragment typeBook_dialogFragment = new typeBook_dialogFragment();
                typeBook_dialogFragment.show(getChildFragmentManager(), "typeBook_dialogFragment");
            }
        });
        return view;
    }
    public static void updateAdapterTypeBook(){
        arraylist.clear();
        arraylist.addAll(dao.readAll());
        adapter.notifyDataSetChanged();
    }
}
