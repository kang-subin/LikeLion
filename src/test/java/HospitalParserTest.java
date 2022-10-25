import com.line.parser.Hospital;
import com.line.parser.HospitalParser;
import org.junit.jupiter.api.Assertions;

class HospitalParserTest { // 여기서 파싱 메소드가 잘 돌아가고 있는지 확인하기 위한 테스트 코드를 작성해보는 것임

    String line1 = "\"A1120837\",\"서울특별시 금천구 벚꽃로 286 삼성리더스타워 111~114호 (가산동)\",\"C\",\"의원\",\"G099\",\"응급의료기관 이외\",\"2\",\"외과: 상시진료 내과는 당분간 휴진\",\"서울시 송파구 문정동 장지동 법조단지 위례 가락동 가락시장역 위치 삼성서울병원 외래교수 출신 구강외과 전문의 진료 진료과목 - 임플란트 치조골 뼈이식 수술 매복 사랑니 발치 턱관절 악관절 질환의 치료 교정 치료 및 기타 보존 보철(크라운 브릿지 인레이) 신경치료\",\"방이역 1번출구 바로옆 굿모닝 신한증권 뒷건물\",\"가산기대찬의원\",\"02-6267-2580\",\"02-920-5374\",\"1930\",\"1930\",\"1930\",\"1930\",\"1930\",\"1500\",\"1500\",\"1500\",\"0900\",\"0900\",\"0900\",\"0900\",\"0900\",\"0900\",\"1000\",\"1000\",\"085\",\"11\",\"126.88412249700781\",\"37.4803938036867\",\"2022-04-07 14:55:00.0\"";

    private void assertEquals(Hospital hospital, String eid, String eaddress, String edistrict, String ecategory, int eemergencyRoom, String ename, String esubdivision) {
        Assertions.assertEquals(eid, hospital.getId());
        Assertions.assertEquals(eaddress, hospital.getAddress());
        Assertions.assertEquals(edistrict, hospital.getDistrict());
        Assertions.assertEquals(ecategory, hospital.getCategory());
        Assertions.assertEquals(eemergencyRoom, hospital.getEmergencyRoom());
        Assertions.assertEquals(ename, hospital.getName());
        Assertions.assertEquals(esubdivision, hospital.getSubdivision());

    }
        void parsing(){
            HospitalParser hospitalParser = new HospitalParser();
            Hospital hospital = hospitalParser.parse(line1);

            assertEquals(hospital, "A1120837", "서울특별시 금천구 벚꽃로 286 삼성리더스타워 111~114호 (가산동)", "서울시 금천구", "C", 2, "가산기대찬의원","");


        }



}
