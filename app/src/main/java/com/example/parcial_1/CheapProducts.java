package com.example.parcial_1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.parcial_1.model.ProductModel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.lang.Integer.parseInt;

public class CheapProducts extends AppCompatActivity {

    private Button btnNext4;
    private TextView txtCheapProducts;
    private ArrayList<ProductModel> products = new ArrayList<ProductModel>();
    private ArrayList<Integer> cheapProducts = new ArrayList<Integer>();
    private Integer mostCheapValue;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cheap_products);

        txtCheapProducts = findViewById(R.id.txtCheapProducts);
        products = (ArrayList<ProductModel>)  getIntent().getSerializableExtra("products");
        GetCheapProducts(products);
    }

    private void GetCheapProducts(ArrayList<ProductModel> products) {
        if(products.size() > 0 ){
            String CheapProduct = "";
            for (ProductModel product: products) {
                if(parseInt(product.getValue()) > mostCheapValue){
                    CheapProduct += "Nombre :" + product.getName() + "Codigo: "+ product.getCode() + "Tiene IVA?" + product.getIva().toString() + "Descripcion: "+ product.getDescription() + "Categoria: " + product.getCategory()+ "\n";
                }
            }
            txtCheapProducts.setText(CheapProduct);
        }
    }

    private void GetMostCheapValue(ArrayList<ProductModel> products) {
        if(products.size() > 0 ){
            for (ProductModel product: products) {
                Integer Value = parseInt(product.getValue());
                cheapProducts.add(Value);
            }
            mostCheapValue = Collections.min(cheapProducts);
        }
    }
}