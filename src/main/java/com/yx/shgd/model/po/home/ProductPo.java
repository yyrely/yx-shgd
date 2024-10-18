package com.yx.shgd.model.po.home;

import com.baomidou.mybatisplus.annotation.TableName;
import com.yx.shgd.model.po.BaseFiled;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@TableName("home_product")
public class ProductPo extends BaseFiled {

    private String name;

    private String englishName;

    private String type;

    private String specification;

    private String brand;

    private String alias;

    private String englishAlias;

    private String code;

    private String casNo;

    private String molecularFormula;

    private String molecularWeight;

    private String purity;

    private String picture;

    private Integer sort;

    private Boolean enable;
}
