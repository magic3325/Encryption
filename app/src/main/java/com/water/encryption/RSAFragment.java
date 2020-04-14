package com.water.encryption;


import android.app.Activity;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
public class RSAFragment extends Fragment {
    private static final String ARG_SECTION_NUMBER = "section_number";

    FragmentPagerAdapter adapterViewPager;

    public RSAFragment() {
    }

    public static RSAFragment newInstance(int sectionNumber){
        RSAFragment fragment = new RSAFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER,sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        ((MainActivity)activity).onSectionAttached(getArguments().getInt(ARG_SECTION_NUMBER));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootview = inflater.inflate(R.layout.fragment_rsa, container, false);
        ViewPager vpPager = (ViewPager)rootview.findViewById(R.id.vpPager);
        adapterViewPager = new MyPagerAdapter(getChildFragmentManager());//注意这里的getChildFragmentManager(),不然无法加载数据,出现空白
        vpPager.setAdapter(adapterViewPager);
        return rootview;
    }


    public static class MyPagerAdapter extends FragmentPagerAdapter {
        private static int NUM_ITEMS = 3;
        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public int getCount() {
            return NUM_ITEMS;
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return RSAFragmentFirst.newInstance(0, "Page 1");
                case 1:
                    return RSAFragmentSecond.newInstance(1, "Page 2");
                case 2:
                    return RSAFragmentThird.newInstance(2, "Page 3");
                default:
                    return null;
            }
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position){
                case 0:
                    return "密钥";
                case 1:
                    return "加密";
                case 2:
                    return "签名";
                default:
                    return null;
            }
        }

    }
}
