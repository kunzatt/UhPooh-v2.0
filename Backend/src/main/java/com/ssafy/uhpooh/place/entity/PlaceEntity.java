package com.ssafy.uhpooh.place.entity;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "places")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PlaceEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "kakao_place_id",nullable = false, unique = true)
	private String kakaoPlaceId;

	@Column(name = "place_name",nullable = false)
	private String placeName;

	@Column(name = "review_count")
	private Long reviewCount;

	@Column(name = "like_count")
	private Long likeCount;

	@CreatedDate
	@Column(updatable = false)
	private LocalDateTime createdAt;

	@LastModifiedDate
	private LocalDateTime updatedAt;

	@Builder
	public PlaceEntity(String kakaoPlaceId, String placeName, Long reviewCount, Long likeCount, LocalDateTime createdAt, LocalDateTime updatedAt) {
		this.kakaoPlaceId = kakaoPlaceId;
		this.placeName = placeName;
		this.reviewCount = reviewCount;
		this.likeCount = likeCount;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

}
