package com.example.noteeditor;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private EditText editTextNote;
    private Button buttonPostNote;
    private RecyclerView recyclerViewNotes;
    private NoteAdapter noteAdapter;
    private List<Note> notes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextNote = findViewById(R.id.editTextNote);
        buttonPostNote = findViewById(R.id.buttonPostNote);
        recyclerViewNotes = findViewById(R.id.recyclerViewNotes);

        notes = new ArrayList<>();
        noteAdapter = new NoteAdapter(notes);

        recyclerViewNotes.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewNotes.setAdapter(noteAdapter);

        buttonPostNote.setOnClickListener(v -> {
            String noteText = editTextNote.getText().toString();
            if (!noteText.isEmpty()) {
                notes.add(new Note(noteText, "Anonymous"));
                noteAdapter.notifyItemInserted(notes.size() - 1);
                editTextNote.setText("");
            }
        });
    }
}
