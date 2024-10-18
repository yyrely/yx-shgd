package com.yx.shgd.model.po.sys;

import com.baomidou.mybatisplus.annotation.TableName;
import com.yx.shgd.model.po.BaseFiled;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author Hu
 * @since 2022-01-21
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("sys_dict_detail")
public class SysDictDetailPo extends BaseFiled {

    @ApiModelProperty(value = "字典id")
    private Long dictId;

    @ApiModelProperty(value = "名称")
    private String name;

    @ApiModelProperty(value = "code")
    private String code;

}
