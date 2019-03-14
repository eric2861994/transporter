package com.kargo.transporter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class JobsAdapter extends RecyclerView.Adapter<JobsAdapter.ViewHolder> {

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView date;
        private final TextView origin;
        private final TextView destination;
        private final TextView price;

        public ViewHolder(View v) {
            super(v);
            // Define click listener for the ViewHolder's View.
            date = v.findViewById(R.id.date);
            origin = v.findViewById(R.id.origin);
            destination = v.findViewById(R.id.destination);
            price = v.findViewById(R.id.price);
        }

        public void setViews(JobData data) {
            this.date.setText(data.getDate().toString());
            this.origin.setText(data.getOrigin());
            this.destination.setText(data.getDestination());
            this.price.setText(Integer.toString(data.getPrice()));
        }
    }

    private List<JobData> jobs;

    public void setJobs(List<JobData> jobs) {
        this.jobs = jobs;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card1, parent, false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.setViews(jobs.get(position));
    }

    @Override
    public int getItemCount() {
        return jobs.size();
    }
}
