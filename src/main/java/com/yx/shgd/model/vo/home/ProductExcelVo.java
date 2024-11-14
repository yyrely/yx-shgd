package com.yx.shgd.model.vo.home;

import com.alibaba.excel.annotation.ExcelProperty;
import com.yx.shgd.model.po.BaseFiled;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class ProductExcelVo extends BaseFiled {
    
    @ExcelProperty("名称")
    private String name;

    @ExcelProperty("英文名")
    private String englishName;

    @ExcelProperty("类型")
    private String type;

    @ExcelProperty("规格")
    private String specification;

    @ExcelProperty("品牌")
    private String brand;

    @ExcelProperty("别名")
    private String alias;

    @ExcelProperty("英文别名")
    private String englishAlias;

    @ExcelProperty("编号")
    private String code;

    @ExcelProperty("cas码")
    private String casNo;

    @ExcelProperty("分子式")
    private String molecularFormula;

    @ExcelProperty("分子量")
    private String molecularWeight;

    @ExcelProperty("纯度")
    private String purity;

    @ExcelProperty("图片地址")
    private String picture;

}
