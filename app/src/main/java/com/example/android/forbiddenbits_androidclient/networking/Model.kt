package com.example.android.forbiddenbits_androidclient.networking

public object Model {
    data class Query(val searchInfo: SearchInfo)
    data class SearchInfo(val totalHits: Int)
    data class Result(val query: Query)
}