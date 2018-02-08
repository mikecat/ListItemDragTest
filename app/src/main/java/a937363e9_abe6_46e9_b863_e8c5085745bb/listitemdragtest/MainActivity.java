package a937363e9_abe6_46e9_b863_e8c5085745bb.listitemdragtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.theList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new MyAdapter(this);
        recyclerView.setAdapter(adapter);
        adapter.addItem("cat");
        adapter.addItem("dog");
        adapter.addItem("rabbit");
        adapter.notifyDataSetChanged();

        final EditText editTextToAdd = (EditText)findViewById(R.id.textToAdd);
        findViewById(R.id.addButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adapter.addItem(editTextToAdd.getText().toString());
                adapter.notifyDataSetChanged();
            }
        });
    }
}
