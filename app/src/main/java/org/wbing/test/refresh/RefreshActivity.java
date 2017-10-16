package org.wbing.test.refresh;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.wbing.test.R;
import org.wbing.test.refresh.view.RefreshLayout;

public class RefreshActivity extends AppCompatActivity {

    RefreshLayout refreshLayout;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_refresh);
        refreshLayout = (RefreshLayout) findViewById(R.id.refresh);
        refreshLayout.setOnRefreshListener(new RefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout parent) {
                parent.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        refreshLayout.stopRefresh();
                    }
                },2000);
            }
        });


        recyclerView = (RecyclerView) findViewById(R.id.content);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new RecyclerView.Adapter<Holder>() {

            @Override
            public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
                return new Holder(new TextView(parent.getContext()));
            }

            @Override
            public void onBindViewHolder(Holder holder, int position) {
                holder.fill(position);
            }

            @Override
            public int getItemCount() {
                return 100;
            }
        });

    }


    class Holder extends RecyclerView.ViewHolder {

        TextView textView;

        public Holder(View itemView) {
            super(itemView);
            textView = (TextView) itemView;
            itemView.setPadding(20,20,20,20);
            itemView.setLayoutParams(new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        }

        public void fill(int pos) {
            textView.setText("position: " + pos);
        }
    }


}
