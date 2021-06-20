package com.example.toko;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class TasksAdapter extends RecyclerView.Adapter<TasksAdapter.TasksViewHolder> {

    private Context mCtx;
    private List<Task> taskList;

    public TasksAdapter(Context mCtx, List<Task> taskList) {
        this.mCtx = mCtx;
        this.taskList = taskList;
    }

    @Override
    public TasksViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mCtx).inflate(R.layout.recyclerview_tasks, parent, false);
        return new TasksViewHolder(view);
    }

    @Override
    public void onBindViewHolder(TasksViewHolder holder, int position) {
        int hasil;
        Task t = taskList.get(position);
        String pemasukkan = "Pemasukkan : Rp. ";
        pemasukkan += t.getPemasukkan();
        String pengeluaran = "Pengeluaran  : Rp. ";
        pengeluaran += t.getPengeluaran();
        hasil = Integer.parseInt(t.getPemasukkan()) - Integer.parseInt(t.getPengeluaran());
        holder.textViewTask.setText(t.getTanggal());
        holder.textViewDesc.setText(pemasukkan);
        holder.textViewFinishBy.setText(pengeluaran);
        holder.textViewStatus.setText("Keuntungan   : Rp. " + String.valueOf(hasil));
    }

    @Override
    public int getItemCount() {
        return taskList.size();
    }

    class TasksViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView textViewStatus, textViewTask, textViewDesc, textViewFinishBy;

        public TasksViewHolder(View itemView) {
            super(itemView);

            textViewTask = itemView.findViewById(R.id.textViewTask);
            textViewDesc = itemView.findViewById(R.id.textViewDesc);
            textViewFinishBy = itemView.findViewById(R.id.textViewFinishBy);
            textViewStatus = itemView.findViewById(R.id.textViewHasil);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            Task task = taskList.get(getAdapterPosition());

            Intent intent = new Intent(mCtx, UpdateTaskActivity.class);
            intent.putExtra("task", task);

            mCtx.startActivity(intent);
        }
    }
}