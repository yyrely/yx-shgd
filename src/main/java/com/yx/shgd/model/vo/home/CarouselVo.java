package com.yx.shgd.model.vo.home;

import com.yx.shgd.model.po.BaseFiled;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class CarouselVo extends BaseFiled {

    @ApiModelProperty(value = "图片地址")
    private String path;

    @ApiModelProperty(value = "排序")
    private Integer sort;

    @ApiModelProperty(value = "开关，0-开，1-关")
    private Boolean enable;
}
