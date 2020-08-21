package com.funtl.myshop.plus.provider.api;

import com.funtl.myshop.plus.provider.domain.ItemCode;

import com.funtl.myshop.plus.provider.dto.RoleList;
import java.util.List;

public interface ItemCodeService{

    List<RoleList> selectByType(Integer itemType);

}
