package com.line.parser;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

    public class MakeSQLFile {



        public void createFile(String fileName, StringBuffer sb) throws IOException {
            BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));

            bw.write(sb.toString()); //리스트에 투스트링 메소드를 만들어서 그걸 sb 객체에 작성쿼리를 만들고 담은 다음
            bw.close();
        }

        public StringBuffer createSQL(List<Hospital> list){
            StringBuffer sb = new StringBuffer("INSERT INTO `likelion-db`.`seoul_hospital`\n" +
                    "(`id`,`address`,`district`,`category`,`emergency_room`,`name`,`subdivision`)\n" +
                    "VALUES\n"); //스트링 버퍼 객체에 이 글자들이 적힘
            for (int i = 0; i < list.size() - 1; i++) {
                sb.append(list.get(i) +",\n"); // append get i 번째 인덱스의 마지막에 , 를 추가해줌 stirngbuffer클래스를
                // 써야 사용가능
            }
            sb.append(list.get(list.size() - 1) + ";");
//리스트는 스플릿으로 쪼개서 필요한 정보만 한줄로 한 객체를 모아논 리스트이다
            // 이 한줄에 , 를 추가하면서 마지막 줄까지 쓰고 마지막에 ; 를 붙인다음 리턴한다
            return sb;
        }
    }


