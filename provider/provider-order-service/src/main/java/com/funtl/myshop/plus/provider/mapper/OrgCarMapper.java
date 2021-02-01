package com.funtl.myshop.plus.provider.mapper;

import com.funtl.myshop.plus.provider.domain.OrgCar;
import com.funtl.myshop.plus.provider.domain.OrgCarList;
import com.funtl.myshop.plus.provider.dto.OrgCarQueryParam;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.MyMapper;

import java.util.List;

public interface OrgCarMapper extends MyMapper<OrgCar> {
    List<OrgCarList> selectOrgCar(@Param("param") OrgCarQueryParam orgCarQueryParam);
}
