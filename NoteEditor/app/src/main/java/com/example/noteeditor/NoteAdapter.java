package com.example.noteeditor;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.NoteViewHolder> {
    private List<Note> notes;

    public NoteAdapter(List<Note> notes) {
        this.notes = notes;
    }

    @NonNull
    @Override
    public NoteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.note_item, parent, false);
        return new NoteViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NoteViewHolder holder, int position) {
        Note note = notes.get(position);

        // Set note text and author
        holder.textViewNoteText.setText(note.getText());
        holder.textViewAuthor.setText("Posted by: " + note.getAuthor());

        // Set initial like and dislike counts
        holder.textViewLikeCount.setText(String.valueOf(note.getLikes()));
        holder.textViewDislikeCount.setText(String.valueOf(note.getDislikes()));

        // Handle "Like" button click
        holder.buttonLike.setOnClickListener(v -> {
            note.like(); // Increment like count in the model
            holder.textViewLikeCount.setText(String.valueOf(note.getLikes())); // Update count in UI
            holder.buttonLike.setBackgroundColor(Color.parseColor("#FFA500")); // Change color to orange
        });

        // Handle "Dislike" button click
        holder.buttonDislike.setOnClickListener(v -> {
            note.dislike(); // Increment dislike count in the model
            holder.textViewDislikeCount.setText(String.valueOf(note.getDislikes())); // Update count in UI
            holder.buttonDislike.setBackgroundColor(Color.parseColor("#FF0000")); // Change color to red
        });

        // Handle "Comment" button click
        holder.buttonComment.setOnClickListener(v -> {
            if (holder.editTextComment.getVisibility() == View.GONE) {
                holder.editTextComment.setVisibility(View.VISIBLE); // Show comment input
            } else {
                // Add comment to the TextView and hide the input field
                String comment = holder.editTextComment.getText().toString().trim();
                if (!comment.isEmpty()) {
                    String existingComments = holder.textViewComments.getText().toString();
                    holder.textViewComments.setVisibility(View.VISIBLE); // Show comments area
                    holder.textViewComments.setText(existingComments + "\n" + comment);
                    holder.editTextComment.setText(""); // Clear input
                }
                holder.editTextComment.setVisibility(View.GONE); // Hide input field
            }
        });
    }

    @Override
    public int getItemCount() {
        return notes.size();
    }

    // ViewHolder class
    static class NoteViewHolder extends RecyclerView.ViewHolder {
        TextView textViewNoteText, textViewAuthor, textViewLikeCount, textViewDislikeCount, textViewComments;
        Button buttonLike, buttonDislike, buttonComment;
        EditText editTextComment;

        public NoteViewHolder(@NonNull View itemView) {
            super(itemView);

            // Initialize views
            textViewNoteText = itemView.findViewById(R.id.textViewNoteText);
            textViewAuthor = itemView.findViewById(R.id.textViewAuthor);
            textViewLikeCount = itemView.findViewById(R.id.textViewLikeCount);
            textViewDislikeCount = itemView.findViewById(R.id.textViewDislikeCount);
            textViewComments = itemView.findViewById(R.id.textViewComments);
            buttonLike = itemView.findViewById(R.id.buttonLike);
            buttonDislike = itemView.findViewById(R.id.buttonDislike);
            buttonComment = itemView.findViewById(R.id.buttonComment);
            editTextComment = itemView.findViewById(R.id.editTextComment);
        }
    }
}
