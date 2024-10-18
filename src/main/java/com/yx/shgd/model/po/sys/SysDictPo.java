package com.yx.shgd.model.po.sys;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.yx.shgd.model.po.BaseFiled;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author Hu
 * @since 2022-01-21
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("sys_dict")
public class SysDictPo extends BaseFiled {

    @ApiModelProperty(value = "名称")
    private String name;

    @ApiModelProperty(value = "code")
    private String code;

}
