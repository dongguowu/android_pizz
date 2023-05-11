package ca.dongguo.pizza;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Collectors;

public class ProfileActivity extends AppCompatActivity implements View.OnClickListener {

    TextView showCustomer, sortText, searchText;
    ArrayList<Person> customerList;
    Button sortByNameBtn, clearSortBtn, searchPizzaBtn;
    RadioGroup searchGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        initialize();
        customerList = initializeCustomerList();
        refreshView(customerList);
        initializeSeach();
    }

    private void initializeSeach() {
        searchGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                String searchStr = (String) ((RadioButton)findViewById(checkedId)).getText();
                ArrayList<Person> filteredList = customerList.stream()
                        .filter(u -> u.getPizza().getType().compareTo(searchStr) == 0)
                        .collect(Collectors.toCollection(ArrayList::new));
                refreshView(filteredList);

            }
        });
    }

    private void refreshView(ArrayList<Person> list) {
        showCustomer.setText(list.toString());
    }

    private ArrayList<Person> initializeCustomerList() {
        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra("intentExtra");
        Serializable bundledListOfStudents = bundle.getSerializable("bundleExtra");

        return (ArrayList<Person>) bundledListOfStudents;
    }

    private void initialize() {
        showCustomer = findViewById(R.id.customer_list);
        sortByNameBtn = findViewById(R.id.sort_by_name_btn);
        sortByNameBtn.setOnClickListener(this);
        clearSortBtn = findViewById(R.id.clear_sort);
        clearSortBtn.setOnClickListener(this);
        searchPizzaBtn = findViewById(R.id.search_pizza_btn);
        searchPizzaBtn.setOnClickListener(this);
        sortText = findViewById(R.id.sort_by_name_text);
        searchText = findViewById(R.id.search_pizza_text);
        searchGroup = findViewById(R.id.search_radio_group);
    }

    @Override
    public void onClick(View v) {
        if (v == sortByNameBtn) {
            customerList.sort(Comparator.comparing(Person::getName));
        }
        refreshView(customerList);
    }
}