package com.example.webservicenews.Adapter;


import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.webservicenews.Common.Common;
import com.example.webservicenews.Interface.IconBetterIdeaService;
import com.example.webservicenews.Interface.ItemClickListener;
import com.example.webservicenews.Model.IconBetterIdea;
import com.example.webservicenews.Model.WebSite;
import com.example.webservicenews.R;
import com.example.webservicenews.ListNews;
import com.squareup.picasso.Picasso;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import de.hdodenhof.circleimageview.CircleImageView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* Making the recycle view clicking*/
class ListSourcesViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    /*------------------------------------------------*/
    ItemClickListener itemClickListener;
    TextView source_title;
    CircleImageView source_image;

    /*-------------------------------------------------*/
    // Definiendo constructor y metodo setter
    public ListSourcesViewHolder(@NonNull View itemView) {
        super(itemView);

        source_image = (CircleImageView) itemView.findViewById(R.id.source_image);
        source_title = (TextView) itemView.findViewById(R.id.source_name);
    }

    public void setItemClickListener(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }
    /*----------------------------------------------------------*/

    @Override
    public void onClick(View v) {
        itemClickListener.onClick(v, getAdapterPosition(), false);
    }
}

public class ListSourceAdapter extends RecyclerView.Adapter<ListSourcesViewHolder> {
    private Context context;
    private WebSite webSite;
    private IconBetterIdeaService mService;

    public ListSourceAdapter(Context context, WebSite webSite) {
        this.context = context;
        this.webSite = webSite;
        mService = Common.getIconService();
    }

    @NonNull
    @Override
    public ListSourcesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.source_layout, parent, false);
        return new ListSourcesViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull final ListSourcesViewHolder holder, int position) {
        StringBuilder iconBetterAPI = new StringBuilder("https://i.olsh.me/allicons.json?url=");
        iconBetterAPI.append(webSite.getSources().get(position).getUrl());
        /*-----------------------------------------------------------------------------*/
        mService.getIconUrl(iconBetterAPI.toString())
                .enqueue(new Callback<IconBetterIdea>() {
                    @Override
                    public void onResponse(Call<IconBetterIdea> call, Response<IconBetterIdea> response) {
                        if(response.body().getIcons().size() > 0){
                            Picasso.with(context)
                                    .load(response.body().getIcons().get(0).getUrl())
                            .into(holder.source_image);
                        }
                    }

                    @Override
                    public void onFailure(Call<IconBetterIdea> call, Throwable t) {

                    }
                });
        holder.source_title.setText(webSite.getSources().get(position).getName());
        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onClick(View view, int position, boolean isLongClick) {
                Intent intent = new Intent(context, ListNews.class);
                intent.putExtra("source",webSite.getSources().get(position).getId());
                intent.putExtra("sortBy", webSite.getSources().get(position).getSortBysAvailable().get(0));
                context.startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {
        return webSite.getSources().size();
    }
}

























