package ca.dongguo.pizza;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

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

    }
}