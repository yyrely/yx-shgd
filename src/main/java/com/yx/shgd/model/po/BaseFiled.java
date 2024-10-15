package com.yx.shgd.model.po;

import com.yx.shgd.model.annotation.Created;
import com.yx.shgd.model.annotation.Modified;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author HU
 * @date 2019/12/19 19:52
 */

@Data
public abstract class BaseFiled {

	@Created
	private LocalDateTime createTime;

	@Modified
	private LocalDateTime updateTime;
}
