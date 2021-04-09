package com.example.parcial_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import com.example.parcial_1.model.ProductModel;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText txtName;
    private EditText txtCode;
    private EditText txtValue;
    private CheckBox chbIva;
    private EditText txtDescription;
    private EditText txtCategory;
    private Button btnSave;
    private Button btnNext;
    private ProductModel product = new ProductModel();
    private ArrayList<ProductModel> products = new ArrayList<ProductModel>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSave = findViewById(R.id.btnSave);
        btnNext = findViewById(R.id.btnNext);
        txtName = findViewById(R.id.txtName);
        txtCode = findViewById(R.id.txtCode);
        txtValue = findViewById(R.id.txtValue);
        chbIva = findViewById(R.id.chbIva);
        txtDescription = findViewById(R.id.txtDescription);
        txtCategory = findViewById(R.id.txtCategory);
        btnSave.setOnClickListener(this);
        btnNext.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.btnSave){
            product.setName(txtName.getText().toString());
            product.setCode(txtCode.getText().toString());
            product.setValue(txtValue.getText().toString());
            product.setIva(chbIva.isChecked());
            product.setDescription(txtDescription.getText().toString());
            product.setCategory(txtCategory.getText().toString());
            products.add(product);
            clearFields();
        }

        if(v.getId() == R.id.btnNext){
            Intent next = new Intent(this, Products.class);
            next.putExtra("products", (Serializable) products);
            startActivity(next);
        }
    }

    private void clearFields() {
        txtName.setText("");
        txtCode.setText("");
        txtValue.setText("");
        chbIva.setChecked(false);
        txtDescription.setText("");
        txtCategory.setText("");
    }
}