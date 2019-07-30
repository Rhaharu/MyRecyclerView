package com.RahmatHidayat.myrecyclerview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
  RecyclerView categoryListView;
  private ArrayList<Hero> list;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    categoryListView = findViewById(R.id.rv_category);
    categoryListView.setHasFixedSize(true);
    list = new ArrayList<>();

    list.addAll(HeroData.getListData());
    setActionBarTitle("Mode List");
    showRecyclerList();
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    getMenuInflater().inflate(R.menu.menu_main, menu);
    return super.onCreateOptionsMenu(menu);
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    String title = null;
    switch (item.getItemId()) {
      case R.id.action_list:
        title = "Mode List";
        showRecyclerList();
        break;

      case R.id.action_grid:
        title = "Mode Grid";
        showRecyclerGrid();
        break;

      case R.id.action_cardview:
        title = "Mode CardView";
        showRecyclerCardView();
        break;
    }
    setActionBarTitle(title);
    return super.onOptionsItemSelected(item);
  }

  private void setActionBarTitle(String title) {
    if (getSupportActionBar() != null) {
      getSupportActionBar().setTitle(title);
    }
  }

  private void showSelectedHero(Hero hero) {
    Toast.makeText(this, "Kamu memilih " + hero.getName(), Toast.LENGTH_SHORT).show();
  }

  private void showRecyclerList() {
    categoryListView.setLayoutManager(new LinearLayoutManager(this));
    ListHeroAdapter listHeroAdapter = new ListHeroAdapter(this);
    listHeroAdapter.setListHero(list);
    categoryListView.setAdapter(listHeroAdapter);

    ItemClickSupport.addTo(categoryListView).setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
      @Override
      public void onItemClicked(RecyclerView recyclerView, int position, View v) {
        showSelectedHero(list.get(position));
      }
    });
  }

  private void showRecyclerGrid() {
    categoryListView.setLayoutManager(new GridLayoutManager(this, 2));
    GridHeroAdapter gridHeroAdapter = new GridHeroAdapter(this);
    gridHeroAdapter.setListHero(list);
    categoryListView.setAdapter(gridHeroAdapter);

    ItemClickSupport.addTo(categoryListView).setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
      @Override
      public void onItemClicked(RecyclerView recyclerView, int position, View v) {
        showSelectedHero(list.get(position));
      }
    });
  }

  private void showRecyclerCardView() {
    categoryListView.setLayoutManager(new LinearLayoutManager(this));
    CardViewHeroAdapter cardViewHeroAdapter = new CardViewHeroAdapter(this);
    cardViewHeroAdapter.setListHero(list);
    categoryListView.setAdapter(cardViewHeroAdapter);

    ItemClickSupport.addTo(categoryListView).setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
      @Override
      public void onItemClicked(RecyclerView recyclerView, int position, View v) {
        showSelectedHero(list.get(position));
      }
    });
  }
}
