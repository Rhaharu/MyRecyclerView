package com.RahmatHidayat.myrecyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import java.util.ArrayList;

public class GridHeroAdapter extends RecyclerView.Adapter<GridHeroAdapter.GridViewHolder> {
  private final Context context;
  private ArrayList<Hero> listHero;

  GridHeroAdapter(Context context) {
    this.context = context;
  }

  @Override
  public GridViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_grid_hero, parent, false);
    return new GridViewHolder(view);
  }

  @Override
  public void onBindViewHolder(GridViewHolder holder, int position) {
    Glide.with(context)
        .load(getHero(position).getPhoto())
        .override(350, 550)
        .into(holder.imgPhoto);
  }

  @Override public int getItemCount() { return listHero != null ? listHero.size() : 0; }
  private Hero getHero(int aPos) { return listHero.get(aPos); }

  void setListHero(ArrayList<Hero> listHero) {
    this.listHero = listHero;
  }

  class GridViewHolder extends RecyclerView.ViewHolder {
    ImageView imgPhoto;
    GridViewHolder(View itemView) {
      super(itemView);
      imgPhoto = itemView.findViewById(R.id.img_item_photo);
    }
  }
}
