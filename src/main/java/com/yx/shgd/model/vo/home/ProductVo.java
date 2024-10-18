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

    @ApiModelProperty(value = "英文名")
    private String englishName;

    @ApiModelProperty(value = "类型")
    private String type;

    @ApiModelProperty(value = "规格")
    private String specification;

    @ApiModelProperty(value = "品牌")
    private String brand;

    @ApiModelProperty(value = "别名")
    private String alias;

    @ApiModelProperty(value = "英文别名")
    private String englishAlias;

    @ApiModelProperty(value = "编号")
    private String code;

    @ApiModelProperty(value = "cas码")
    private String casNo;

    @ApiModelProperty(value = "分子式")
    private String molecularFormula;

    @ApiModelProperty(value = "分子量")
    private String molecularWeight;

    @ApiModelProperty(value = "纯度")
    private String purity;

    @ApiModelProperty(value = "图片地址")
    private String picture;

    @ApiModelProperty(value = "排序")
    private Integer sort;

    @ApiModelProperty(value = "开关")
    private Boolean enable;


}
