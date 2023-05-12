package com.android.johnabbotte.wu_dongguo_finalexam;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.android.johnabbotte.wu_dongguo_finalexam.model.Customer;

import java.io.Serializable;
import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {

    public final static String TAG = "ListActivity";

    ArrayList<Customer> customersList;
    Customer currentCustomer;

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        listView = (ListView) findViewById(R.id.list_listView_content);

        Bundle bundle = getIntent().getBundleExtra("intentExtra");
        Serializable bundledList = bundle.getSerializable("bundleExtraList");
        customersList = (ArrayList<Customer>) bundledList;

        listView.setAdapter(new ArrayAdapter<Customer>(
                this,
                android.R.layout.simple_list_item_1,
                customersList));

        //  Set click listener
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView,
                                    View itemView,
                                    int position,    // Position in the ListView start from zero
                                    long id) {       // Row id of the underlying data
                currentCustomer = (Customer) adapterView.getItemAtPosition(position);


                Bundle bundle = new Bundle();
                bundle.putSerializable("bundleExtra", currentCustomer);
                bundle.putSerializable("bundleExtraList", customersList);

                Intent intent = new Intent(ListActivity.this, WithdrawActivity.class);
                intent.putExtra("intentExtra", bundle);
                finish();
                startActivity(intent);
            }
        });
    }


}
