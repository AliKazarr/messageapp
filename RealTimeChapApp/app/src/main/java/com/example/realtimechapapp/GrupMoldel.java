package com.example.realtimechapapp;

import java.util.List;

public class GrupMoldel {

    private  String grupAdi,grupAciklamasi,grupResmi,grupId,uid;

    private List<String> numaralar;


    public  GrupMoldel(String grupAdi,String grupAciklamasi,String grupResmi,String grupId, String uid, List<String> numaralar)
    {
        this.grupAdi = grupAdi;
        this.grupAciklamasi=grupAciklamasi;
        this.grupResmi=grupResmi;
        this.grupId=grupId;
        this.uid=uid;
        this.numaralar=numaralar;

    }
    public String getGrupAdi()
    {
        return grupAdi;
    }
    public void setGrupAdi(String grupAdi)
    {
        this.grupAdi = grupAdi;
    }
    public  String getGrupAciklamasi()
    {
        return  grupAciklamasi;
    }
    public  void  setGrupAciklamasi(String grupAciklamasi)
    {
        this.grupAciklamasi=grupAciklamasi;
    }

    public String getGrupResmi()
    {
        return  grupResmi;
    }

    public  void setGrupResmi(String grupResmi)
    {
        this.grupResmi=grupResmi;
    }
    public  String getGrupId()
    {
return grupId;    }

    public  void setGrupId(String grupId)
    {
        this.grupId=grupId;
    }
    public String uid()
    {
        return uid;
    }
    public void setGrupuid(String uid)
    {
        this.uid=uid;
    }

}
