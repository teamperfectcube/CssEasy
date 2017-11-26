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
import com.itsgaurav.csseasy.models.DataModel;
import com.zhukic.sectionedrecyclerview.SectionedRecyclerAdapter;

import java.util.List;

import static com.itsgaurav.csseasy.constants.ConstantValue.CATEGORY_BASICS;
import static com.itsgaurav.csseasy.constants.ConstantValue.CATEGORY_CSS3;
import static com.itsgaurav.csseasy.constants.ConstantValue.CATEGORY_RESPONSIVE;

public class MainAdapter extends SectionedRecyclerAdapter<MainAdapter.HeaderItemViewHolder, MainAdapter.ItemViewHolder> {

    private List<DataModel> list;
    private AppCompatActivity activity;

    //Required constructor
    public MainAdapter(List<DataModel> list, AppCompatActivity activity) {
        this.list = list;
        this.activity = activity;
    }

    //For Header
    public static class HeaderItemViewHolder extends RecyclerView.ViewHolder {
        TextView headerText;

        public HeaderItemViewHolder(View itemView) {
            super(itemView);
            headerText = (TextView) itemView.findViewById(R.id.text_view_header);
        }
    }

    //For Content
    public static class ItemViewHolder extends RecyclerView.ViewHolder {
        public TextView chapterName;

        public ItemViewHolder(View itemView) {
            super(itemView);
            chapterName = (TextView) itemView.findViewById(R.id.text_view_chapter_name);
        }
    }

    //For header
    public boolean onPlaceSubheaderBetweenItems(int itemPosition, int nextItemPosition) {
        DataModel data1 = list.get(itemPosition);
        DataModel data2 = list.get(nextItemPosition);
        return !(data1.getChapterValue().equals(data2.getChapterValue()));// //return true if you want to place sub-header between two neighboring items
    }

    //For header
    @Override
    public MainAdapter.HeaderItemViewHolder onCreateSubheaderViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.header_item_view, parent, false);
        return new HeaderItemViewHolder(view);
    }

    //For content
    @Override
    public MainAdapter.ItemViewHolder onCreateItemViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view_main_adapter, parent, false);
        return new ItemViewHolder(view);
    }

    //For header
    @Override
    public void onBindSubheaderViewHolder(MainAdapter.HeaderItemViewHolder subheaderHolder, int nextItemPosition) {
        DataModel dataBasics = list.get(nextItemPosition);
        switch (dataBasics.getChapterValue()) {
            case CATEGORY_BASICS:
                subheaderHolder.headerText.setText(CATEGORY_BASICS);
                break;
            case CATEGORY_CSS3:
                subheaderHolder.headerText.setText(CATEGORY_CSS3);
                break;
            case CATEGORY_RESPONSIVE:
                subheaderHolder.headerText.setText(CATEGORY_RESPONSIVE);
                break;
        }
    }

    //For content
    @Override
    public void onBindItemViewHolder(MainAdapter.ItemViewHolder holder, int itemPosition) {
        final DataModel dataBasics = list.get(itemPosition);
        holder.chapterName.setText(dataBasics.getChapterName());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(activity, ChapterActivity.class);
                intent.putExtra("CHAPTER_VALUE", dataBasics.getChapterNumber());
                activity.startActivity(intent);
            }
        });
    }

    @Override
    public int getCount() {
        return list.size();
    }
}
