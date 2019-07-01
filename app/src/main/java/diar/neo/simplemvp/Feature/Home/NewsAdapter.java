package diar.neo.simplemvp.Feature.Home;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

import diar.neo.simplemvp.Const;
import diar.neo.simplemvp.Feature.detail.DetailActivity;
import diar.neo.simplemvp.R;
import diar.neo.simplemvp.data.News;


public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsViewHolder> {

    private List<News> mNewsList;
    private Context mContext;

    public NewsAdapter(Context context, List<News> news) {

        mNewsList = news;
        mContext = context;
    }

    @NonNull
    @Override
    public NewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_rv_home_fragment, parent, false);

        return new NewsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsViewHolder holder, final int position) {
        holder.txtTitle.setText(mNewsList.get(position).getTitle());
        holder.txtDate.setText(mNewsList.get(position).getDate());
        Picasso.get()
                .load(mNewsList.get(position).getImage_url())
                .error(R.color.colorAccent)
                .placeholder(R.drawable.ic_launcher_background)
                .into(holder.img_icon);

        holder.cardParent.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, DetailActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra(Const.KEY_TITLE,mNewsList.get(position).getTitle());
                intent.putExtra(Const.KEY_DATE,mNewsList.get(position).getDate());
                intent.putExtra(Const.KEY_IMAGE,mNewsList.get(position).getImage_url());
                intent.putExtra(Const.KEY_DESC,mNewsList.get(position).getDescription());
                mContext.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return mNewsList.size();
    }

    public class NewsViewHolder extends RecyclerView.ViewHolder {
        private ImageView img_icon;
        private TextView txtDate;
        private TextView txtTitle;
        private CardView cardParent;

        public NewsViewHolder(@NonNull View itemView) {
            super(itemView);

            img_icon = itemView.findViewById(R.id.img_newsRow_icon);
            txtDate = itemView.findViewById(R.id.txt_newsRow_date);
            txtTitle = itemView.findViewById(R.id.txt_newsRow_title);
            cardParent = itemView.findViewById(R.id.cardview_item_homefragment);

        }
    }


}
