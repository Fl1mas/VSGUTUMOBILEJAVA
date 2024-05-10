package com.example.vsgutulabs.LB8;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;

import android.widget.Toast;

import com.example.vsgutulabs.R;

public class MainActivity2 extends AppCompatActivity {
    private ListView listView;
    private ArrayAdapter<Product> adapter;
    private ArrayList<Product> products;
    private static final int PRODUCT_DETAILS_REQUEST = 1;

    private ActivityResultLauncher<Intent> productDetailsLauncher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        listView = findViewById(R.id.listView);

        products = new ArrayList<>();
        products.add(new Product(101, R.drawable.toaster, "Тостер", "Электроприборы для кухни", "Этот тостер с четырьмя отделениями позволяет быстро и равномерно поджаривать тосты для вкусного завтрака."));
        products.add(new Product(102, R.drawable.iron, "Утюг", "Электроприборы для утюгов", "Этот утюг с паровой функцией обеспечивает идеально гладкие результаты при глажении одежды."));
        products.add(new Product(103, R.drawable.microwave, "Микроволновая печь", "Кухонная техника", "Эта микроволновка имеет несколько режимов нагрева и размораживания для быстрого приготовления пищи."));
        products.add(new Product(104, R.drawable.cleaner, "Пылесос", "Уборочные приборы", "Этот пылесос с мощным всасыванием подходит для уборки любой поверхности в доме."));
        products.add(new Product(105, R.drawable.teapot, "Электрический чайник", "Кухонные принадлежности", "Этот чайник быстро кипятит воду благодаря высокой мощности и автоматическому отключению."));
        products.add(new Product(106, R.drawable.fan, "Фен для волос", "Устройства для ухода за внешностью", "Этот фен обеспечивает быструю сушку волос и создание различных укладок благодаря разнообразным насадкам."));
        products.add(new Product(107, R.drawable.toothbrush, "Электрическая зубная щетка", "Товары для гигиены", "Эта зубная щетка оснащена множеством режимов чистки для эффективного ухода за зубами и деснами."));
        products.add(new Product(108, R.drawable.product, "Электрическая сковорода", "Кухонные принадлежности", "Эта сковорода позволяет готовить различные блюда с минимальным количеством масла благодаря антипригарному покрытию."));
        products.add(new Product(109, R.drawable.razor, "Электрическая бритва", "Товары для ухода за внешностью", "Эта бритва обеспечивает гладкое бритье и комфорт при использовании благодаря системе сдвоенных лезвий."));
        products.add(new Product(110, R.drawable.coffee, "Кофемашина", "Кофейные аппараты", "Эта кофемашина приготовит идеальный эспрессо или капучино за несколько минут с помощью автоматических программных режимов."));

        adapter = new ProductAdapter(this, products);
        listView.setAdapter(adapter);

        productDetailsLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    if (result.getResultCode() == RESULT_OK) {
                        Intent data = result.getData();
                        if (data != null) {
                            Product updatedProduct = data.getParcelableExtra("updatedProduct");
                            if (updatedProduct != null) {
                                updateProduct(updatedProduct);
                                Toast.makeText(this, "Данные обновлены в списке", Toast.LENGTH_SHORT).show();
                                Toast.makeText(this, updatedProduct.getName(), Toast.LENGTH_SHORT).show();
                            }
                        }
                    }
                });

        listView.setOnItemClickListener((parent, view, position, id) -> {
            Product selectedProduct = products.get(position);
            openProductDetails(selectedProduct);
        });
    }

    private void openProductDetails(Product product) {
        Intent intent = new Intent(this, ProductDetailsActivity.class);
        intent.putExtra("product", product);
        productDetailsLauncher.launch(intent);
    }

    private void updateProduct(Product updatedProduct) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId() == updatedProduct.getId()) {
                products.set(i, updatedProduct);
                Toast.makeText(this, "Продукт обновлен", Toast.LENGTH_SHORT).show();
                adapter.notifyDataSetChanged();
                Log.d("MainActivity", "Продукт обновлен: " + updatedProduct.getName());
                break;
            }
        }
    }
}

