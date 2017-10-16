package org.wbing.test.refreshlayout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.wbing.test.R;
import org.wbing.test.refresh.RefreshActivity;
import org.wbing.test.refreshlayout.view.RefreshLayout;
import org.wbing.test.refreshlayout.view.impl.PullScrollableLayout;

public class RefreshLayoutActivity extends AppCompatActivity {

    PullScrollableLayout pullScrollableLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_refresh_layout);

        pullScrollableLayout = (PullScrollableLayout) findViewById(R.id.sl_layout);
        pullScrollableLayout.setOnRefreshListener(new RefreshLayout.OnRefreshListener() {
            @Override
            public void onPullDown(float y) {
                Log.e("onPullDown ",String.valueOf(y));
            }

            @Override
            public void onRefresh() {
//                pullScrollableLayout.showEmptyView();
                pullScrollableLayout.refreshOver(null);
             }

            @Override
            public void onRefreshOver(Object obj) {
//                Log.e("onRefreshOver ",String.valueOf(obj.getClass().getName()));
            }
        });

        pullScrollableLayout.getRefreshView().setExtralY(30);
        pullScrollableLayout.getRefreshView().getHelper().setCurrentScrollableContainer(findViewById(R.id.content));

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.content);


        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new RecyclerView.Adapter<RefreshActivity.Holder>() {

            @Override
            public RefreshActivity.Holder onCreateViewHolder(ViewGroup parent, int viewType) {
                return new RefreshActivity.Holder(new TextView(parent.getContext()));
            }

            @Override
            public void onBindViewHolder(RefreshActivity.Holder holder, int position) {
                holder.fill(position);
            }

            @Override
            public int getItemCount() {
                return 1;
            }
        });
    }
}
