//Пальшина А. ИВТ-19
#include "circlecl.h"

CircleCl::CircleCl()
{
    x0=0;
    y0=0;
    r=0;
}

CircleCl::CircleCl(double x,double y,double r1)
{
    setxy(x,y);
    setr(r1);
}

void CircleCl::setxy(double x, double y)
{
    x0=x;
    y0=y;
}

void CircleCl::setr(double r1)
{
    if(r>=0)
    {
        r=r1;
    }
    else throw NotExistCircle;
}

double CircleCl::getx()
{
    return x0;
}

double CircleCl::gety()
{
    return y0;
}

double CircleCl::getr()
{
    return r;
}

double CircleCl::area()
{
    return M_PI*r*r;
}

double CircleCl::diameter()
{
    return 2*r;
}

double CircleCl::length()
{
    return 2*M_PI*r;
}
