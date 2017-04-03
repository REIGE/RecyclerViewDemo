package com.reige.recyclerviewdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;


public class MainActivity extends AppCompatActivity {

    @BindView(R.id.RecyclerView)
    RecyclerView mRecyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        MyAdapter myAdapter = new MyAdapter(this, null, new MyAdapter.OnRvItemClick() {
            @Override
            public void onItemClick(View v, int position) {
                Toast.makeText(getApplicationContext(), "click" + position, Toast.LENGTH_SHORT)
                        .show();
            }
        });
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));

        mRecyclerView.setAdapter(myAdapter);
    }
}
