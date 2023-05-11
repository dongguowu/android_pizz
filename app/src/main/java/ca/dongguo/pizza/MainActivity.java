package ca.dongguo.pizza;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    RadioGroup pizzaSize, pizzaType;
    TextView textViewFeedBack;
    EditText nameText, emailText, phoneText;
    ArrayList<Person> customerList = new ArrayList<>();
    Button addOrder, showOrder;

    Person person;
    Pizza pizza;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initialize();
    }

    private void initialize() {
        nameText = findViewById(R.id.edit_text_name);
        emailText = findViewById(R.id.edit_text_email);
        phoneText = findViewById(R.id.edit_text_phone);
        textViewFeedBack = findViewById(R.id.textViewFeedBack);
        addOrder = findViewById(R.id.button_add_order);
        addOrder.setOnClickListener(this);
        showOrder = findViewById(R.id.button_show_order);
        showOrder.setOnClickListener(this);
        pizzaSize = findViewById(R.id.pizza_size);
        pizzaType = findViewById(R.id.pizza_type);

        setDefaultValue();
        initializeData(customerList);
    }

    private void setDefaultValue() {
        nameText.setText("test");
        emailText.setText("email@email.com");
        phoneText.setText("514813");

        pizzaSize.check(((RadioButton) findViewById(R.id.medium_size)).getId());
        pizzaType.check(((RadioButton) findViewById(R.id.deluxe)).getId());

    }

    private void initializeData(ArrayList<Person> list) {
        Pizza pizza1 = new Pizza("Small", "Hawaiian");
        Pizza pizza2 = new Pizza("Medium", "Deluxe");
        Pizza pizza3 = new Pizza("Large", "Pepperoni");
        Person p1 = new Person("Leonardo DiCaprio", "leo@email.com", 12345, pizza1);
        Person p2 = new Person("Will Smith", "will@email.com", 12345, pizza2);
        Person p3 = new Person("Tom Hanks", "tom@email.com", 12345, pizza3);
        Person p4 = new Person("Keanu Reeves", "keanu@email.com", 12345, pizza1);
        list.addAll(Arrays.asList(p1, p2, p3, p4));
    }

    @Override
    public void onClick(View v) {
        if (v == addOrder) {
            Person person = createOrder();
            customerList.add(person);
            customerList.forEach((c) -> System.out.println(c));
            return;
        }

    }

    private Person createOrder() {
        String size = getTextFromRadioGroup(pizzaSize);
        String type = getTextFromRadioGroup(pizzaType);
        pizza = new Pizza(size, type);

        String email = emailText.getText().toString();
        String name = nameText.getText().toString();
        String phone = phoneText.getText().toString();

        person = new Person(name, email, Integer.parseInt(phone), pizza);
        return person;
    }

    @NonNull
    private String getTextFromRadioGroup(RadioGroup group) {
        int checkedRadioButtonId = group.getCheckedRadioButtonId();
        RadioButton checkedRadioButton = findViewById(checkedRadioButtonId);
        String text = checkedRadioButton.getText().toString();
        return text;
    }
}