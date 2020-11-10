package com.example.du_an_mau.Fragment.DialogFragment;

import android.app.AlertDialog;
import android.content.Context;
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

import com.example.du_an_mau.Dao.typeBookDao;
import com.example.du_an_mau.Fragment.typeBookFragment;
import com.example.du_an_mau.Model.typeBook;
import com.example.du_an_mau.R;

import java.util.ArrayList;

public class typeBook_dialogFragment extends DialogFragment {
    EditText typeBookDialog, RoomBookDialog,AmountTypeBookDiaLog,edtasm;
    Button CancelTypeBook, AddTypeBook;
    typeBookDao dao;
    ArrayList<typeBook> arrayList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        final Context context;
        AlertDialog.Builder al = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater1 = getActivity().getLayoutInflater();
        View view = inflater1.inflate(R.layout.custom_dialog_typebook, container, false);
        typeBookDialog = (EditText) view.findViewById(R.id.edtTypeBook2);
        RoomBookDialog = (EditText) view.findViewById(R.id.edtRoomBook);
        AmountTypeBookDiaLog = (EditText)view.findViewById(R.id.edtAmountTypeBook);
        CancelTypeBook = (Button) view.findViewById(R.id.btnCancelTypeBook);
        AddTypeBook = (Button) view.findViewById(R.id.btnAddDataTypeBook);
        edtasm =(EditText)view.findViewById(R.id.edtAsm);
        CancelTypeBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "Hủy thực hiện", Toast.LENGTH_SHORT).show();
                getDialog().dismiss();

            }

        });
        AddTypeBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayList<typeBook> arrayList = new ArrayList<>();
                typeBookDao dao = new typeBookDao(getActivity());
                String codeType = String.valueOf(typeBookDialog.getText().toString());
                int amount = Integer.parseInt(AmountTypeBookDiaLog.getText().toString());
                int romm = Integer.parseInt(RoomBookDialog.getText().toString());
                String asm = String.valueOf(edtasm.getText().toString());
                typeBook loai = new typeBook(codeType,amount,romm,asm);
                dao.insert(loai);
                typeBookFragment.updateAdapterTypeBook();

                Toast.makeText(getActivity(), "Add Thành công", Toast.LENGTH_SHORT).show();

                getDialog().dismiss();
            }
        });


        return view;


    }
}
