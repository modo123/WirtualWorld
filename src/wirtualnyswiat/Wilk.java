package wirtualnyswiat;

public class Wilk extends Zwierze
{
    public Wilk(int x, int y)
    {
            wiek = 0;
            id = 1;
            sila = 9;
            inicjatywa = 5;
            pozX = x;
            pozY = y;
            znak = 'W';
            nazwa = "Wilk";
            zyje = true;
            rozmnozony = false;
    }

    public Wilk(Wilk wilk)
    {
            wiek = 0;
            id = wilk.id;
            sila = wilk.sila;
            inicjatywa = wilk.inicjatywa;
            pozX = wilk.pozX;
            pozY = wilk.pozY;
            znak = wilk.znak;
            nazwa = wilk.nazwa;
            zyje = true;
            rozmnozony = false;
    }


    @Override
    public Organizm rozmnoz()
    {
            return new Wilk(this);
    }
}
