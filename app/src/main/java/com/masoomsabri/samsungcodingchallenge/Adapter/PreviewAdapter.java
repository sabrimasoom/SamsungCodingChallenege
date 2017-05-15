package com.masoomsabri.samsungcodingchallenge.Adapter;

import android.content.res.AssetManager;

import com.masoomsabri.samsungcodingchallenge.Model.Category;
import com.masoomsabri.samsungcodingchallenge.R;
import com.masoomsabri.samsungcodingchallenge.Utils.Utils;

import java.util.List;

/**
 * Created by masoomsabri on 5/14/17.
 */

public class PreviewAdapter extends RecyclerViewPhotoAdapter {
    private static final String TAG = PreviewAdapter.class.getSimpleName();
    private List<Category> mCategories;

    public PreviewAdapter(List<Category> list, AssetManager assetManager, OnCategoryClickListener listener) {
        super(list, assetManager, true, listener);
        mAssetManager = assetManager;
        mCategories = list;
        mLayout = R.layout.photo_preview_item;
    }

    @Override
    public int getItemCount() {
        return mCategories != null ? mCategories.size() : -1;
    }

    @Override
    String getFilePath(int index) {
        if (mCategories == null || mCategories.get(index) == null) return null;
        return Utils.buildFilePath(mCategories.get(index).getCategory(), mCategories.get(index).getFileNames()[0]);
    }

    @Override
    String getTitle(int index) {
        if (mCategories == null || mCategories.get(index) == null) return null;
        return mCategories.get(index).getCategory();
    }
}
