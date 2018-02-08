package a937363e9_abe6_46e9_b863_e8c5085745bb.listitemdragtest;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class MyViewHolder extends RecyclerView.ViewHolder {
    private TextView itemText;

    public MyViewHolder(Context context) {
        super(View.inflate(context, R.layout.list_item, null));
        itemText = (TextView)itemView.findViewById(R.id.textView);
    }

    public void setItemText(String text) {
        itemText.setText(text);
    }
}
