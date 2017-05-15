package com.masoomsabri.samsungcodingchallenge.Adapter;

import android.content.res.AssetManager;
import android.graphics.drawable.Drawable;
import android.support.annotation.LayoutRes;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.masoomsabri.samsungcodingchallenge.Model.Category;
import com.masoomsabri.samsungcodingchallenge.R;

import java.io.IOException;
import java.util.List;

/**
 * Created by masoomsabri on 5/14/17.
 */

public abstract class RecyclerViewPhotoAdapter extends RecyclerView.Adapter<RecyclerViewPhotoAdapter.ViewHolder> {
    private static final String TAG = RecyclerViewPhotoAdapter.class.getSimpleName();
    protected List<Category> mCategories;
    protected AssetManager mAssetManager;
    protected
    @LayoutRes
    int mLayout;
    private OnCategoryClickListener mListener;
    private boolean mIsSummary;

    public RecyclerViewPhotoAdapter(List<Category> list, AssetManager assetManager, boolean isSummary, OnCategoryClickListener listener) {
        mAssetManager = assetManager;
        mCategories = list;
        mIsSummary = isSummary;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(mLayout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        if (mCategories == null || mAssetManager == null) return;

        //getting the position in the adapter
        final int pos = holder.getAdapterPosition();
        holder.mTitleTextView.setText(getTitle(pos));
        try {
            final String filePath = getFilePath(pos);
            holder.mImageView.setImageDrawable(Drawable.createFromStream(mAssetManager.open(filePath), null));

            if (mListener != null) {
                holder.mRootView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //
                        mListener.onClick(pos);
                    }
                });
                holder.mRootView.setOnLongClickListener(new View.OnLongClickListener() {
                    @Override
                    public boolean onLongClick(View v) {
                        mListener.onLongClick(pos);
                        return true;
                    }
                });
            }
        } catch (IOException e) {
            e.printStackTrace();
            Log.e(TAG, "Failure to log asset into photo view", e);
        }
    }


    abstract String getFilePath(int index);

    abstract String getTitle(int index);


    public interface OnCategoryClickListener {
        void onLongClick(int id);

        void onClick(int id);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView mImageView;
        public TextView mTitleTextView;
        public View mRootView;

        public ViewHolder(View view) {
            super(view);
            mRootView = view;
            mImageView = (ImageView) view.findViewById(R.id.photo_view);
            mTitleTextView = (TextView) view.findViewById(R.id.title);
        }
    }
}
