package com.yx.shgd.model.po.home;

import com.baomidou.mybatisplus.annotation.TableName;
import com.yx.shgd.model.po.BaseFiled;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@TableName("home_advantage")
public class AdvantagePo extends BaseFiled {

    private String title;

    private String content;

    private String picture;

    private Integer sort;

    private Boolean enable;
}
