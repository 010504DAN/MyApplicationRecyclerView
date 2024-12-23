package com.example.myapplicationrecyclerview;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapplicationrecyclerview.databinding.FragmentFirstBinding;

import java.util.ArrayList;

public class FirstFragment extends Fragment implements OnItemClick{

    private FragmentFirstBinding binding;
    ArrayList<Continent> continents = new ArrayList<>();
    ArrayList<Country> countries = new ArrayList<>();
    ArrayList<Cities> cities = new ArrayList<>();
    Boolean isContinent = true;
    Boolean isCountry = false;
    Boolean isCities = false;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentFirstBinding.inflate(inflater,container,false);
        return  binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        loadContinents();
        ContinentAdapter adapter = new ContinentAdapter(continents, this::onClick);
        binding.recyclerView.setAdapter(adapter);
    }

    private void loadContinents() {
        continents.add(new Continent("Asia"));
        continents.add(new Continent("Europe"));
        continents.add(new Continent("Northern America"));
    }

    @Override
    public void onClick(int position) {
        if (isContinent){
            isContinent = false;
            isCountry = true;
            loadCountries(position);
        } else if (isCountry) {
            isCountry = false;
            loadCities(position);
            isCities = true;
        } else if (isCities){
            isCities = false;
            Bundle bundle = new Bundle();
            bundle.putString("img", cities.get(position).getImg());
            bundle.putString("name", cities.get(position).getName());
            bundle.putString("description", cities.get(position).getDescription());
            DetailFragment fragment = new DetailFragment();
            fragment.setArguments(bundle);
            getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.main, fragment).commit();
        }
    }

    private void loadCities(int position) {
      cities = countries.get(position).getCities();
      CitiesAdapter citiesAdapter = new CitiesAdapter(cities, this::onClick);
      binding.recyclerView.setAdapter(citiesAdapter);
    }

    private void loadCountries(int position) {
        switch (position){
            case 0:
                ArrayList<Cities> citiesKyrgyzstan = new ArrayList<>();
                citiesKyrgyzstan.add(new Cities("https://upload.wikimedia.org/wikipedia/commons/thumb/4/42/Bishkek_City%27s_business_center.jpg/432px-Bishkek_City%27s_business_center.jpg",
                        "Bishkek",
                        "The Khanate of Kokand established the fortress of Pishpek in 1825 " +
                        "to control local caravan routes and to collect tribute from Kyrgyz tribes. " +
                        "On 4 September 1860, with the approval of the Kyrgyz, Russian forces led by " +
                        "Colonel Apollon Zimmermann destroyed the fortress. In the present day, the fortress " +
                        "ruins can be found just north of Jibek jolu Street, near the new main mosque." +
                        "[7] A Russian settlement was established in 1868 on the site of the fortress under " +
                        "its original name, Pishpek. It lay within the General Governorship of Russian " +
                        "Turkestan and its Semirechye Oblast."));
                citiesKyrgyzstan.add(new Cities("https://upload.wikimedia.org/wikipedia/commons/thumb/3/31/Osh_03-2016_img27_view_from_Sulayman_Mountain.jpg/399px-Osh_03-2016_img27_view_from_Sulayman_Mountain.jpg",
                        "Osh",
                        "Osh has an important outdoor activity bazaar which has been taking place " +
                                "on the same spot for the past 2,000 years and was a major market along the Silk Road. " +
                                "The city's industrial base, established during the Soviet period, largely " +
                                "collapsed after the break-up of the Soviet Union and has only recently[when?] " +
                                "started to revive."));
                citiesKyrgyzstan.add(new Cities("https://upload.wikimedia.org/wikipedia/commons/thumb/c/c9/Naryn_overlook.jpg/375px-Naryn_overlook.jpg",
                        "Narin",
                        "Naryn (/nəˈrɪn/ nə-RIN; Kyrgyz: Нарын [nɑrɯ́n]) is the regional administrative center of " +
                                "Naryn Region in central Kyrgyzstan. Its area is 84 square kilometres (32 sq mi),[2] " +
                                "and its estimated population was 41,178 as of January 2021.[1] The town was established " +
                                "as a fortress on the caravan route in 1868.[3] It is situated on both banks of the river " +
                                "Naryn (one of the main headwaters of the Syr Darya), which cuts a picturesque gorge " +
                                "through the town. The city has two regional museums and some hotels, but is otherwise " +
                                "residential."));
                countries.add(new Country("Kyrgyzstan", citiesKyrgyzstan));
                ArrayList<Cities> Kazakhstan = new ArrayList<>();
                Kazakhstan.add(new Cities("","Astana",""));
                Kazakhstan.add(new Cities("","Almaty",""));
                countries.add(new Country("Kazakhstan", Kazakhstan));
                break;
            case 1:
                ArrayList<Cities> citiesGermany = new ArrayList<>();
                citiesGermany.add(new Cities(""," Munich",""));
                citiesGermany.add(new Cities("","Berlin",""));
                citiesGermany.add(new Cities("","Hamburg",""));
                countries.add(new Country("Germany", citiesGermany));
                ArrayList<Cities> France = new ArrayList<>();
                France.add(new Cities("","Paris",""));
                France.add(new Cities("","Paris",""));
                countries.add(new Country("France", France));

            case 2:
                ArrayList<Cities> America = new ArrayList<>();
                America.add(new Cities("","New York",""));
                America.add(new Cities("","Los Angeles",""));
                America.add(new Cities("","Chicago",""));
                countries.add(new Country("America", America));
                ArrayList<Cities> Canada = new ArrayList<>();
                Canada.add(new Cities("","Alberta",""));
                Canada.add(new Cities("","Manitoba",""));
                countries.add(new Country("Canada", Canada));

        }
        CountryAdapter countryAdapter = new CountryAdapter(countries,this::onClick);
        binding.recyclerView.setAdapter(countryAdapter);
    }
}