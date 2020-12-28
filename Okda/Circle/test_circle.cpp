//Пальшина А. ИВТ-19
#include "test_circle.h"

void test_setxy()
{
    CircleCl crc;
    crc.setxy(1,6);
    assert((crc.getx()-1<=0.0000001)&&(crc.gety()-6<=0.0000001));
}

void test_setr()
{
    CircleCl crc;
    crc.setr(6);
    assert((crc.getr()-6<=0.0000001));
}

void test_area()
{
    CircleCl crc;
    crc.setxy(1,6);
    crc.setr(6);
    assert((crc.area()-113.0973355<=0.0000001));
}

void test_length()
{
    CircleCl crc;
    crc.setxy(1,6);
    crc.setr(6);
    assert((crc.length()-37.6991118<=0.0000001));
}

void test_diameter()
{
    CircleCl crc;
    crc.setxy(1,6);
    crc.setr(6);
    assert((crc.diameter()-12<=0.0000001));
}

void test_all()
{
    test_setxy();
    test_setr();
    test_area();
    test_diameter();
    test_length();
    std::cout<<"OKEY"<<std::endl;
}

