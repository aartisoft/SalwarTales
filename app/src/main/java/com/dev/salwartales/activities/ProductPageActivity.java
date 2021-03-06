package com.dev.salwartales.activities;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.internal.BottomNavigationMenuView;
import android.support.design.internal.NavigationMenuView;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.dev.salwartales.R;
import com.dev.salwartales.activities.adapters.BottomNavigationViewHelper;
import com.dev.salwartales.activities.bottomnavfragments.FeatureProductsFragment;
import com.dev.salwartales.activities.fragments.HomeFragment;
import com.dev.salwartales.activities.fragments.MoreFragment;

public class ProductPageActivity extends AppCompatActivity  {

    View view;
    private TextView tvbudge;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_page);

        view=findViewById(R.id.actionbarbottom);
     ImageView ivback = findViewById(R.id.iv_back);
     ivback.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {
//             Toast.makeText(ProductPageActivity.this,"back clicked",Toast.LENGTH_SHORT).show();
         finish();
         }
     });




        ImageView ivcart = findViewById(R.id.iv_customcart);
        ivcart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(ProductPageActivity.this,CartActivity.class);
                startActivity(intent);
            }
        });

        tvbudge=findViewById(R.id.badge_notification_1);
        tvbudge.setText("0");






        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.navigation);

        //reducing icon size
        BottomNavigationMenuView menuView = (BottomNavigationMenuView) bottomNavigationView.getChildAt(0);
        for (int i = 0; i < menuView.getChildCount(); i++) {
            final View iconView = menuView.getChildAt(i).findViewById(android.support.design.R.id.icon);
            final ViewGroup.LayoutParams layoutParams = iconView.getLayoutParams();
            final DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
            layoutParams.height = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 20, displayMetrics);
            layoutParams.width = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 20, displayMetrics);
            iconView.setLayoutParams(layoutParams);
        }

        //desable animation
        BottomNavigationViewHelper.disableShiftMode(bottomNavigationView);


       /* NavigationMenuView navigationMenuView= (NavigationMenuView) bottomNavigationView.getChildAt(0);
        navigationMenuView.addItemDecoration(new DividerItemDecoration(ProductPageActivity.this,DividerItemDecoration.VERTICAL));*/
//        BottomNavigationViewHelper.disableShiftMode(bottomNavigationView);


        bottomNavigationView.setOnNavigationItemSelectedListener
                (new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        Fragment selectedFragment = null;
                        switch (item.getItemId()) {
                            case R.id.home:
                     view.setVisibility(View.GONE);


                                setTitle("");
                                HomeFragment fragment =new HomeFragment();
                                FragmentTransaction fragmentTransaction= getSupportFragmentManager().beginTransaction();
                                fragmentTransaction.replace(R.id.framee,fragment," ");
                                fragmentTransaction.commit();

                                break;
                            case R.id.categories:
                              //  selectedFragment = ItemTwoFragment.newInstance();

                                view.setVisibility(View.GONE);
                                setTitle("");
                                MoreFragment moreFragment =new MoreFragment();
                                FragmentTransaction fragmentTransactionmore= getSupportFragmentManager().beginTransaction();
                                fragmentTransactionmore.replace(R.id.framee,moreFragment," ");
                                fragmentTransactionmore.commit();





                                break;
                            case R.id.deals:
                                view.setVisibility(View.GONE);
                                setTitle("");
                                FeatureProductsFragment featureProductsFragment =new FeatureProductsFragment();
                                FragmentTransaction fragmentTransactionfea= getSupportFragmentManager().beginTransaction();
                                fragmentTransactionfea.replace(R.id.framee,featureProductsFragment," ");
                                fragmentTransactionfea.commit();

                                break;
                            case R.id.wishlist:
                               // selectedFragment = ItemTwoFragment.newInstance();
                                break;
                            case R.id.account:
                              //  selectedFragment = ItemThreeFragment.newInstance();
                                break;
                        }
                       /* FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                        transaction.replace(R.id.frame, selectedFragment);
                        transaction.commit();*/
                        return true;
                    }
                });

        setTitle("Deals");
        FeatureProductsFragment fragment =new FeatureProductsFragment();
        FragmentTransaction fragmentTransaction= getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.framee,fragment," ");
        fragmentTransaction.commit();


       /* //Manually displaying the first fragment - one time only
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_layout, ItemOneFragment.newInstance());
        transaction.commit();*/

        //Used to select an item programmatically
        bottomNavigationView.getMenu().getItem(2).setChecked(true);
    }

    @Override
    public void onBackPressed(){
        super.onBackPressed();
        /*Toast.makeText(ProductPageActivity.this,"Back pressed",Toast.LENGTH_LONG).show();
        Log.i("back","backpressed");*/



    }


}
