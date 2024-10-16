package com.yx.shgd.model.vo.home;

import com.yx.shgd.model.vo.page.Paging;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CarouselQueryVo extends Paging {

    @ApiModelProperty(value = "主键")
    private Long id;

    @ApiModelProperty(value = "图片地址")
    private String path;

    @ApiModelProperty(value = "排序")
    private Integer sort;

    @ApiModelProperty(value = "开关，0-关，1-开")
    private Boolean enable;
}
