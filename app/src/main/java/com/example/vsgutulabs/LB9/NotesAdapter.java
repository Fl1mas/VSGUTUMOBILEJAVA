package com.example.vsgutulabs.LB9;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.vsgutulabs.R;

import java.util.List;

public class NotesAdapter extends RecyclerView.Adapter<NotesAdapter.NoteViewHolder> {

    private List<Note> notes;
    private OnNoteClickListener listener;

    public NotesAdapter(List<Note> notes) {
        this.notes = notes;
    }

    public void setOnNoteClickListener(OnNoteClickListener listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public NoteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_note, parent, false);
        return new NoteViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull NoteViewHolder holder, @SuppressLint("RecyclerView") int position) {
        Note note = notes.get(position);
        holder.bind(note);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    listener.onNoteClick(position);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return notes.size();
    }

    public void updateNote(int position, Note updatedNote) {
        notes.set(position, updatedNote);
        notifyItemChanged(position);
    }

    public interface OnNoteClickListener {
        void onNoteClick(int position);
    }

    static class NoteViewHolder extends RecyclerView.ViewHolder {
        private TextView titleTextView;
        private ImageView priorityImageView;

        NoteViewHolder(View itemView) {
            super(itemView);
            titleTextView = itemView.findViewById(R.id.text_view_title);
            priorityImageView = itemView.findViewById(R.id.image_view_priority);
        }

        void bind(Note note) {
            titleTextView.setText(note.getTitle());
            switch (note.getPriority()) {
                case 0:
                    priorityImageView.setImageResource(R.drawable.green_circle);
                    break;
                case 1:
                    priorityImageView.setImageResource(R.drawable.yellow_circle);
                    break;
                case 2:
                    priorityImageView.setImageResource(R.drawable.red_circle);
                    break;
            }
        }
    }
}