package com.pisto.frankensteinapp;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;

public class ProvaTab extends App {

    private ViewPager viewPager;
    private TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getLayoutInflater().inflate(R.layout.activity_prova_tab, frameLayout);

        viewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);

        setupTabIcons();

    }

    private void setupTabIcons() {
        tabLayout.getTabAt(0).setIcon(R.mipmap.icon_info);
        tabLayout.getTabAt(1).setIcon(R.mipmap.icon_memo);
        tabLayout.getTabAt(2).setIcon(R.mipmap.icon_money);
        tabLayout.getTabAt(3).setIcon(R.mipmap.icon_stats);

    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new OneFragment(), "ONE");
        adapter.addFragment(new TwoFragment(), "TWO");
        adapter.addFragment(new ThreeFragment(), "THREE");
        adapter.addFragment(new FourFragment(), "FOUR");
        viewPager.setAdapter(adapter);
    }

}
