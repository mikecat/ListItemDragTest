package a937363e9_abe6_46e9_b863_e8c5085745bb.listitemdragtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.theList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        final MyAdapter adapter = new MyAdapter(this);
        recyclerView.setAdapter(adapter);
        adapter.addItem(getText(R.string.initial_item1).toString());
        adapter.addItem(getText(R.string.initial_item2).toString());
        adapter.addItem(getText(R.string.initial_item3).toString());
        adapter.notifyDataSetChanged();

        final EditText editTextToAdd = (EditText)findViewById(R.id.textToAdd);
        findViewById(R.id.addButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adapter.addItem(editTextToAdd.getText().toString());
                adapter.notifyDataSetChanged();
            }
        });

        ItemTouchHelper ith = new ItemTouchHelper(
                new ItemTouchHelper.SimpleCallback(ItemTouchHelper.UP | ItemTouchHelper.DOWN, 0) {
                    @Override
                    public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
                        int fromPos = viewHolder.getAdapterPosition();
                        int toPos = target.getAdapterPosition();
                        Log.d("item_move", "move " + fromPos + " to " + toPos);
                        adapter.notifyItemMoved(fromPos, toPos);
                        return true;
                    }

                    @Override
                    public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {

                    }
                }
        );
        ith.attachToRecyclerView(recyclerView);
    }
}
