package com.funtl.myshop.plus.provider.service;

import javax.annotation.Resource;

import com.funtl.myshop.plus.provider.domain.IncomeList;
import com.funtl.myshop.plus.provider.domain.PaymentFileList;
import com.funtl.myshop.plus.provider.domain.PaymentList;
import com.funtl.myshop.plus.provider.dto.IncomeInsertDto;
import com.funtl.myshop.plus.provider.dto.PaymentQueryParam;
import com.funtl.myshop.plus.provider.mapper.OrdersMapper;
import com.funtl.myshop.plus.provider.domain.Orders;
import com.funtl.myshop.plus.provider.api.OrdersService;
import org.apache.dubbo.config.annotation.Service;

import java.util.List;

@Service(version = "1.0.0")
public class OrdersServiceImpl implements OrdersService{

    @Resource
    private OrdersMapper ordersMapper;

    @Override
    public List<PaymentList> selectPaymentList(PaymentQueryParam paymentQueryParam) {
        return ordersMapper.selectPaymentList(paymentQueryParam);
    }

    @Override
    public List<IncomeList> selectIncomeList(Integer type, String searchWord) {
        return ordersMapper.selectIncomeList(type,searchWord);
    }

    @Override
    public List<PaymentFileList> selectPaymentFileList(Integer type, Long docPostId) {
        return ordersMapper.selectPaymentFileList(type,docPostId);
    }

    @Override
    public Integer createIncome(IncomeInsertDto incomeInsertDto) {
        return ordersMapper.createIncome(incomeInsertDto);
    }

    @Override
    public Integer selectType(Integer type, Long creditMainAuto) {
        return ordersMapper.selectType(type,creditMainAuto);
    }

    @Override
    public Integer deleteIncome(Long loginUserId, Long bookCarIncomeAuto) {
        return ordersMapper.deleteIncome(loginUserId,bookCarIncomeAuto);
    }
}
