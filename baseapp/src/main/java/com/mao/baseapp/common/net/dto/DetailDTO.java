package com.mao.baseapp.common.net.dto;

public class DetailDTO<T> extends RestStatus {
    public T detail;
    public DetailDTO(){
    }
    public DetailDTO(Boolean status){
        super(status);
    }
    public DetailDTO(Boolean status,T detail){
        super(status);
        this.detail=detail;
    }
    public T getDetail(){
        return detail;
    }
    public void setDetail(T detail){
        this.detail=detail;
    }
}