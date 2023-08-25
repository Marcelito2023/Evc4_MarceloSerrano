package com.example.finalevaluacion.data.response;

import com.example.finalevaluacion.model.Shows;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ShowResponse {

@SerializedName("Shows")

    public List<Shows> showsList;

    public List<Shows> getShowsList() {
        return showsList;
    }

    public void setShowsList(List<Shows> showsList) {
        this.showsList = showsList;
    }
}
