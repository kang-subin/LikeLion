package com.line.parser;

public class Hospital {
    private String id;
    private String address;
    private String district;
    private String category;
    private Integer emergencyRoom;
    private String name;
    private String subdivision;

    public Hospital(String id, String address, String category,  String emergencyRoom, String name, String subdivision) {
        this.id = id;
        this.address = address;
        this.category = category;
        setDistrict(this.address);
        this.emergencyRoom = Integer.valueOf(emergencyRoom); // 파싱해서 넘어온 문자열을 숫자로 바꿔줌
        this.name = name;
        this.subdivision = subdivision;


    }

    public Hospital() {

    }
//    public String setDistrict() {
//        String[] splitted = this.address.split(" ");
//        this.district = String.format("%s %s", splitted[0], splitted[1]); // address 나눈 값을 스플릿해서 이를 district에 저장시킴
//
//        return district;

    //    }
    public String getId() {

        return id;

    }

    public String getAddress() {

        return address;

    }


    public String setDistrict(String address) { // 애는 저장한 값 리턴해줌
        String[] splitted = this.address.split(" ");
        this.district = String.format("%s %s", splitted[0], splitted[1]); // address 나눈 값을 스플릿해서 이를 district에 저장시킴

        return district;

    }

    public String getCategory() {

        return category;

    }

    public Integer getEmergencyRoom() {
        return emergencyRoom;
    }


    public String getName() {

        return name;

    }


    public String getSubdivision() {

        return subdivision;
    }
    @Override
    public String toString() {
        return "(" + "\"" + id + "\"," + "\"" + address + "\"," + "\"" + district + "\"," + "\"" + category + "\"," +
                "\"" + emergencyRoom + "\"," + "\"" + name + "\"," + "\"" + subdivision + "\"" + ")";
    }

    public String getDistrict() {
        return district;
    }
}





