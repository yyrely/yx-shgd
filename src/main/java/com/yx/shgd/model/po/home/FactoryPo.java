package com.yx.shgd.model.po.home;

import com.baomidou.mybatisplus.annotation.TableName;
import com.yx.shgd.model.po.BaseFiled;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@TableName("home_factory")
public class FactoryPo extends BaseFiled {

    private String name;

    private String phone;

    private String mobile;

    private String email;

    private String address;

    private String about;

    private String aboutPicture;
}
