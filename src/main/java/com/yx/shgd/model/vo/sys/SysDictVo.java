package com.yx.shgd.model.vo.sys;

import com.yx.shgd.model.po.BaseFiled;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
public class SysDictVo extends BaseFiled {

    @ApiModelProperty(value = "名称")
    private String name;

    @ApiModelProperty(value = "code")
    private String code;

    @ApiModelProperty(value = "详情列表")
    private List<SysDictDetailVo> sysDictDetailVoList;
}
