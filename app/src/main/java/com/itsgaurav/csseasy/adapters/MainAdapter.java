/*
 * MIT License
 *
 * Copyright (c) 2017 Perfect Cube
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 *
 */

package com.itsgaurav.csseasy.adapters;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.itsgaurav.csseasy.R;
import com.itsgaurav.csseasy.activities.ChapterActivity;
import com.itsgaurav.csseasy.models.MainModel;
import com.zhukic.sectionedrecyclerview.SectionedRecyclerViewAdapter;

import java.util.List;

import static com.itsgaurav.csseasy.constants.ConstantValue.CATEGORY_BASICS;
import static com.itsgaurav.csseasy.constants.ConstantValue.CATEGORY_CSS3;
import static com.itsgaurav.csseasy.constants.ConstantValue.CATEGORY_RESPONSIVE;
import static com.itsgaurav.csseasy.constants.ConstantValue.EXTRA_CHAPTER_NUMBER;

public class MainAdapter extends SectionedRecyclerViewAdapter<MainAdapter.HeaderItemViewHolder, MainAdapter.ItemViewHolder> {

    private List<MainModel> mList;
    private AppCompatActivity mContext;

    /**
     * Required constructor.
     *
     * @param list    Data list.
     * @param context Context to use.
     */
    public MainAdapter(List<MainModel> list, AppCompatActivity context) {
        this.mList = list;
        this.mContext = context;
    }

    //For header
    public boolean onPlaceSubheaderBetweenItems(int itemPosition) {
        // //return true if you want to place sub-header between two neighboring items
        MainModel data1 = mList.get(itemPosition);
        MainModel data2 = mList.get(itemPosition + 1);
        return !(data1.getChapterValue().equals(data2.getChapterValue()));
    }

    //For header
    @Override
    public MainAdapter.HeaderItemViewHolder onCreateSubheaderViewHolder(ViewGroup parent, int viewType) {
        return new HeaderItemViewHolder(LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.item_main_header
                        , parent
                        , false));
    }

    //For content
    @Override
    public MainAdapter.ItemViewHolder onCreateItemViewHolder(ViewGroup parent, int viewType) {

        return new ItemViewHolder(LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.item_main
                        , parent
                        , false));
    }

    //For header
    @Override
    public void onBindSubheaderViewHolder(MainAdapter.HeaderItemViewHolder subHeaderHolder, int nextItemPosition) {
        MainModel data = mList.get(nextItemPosition);
        switch (data.getChapterValue()) {
            case CATEGORY_BASICS:
                subHeaderHolder.headerText.setText(CATEGORY_BASICS);
                break;
            case CATEGORY_CSS3:
                subHeaderHolder.headerText.setText(CATEGORY_CSS3);
                break;
            case CATEGORY_RESPONSIVE:
                subHeaderHolder.headerText.setText(CATEGORY_RESPONSIVE);
                break;
        }
    }

    //For content
    @Override
    public void onBindItemViewHolder(MainAdapter.ItemViewHolder holder, int itemPosition) {
        final MainModel data = mList.get(itemPosition);
        //Set chapter name
        holder.chapterName.setText(data.getChapterName());

        //Item view click functionality
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, ChapterActivity.class);
                intent.putExtra(EXTRA_CHAPTER_NUMBER, data.getChapterNumber());
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemSize() {
        return mList.size();
    }

    //HeaderViewHolder
    static class HeaderItemViewHolder extends RecyclerView.ViewHolder {
        TextView headerText;

        public HeaderItemViewHolder(View itemView) {
            super(itemView);
            headerText = itemView.findViewById(R.id.textHeader);
        }
    }

    //ItemViewHolder
    static class ItemViewHolder extends RecyclerView.ViewHolder {
        public TextView chapterName;

        public ItemViewHolder(View itemView) {
            super(itemView);
            chapterName = itemView.findViewById(R.id.textChapterName);
        }
    }

}
