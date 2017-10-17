package com.iteso.is705419.sesion10;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.iteso.is705419.sesion10.beans.ItemProduct;

public class ActivityMain extends AppCompatActivity {

    Toolbar toolbar;
    TabLayout tabLayout;
    ViewPager viewPager;
    static final int INTENT_PRODUCTS_NOTIFY = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.activity_main_toolbar);
        viewPager = (ViewPager) findViewById(R.id.activity_main_viewpager);
        tabLayout = (TabLayout) findViewById(R.id.activity_main_tabs);

        setSupportActionBar(toolbar);
        SectionAdapter mSection =
                new SectionAdapter(getSupportFragmentManager());
        viewPager.setAdapter(mSection);
        tabLayout.setupWithViewPager(viewPager);
    }

    public class SectionAdapter extends FragmentPagerAdapter{

        public SectionAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch(position){
                case 0:
                    return new FragmentTechnology();
                case 1:
                    return new FragmentHome();
                case 2:
                    return new FragmentElectronics();
                default:
                    return new FragmentTechnology();
            }
        };

        @Override
        public int getCount() {
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch(position){
                case 0: return getString(R.string.fragment_tab1);
                case 1: return getString(R.string.fragment_tab2);
                case 2: return getString(R.string.fragment_tab3);
            }

            return super.getPageTitle(position);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.activity_main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.activity_main_logout:
                clearPreferences();
                return true;
            case R.id.activity_main_privacy:
                Intent intent = new Intent(this, ActivityPrivacyPolicy.class);
                startActivity(intent);
                return true;
            case R.id.action_products:
                Intent products = new Intent(this, ActivityProduct.class);
                startActivityForResult(products, INTENT_PRODUCTS_NOTIFY);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case INTENT_PRODUCTS_NOTIFY:
                if (resultCode == Activity.RESULT_OK) {
                    if (data != null) {
                        ItemProduct itemProduct = data.getParcelableExtra("ITEM");
                        if (itemProduct.getCategory().getName().equalsIgnoreCase("TECHNOLOGY")) {
                            FragmentTechnology.notifyDataSetChanged(itemProduct);
                        }
                    }
                }
                break;
        }
    }

    public void clearPreferences(){
        SharedPreferences sharedPreferences =
                getSharedPreferences("com.iteso.session13.CACAHUATE",
                        Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear().apply();

        Intent intent = new Intent(this, ActivityLogin.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP
                | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        finish();
    }


/*
    public static class PlaceHolder extends Fragment{
        public static PlaceHolder newInstance(){
            PlaceHolder fragment = new PlaceHolder();
            return fragment;
        }
        public PlaceHolder(){}

        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater,
                                 ViewGroup container,
                                 Bundle savedInstanceState){
                View rootView = inflater.inflate(R.layout.activity_fragment_main,container,false);
            return rootView;
        }
    }
    */
}
