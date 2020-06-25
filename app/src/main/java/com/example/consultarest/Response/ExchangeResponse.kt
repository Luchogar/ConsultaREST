package com.example.consultarest.Response

import com.example.consultarest.Model.Rates

data class ExchangeResponse(
    val rates: Rates? = null,
    val base: String
)