package a937363e9_abe6_46e9_b863_e8c5085745bb.listitemdragtest;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private List<String> items = new ArrayList<>();
    private Context context;
    private ItemTouchHelper itemTouchHelper;

    public MyAdapter(Context context) {
        this.context = context;
    }

    public void addItem(String text) {
        items.add(text);
    }

    public void removeItem(int position) {
        items.remove(position);
    }

    public void setItemTouchHelper(ItemTouchHelper itemTouchHelper) {
        this.itemTouchHelper = itemTouchHelper;
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

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView itemText;

        public MyViewHolder(Context context) {
            super(View.inflate(context, R.layout.list_item, null));
            itemText = (TextView)itemView.findViewById(R.id.textView);
            itemView.findViewById(R.id.dots).setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    Log.d("item", "touched " + itemText.getText());
                    if (event.getActionMasked() == MotionEvent.ACTION_DOWN) {
                        if (itemTouchHelper != null) {
                            itemTouchHelper.startDrag(MyViewHolder.this);
                        }
                    }
                    return false;
                }
            });
        }

        public void setItemText(String text) {
            itemText.setText(text);
        }
    }
}
