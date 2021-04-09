package com.example.parcial_1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.parcial_1.model.ProductModel;

import java.io.Serializable;
import java.util.ArrayList;

public class Products extends AppCompatActivity implements View.OnClickListener {

    private TextView txtProductsWithoutIVA;
    private Button btnNext2;
    private ArrayList<ProductModel> products = new ArrayList<ProductModel>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products);

        txtProductsWithoutIVA = findViewById(R.id.txtProductsWithoutIVA);
        products = (ArrayList<ProductModel>)  getIntent().getSerializableExtra("products");
        GetProductsWithoutIVA(products);
        btnNext2.setOnClickListener(this);
    }

    private void GetProductsWithoutIVA(ArrayList<ProductModel> products) {
        if(products.size() > 0 ){
            String productWithoutIVA = "";
            for (ProductModel product: products) {
                if(product.getIva()){
                    productWithoutIVA += "Nombre :" + product.getName() + "Codigo: "+ product.getCode() + "Tiene IVA?" + product.getIva().toString() + "Descripcion: "+ product.getDescription() + "Categoria: " + product.getCategory()+ "\n";
                }
            }
            txtProductsWithoutIVA.setText(productWithoutIVA);
        }
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.btnNext2){
            Intent next = new Intent(this, ExpensiveProducts.class);
            next.putExtra("products", (Serializable) products);
            startActivity(next);
        }
    }
}