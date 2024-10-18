package com.yx.shgd.model.vo.sys;

import com.yx.shgd.model.po.BaseFiled;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class SysDictDetailVo extends BaseFiled {

    @ApiModelProperty(value = "字典id")
    private Long dictId;

    @ApiModelProperty(value = "名称")
    private String name;

    @ApiModelProperty(value = "code")
    private String code;

}
