package vn.edu.csc.bt_advanceui;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class WeatherAdapter extends FragmentStateAdapter {


//    public WeatherAdapter(@NonNull FragmentActivity fragmentActivity) {
//        super(fragmentActivity);
//    }
//
//    @NonNull
//    @Override
//    public Fragment createFragment(int position) {
//        return WeatherFragment.newInstance(position);
//    }
//
//    @Override
//    public int getItemCount() {
//        return 5;
//    }

    public WeatherAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0:
                return new SunnyWeatherFragment();
            case 1:
                return new StormWeatherFragment();
            case 2:
                return new RainyWeatherFragment();
        }
        return null;
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
