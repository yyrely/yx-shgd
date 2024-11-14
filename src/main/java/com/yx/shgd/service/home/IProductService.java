package com.yx.shgd.service.home;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yx.shgd.model.po.home.NewPo;
import com.yx.shgd.model.po.home.ProductPo;
import com.yx.shgd.model.vo.home.ProductQueryVo;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface IProductService extends IService<ProductPo> {

    IPage<ProductPo> pageProduct(ProductQueryVo productQueryVo);

    List<ProductPo> listProduct(ProductQueryVo productQueryVo);

    void excelImport(MultipartFile file) throws IOException;
}
