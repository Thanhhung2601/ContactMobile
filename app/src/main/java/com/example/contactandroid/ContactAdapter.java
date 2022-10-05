package com.example.contactandroid;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class ContactAdapter extends BaseAdapter {
    private Context context ;
    private int layout ;
    private List<Contact> contaclList ;
    public ContactAdapter(Context context , int layout ,List<Contact> contaclList ){
        this.context = context ;
        this.layout = layout ;
        this.contaclList = contaclList ;
    }
    @Override
    public int getCount() {
        return contaclList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(layout , null);
        TextView pName = view.findViewById(R.id.phoneNameDetail);
        TextView pNumber = view.findViewById(R.id.phoneNumberDetail);
        Contact contact = contaclList.get(i);
        pName.setText(contact.getName());
        pNumber.setText(contact.getPhone());

        return view;
    }
}
