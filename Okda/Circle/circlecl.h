//Пальшина А. ИВТ-19
//Класс-окружность
#ifndef CIRCLECL_H
#define CIRCLECL_H
#include <math.h>

enum Exception{NotExistCircle};

class CircleCl
{
private:
    double x0,y0,r;//x0,y0 - точки центра окружности, r - радиус окружности
public:
    CircleCl();//Конструктор
    CircleCl(double x,double y, double r1);//Конструктор с параметрами
    void setxy(double x,double y);//Сеттер центра окружности
    void setr(double r1);//Сеттер радиуса
    double getx();//геттер х
    double gety();//геттер y
    double getr();//геттер r
    double area();//Функция поиска площади данной окружности
    double diameter();//Функция выводящая диаметр данной окружности
    double length();//Функция поиска длины данной окружности
};

#endif // CIRCLECL_H
