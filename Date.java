//Раменский А.А. ИВТ-19
//Класс-Дата
package library.date;

import java.io.IOException;

public class Date {

    int day;//Day - день
    int mnt;//Month - месяц
    int year;//Year - год

    public Date()//Конструктор, решил начальные значения сделать 01.01.2021(Почему бы и нет)
    {
        this.day = 1;
        this.mnt = 1;
        this.year = 2021;
    }

    public Date(int day, int mnt, int year) { //Конструктор с параметрами
        this.day = day;
        this.mnt = mnt;
        this.year = year;
    }

    public int getDay() {//Геттеры и сеттеры
        return day;
    }

    public void setDay(int day) throws IOException{
        if (day>31 || day<1) throw new IOException("Day is wrong");
        else this.day = day;
    }

    public int getMnt() {
        return mnt;
    }

    public void setMnt(int mnt) throws IOException{
        if(mnt<1 || mnt>12) throw new IOException("Month is wrong");
        else this.mnt = mnt;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) throws IOException {
        if(year<1) throw new IOException("Year is wrong");
        else this.year = year;
    }

    public Date sum(Date dat1)throws IOException//Функция считает сумму двух дат, дни + дни, месяца + месяца, год+год
    {
        Date dat2 = new Date();
        int sd= this.getDay()+dat1.getDay(), //Сумма дней
                sm = this.getMnt()+dat1.getMnt(), //Сумма месяцев
                sy = this.getYear()+dat1.getYear(); //Сумма лет
        //Далее идёт обработка кол-во дней, относительно их кол-ва в месяце(В январе 31, в феврале 28(Обычный год) или 29(Високосный) и т.д.)
        if ((sm==1 || sm==3 || sm==5 || sm==7 || sm==8 || sm==10 || sm==12) && sd>31) {
            sd -= 31;
            sm++;
        }
        if(sm==2 && sy%4!=0 && sd>28) {//Високосность проверяем через остаток от деления года на 4
            sd -= 28;
            sm++;
        }
        if(sm==2 && sy%4==0 && sd>29) {
            sd -= 29;
            sm++;
        }
        if((sm==4 || sm==6 || sm==9 || sm==11) && sd>30) {
            sd -= 30;
            sm++;
        }
        if(sm>12) //Такая же обработка месяцев как и с днями
        {
            sm-=12;
            sy++;
        }
        dat2.setDay(sd);//Далее ставим полученный суммы в dat2
        dat2.setMnt(sm);
        dat2.setYear(sy);
        return dat2;
    }

    public Date diff(Date dat1)throws IOException//Функция считает разность двух дат, дни - дни, месяца - месяца, год-год
    {
        Date dat2 = new Date();
        int dd= this.getDay()-dat1.getDay(), //Разность дней
                dm = this.getMnt()-dat1.getMnt(), //Разность месяцев
                dy = this.getYear()-dat1.getYear(); //Разность лет
        //Далее идёт обработка кол-во дней, относительно их кол-ва в месяце(В январе 31, в феврале 28(Обычный год) или 29(Високосный) и т.д.)
        if (dd<1) {
            dm--;
            if(dm<1) //Такая же обработка месяцев как и с днями
            {
                dm+=12;
                dy--;
            }
            if ((dm == 1 || dm == 3 || dm == 5 || dm == 7 || dm == 8 || dm == 10 || dm == 12)) {
                dd += 31;
            }
            if (dm == 2 && dy % 4 != 0) {//Високосность проверяем через остаток от деления года на 4
                dd += 28;
            }
            if (dm == 2 && dy % 4 == 0) {
                dd += 29;
            }
            if ((dm == 4 || dm == 6 || dm == 9 || dm == 11)) {
                dd += 30;
            }
        }
        if(dm<1) //Такая же обработка месяцев как и с днями
        {
            dm+=12;
            dy--;
        }
        dat2.setDay(dd);//Далее ставим полученный суммы в dat2
        dat2.setMnt(dm);
        dat2.setYear(dy);
        return dat2;
    }

