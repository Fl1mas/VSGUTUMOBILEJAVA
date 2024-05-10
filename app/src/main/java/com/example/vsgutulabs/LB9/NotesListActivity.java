package com.example.vsgutulabs.LB9;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.vsgutulabs.R;

import java.util.ArrayList;

public class NotesListActivity extends AppCompatActivity {

    private List<Note> notesList = new ArrayList<>();
    private NotesAdapter notesAdapter;
    private static final int EDIT_NOTE_REQUEST = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes_list);

        notesList.add(new Note("Заметка 1", "Описание 1", 2));
        notesList.add(new Note("Заметка 2", "Описание 2", 1));

        RecyclerView recyclerView = findViewById(R.id.recycler_view_notes);
        notesAdapter = new NotesAdapter(notesList);
        recyclerView.setAdapter(notesAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        sortNotesByPriority();

        notesAdapter.setOnNoteClickListener(new NotesAdapter.OnNoteClickListener() {
            @Override
            public void onNoteClick(int position) {
                Intent intent = new Intent(NotesListActivity.this, NoteDetailsActivity.class);
                intent.putExtra("position", position);
                intent.putExtra("title", notesList.get(position).getTitle());
                intent.putExtra("description", notesList.get(position).getDescription());
                intent.putExtra("priority", notesList.get(position).getPriority());
                startActivityForResult(intent, EDIT_NOTE_REQUEST);
            }
        });

        Button btnAddNote = findViewById(R.id.btn_add_note);
        btnAddNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Note newNote = new Note("", "", 0);
                int position = notesList.size();

                Intent intent = new Intent(NotesListActivity.this, NoteDetailsActivity.class);
                intent.putExtra("position", position);
                intent.putExtra("title", newNote.getTitle());
                intent.putExtra("description", newNote.getDescription());
                intent.putExtra("priority", newNote.getPriority());

                intent.putExtra("isNewNote", true);

                startActivityForResult(intent, EDIT_NOTE_REQUEST);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == EDIT_NOTE_REQUEST) {
            if (resultCode == RESULT_OK) {
                int position = data.getIntExtra("position", -1);
                boolean isDeleted = data.getBooleanExtra("isDeleted", false);

                if (position != -1) {
                    if (isDeleted) {
                        notesList.remove(position);
                    } else {
                        Note updatedNote = data.getParcelableExtra("updatedNote");
                        if (updatedNote != null) {
                            if (position < notesList.size()) {
                                notesList.set(position, updatedNote);
                            } else {
                                notesList.add(updatedNote);
                            }
                        }
                    }
                    sortNotesByPriority();
                }
            }
        }
    }

    private void sortNotesByPriority() {
        Collections.sort(notesList, new Comparator<Note>() {
            @Override
            public int compare(Note note1, Note note2) {
                return Integer.compare(note2.getPriority(), note1.getPriority());
            }
        });

        notesAdapter.notifyDataSetChanged();
    }
}