package com.example.finalevaluacion.fragment;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.finalevaluacion.R;
import com.example.finalevaluacion.data.response.ShowResponse;
import com.example.finalevaluacion.data.retrofit.RetrofitHelper;
import com.example.finalevaluacion.databinding.FragmentHomeBinding;
import com.example.finalevaluacion.model.Shows;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }



    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

      RetrofitHelper.getService().getShows().enqueue(new Callback<ShowResponse>() {
          @Override
          public void onResponse(Call<ShowResponse> call, Response<ShowResponse> response) {
            if(response.isSuccessful()){
                assert response.body() != null;
                showCarros(response.body().getShowsList());
            }
          }

          @Override
          public void onFailure(Call<ShowResponse> call, Throwable t) {

          }
      });
    }


    private void showCarros(List<Shows> showModelList) {
        RVShowAdapter adapter = new RVShowAdapter(showModelList);
        binding.rvShows.setAdapter(adapter);
    }
}
