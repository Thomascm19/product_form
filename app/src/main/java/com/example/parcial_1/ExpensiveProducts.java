package com.example.parcial_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.parcial_1.model.ProductModel;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static java.lang.Integer.parseInt;

public class ExpensiveProducts extends AppCompatActivity implements View.OnClickListener {

    private Button btnNext3;
    private TextView txtProductCostly;
    private ArrayList<ProductModel> products = new ArrayList<ProductModel>();
    private ArrayList<Integer> expensiveProducts = new ArrayList<Integer>();
    private Integer mostExpensiveValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products_costly);

        txtProductCostly = findViewById(R.id.txtProductCostly);
        products = (ArrayList<ProductModel>)  getIntent().getSerializableExtra("products");
        GetExpensiveProducts(products);
        btnNext3.setOnClickListener(this);
    }

    private void GetExpensiveProducts(ArrayList<ProductModel> products) {
        if(products.size() > 0 ){
            String productCostly = "";
            for (ProductModel product: products) {
                if(parseInt(product.getValue()) < mostExpensiveValue){
                    productCostly += "Nombre :" + product.getName() + "Codigo: "+ product.getCode() + "Tiene IVA?" + product.getIva().toString() + "Descripcion: "+ product.getDescription() + "Categoria: " + product.getCategory()+ "\n";
            }
                txtProductCostly.setText(productCostly);
            }
        }
    }

    private void GetMostExpensiveValue(ArrayList<ProductModel> products) {
        if(products.size() > 0 ){
            for (ProductModel product: products) {
                Integer Value = parseInt(product.getValue());
                expensiveProducts.add(Value);
            }
            mostExpensiveValue = Collections.max(expensiveProducts);
        }
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.btnNext3){
            Intent next = new Intent(this, CheapProducts.class);
            next.putExtra("products", (Serializable) products);
            startActivity(next);
        }
    }
}