package com.example.JobProject.entity;
public class ExchangeData {
    private String exchangeId;
    private String baseId;
    private String quoteId;
    private String baseSymbol;
    private String quoteSymbol;
    private String volumeUsd24Hr;
    private String priceUsd;
    private String volumePercent;

    // Геттеры и сеттеры
    public String getExchangeId() {
        return exchangeId;
    }

    public void setExchangeId(String exchangeId) {
        this.exchangeId = exchangeId;
    }

    public String getBaseId() {
        return baseId;
    }

    public void setBaseId(String baseId) {
        this.baseId = baseId;
    }

    public String getQuoteId() {
        return quoteId;
    }

    public void setQuoteId(String quoteId) {
        this.quoteId = quoteId;
    }

    public String getBaseSymbol() {
        return baseSymbol;
    }

    public void setBaseSymbol(String baseSymbol) {
        this.baseSymbol = baseSymbol;
    }

    public String getQuoteSymbol() {
        return quoteSymbol;
    }

    public void setQuoteSymbol(String quoteSymbol) {
        this.quoteSymbol = quoteSymbol;
    }

    public String getVolumeUsd24Hr() {
        return volumeUsd24Hr;
    }

    public void setVolumeUsd24Hr(String volumeUsd24Hr) {
        this.volumeUsd24Hr = volumeUsd24Hr;
    }

    public String getPriceUsd() {
        return priceUsd;
    }

    public void setPriceUsd(String priceUsd) {
        this.priceUsd = priceUsd;
    }

    public String getVolumePercent() {
        return volumePercent;
    }

    public void setVolumePercent(String volumePercent) {
        this.volumePercent = volumePercent;
    }

    @Override
    public String toString() {
        return "ExchangeData{" +
                "exchangeId='" + exchangeId + '\'' +
                ", baseId='" + baseId + '\'' +
                ", quoteId='" + quoteId + '\'' +
                ", baseSymbol='" + baseSymbol + '\'' +
                ", quoteSymbol='" + quoteSymbol + '\'' +
                ", volumeUsd24Hr='" + volumeUsd24Hr + '\'' +
                ", priceUsd='" + priceUsd + '\'' +
                ", volumePercent='" + volumePercent + '\'' +
                '}';
    }
}
