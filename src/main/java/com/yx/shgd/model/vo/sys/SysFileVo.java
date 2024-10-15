package com.yx.shgd.model.vo.sys;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class SysFileVo {

    @ApiModelProperty(value = "名称")
    private String name;

    @ApiModelProperty(value = "路径")
    private String path;

}
