
package com.example.vsgutulabs.LB8;
import android.os.Parcel;
import android.os.Parcelable;

public class Product implements Parcelable {
    private int id;
    private int imageResourceId;
    private String name;
    private String category;
    private String description;

    public Product(int id, int imageResourceId, String name, String category, String description) {
        this.id = id;
        this.imageResourceId = imageResourceId;
        this.name = name;
        this.category = category;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    protected Product(Parcel in) {
        id = in.readInt();
        imageResourceId = in.readInt();
        name = in.readString();
        category = in.readString();
        description = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeInt(imageResourceId);
        dest.writeString(name);
        dest.writeString(category);
        dest.writeString(description);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Product> CREATOR = new Creator<Product>() {
        @Override
        public Product createFromParcel(Parcel in) {
            return new Product(in);
        }

        @Override
        public Product[] newArray(int size) {
            return new Product[size];
        }
    };

    @Override
    public String toString() {
        return name;
    }
}