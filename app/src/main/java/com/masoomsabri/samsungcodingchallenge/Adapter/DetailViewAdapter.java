package com.masoomsabri.samsungcodingchallenge.Adapter;

import android.content.res.AssetManager;

import com.masoomsabri.samsungcodingchallenge.Model.Category;
import com.masoomsabri.samsungcodingchallenge.R;
import com.masoomsabri.samsungcodingchallenge.Utils.Utils;

import java.util.List;

/**
 * Created by masoomsabri on 5/14/17.
 */

public class DetailViewAdapter extends RecyclerViewPhotoAdapter {
    private int mCatId;
    private Category mCategory;

    public DetailViewAdapter(List<Category> list, AssetManager assetManager, int catId) {
        super(list, assetManager, false, null);
        mCatId = catId;
        mLayout = R.layout.activity_photo_detail_item;
        if (catId > -1) mCategory = mCategories.get(catId);
    }

    @Override
    public int getItemCount() {
        return (mCategories != null && mCatId > -1 && mCategories.get(mCatId) != null) ? mCategories.get(mCatId).getFileNames().length : -1;
    }

    @Override
    String getFilePath(int index) {
        if (mCategory == null || mCategory.getFileNames() == null) return null;
        return Utils.buildFilePath(mCategory.getCategory(), mCategory.getFileNames()[index]);
    }

    @Override
    String getTitle(int index) {
        if (mCategory == null || mCategory.getFileNames() == null) return null;
        return mCategory.getFileNames()[index];
    }
}
