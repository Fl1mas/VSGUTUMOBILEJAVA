package com.example.vsgutulabs.LB8;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.vsgutulabs.R;

public class ProductDetailsActivity extends AppCompatActivity {
    private Product product;
    private ImageView imageView;
    private EditText nameEditText, categoryEditText, descriptionEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);

        product = getIntent().getParcelableExtra("product");
        if (product == null) {
            finish();
            return;
        }

        imageView = findViewById(R.id.imageView);
        nameEditText = findViewById(R.id.nameEditText);
        categoryEditText = findViewById(R.id.categoryEditText);
        descriptionEditText = findViewById(R.id.descriptionEditText);

        imageView.setImageResource(product.getImageResourceId());
        nameEditText.setText(product.getName());
        categoryEditText.setText(product.getCategory());
        descriptionEditText.setText(product.getDescription());

        findViewById(R.id.saveButton).setOnClickListener(v -> saveChanges());
    }

    private void saveChanges() {
        String newName = nameEditText.getText().toString().trim();
        String newCategory = categoryEditText.getText().toString().trim();
        String newDescription = descriptionEditText.getText().toString().trim();

        if (TextUtils.isEmpty(newName) || TextUtils.isEmpty(newCategory)) {
            Toast.makeText(this, "Название и категория не могут быть пустыми", Toast.LENGTH_SHORT).show();
            return;
        }

        product.setName(newName);
        product.setCategory(newCategory);
        product.setDescription(newDescription);

        Toast.makeText(this, "Данные обновлены", Toast.LENGTH_SHORT).show();

        Intent resultIntent = new Intent();
        resultIntent.putExtra("updatedProduct", product);
        setResult(RESULT_OK, resultIntent);

        Toast.makeText(this, "Данные отправлены обратно в MainActivity", Toast.LENGTH_SHORT).show();

        finish();
    }
}