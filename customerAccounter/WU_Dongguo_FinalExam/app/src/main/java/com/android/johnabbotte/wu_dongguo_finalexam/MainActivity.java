package com.android.johnabbotte.wu_dongguo_finalexam;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.johnabbotte.wu_dongguo_finalexam.model.Account;
import com.android.johnabbotte.wu_dongguo_finalexam.model.Customer;
import com.android.johnabbotte.wu_dongguo_finalexam.model.Person;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    public final static String TAG = "MainActivity";

    ArrayList<Customer> customersList;
    Customer currentCustomer;

    EditText accountView, openDateView, balanceView,
            personNameView, personFamilyView, personPhoneNoView, personSINView;
    Button btnAdd, btnRemove, btnUpdate, btnShowAll, btnSave, btnLoad, btnClear;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initialize();
    }

    private void initialize() {
        accountView = (EditText) findViewById(R.id.main_editText_accountNo);
        openDateView = (EditText) findViewById(R.id.main_editText_date_open);
        balanceView = (EditText) findViewById(R.id.main_editText_decimal_balance);
        personNameView = (EditText) findViewById(R.id.main_editText_firstName);
        personFamilyView = (EditText) findViewById(R.id.main_editText_lastname);
        personPhoneNoView = (EditText) findViewById(R.id.main_editText_phoneNo);
        personSINView = (EditText) findViewById(R.id.main_editText_sinNo);
        btnAdd = (Button) findViewById(R.id.main_btn_add);
        btnRemove = (Button) findViewById(R.id.main_btn_remove);
        btnUpdate = (Button) findViewById(R.id.main_btn_update);
        btnShowAll = (Button) findViewById(R.id.main_btn_showAll);
        btnSave = (Button) findViewById(R.id.main_btn_save);
        btnLoad = (Button) findViewById(R.id.main_btn_load);
        btnClear = (Button) findViewById(R.id.main_btn_clear);

        accountView.setOnClickListener(this);
        balanceView.setOnClickListener(this);
        personNameView.setOnClickListener(this);
        personFamilyView.setOnClickListener(this);
        personPhoneNoView.setOnClickListener(this);
        personSINView.setOnClickListener(this);
        btnAdd.setOnClickListener(this);
        btnRemove.setOnClickListener(this);
        btnUpdate.setOnClickListener(this);
        btnShowAll.setOnClickListener(this);
        btnSave.setOnClickListener(this);
        btnLoad.setOnClickListener(this);
        btnClear.setOnClickListener(this);

        customersList = new ArrayList<>();

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.main_btn_add:
                addCustomer();
                break;
            case R.id.main_btn_remove:
                removeCustomer(customersList);
                break;
            case R.id.main_btn_update:
                updateCustomer(customersList);
                break;
            case R.id.main_btn_showAll:
                showAllCustomers(customersList);
                break;
            case R.id.main_btn_save:
                saveFile(customersList);
                break;
            case R.id.main_btn_clear:
                clearUI();
                break;

        }

    }

    private boolean updateCustomer(ArrayList<Customer> list) {
        Customer customer = createCustomerFromUI();
        for (Customer c : list) {
            if (c.getPerson().getNumberOfSIN().equals(customer.getPerson().getNumberOfSIN())) {
                c.getAccount().setBalance(customer.getAccount().getBalance());
                return true;
            }
        }
        return false;
    }

    private void saveFile(ArrayList<Customer> list) {

    }

    private void clearUI() {
        accountView.setText(null);
        balanceView.setText(null);
        openDateView.setText(null);
        personNameView.setText(null);
        personFamilyView.setText(null);
        personPhoneNoView.setText(null);
        personSINView.setText(null);
    }

    private boolean removeCustomer(ArrayList<Customer> list) {
        Customer customer = createCustomerFromUI();
        for (Customer c : list) {
            if (c.getPerson().getNumberOfSIN().equals(customer.getPerson().getNumberOfSIN())) {
                c.getAccount().setBalance(customer.getAccount().getBalance());
                return true;
            }
        }
        return false;
    }

    private void showAllCustomers(ArrayList<Customer> customersList) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("bundleExtraList", customersList);

        Intent intent = new Intent(this, ListActivity.class);
        intent.putExtra("intentExtra", bundle);
        startActivity(intent);
    }

    private void addCustomer() {
        if (createCustomerFromUI() != null) {
            customersList.add(createCustomerFromUI());
        }
    }

    private Customer createCustomerFromUI() {
        // Account
        String accountNo = accountView.getText().toString();
        Date date = new Date();
        String openDateStr = openDateView.getText().toString();
        SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
        try {
            date = format.parse(openDateStr);
            System.out.println(date);
        } catch (Exception e) {
            e.printStackTrace();
        }
        BigDecimal balance = BigDecimal.valueOf(0.0);
        String balanceStr = balanceView.getText().toString();
        try {
            balance = new BigDecimal(balanceStr);
        } catch (Exception e) {
            System.out.print(e.getMessage());
            return null;
        }
        Account account = new Account(100, accountNo, date, balance);
        // Person
        String name = personNameView.getText().toString();
        String family = personFamilyView.getText().toString();
        String phone = personPhoneNoView.getText().toString();
        String sin = personSINView.getText().toString();
        Person person = new Person(100, name, family, phone, sin);

        currentCustomer = new Customer(account, person);
        return currentCustomer;
    }



}
