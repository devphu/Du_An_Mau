package com.example.du_an_mau.Fragment.DialogFragment;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.example.du_an_mau.Dao.bookDao;
import com.example.du_an_mau.Fragment.HomeFragment;
import com.example.du_an_mau.MainActivity;
import com.example.du_an_mau.Model.Book;
import com.example.du_an_mau.R;

import java.io.IOException;
import java.util.ArrayList;

public class diaLog_Fragment extends DialogFragment {
    ArrayList<Book> arrayList;
    bookDao dao;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final EditText dialogCodeType, dialogNameBook, dialogPriceBook, diaLogNsb, dialogcodeBook;
        Context context;
        Button diaLogBtnCancel, diaLogBtnAddData;
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater layoutInflater = getActivity().getLayoutInflater();
        ViewGroup root;
        View view = layoutInflater.inflate(R.layout.custom_dialog, container, false);


        dialogCodeType = (EditText) view.findViewById(R.id.edtCodeType);
        dialogNameBook = (EditText) view.findViewById(R.id.edtNameBookDiaLog);
        dialogPriceBook = (EditText) view.findViewById(R.id.edtPriceBook);
        diaLogNsb = (EditText) view.findViewById(R.id.edtNsbDialog);

        diaLogBtnCancel = view.findViewById(R.id.btnCancel);

        //
        diaLogBtnAddData = view.findViewById(R.id.btnAddData);
        diaLogBtnAddData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bookDao dao = new bookDao(getActivity());
//                int codeBook = Integer.parseInt(dialogcodeBook.getText().toString());
                String nameBook = String.valueOf(dialogNameBook.getText().toString());
                int priceBook = Integer.parseInt(dialogPriceBook.getText().toString());
                String nsb = String.valueOf(diaLogNsb.getText().toString());
                String codeType = String.valueOf(dialogCodeType.getText().toString());

                Book book = new Book(nameBook, priceBook, nsb, codeType);
                dao.insert(book);
                Toast.makeText(getActivity(), "Add Data", Toast.LENGTH_SHORT).show();
                HomeFragment.updateAdapter();
                getDialog().dismiss();


            }
        });
        diaLogBtnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "Hủy thực hiên", Toast.LENGTH_SHORT).show();
                getDialog().dismiss();

            }
        });
        return view;
    }
}
