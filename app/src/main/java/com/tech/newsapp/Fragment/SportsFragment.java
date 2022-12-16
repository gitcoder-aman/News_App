package com.tech.newsapp.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

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

public class SportsFragment extends Fragment {

    String api = "74f39d16444847ed86082a255e94ebe8";
    java.util.ArrayList<ModelClass> ArrayList;
    Adapter adapter;
    String country = "in";
    private RecyclerView recyclerViewOfSports;
    private String category = "sports";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.sports_fragment,null);

        recyclerViewOfSports = view.findViewById(R.id.recyclerViewOfSports);
        ArrayList = new ArrayList<>();

        recyclerViewOfSports.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new Adapter(getContext(),ArrayList);
        recyclerViewOfSports.setAdapter(adapter);

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
                Toast.makeText(getContext(), "fail Load", Toast.LENGTH_SHORT).show();

            }
        });
    }
}
