package com.android.johnabbotte.wu_dongguo_finalexam;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.johnabbotte.wu_dongguo_finalexam.model.Customer;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;

public class WithdrawActivity extends AppCompatActivity implements View.OnClickListener {

    public final static String TAG = "WithdrawActivity";
    ArrayList<Customer> customersList;
    Customer currentCustomer;

    TextView balanceTitleView, balanceValueView;
    EditText amountValueView;
    Button withdrawBtn, backBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_withdraw);

        Bundle bundle = getIntent().getBundleExtra("intentExtra");
        Serializable bundledCustomer = bundle.getSerializable("bundleExtra");
        currentCustomer = (Customer) bundledCustomer;
        Serializable bundledList = bundle.getSerializable("bundleExtraList");
        customersList = (ArrayList<Customer>) bundledList;

        balanceTitleView = (TextView) findViewById(R.id.withdraw_textView_title);
        balanceValueView = (TextView) findViewById(R.id.withdraw_textView_balanceValue);
        amountValueView = (EditText) findViewById(R.id.withdraw_editText_withdrawValue);
        withdrawBtn = (Button) findViewById(R.id.withdraw_btn_withdraw);
        backBtn = (Button) findViewById(R.id.withdraw_btn_showAll);

        refreshBalanceView();


        withdrawBtn.setOnClickListener(this);
        backBtn.setOnClickListener(this);

    }

    private void refreshBalanceView() {
        balanceTitleView.setText(currentCustomer.getPerson().getlName() + "'s Balance");
        balanceValueView.setText(String.valueOf(currentCustomer.getAccount().getBalance()));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.withdraw_btn_withdraw:
                withdraw();
                break;
            case R.id.withdraw_btn_showAll:
                backList();
        }
    }

    private void backList() {
        Bundle bundle = new Bundle();
        bundle.putSerializable("bundleExtraList", customersList);

        Intent intent = new Intent(this, ListActivity.class);
        intent.putExtra("intentExtra", bundle);
        finish();
        startActivity(intent);
    }

    private void withdraw() {
        String amountStr = amountValueView.getText().toString();
        BigDecimal withdrawValue = new BigDecimal(amountStr);
        BigDecimal oldBalance = currentCustomer.getAccount().getBalance();
        if(withdrawValue.compareTo(oldBalance) > 1 ) {
            return;
        }else {
            BigDecimal newBalance = oldBalance.subtract(withdrawValue);
            currentCustomer.getAccount().setBalance( newBalance );
            updateList(customersList, currentCustomer);
            refreshBalanceView();
        }
    }

    private boolean updateList(ArrayList<Customer> list, Customer customer) {
        for (Customer c : list) {
            if (c.getPerson().getNumberOfSIN().equals(customer.getPerson().getNumberOfSIN())) {
                c.getAccount().setBalance(customer.getAccount().getBalance());
                return true;
            }
        }
        return false;
    }
}
