package diar.neo.simplemvp.Home;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;
import java.util.List;

import diar.neo.simplemvp.R;
import diar.neo.simplemvp.data.News;


public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsViewHolder> {

    private List<News> mNewsList;

    public NewsAdapter(List<News> news) {

        mNewsList = news;

    }

    @NonNull
    @Override
    public NewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_rv_home_fragment, parent, false);

        return new NewsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsViewHolder holder, int position) {
        holder.txtTitle.setText(mNewsList.get(position).getTitle());
        holder.txtDate.setText(mNewsList.get(position).getDate());
        Picasso.get()
                .load(mNewsList.get(position).getImage_url())
                .error(R.color.colorAccent)
                .placeholder(R.drawable.ic_launcher_background)
                .into(holder.img_icon);

    }

    @Override
    public int getItemCount() {
        return mNewsList.size();
    }

    public class NewsViewHolder extends RecyclerView.ViewHolder {
        private ImageView img_icon;
        private TextView txtDate;
        private TextView txtTitle;

        public NewsViewHolder(@NonNull View itemView) {
            super(itemView);

            img_icon=itemView.findViewById(R.id.img_newsRow_icon);
            txtDate=itemView.findViewById(R.id.txt_newsRow_date);
            txtTitle=itemView.findViewById(R.id.txt_newsRow_title);


        }
    }


}
