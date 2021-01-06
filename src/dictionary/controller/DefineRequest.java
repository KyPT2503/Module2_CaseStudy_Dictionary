package dictionary.controller;

public class DefineRequest extends Request{
    private String action="define";
    private String keyWord;
    private enum kindOfDefine={PRONOUNCE,ADJECTIVE};
}