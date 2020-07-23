package com.funtl.myshop.plus.provider.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class SelfAgentQueryParam implements Serializable {
    private String fName;
    private Integer selfUser;
    private Integer agentUser;
    private Integer pageNum;
    private Integer pageSize;

    public SelfAgentQueryParam(Integer selfUser, Integer agentUser, Integer pageNum, Integer pageSize) {
        this.selfUser = selfUser;
        this.agentUser = agentUser;
        this.pageNum = pageNum;
        this.pageSize = pageSize;
    }
}
