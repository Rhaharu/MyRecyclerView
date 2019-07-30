package com.RahmatHidayat.myrecyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.bumptech.glide.Glide;
import java.util.ArrayList;

public class CardViewHeroAdapter extends RecyclerView.Adapter<CardViewHeroAdapter.CardViewViewHolder> {
  private ArrayList<Hero> listHero;
  private final Context context;

  CardViewHeroAdapter(Context context) {
    this.context = context;
  }

  @Override
  public CardViewViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cardview_hero, parent, false);
    return new CardViewViewHolder(view);
  }

  @Override
  public void onBindViewHolder(CardViewViewHolder holder, int position) {
    Hero p = getHero(position);

    Glide.with(context)
        .load(p.getPhoto())
        .override(350, 550)
        .into(holder.imgPhoto);

    holder.tvName.setText(p.getName());
    holder.tvRemarks.setText(p.getRemarks());

    holder.btnFavorite.setOnClickListener(new CustomOnItemClickListener(position, new CustomOnItemClickListener.OnItemClickCallback() {
      @Override
      public void onItemClicked(View view, int position) {
        Toast.makeText(context, "Favorite " + getHero(position).getName(), Toast.LENGTH_SHORT).show();
      }
    }));

    holder.btnShare.setOnClickListener(new CustomOnItemClickListener(position, new CustomOnItemClickListener.OnItemClickCallback() {
      @Override
      public void onItemClicked(View view, int position) {
        Toast.makeText(context, "Share " + getHero(position).getName(), Toast.LENGTH_SHORT).show();
      }
    }));
  }

  @Override public int getItemCount() { return listHero != null ? listHero.size() : 0; }
  private Hero getHero(int aPos) { return listHero.get(aPos); }

  void setListHero(ArrayList<Hero> listHero) {
    this.listHero = listHero;
  }

  class CardViewViewHolder extends RecyclerView.ViewHolder {
    ImageView imgPhoto;
    TextView tvName;
    TextView tvRemarks;
    Button btnFavorite;
    Button btnShare;
    CardViewViewHolder(View itemView) {
      super(itemView);
      imgPhoto = itemView.findViewById(R.id.img_item_photo);
      tvName = itemView.findViewById(R.id.tv_item_name);
      tvRemarks = itemView.findViewById(R.id.tv_item_remarks);
      btnFavorite = itemView.findViewById(R.id.btn_set_favorite);
      btnShare = itemView.findViewById(R.id.btn_set_share);
    }
  }
}
