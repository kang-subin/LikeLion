package com.line.parser;

public interface Parser<T> {
    T parse(String str); //어떤 객체에 리턴할 지 모르기 때문에 T라고 한것  메소드임
    // 파서를 계속 만드는 것은 어떤 내용? 인가에 따라서 계속 만들면 됨


}
