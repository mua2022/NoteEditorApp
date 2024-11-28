package com.example.noteeditor;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.NoteViewHolder> {

    private final List<Note> notes;

    public NoteAdapter(List<Note> notes) {
        this.notes = notes;
    }

    @NonNull
    @Override
    public NoteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.note_item, parent, false);
        return new NoteViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NoteViewHolder holder, int position) {
        Note note = notes.get(position);
        holder.textViewNoteText.setText(note.getText());
        holder.textViewAuthor.setText("Posted by: " + note.getAuthor());
        holder.buttonLike.setOnClickListener(v -> {
            note.like();
            notifyItemChanged(position);
        });
        holder.buttonDislike.setOnClickListener(v -> {
            note.dislike();
            notifyItemChanged(position);
        });
        holder.buttonComment.setOnClickListener(v -> {
            // Add comment functionality
        });
    }

    @Override
    public int getItemCount() {
        return notes.size();
    }

    static class NoteViewHolder extends RecyclerView.ViewHolder {
        TextView textViewNoteText, textViewAuthor;
        Button buttonLike, buttonDislike, buttonComment;

        public NoteViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewNoteText = itemView.findViewById(R.id.textViewNoteText);
            textViewAuthor = itemView.findViewById(R.id.textViewAuthor);
            buttonLike = itemView.findViewById(R.id.buttonLike);
            buttonDislike = itemView.findViewById(R.id.buttonDislike);
            buttonComment = itemView.findViewById(R.id.buttonComment);
        }
    }
}
