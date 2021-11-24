package com.dacasa.streamingapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.dacasa.streamingapp.cv.CvFragment;
import com.dacasa.streamingapp.portfolio.portfolioFragment;
import com.dacasa.streamingapp.sidemenu.MenuUtil;
import com.dacasa.streamingapp.sidemenu.Menuitem;
import com.dacasa.streamingapp.sidemenu.Callback;
import com.dacasa.streamingapp.team.TeamFragment;
import com.dacasa.streamingapp.home.CVHomeFragment;

import java.util.List;

public class CVMainActivity extends AppCompatActivity implements Callback {

    RecyclerView menuRv;
    List<Menuitem> menuitems;
    MenuAdapter adapter;
    int selectedMenuPos = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c_v_main);
        getSupportActionBar().hide();

        // setup side menu
        setSideMenu();

        //set the default fragment when activity launch
        setHomeFragment();


        //setPortfolioragment();
        //setTeamFragment();
        //setCVFragment();
        //setHomeFragment();
    }

    private void setSideMenu() {
        menuRv = findViewById(R.id.rv_side_menu);
        // get menu list item will get data from a static data class

        menuitems = MenuUtil.getMenuList();
        adapter = new MenuAdapter(menuitems,this);
        menuRv.setLayoutManager(new LinearLayoutManager(this));
        menuRv.setAdapter(adapter);



    }


    void setPortfolioragment() {
        getSupportFragmentManager().beginTransaction().replace(R.id.container, new portfolioFragment()).commit();
    }


    void setTeamFragment() {
        getSupportFragmentManager().beginTransaction().replace(R.id.container, new TeamFragment()).commit();
    }

    void setCVFragment() {
        getSupportFragmentManager().beginTransaction().replace(R.id.container, new CvFragment()).commit();
    }

    void setHomeFragment() {
        getSupportFragmentManager().beginTransaction().replace(R.id.container, new CVHomeFragment()).commit();
    }


    @Override
    public void onSideMenuItemClick(int i) {

        switch (menuitems.get(i).getCode()) {
            case MenuUtil.HOME_FRAGMENT_CODE : setHomeFragment();
            break;

            case MenuUtil.CV_FRAGMENT_CODE : setCVFragment();
                break;
            case MenuUtil.TEAM_FRAGMENT_CODE : setTeamFragment();
                break;
            case MenuUtil.PORTFOLIO_FRAGMENT_CODE : setPortfolioragment();
                break;
            default: setHomeFragment();
        }

        //highlight the selected menu item
        menuitems.get(selectedMenuPos).setSelected(false);
        menuitems.get(i).setSelected(true);
        selectedMenuPos = i;
        adapter.notifyDataSetChanged();

    }
}