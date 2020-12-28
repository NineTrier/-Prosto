//Пальшина А. ИВТ-19
#include <iostream>
#include <time.h>
#include <fstream>
#include "circlecl.h"
#include "test_circle.h"

using namespace std;

int main()
{
    srand(time(NULL));
    test_all();
    try {
        CircleCl crc;
        //Задаём окружность радиуса 3, с центром в точке (0;0)
        crc.setxy(0,0);
        crc.setr(3);
        //Теперь проверим основные методы
        cout<<"area="<<crc.area()<<endl;
        cout<<"diameter="<<crc.diameter()<<endl;
        cout<<"length="<<crc.length()<<endl;
        //Теперь создадим массив из объектов этого класса
        CircleCl crcar[2];//Создали массив из двух объектов
        crcar[0]=crc;//Чтобы не писать заново, возьмём значения из kv
        //Возьмём площадь ещё раз, чтобы проверить работают ли методы класса в массиве
        cout<<"area="<<crcar[0].area()<<endl;//Всё выводится значит методы работают
        //Теперь выделим память под объект динамически и ещё раз создадим массив
        CircleCl* crcdin=new CircleCl[2];
        crcdin[0].setxy(1,2);
        crcdin[0].setr(2);
        //Методы работаю с динамически созданным объектом
        //Теперь создадим массив из указателей на объект
        CircleCl** crcpoint=new CircleCl*[2];
        for(unsigned i=0;i<2;i++){
            crcpoint[i]=new CircleCl;
            crcpoint[i]->setxy(rand()%100,rand()%100);
            crcpoint[i]->setr(rand()%100);
            cout<<"("<<crcpoint[i]->getx()<<","<<crcpoint[i]->gety()<<")"<<"r="<<crcpoint[i]->getr()<<endl;
            cout<<endl;
        }
        //Теперь запишем в файл наш объект одну из координат sqr2[0] для примера
        ofstream f;
        f.open("testcircle.txt");
        f<<crcdin[0].getx()<<endl;
        f<<crcdin[0].gety()<<endl;
        f<<crcdin[0].getr()<<endl;
        f.close();
        //Теперь для объекта sqr2[1] возьмём данные sqr2[0] из файла
        ifstream f1;
        float k;
        f1.open("testcircle.txt");
        f1>>k;
        crcdin[1].setxy(k,0);
        f1>>k;
        crcdin[1].setxy(crcdin[1].getx(),k);
        f1>>k;
        crcdin[1].setr(k);
        //Для проверки выведем данный объект
        cout<<"("<<crcdin[1].getx()<<","<<crcdin[1].gety()<<")"<<endl;
        delete[] crcdin;
        for (unsigned i=0;i<2;i++){
            delete crcpoint[i];
        }
        delete[] crcpoint;
        return 0;
    }
    catch(Exception e)
    {
        cout<<"Circle doesn't exist"<<endl;
    }
    return 0;
}
