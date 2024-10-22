package com.example.JobProject.entity;

import java.util.List;

public class ApiResponse {
    private List<ExchangeData> data;

    public List<ExchangeData> getData() {
        return data;
    }

    public void setData(List<ExchangeData> data) {
        this.data = data;
    }
}
