package com.itsgaurav.csseasy.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.itsgaurav.csseasy.adapters.MainAdapter;
import com.itsgaurav.csseasy.R;
import com.itsgaurav.csseasy.adapter.MainAdapter;
import com.itsgaurav.csseasy.models.DataModel;

import java.util.ArrayList;
import java.util.List;

import static com.itsgaurav.csseasy.constants.ListItems.CSSListItems;
import static com.itsgaurav.csseasy.constants.ListItems.listItemHeaderValue;

/**
 * MainActivity is a class which contains the RecyclerView i.e list item of chapters.
 */
public class MainActivity extends AppCompatActivity {

    private String TAG = getClass().getSimpleName();
    private List<DataModel> list = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar();

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view_main_activity);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        MainAdapter mainScreenAdapter = new MainAdapter(getBasicAdapterData(), this);
        recyclerView.setAdapter(mainScreenAdapter);
    }

    /**
     * Method to set the chapterName  ,chapterValue , chapterNumber  and returns List which contains these data.
     *
     * @return List
     */
    private List<DataModel> getBasicAdapterData() {
        for (int startIndex = 0; startIndex < CSSListItems.length; startIndex++) {
            DataModel dataBasics = new DataModel();
            dataBasics.setChapterName(CSSListItems[startIndex]);
            dataBasics.setChapterValue(listItemHeaderValue[startIndex]);
            dataBasics.setChapterNumber(startIndex);

            Log.d(TAG, "getBasicAdapterData: listItem Value" + CSSListItems[startIndex]);
            list.add(dataBasics);
        }
        Log.d(TAG, "getBasicAdapterData: " + list);
        return list;
    }
}
