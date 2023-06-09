package ca.dongguo.pizza;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Collectors;

public class ProfileActivity extends AppCompatActivity implements View.OnClickListener {

    TextView showCustomer, sortText, searchText;
    ArrayList<Person> customerList;
    Button sortByNameBtn, clearSortBtn, searchPizzaBtn;
    RadioGroup searchGroup;
    boolean isSorted = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        initialize();
        customerList = initializeCustomerList();
        refreshView(customerList);
        initializeSearch();
    }

    private void initializeSearch() {
        searchGroup.setOnCheckedChangeListener((group, checkedId) -> {
            String searchStr = (String) ((RadioButton) findViewById(checkedId)).getText();
            ArrayList<Person> filteredList = customerList.stream()
                    .filter(u -> u.getPizza().getType().compareTo(searchStr) == 0)
                    .collect(Collectors.toCollection(ArrayList::new));
            refreshView(filteredList);
        });
    }

    private void refreshView(ArrayList<Person> list) {
        showCustomer.setText(list.toString());
    }

    private ArrayList<Person> initializeCustomerList() {
        return (ArrayList<Person>) getIntent().getBundleExtra("intentExtra").getSerializable("bundleExtra");
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
            if (isSorted) {
                customerList.sort(Comparator.comparing(Person::getName).reversed());
                isSorted = false;
            } else {
                customerList.sort(Comparator.comparing(Person::getName));
                isSorted = true;
            }
        }
        refreshView(customerList);
    }
}