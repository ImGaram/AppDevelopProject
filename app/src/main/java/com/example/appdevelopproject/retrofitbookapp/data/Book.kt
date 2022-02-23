package com.example.appdevelopproject.retrofitbookapp.data

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Book(
    @SerializedName("title") var title: String?, // 제목
    @SerializedName("publisher")var publisher: String?, // 출판사
    @SerializedName("author")var author: String?,    // 저자
    @SerializedName("coverLargeUrl")var coverLargeUrl: String?, // 책 이미지
    @SerializedName("mobileLink")var mobileLink: String?,    // 모바일 주소
    @SerializedName("customerReviewRank")var customerReviewRank: Float?,   // 평점
    @SerializedName("rank") var rank: String?,  // 순위
    @SerializedName("description") var description: String?     // 설명
):Serializable
