package diar.neo.simplemvp.feature.category;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import diar.neo.simplemvp.R;
import diar.neo.simplemvp.data.Category;
public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategotyViewHolder> {
    private Context mContext;
    private List<Category> mCategories;

    public CategoryAdapter(Context context, List<Category> categories) {
        mContext = context;
        mCategories = categories;

    }

    @NonNull
    @Override
    public CategotyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_rv_categroy_fragment, parent, false);

        return new CategotyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategotyViewHolder holder, int position) {
        holder.txtCat.setText(mCategories.get(position).getCat_name());
    }

    @Override
    public int getItemCount() {
        return mCategories.size();
    }

    class CategotyViewHolder extends RecyclerView.ViewHolder {

        TextView txtCat;

        public CategotyViewHolder(@NonNull View itemView) {
            super(itemView);
            txtCat = itemView.findViewById(R.id.txt_category_row_name);
        }
    }
}
