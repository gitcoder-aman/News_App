package com.tech.newsapp.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.tech.newsapp.Adapter.Adapter;
import com.tech.newsapp.Api.ApiUtilities;
import com.tech.newsapp.Model.ModelClass;
import com.tech.newsapp.Model.mainNewsModel;
import com.tech.newsapp.R;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ScienceFragment extends Fragment {

    String api = "74f39d16444847ed86082a255e94ebe8";
    ArrayList<ModelClass>ArrayList;
    Adapter adapter;
    String country = "in";
    private RecyclerView recyclerViewOfScience;
    private String category = "science";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.science_fragment,null);

        recyclerViewOfScience = view.findViewById(R.id.recyclerViewOfScience);
        ArrayList = new ArrayList<>();

        recyclerViewOfScience.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new Adapter(getContext(),ArrayList);
        recyclerViewOfScience.setAdapter(adapter);

        findNews();

        return view;
    }

    private void findNews() {

        ApiUtilities.getApiInterface().getCategoryNews(country,category,100,api).enqueue(new Callback<mainNewsModel>() {
            @Override
            public void onResponse(Call<mainNewsModel> call, Response<mainNewsModel> response) {
                if(response.isSuccessful()){
                    ArrayList.addAll(response.body().getArticles());
                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<mainNewsModel> call, Throwable t) {

            }
        });
    }
}
