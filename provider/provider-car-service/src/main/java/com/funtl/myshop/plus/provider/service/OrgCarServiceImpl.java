package com.funtl.myshop.plus.provider.service;


import com.funtl.myshop.plus.provider.api.OrgCarService;
import com.funtl.myshop.plus.provider.domain.OrgCarList;
import com.funtl.myshop.plus.provider.dto.OrgCarQueryParam;
import com.funtl.myshop.plus.provider.mapper.OrgCarMapper;
import org.apache.dubbo.config.annotation.Service;

import javax.annotation.Resource;
import java.util.List;

@Service(version = "1.0.0")
public class OrgCarServiceImpl implements OrgCarService {

    @Resource
    private OrgCarMapper orgCarMapper;


    @Override
    public List<OrgCarList> selectOrgCar(OrgCarQueryParam orgCarQueryParam) {
        return orgCarMapper.selectOrgCar(orgCarQueryParam);
    }

    @Override
    public Integer selectNum(Long carBaseAuto) {
        return orgCarMapper.selectNum(carBaseAuto);
    }
}
