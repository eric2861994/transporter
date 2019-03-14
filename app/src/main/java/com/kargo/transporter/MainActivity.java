package com.kargo.transporter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * This activity is to display jobs listing,
 * the list can be sorted by price and date.
 */
public class MainActivity extends AppCompatActivity implements SortDialog.SortDialogListener {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private List<JobData> myDataset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.jobs_list);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        recyclerView.setHasFixedSize(true);

        // use a linear layout manager
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        // retrieve mock data
        myDataset = new MockDataProvider().getJobs();
        mAdapter = new JobsAdapter();
        ((JobsAdapter) mAdapter).setJobs(myDataset);

        recyclerView.setAdapter(mAdapter);

        Toolbar myToolbar = findViewById(R.id.toolbar);
        setSupportActionBar(myToolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if (id == R.id.action_sort) {
            // open sorting dialog
            SortDialog newFragment = new SortDialog();
            newFragment.setListener(this);
            newFragment.show(getSupportFragmentManager(), "dialog");
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void sortData(SortEnum sortBy, boolean ascending) {
        if (sortBy == SortEnum.PRICE && ascending) {
            Collections.sort(myDataset, new Comparator<JobData>() {
                @Override
                public int compare(JobData o1, JobData o2) {
                    return o1.getPrice() - o2.getPrice();
                }
            });

        } else if (sortBy == SortEnum.PRICE && !ascending) {
            Collections.sort(myDataset, new Comparator<JobData>() {
                @Override
                public int compare(JobData o1, JobData o2) {
                    return o2.getPrice() - o1.getPrice();
                }
            });
        }

        ((JobsAdapter) mAdapter).setJobs(myDataset);
        mAdapter.notifyDataSetChanged();
    }
}
