package com.itwill.my_real_korea.dto.ticket;

import java.util.Date;

import com.itwill.my_real_korea.dto.user.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TicketReview {

    private int tiReviewNo;
    private Date tiReviewDate;
    private String tiReviewTitle;
    private String tiReviewContent;
    private String tiReviewImg;
    private int tiReviewStar;
    private int tiNo;
    private User user;



}
