package com.yx.shgd.model.vo.home;

import com.yx.shgd.model.po.BaseFiled;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class FactoryVo extends BaseFiled {

    @ApiModelProperty(value = "名称")
    private String name;

    @ApiModelProperty(value = "手机")
    private String phone;

    @ApiModelProperty(value = "电话")
    private String mobile;

    @ApiModelProperty(value = "邮箱")
    private String email;

    @ApiModelProperty(value = "地址")
    private String address;

    @ApiModelProperty(value = "关于")
    private String about;

    @ApiModelProperty(value = "关于图片")
    private String aboutPicture;

}
