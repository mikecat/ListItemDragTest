package a937363e9_abe6_46e9_b863_e8c5085745bb.listitemdragtest;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {
    private List<String> items = new ArrayList<>();
    private Context context;

    public MyAdapter(Context context) {
        this.context = context;
    }

    public void addItem(String text) {
        items.add(text);
    }

    public void removeItem(int position) {
        items.remove(position);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MyViewHolder(context);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.setItemText(items.get(position));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}
