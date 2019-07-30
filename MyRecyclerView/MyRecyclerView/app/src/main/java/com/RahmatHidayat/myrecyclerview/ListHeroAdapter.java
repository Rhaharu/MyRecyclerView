package com.RahmatHidayat.myrecyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import java.util.ArrayList;

public class ListHeroAdapter extends RecyclerView.Adapter<ListHeroAdapter.CategoryViewHolder> {
  private final Context context;
  private ArrayList<Hero> listHero;

  public ListHeroAdapter(Context context) {
    this.context = context;
  }

  @Override
  public CategoryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View itemRow = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row_hero, parent, false);
    return new CategoryViewHolder(itemRow);
  }

  @Override
  public void onBindViewHolder(CategoryViewHolder holder, int position) {
    holder.nameTv.setText(getHero(position).getName());
    holder.remarksTv.setText(getHero(position).getRemarks());

    Glide.with(context)
        .load(getHero(position).getPhoto())
        .override(55, 55)
        .crossFade()
        .into(holder.photoImage);
  }

  @Override public int getItemCount() { return listHero != null ? listHero.size() : 0; }
  Hero getHero(int aPos) { return listHero.get(aPos); }

  void setListHero(ArrayList<Hero> listHero) {
    this.listHero = listHero;
  }

  class CategoryViewHolder extends RecyclerView.ViewHolder {
    TextView nameTv;
    TextView remarksTv;
    ImageView photoImage;

    CategoryViewHolder(View itemView) {
      super(itemView);
      nameTv = itemView.findViewById(R.id.tv_item_name);
      remarksTv = itemView.findViewById(R.id.tv_item_remarks);
      photoImage = itemView.findViewById(R.id.img_item_photo);
    }
  }
}

