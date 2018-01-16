package com.infosolution.dev.salwartales.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.infosolution.dev.salwartales.R;
import com.infosolution.dev.salwartales.activities.adapters.CartAdapter;
import com.infosolution.dev.salwartales.activities.adapters.HorizontalAdapter;
import com.infosolution.dev.salwartales.activities.model.Cart;
import com.infosolution.dev.salwartales.activities.model.Dataa;

import java.util.ArrayList;
import java.util.List;

import static java.security.AccessController.getContext;

public class CartActivity extends AppCompatActivity {

    RecyclerView rccart;
    CartAdapter cartAdapter;
    Button btnprotocheckout;
    View view;
    private List<Cart> cartList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        btnprotocheckout = findViewById(R.id.btn_protocheckout);
        btnprotocheckout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CartActivity.this,Checkout_Login.class);
                startActivity(intent);
            }
        });

        view = findViewById(R.id.actionbarcart);
        ImageView ivback = findViewById(R.id.iv_backcart);
        ivback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //  Toast.makeText(CartActivity.this,"back clicked",Toast.LENGTH_SHORT).show();
                finish();
            }
        });


        rccart = findViewById(R.id.cart_rcview);

        cartList = cart_data();


        cartAdapter = new CartAdapter(cartList, this);

        LinearLayoutManager layoutManager = new LinearLayoutManager(CartActivity.this, LinearLayoutManager.VERTICAL, false);
        rccart.setLayoutManager(layoutManager);
        rccart.addItemDecoration(new DividerItemDecoration(this,
                DividerItemDecoration.VERTICAL));
        rccart.setAdapter(cartAdapter);

    }

    private List<Cart> cart_data() {

        List<Cart> cart = new ArrayList<>();

        cart.add(new Cart("Black color designer  dress for women", R.drawable.abc, "1545"));
        cart.add(new Cart("Black color designer dress for women", R.drawable.abc, "154"));
        cart.add(new Cart("Black color designer dress for women", R.drawable.abc, "478"));
        return cart;
    }


}
