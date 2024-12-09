package com.yx.shgd.model.vo.sys;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author HU
 * @date 2022/1/21 11:57
 */

@Data
public class SysUserPasswordVo {

    @ApiModelProperty(value = "主键")
    private Long id;

    @NotNull(message = "原密码")
    @ApiModelProperty(value = "原密码")
    private String oldPassword;

    @NotNull(message = "新密码")
    @ApiModelProperty(value = "新密码")
    private String newPassword;

    @NotNull(message = "新密码")
    @ApiModelProperty(value = "新密码")
    private String surePassword;

}
