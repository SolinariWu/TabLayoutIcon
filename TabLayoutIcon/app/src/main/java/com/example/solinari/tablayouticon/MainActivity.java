package com.example.solinari.tablayouticon;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ViewPager myViewPager;
    private TabLayout tabLayout;
    private int[] IconResID = {R.drawable.tab_one_selected,R.drawable.tab_two,R.drawable.tab_three,
            R.drawable.tab_one, R.drawable.tab_two_selected,R.drawable.tab_three_selected};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myViewPager = (ViewPager) findViewById(R.id.myViewPager);

        tabLayout = (TabLayout) findViewById(R.id.TabLayout);
        setViewPager();;
        tabLayout.setupWithViewPager(myViewPager);
        setTabLayoutIcon();
    }
    public void setTabLayoutIcon(){
        for(int i =0; i < 3;i++){

            tabLayout.getTabAt(i).setIcon(IconResID[i]);
        }
      tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
          @Override
          public void onTabSelected(TabLayout.Tab tab) {
              switch(tab.getPosition()){
                  case 0:
                      tabLayout.getTabAt(0).setIcon(IconResID[0]);
                      tabLayout.getTabAt(1).setIcon(IconResID[1]);
                      tabLayout.getTabAt(2).setIcon(IconResID[2]);
                      break;
                  case 1:
                      tabLayout.getTabAt(0).setIcon(IconResID[3]);
                      tabLayout.getTabAt(1).setIcon(IconResID[4]);
                      tabLayout.getTabAt(2).setIcon(IconResID[2]);
                      break;
                  case 2:
                      tabLayout.getTabAt(0).setIcon(IconResID[3]);
                      tabLayout.getTabAt(1).setIcon(IconResID[1]);
                      tabLayout.getTabAt(2).setIcon(IconResID[5]);
                      break;
              }
          }

          @Override
          public void onTabUnselected(TabLayout.Tab tab) {

          }

          @Override
          public void onTabReselected(TabLayout.Tab tab) {

          }
      });

    }
    private void setViewPager(){
        FragmentList_One myFragment1 = new FragmentList_One();
        FragmentList_Two myFragment2 = new FragmentList_Two();
        FragmentList_Three myFragment3 = new FragmentList_Three();
        List<Fragment> fragmentList = new ArrayList<Fragment>();
        fragmentList.add(myFragment1);
        fragmentList.add(myFragment2);
        fragmentList.add(myFragment3);
        ViewPagerFragmentAdapter myFragmentAdapter = new ViewPagerFragmentAdapter(getSupportFragmentManager(), fragmentList);
        myViewPager.setAdapter(myFragmentAdapter);
    }

}
