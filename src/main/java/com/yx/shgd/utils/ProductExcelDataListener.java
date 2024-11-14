package com.yx.shgd.utils;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.yx.shgd.model.vo.home.ProductExcelVo;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class ProductExcelDataListener extends AnalysisEventListener<ProductExcelVo> {


    private final List<ProductExcelVo> dataList = new ArrayList<>();

    // 每读取一行会调用这个方法
    @Override
    public void invoke(ProductExcelVo data, AnalysisContext context) {
        dataList.add(data);
    }

    // 所有数据读取完成后会调用这个方法
    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {
        // 读取完成后的处理逻辑，例如保存到数据库
    }

}

