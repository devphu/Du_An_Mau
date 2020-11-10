package com.example.du_an_mau.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.du_an_mau.Adapter.billAdapter;
import com.example.du_an_mau.Dao.BillDao;
import com.example.du_an_mau.Model.Bill;
import com.example.du_an_mau.R;

import java.net.ConnectException;
import java.util.ArrayList;

public class invoiceFragment extends Fragment {
    RecyclerView recyclerView;
    billAdapter adapter;
    ArrayList<Bill> arrayList;
    BillDao dao;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.invoice_fragment, container, false);
        recyclerView = view.findViewById(R.id.rcyview1);
        Context context;
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        arrayList = new ArrayList<>();
        dao = new BillDao(getContext());
        arrayList = dao.readALl();
        adapter = new billAdapter(getActivity(), arrayList);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);
        return view;
    }
}