package com.yx.shgd.model.vo.home;

import com.yx.shgd.model.po.BaseFiled;
import com.yx.shgd.model.vo.page.Paging;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class FactoryQueryVo extends Paging {

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

    @ApiModelProperty(value = "排序")
    private Integer sort;

    @ApiModelProperty(value = "开关，0-开，1-关")
    private Boolean enable;

}