package com.studies.quizzapp;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    private List<Question> list = new ArrayList<>();

    public RecyclerAdapter() {
    }

    @NonNull
    @Override
    public RecyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.single_question_item, parent, false);
        return new RecyclerAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapter.ViewHolder holder, int position) {

        holder.question.setText(list.get(position).getQuestion());
        holder.choice1.setText(list.get(position).getChoice1());
        holder.choice2.setText(list.get(position).getChoice2());
        holder.choice3.setText(list.get(position).getChoice3());
        holder.choice4.setText(list.get(position).getChoice4());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView question;
        TextView choice1;
        TextView choice2;
        TextView choice3;
        TextView choice4;

        public ViewHolder(View view) {
            super(view);

            question = view.findViewById(R.id.question);
            choice1 = view.findViewById(R.id.choice_1);
            choice2 = view.findViewById(R.id.choice_2);
            choice3 = view.findViewById(R.id.choice_3);
            choice4 = view.findViewById(R.id.choice_4);
        }
    }

    public void swapData(Question question) {
        list.add(question);
        notifyDataSetChanged();
    }

    public void clearData() {
        list.clear();
    }
}
