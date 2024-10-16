package com.yx.shgd.model.po.home;

import com.baomidou.mybatisplus.annotation.TableName;
import com.yx.shgd.model.po.BaseFiled;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@TableName("home_carousel")
public class CarouselPo extends BaseFiled {

    private String path;

    private Integer sort;

    private Boolean enable;
}
