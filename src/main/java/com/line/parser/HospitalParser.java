package com.line.parser;

public class HospitalParser implements Parser <Hospital> {
    private String getSubdivision(String name) {
        String[] subdivisions = {"내과", "외과", "소아과", "피부과", "성형", "정형외과", "산부인과",
                "관절", "안과", "가정의학과", "비뇨기과", "치과"};
        for (String subdivision : subdivisions
        ) {
            if (name.contains(subdivision)) {
                return subdivision;
            }
        }
        return "분류 불가";
    }




    @Override

    public Hospital parse(String str) {
        str = str.replaceAll("\"", ""); // 문장의 // 부분 다 공백으로 처리함
        String[] splitted = str.split(",");
        String name = splitted[10];
        String subdivision = getSubdivision(name);



            return new Hospital(splitted[0],splitted[1],splitted[2],splitted[6],splitted[10],getSubdivision(name));// 파서에 파서니까 호스피탈 파서에서 한줄을 넣은 값ㅇ르 분절로 나눠서 이걸 호스피탈
        //객체에 넣어줌// hospital 객체로 넘겨줌
    }
}

