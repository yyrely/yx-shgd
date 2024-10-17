package com.yx.shgd.model.vo.home;

import com.yx.shgd.model.po.BaseFiled;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class ProductVo extends BaseFiled {

    @ApiModelProperty(value = "名称")
    private String name;

    @ApiModelProperty(value = "图片地址")
    private String picture;

    @ApiModelProperty(value = "排序")
    private Integer sort;

    @ApiModelProperty(value = "开关")
    private Boolean enable;

}
