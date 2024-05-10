package com.example.vsgutulabs.LB9;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.vsgutulabs.R;

public class NoteDetailsActivity extends AppCompatActivity {

    private EditText titleEditText;
    private EditText descriptionEditText;
    private Spinner prioritySpinner;
    private Button saveButton;
    private Button deleteButton;
    private ArrayAdapter<CharSequence> spinnerAdapter;

    private int selectedPosition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_details);

        titleEditText = findViewById(R.id.edit_text_title);
        descriptionEditText = findViewById(R.id.edit_text_description);
        prioritySpinner = findViewById(R.id.spinner_priority);
        saveButton = findViewById(R.id.btn_save);
        deleteButton = findViewById(R.id.btn_delete);

        spinnerAdapter = new ArrayAdapter<CharSequence>(this, R.layout.spinner_item_priority, R.id.text_view_priority, getResources().getStringArray(R.array.priority_array)) {
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                View view = super.getView(position, convertView, parent);
                ImageView imageView = view.findViewById(R.id.image_view_priority);

                switch (position) {
                    case 0:
                        imageView.setImageResource(R.drawable.green_circle);
                        break;
                    case 1:
                        imageView.setImageResource(R.drawable.yellow_circle);
                        break;
                    case 2:
                        imageView.setImageResource(R.drawable.red_circle);
                        break;
                }

                return view;
            }

            @Override
            public View getDropDownView(int position, View convertView, ViewGroup parent) {
                return getView(position, convertView, parent);
            }
        };
        prioritySpinner.setAdapter(spinnerAdapter);

        Intent intent = getIntent();
        if (intent != null) {
            selectedPosition = intent.getIntExtra("position", -1);
            String title = intent.getStringExtra("title");
            String description = intent.getStringExtra("description");
            int priority = intent.getIntExtra("priority", 0);
            boolean isNewNote = intent.getBooleanExtra("isNewNote", false);

            titleEditText.setText(title);
            descriptionEditText.setText(description);
            prioritySpinner.setSelection(priority);

            if (isNewNote) {
                deleteButton.setVisibility(View.GONE);
            } else {
                deleteButton.setVisibility(View.VISIBLE);
            }
        }

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newTitle = titleEditText.getText().toString().trim();
                String newDescription = descriptionEditText.getText().toString();
                int newPriority = prioritySpinner.getSelectedItemPosition();

                if (TextUtils.isEmpty(newTitle)) {
                    Toast.makeText(NoteDetailsActivity.this, "Пожалуйста, введите заголовок", Toast.LENGTH_SHORT).show();
                } else {
                    Note updatedNote = new Note(newTitle, newDescription, newPriority);

                    Intent resultIntent = new Intent();
                    resultIntent.putExtra("updatedNote", updatedNote);
                    resultIntent.putExtra("position", selectedPosition);
                    setResult(RESULT_OK, resultIntent);

                    finish();
                }
            }
        });

        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (selectedPosition != -1) {
                    Intent resultIntent = new Intent();
                    resultIntent.putExtra("position", selectedPosition);
                    resultIntent.putExtra("isDeleted", true);
                    setResult(RESULT_OK, resultIntent);
                    finish();
                }
            }
        });
    }
}