    public Date DayAdd(int day1) throws IOException//Функция добавляет дни
    {
        Date dat1 = new Date();
        int sd=this.getDay()+day1;
        if ((this.getMnt()==1 || this.getMnt()==3 || this.getMnt()==5 || this.getMnt()==7 || this.getMnt()==8 || this.getMnt()==10 || this.getMnt()==12) && sd>31) {
            sd -= 31;
            this.setMnt(this.getMnt()+1);
        }
        if(this.getMnt()==2 && this.getYear()%4!=0 && sd>28) {//Високосность проверяем через остаток от деления года на 4
            sd -= 28;
            this.setMnt(this.getMnt()+1);
        }
        if(this.getMnt()==2 && this.getYear()%4==0 && sd>29) {
            sd -= 29;
            this.setMnt(this.getMnt()+1);
        }
        if((this.getMnt()==4 || this.getMnt()==6 || this.getMnt()==9 || this.getMnt()==11) && sd>30) {
            sd -= 30;
            this.setMnt(this.getMnt()+1);
        }
        this.setDay(sd);
        dat1=this;
        return dat1;
    }

    public Date MonthAdd(int mnt1) throws IOException//Функция добавляет месяцы
    {
        Date dat1 = new Date();
        int sm=this.getMnt()+mnt1;
        if(sm>12) //Такая же обработка месяцев как и с днями
        {
            sm-=12;
            this.setYear(this.getYear()+1);
        }
        this.setDay(1);//Дней поставим 1, чтобы избежать лишних ошибок (Типа в январе 31 день, меняем месяц на февраль и уже ошибка получается)
        this.setMnt(sm);
        dat1=this;
        return dat1;
    }

    public Date YearAdd(int year1) throws IOException//Функция добавляет года
    {
        Date dat1 = new Date();
        this.setMnt(1);//Месяца и дни поставим 1, чтобы также избежать лишних ошибок, типа високосного года
        this.setDay(1);
        dat1=this;
        dat1.setYear(dat1.getYear()+year1);
        return dat1;
    }

    public Date DayRemove(int day1) throws IOException//Функция убирает дни
    {
        Date dat1 = new Date();
        int dd=this.getDay()-day1;
        if (dd<1) {
            this.MonthRemove(1);
            if ((this.getMnt() == 1 || this.getMnt() == 3 || this.getMnt() == 5 || this.getMnt() == 7 || this.getMnt() == 8 || this.getMnt() == 10 || this.getMnt() == 12)) {
                dd += 31;
            }
            if (this.getMnt() == 2 && this.getYear() % 4 != 0) {//Високосность проверяем через остаток от деления года на 4
                dd += 28;
            }
            if (this.getMnt() == 2 && this.getYear() % 4 == 0) {
                dd += 29;
            }
            if ((this.getMnt() == 4 || this.getMnt() == 6 || this.getMnt() == 9 || this.getMnt() == 11)) {
                dd += 30;
            }
        }
        dat1=this;
        dat1.setDay(dd);
        return dat1;
    }

    public Date MonthRemove(int mnt1) throws IOException//Функция убирает месяцы
    {
        Date dat1 = new Date();
        int dm=this.getMnt()-mnt1;
        if(dm<1) //Такая же обработка месяцев как и с днями
        {
            dm+=12;
            this.setYear(this.getYear()-1);
        }
        this.setDay(1);
        dat1=this;
        dat1.setMnt(dm);
        return dat1;
    }

    public Date YearRemove(int year1) throws IOException//Функция убирает года
    {
        Date dat1 = new Date();
        this.setMnt(1);
        this.setDay(1);
        dat1=this;
        dat1.setYear(dat1.getYear()-year1);
        return dat1;
    }

    public String DateToString()//Функция переводит дату в символьный тип удобного формата ДД.ММ.ГГГГ
    {
        String s="";
        if(this.getDay()<10)
        {
            s+="0";
        }
        s+=String.valueOf(this.getDay());
        s+=".";
        if(this.getMnt()<10)
        {
            s+="0";
        }
        s+=String.valueOf(this.getMnt());
        s+=".";
        if(this.getYear()<10)
        {
            s+="000";
        }
        else if(this.getYear()<100)
        {
            s+="00";
        }
        else if(this.getYear()<1000)
        {
            s+="0";
        }
        s+=String.valueOf(this.getYear());
        return s;
    }
}
