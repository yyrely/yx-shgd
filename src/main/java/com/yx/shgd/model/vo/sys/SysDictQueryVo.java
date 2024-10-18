package com.yx.shgd.model.vo.sys;

import com.yx.shgd.model.vo.page.Paging;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class SysDictQueryVo extends Paging {

    @ApiModelProperty(value = "名称")
    private String name;

    @ApiModelProperty(value = "code")
    private String code;

}
