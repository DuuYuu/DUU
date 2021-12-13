package com.atduu.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created  by DuuYuu on 2021/12/13 19:50
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BlogQuery {

    private String title;

    private Long typeId;

    private Boolean recommend;

}
