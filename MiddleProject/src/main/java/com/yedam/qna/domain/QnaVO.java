package com.yedam.qna.domain;

import java.util.Date;

import lombok.Data;

@Data
public class QnaVO {
	private int postId;
	private String userId;
	private String postTitle;
	private String postCT;
	private Date postDate;
}
