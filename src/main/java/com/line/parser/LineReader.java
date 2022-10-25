package com.line.parser;

import com.line.parser.Parser;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class LineReader<T> {
    // 리스트 만들고 파서 만들어서 한줄씩 읽은 걸 넣을거임
    Parser<T> parser; // 라인리더는 파서에 의존 = 이 클래스랑 연결이라 생각
    boolean isRemoveColumnName = true;

    public LineReader(Parser<T> parser) {
        this.parser = parser;
    }

    public LineReader(Parser<T> parser, boolean isRemoveColumnName) {
        this.parser = parser;
        this.isRemoveColumnName = isRemoveColumnName;
    }



    List<T> readlines(String filename) throws IOException { //
        List<T> result = new ArrayList<>(); // 파서로 자른 객체를 담을 리스트
        BufferedReader br = new BufferedReader(new FileReader(filename)); //한줄 읽기를 위한 객체
        String str; // 한줄
        if (isRemoveColumnName) {
            br.readLine();
        }

        while ((str = br.readLine()) != null) {
            result.add(parser.parse(str)); // 객체 hospital 객체로 값이 도달하고 이는 객체를 의미
        }
        return result; //

    }


}