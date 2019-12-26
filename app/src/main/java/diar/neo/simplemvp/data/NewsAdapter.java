package diar.neo.simplemvp.data;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

import diar.neo.simplemvp.Constants;
import diar.neo.simplemvp.data.local.NewsDataBase;
import diar.neo.simplemvp.R;
import diar.neo.simplemvp.data.model.News;
import diar.neo.simplemvp.feature.home.HomeFragment;
import diar.neo.simplemvp.feature.search.SearchFragment;


public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsViewHolder> {

    private List<News> mNewsList;
    private Context mContext;
    private Fragment fragment;

    public NewsAdapter(Context context, List<News> news, Fragment parentFragment) {

        mNewsList = news;
        mContext = context;
        fragment=parentFragment;
    }

    @NonNull
    @Override
    public NewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_rv_home_fragment, parent, false);

        return new NewsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final NewsViewHolder holder, final int position) {
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

                Bundle bundle=new Bundle();
                bundle.putString(Constants.KEY_IMAGE,mNewsList.get(position).getImage_url());
                bundle.putString(Constants.KEY_DESC,mNewsList.get(position).getDescription());
                bundle.putString(Constants.KEY_TITLE,mNewsList.get(position).getTitle());
                bundle.putString(Constants.KEY_DATE,mNewsList.get(position).getDate());
                final NavController navController = Navigation.findNavController(fragment.getActivity(), R.id.navHost_fragment);

                if (fragment instanceof SearchFragment){
                    navController.navigate(R.id.action_searchFragment_to_detailFragment,bundle);

                }else if (fragment instanceof HomeFragment){
                    navController.navigate(R.id.action_homeFragment_to_detailFragment,bundle);

                }else{
                    navController.navigate(R.id.action_savedFragment_to_detailFragment,bundle);

                }


            }
        });
        holder.imgBookmark.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

                boolean isBookmarked = NewsDataBase.getInstance(mContext).getNewsDAO().isBookmarked(mNewsList.get(position).getId());
                if (isBookmarked) {
                    Toast.makeText(mContext, "در لبست علاقه مندی ها وجود دارد", Toast.LENGTH_SHORT).show();
                } else {
                    NewsDataBase.getInstance(mContext).getNewsDAO().insertNews(mNewsList.get(position));
                    Toast.makeText(mContext, " لبست علاقه مندی ها", Toast.LENGTH_SHORT).show();

                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return mNewsList.size();
    }

    class NewsViewHolder extends RecyclerView.ViewHolder {
        private ImageView img_icon;
        private TextView txtDate;
        private TextView txtTitle;
        private CardView cardParent;
        private ImageView imgBookmark;

        NewsViewHolder(@NonNull View itemView) {
            super(itemView);

            img_icon = itemView.findViewById(R.id.img_newsRow_icon);
            txtDate = itemView.findViewById(R.id.txt_newsRow_date);
            txtTitle = itemView.findViewById(R.id.txt_newsRow_title);
            cardParent = itemView.findViewById(R.id.cardview_item_homefragment);
            imgBookmark = itemView.findViewById(R.id.img_newsRow_bookmark);

        }
    }


}
