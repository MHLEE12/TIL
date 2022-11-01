package com.study.springboard.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

// Entity는 DB의 table을 의미
@Entity
@Data // lombok
public class Board {

    // JPA가 인식하고 처리하게 하는 annotation
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id; // Integer는 null값을 넣을 수 있어서 Integer를 사용했다고 함
    private String title;
    private String content;
    private String filename;
    private String filepath;
}
